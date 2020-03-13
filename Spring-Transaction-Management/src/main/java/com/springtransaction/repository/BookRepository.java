package com.springtransaction.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springtransaction.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {

}