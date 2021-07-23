package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerServiceRepo;

	@Override
	public Customer createCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> findCustomerById = customerServiceRepo.findById(c.getCustomerId());
		if (!findCustomerById.isPresent()) {
			return customerServiceRepo.save(c);
		} else
			throw new BookAlreadyPresentException(
					"Customer " + c.getCustomerId() + " already exists!!");
	}

	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return customerServiceRepo.findAll();
	}

	@Override
	public Customer deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> findCustomerById = customerServiceRepo.findById(c.getCustomerId());
		if (findCustomerById.isPresent()) {
			customerServiceRepo.save(c);
			return c;
		} else
			throw new CustomerNotFoundException(
					"Customer with Id: " + c.getCustomerId() + " not exists!!");
	}

	@Override
	public Customer viewCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> listAllCustomersByBook(Book book) {
		// TODO Auto-generated method stub
		return customerServiceRepo.findByBook(book);
	}

}
