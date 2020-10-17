1. Start the redis docker container with image redis:latest on port 6379
2. Find out the IPAddress of the redis docker container with below command
	$docker container inspect <Container Name>
3. For redis database visualization, start another docker container with image name "redislabs/redisinsight:latest" on port 8001
4. visit localhost:8001 and click on add redis database.
5. enter the redis database details use the IPAddress from step 2 while filling the form also use step 1 port as well..
6. import the postman collection.
7. create the new user in redis database.
8. Retrieve the created user by Id
9. Update the existing user.
10. Congratulations use have successfully used basic redis as your database



Additional Information: You can visit http://localhost8083/swagger-ui.html to know the list of application endpoints!.
