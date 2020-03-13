package com.springtransaction.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtransaction.entity.Book;
import com.springtransaction.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/saveUB", method = RequestMethod.POST)
	@ResponseBody
	public Book saveUncheckedBook(@RequestBody Book book){
		bookService.saveUnCheckedBook(book);
		
		return book;
	}

	@RequestMapping(value = "/saveCB", method = RequestMethod.POST)
	@ResponseBody
	public Book saveCheckedBook(@RequestBody Book book) throws SQLException{
		bookService.saveCheckedBook(book);

		return book;
	}
	

}