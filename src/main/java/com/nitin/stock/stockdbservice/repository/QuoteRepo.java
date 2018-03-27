package com.nitin.stock.stockdbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.stock.stockdbservice.model.Quote;

public interface QuoteRepo extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String userName);

}
