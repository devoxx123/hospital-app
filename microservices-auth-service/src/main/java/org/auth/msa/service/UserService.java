package org.auth.msa.service;

import java.util.Date;
import java.util.List;

import org.auth.msa.model.User;
import org.auth.msa.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public User addUser(User user) {
		user.setPassword(getPasswordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return this.userRepository.findAll();
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void changeUserPassword(User user, String newPassword) {
		user.setPassword(getPasswordEncoder().encode(newPassword));
		user.setChangePasswordDate(new Date());
		userRepository.save(user);
	}

	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		return getPasswordEncoder().matches(oldPassword, user.getPassword());
	}
}
