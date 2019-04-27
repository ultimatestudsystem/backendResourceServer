package com.studsystem.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.studsystem.dto.UserProfile;
import com.studsystem.enums.UserType;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.FirebaseUserProfileService;
import com.studsystem.interfaces.repository.UserProfileFirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FirebaseUserProfileServiceImpl implements FirebaseUserProfileService {

    @Autowired
    private UserProfileFirebaseRepository userProfileFirebaseRepository;


    @Override
    public String createUser(String email, String password, String role, String birthDate, String firstName,
                           String lastName, String middleName, String phone, String photo) throws FirebaseAuthException {
        StringBuilder answer = new StringBuilder();
        role = role.toLowerCase();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail(email);
        request.setPassword(password);
        UserRecord user = FirebaseAuth.getInstance().createUser(request);

        OnValidationFailure failureCallback = (dto, message) -> answer.append(message.concat(" "));
        OnValidationSuccess successCallback = (dto) -> {};
        UserProfile newUserProfile = UserProfile.getInstance()
                .setEmail(email, successCallback, failureCallback)
                .setBirthDate(birthDate, successCallback, failureCallback)
                .setFirstName(firstName, successCallback, failureCallback)
                .setLastName(lastName, successCallback, failureCallback)
                .setMiddleName(middleName, successCallback, failureCallback)
                .setPhone(phone, successCallback, failureCallback)
                .setPhoto(photo, successCallback, failureCallback)
                .setRole(role, successCallback, failureCallback)
                .setFirebaseUserId(user.getUid());

        boolean answerIsEmpty = answer.toString().isEmpty();
        try {
            if (answerIsEmpty && !userProfileFirebaseRepository.save(newUserProfile)) {
                answer.append("could not save new user profile");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return answerIsEmpty ? "OK" : answer.toString();
    }

//    @Override
//    public String createUser(String email, String password, String type, String birthDate, String firstName,
//                           String lastName, String middleName, String phone, String photo, String secret) throws FirebaseAuthException {
//
//        StringBuilder answer = new StringBuilder();
//        type = type.toLowerCase();
//        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
//        request.setEmail(email);
//        request.setPassword(password);
//        UserRecord user = FirebaseAuth.getInstance().createUser(request);
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(type, true);
//        claims.put("secret", secret);
//        FirebaseAuth.getInstance().setCustomClaims(user.getUid(), claims);
//
//        OnValidationFailure failureCallback = (dto, message) -> answer.append(message.concat(" "));
//        OnValidationSuccess successCallback = (dto) -> {};
//        UserProfile newUserProfile = UserProfile.getInstance()
//                .setEmail(email, successCallback, failureCallback)
//                .setBirthDate(birthDate, successCallback, failureCallback)
//                .setFirstName(firstName, successCallback, failureCallback)
//                .setLastName(lastName, successCallback, failureCallback)
//                .setMiddleName(middleName, successCallback, failureCallback)
//                .setPhone(phone, successCallback, failureCallback)
//                .setPhoto(photo, successCallback, failureCallback);
//
//        boolean answerIsEmpty = answer.toString().isEmpty();
//        try {
//            if (answerIsEmpty && !userProfileFirebaseRepository.save(newUserProfile)) {
//                answer.append("could not save new user profile");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return answerIsEmpty ? "OK" : answer.toString();
//    }

    @Override
    public String deleteUser(String id) {
        if (userProfileFirebaseRepository.delete(id)) {
            return "OK";
        } else {
            return "Could not delete User profile with ID: ".concat(id);
        }
    }

    @Override
    public Optional<UserProfile> getUserByKey(String key) {
        return userProfileFirebaseRepository.get(key);
    }

    @Override
    public Optional<UserProfile> getUserByFirebaseKey(String firebaseKey) {
        List<UserProfile> userProfilesList;
        try {
            userProfilesList = userProfileFirebaseRepository.getObjectsAccordingToPredicate("users",
                    (userProfile) -> userProfile.getFirebaseUserId().equals(firebaseKey));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        if (userProfilesList.size() > 1) {
            throw new RuntimeException(String.format("There is more than one user profile with id token %s", firebaseKey));
        }
        return Optional.ofNullable(userProfilesList.get(0));
    }
}
