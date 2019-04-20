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
import java.util.Map;

@Service
public class FirebaseUserProfileServiceImpl implements FirebaseUserProfileService {

    @Value("${secret.student}")
    private String secretStudent;

    @Value("${secret.teacher}")
    private String secretTeacher;

    private Map<String, String> secrets;

    @Autowired
    private UserProfileFirebaseRepository userProfileFirebaseRepository;

    public FirebaseUserProfileServiceImpl() {
        secrets = new HashMap<>();
        secrets.put(UserType.STUDENT.name().toLowerCase(),  secretStudent);
        secrets.put(UserType.TEACHER.name().toLowerCase(),  secretTeacher);
    }

    @Override
    public String createUser(String email, String password, String type, String birthDate, String firstName,
                           String lastName, String middleName, String phone, String photo) throws FirebaseAuthException {
        return createUser(email, password, type, birthDate, firstName, lastName, middleName, phone, photo, secrets.get(type));
    }

    @Override
    public String createUser(String email, String password, String type, String birthDate, String firstName,
                           String lastName, String middleName, String phone, String photo, String secret) throws FirebaseAuthException {

        StringBuilder answer = new StringBuilder();
        type = type.toLowerCase();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail(email);
        request.setPassword(password);
        UserRecord user = FirebaseAuth.getInstance().createUser(request);
        Map<String, Object> claims = new HashMap<>();
        claims.put(type, true);
        claims.put("secret", secret);
        FirebaseAuth.getInstance().setCustomClaims(user.getUid(), claims);

        OnValidationFailure failureCallback = (dto, message) -> answer.append(message.concat(" "));
        OnValidationSuccess successCallback = (dto) -> {};
        UserProfile newUserProfile = UserProfile.getInstance()
                .setEmail(email, successCallback, failureCallback)
                .setBirthDate(birthDate, successCallback, failureCallback)
                .setFirstName(firstName, successCallback, failureCallback)
                .setLastName(lastName, successCallback, failureCallback)
                .setMiddleName(middleName, successCallback, failureCallback)
                .setPhone(phone, successCallback, failureCallback)
                .setPhoto(photo, successCallback, failureCallback);

        boolean answerIsEmpty = answer.toString().isEmpty();
        if (answerIsEmpty && !userProfileFirebaseRepository.save(newUserProfile)) {
            answer.append("could not save new user profile");
        }
        return answerIsEmpty ? "OK" : answer.toString();
    }

    @Override
    public String deleteUser(String id) {
        if (userProfileFirebaseRepository.delete(id)) {
            return "OK";
        } else {
            return "Could not delete User profile with ID: ".concat(id);
        }
    }

    @Override
    public UserProfile getUserByKey(String key) {
        return userProfileFirebaseRepository.get(key);
    }
}
