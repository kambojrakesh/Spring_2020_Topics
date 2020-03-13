package com.springtransaction.service;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.springtransaction.entity.Book;

@Component
public interface BookService {
	public void saveCheckedBook(Book book) throws SQLException ;
	public void saveUnCheckedBook(Book book);
}