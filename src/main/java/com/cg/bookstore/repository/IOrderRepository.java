package com.cg.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.entities.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<BookOrder, Integer>{

}
