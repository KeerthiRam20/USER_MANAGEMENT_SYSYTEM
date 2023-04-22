package com.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class UserManagementSysytemApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserManagementSysytemApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream,typeReference);
				userService.save(users);
				System.out.println("Users Saved!");
				//writing to json file
				User user = new User();
				user.setId(10);
				user.setName("Keerthi");
				user.setUsername("keerthiram");
				user.setEmail("keerthiram2000@gmail.com");
				user.setPhone("9110480748");
				user.setWebsite("https://jsonplaceholder.typicode.com/");
				mapper.writeValue(new File("C:\\STS\\USER_MANAGEMENT_SYSYTEM\\src\\main\\resources\\json\\writinguser.json"), user);
				inputStream.close();
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
