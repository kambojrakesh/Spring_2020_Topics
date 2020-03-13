package com.example.SpringProjection.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProjection.Dao.AddressDao;
import com.example.SpringProjection.Dao.PersonDao;
import com.example.SpringProjection.Dto.AddressDto;
import com.example.SpringProjection.Dto.AddressView;
import com.example.SpringProjection.Dto.ClassDto;
import com.example.SpringProjection.Dto.PersonDto;
import com.example.SpringProjection.Dto.PersonView;
import com.example.SpringProjection.Entity.PersonEntity;

@Service
public class ProjectionService {
	
	@Autowired
	PersonDao dao;
	
	@Autowired
	AddressDao addDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public List<PersonDto> getAllPersons(){
		List<PersonDto> dtoList = new ArrayList<>();
		List<PersonEntity> personEntity =  dao.findAll();
		for(PersonEntity entity:personEntity)
		{
			PersonDto dto = modelMapper.map(entity, PersonDto.class);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public List<PersonDto> getAllPersons1(){
		List<PersonDto> dtoList = new ArrayList<>();
		List<PersonEntity> personEntity =  dao.findAll();
		for(PersonEntity entity:personEntity)
		{
			PersonDto dto = new PersonDto();
			dto.setId(entity.getId());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			
			AddressDto addDto = new AddressDto();
			addDto.setId(entity.getAddress().getId());
			addDto.setStreet(entity.getAddress().getStreet());
			addDto.setCity(entity.getAddress().getCity());
			addDto.setState(entity.getAddress().getState());
			addDto.setZipCode(entity.getAddress().getZipCode());
			dto.setAddress(addDto);
			
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public List<String> closedProjection(String state) {
		
		List<String> zipCodeList = new ArrayList<>();
		String zipCode;
		List<AddressView> addressView = addDao.getAddressByState(state);
		for(AddressView addView:addressView) {
			zipCode = addView.getZipCode();
			System.out.println("City "+addView.livingIn());
			zipCodeList.add(zipCode);
		}
		return zipCodeList;		
	}
	
	public PersonDto findByLastName(String lastName) {
		PersonEntity perEntity = dao.findByLastName(lastName, PersonEntity.class);
		return modelMapper.map(perEntity, PersonDto.class);		
	}
	
	public PersonView findFullName(String lastName) {
		PersonView personView = dao.findByLastName(lastName, PersonView.class);
		return personView;	
	}
	
	public ClassDto findByLastNameClass(String lastName) {
		ClassDto perDto = dao.findByLastName(lastName);
		return perDto;		
	}

}
