package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
	private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    void shouldReturnUserName_whenUserExists() {
    	User user = new User(1L, "Ashish");
    	when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    	
    	String result=userService.getUserNameById(1L);
    	
    	assertEquals("Ashish", result);
    	verify(userRepository).findById(1L);
    }
    
    @Test
    void shouldReturnUnknown_whenUserNotFound() {
    	when(userRepository.findById(2L)).thenReturn(Optional.empty());
    	
    	String result=userService.getUserNameById(2L);
    	
    	assertEquals("Unknown", result);
    }
}
