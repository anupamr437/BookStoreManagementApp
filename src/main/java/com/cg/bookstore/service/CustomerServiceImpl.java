package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.exceptions.CustomerAlreadyPresentException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
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
			throw new CustomerAlreadyPresentException(
					"Customer " + c.getFullName() + " already exists!!");
	}

	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return customerServiceRepo.findAll();
	}

	@Override
	public Customer deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> findCustomerById = customerServiceRepo.findById(c.getCustomerId());
		if (findCustomerById.isPresent()) {
			customerServiceRepo.deleteById(c.getCustomerId());
			return c;
		} else
			throw new CustomerNotFoundException("Customer not found for the entered CustomerID");
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerServiceRepo.save(c);
	}

	@Override
	public Customer viewCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerServiceRepo.getById(c.getCustomerId());
	}

	@Override
	public List<Customer> listAllCustomersByBook(Book book) {
		// TODO Auto-generated method stub
		return customerServiceRepo.findByBook(book);
	}

}
