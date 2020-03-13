package com.example.SpringProjection.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringProjection.Dto.AddressView;
import com.example.SpringProjection.Entity.AddressEntity;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Long> {
	
	@Query("SELECT a.zipCode as zipCode, a.city as city FROM AddressEntity a WHERE a.state = ?1") 
	List<AddressView> getAddressByState(String state);

}
