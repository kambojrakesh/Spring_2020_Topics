package com.springtransaction.serviceimpl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtransaction.entity.Book;
import com.springtransaction.repository.BookRepository;
import com.springtransaction.service.BookService;
import com.springtransaction.service.StoryService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private StoryService storyService;

	
	//	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	//	public void saveUnCheckedBook(Book book) {
	//		bookRepository.save(book);
	//		
	//		Story story = new Story(); 
	//		story.setStoryName("story name1"); // save story
	//		storyService.saveStory(story);
	//		 
	//		String s1 = null;
	//		System.out.println(s1.length());
	//		
	//	}
	
	@Transactional//(noRollbackFor = NullPointerException.class)
	@Override
	public void saveUnCheckedBook(Book book) {
		bookRepository.save(book);
		
		//Story story = new Story(); story.setStoryName("story name1"); // save story
		//storyService.saveStory(story);
		 
		//String s1 = null;
		//System.out.println(s1.length());
		
	}
	
	@Transactional(rollbackFor = SQLException.class)
	@Override
	public void saveCheckedBook(Book book) throws SQLException {
		bookRepository.save(book);	
		//throw new SQLException ("");		
	}


}