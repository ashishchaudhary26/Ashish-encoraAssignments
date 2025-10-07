package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.test.web.servlet.MockMvc;

import com.model.User;
import com.repository.UserRepository;

@SpringBootTest(webEnvironment = 
SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void setup() {
		userRepository.save(new User(1L, "Madhav"));
	}
	
	@Test
	void shouldReturnUserFromDatabase() throws Exception{
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.uname").value("Madhav"));
	}
	
	@Test
	void shouldRetunNotFoundForMissingUser() throws Exception {
		mockMvc.perform(get("/users/99"))
		.andExpect(status().isNotFound());
	}

}
