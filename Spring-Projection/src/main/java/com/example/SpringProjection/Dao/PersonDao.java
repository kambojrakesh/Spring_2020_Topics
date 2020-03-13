package com.example.SpringProjection.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProjection.Dto.ClassDto;
import com.example.SpringProjection.Entity.PersonEntity;

public interface PersonDao extends JpaRepository<PersonEntity, Long> {
	
	<T> T findByLastName(String lastName, Class<T> type);
	
	ClassDto findByLastName(String lastName);

}
