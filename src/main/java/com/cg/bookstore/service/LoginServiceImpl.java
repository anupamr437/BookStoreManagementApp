package com.cg.bookstore.service;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Login;
import com.cg.bookstore.exceptions.UserAlreadyPresentException;
import com.cg.bookstore.exceptions.UserNotPresentException;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ILoginRepository;

public class LoginServiceImpl implements ILoginService {
	@Autowired 
	private ILoginRepository loginServiceRepo;

	
	@Override
	public String validateLogin(Login user1) {
		// TODO Auto-generated method stub
		Optional<User> findByEmail = loginServiceRepo.findByEmailAndPassword(user1.getEmail(),user1.getPassword());
		if (findByEmail.isPresent()) {
			return "User Valid";
		} else
			throw new UserNotPresentException("User not Present");
	}
}
