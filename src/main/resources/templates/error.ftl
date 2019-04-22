<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>An error occurred.</title>
   </head>

   <body>
      <h1>Sorry, there is an error.</h1>
      <#if message??>
        <h2>${message}</h2>
      <#else>
        <h2>Unknown error :(</h2>
      </#if>
   </body>

</html>