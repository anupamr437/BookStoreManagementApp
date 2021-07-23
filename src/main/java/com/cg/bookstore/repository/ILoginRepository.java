package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Customer;

@Repository
public interface ILoginRepository extends JpaRepository<Customer, Integer>{

}
