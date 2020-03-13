package com.example.SpringProjection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.example.SpringProjection.Dto.AddressDto;
import com.example.SpringProjection.Dto.Order;
import com.example.SpringProjection.Dto.OrderInfo;
import com.example.SpringProjection.Dto.PersonDto;
import com.example.SpringProjection.Entity.AddressEntity;
import com.example.SpringProjection.Entity.PersonEntity;

public class PersonDtoUnitTest {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
    public void whenConvertPersonEntityToPersonDto() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1L);
        personEntity.setFirstName("Akki");
        personEntity.setLastName("Saxena");       
        AddressEntity add = new AddressEntity(1L,personEntity,"New Delhi","New Delhi","RK puram","110042");
        personEntity.setAddress(add);
        
        PersonDto personDto = modelMapper.map(personEntity, PersonDto.class);
        assertEquals(personEntity.getId(), personDto.getId());
        assertEquals(personEntity.getFirstName(), personDto.getFirstName());
        assertEquals(personEntity.getLastName(), personDto.getLastName());
        assertEquals(personEntity.getAddress().getCity(), personDto.getAddress().getCity());

    }
 
    @Test
    public void whenConvertPersonDtoToPersonEntity() {
        PersonDto personDto = new PersonDto();
        personDto.setId(1L);
        personDto.setFirstName("Akki");
        personDto.setLastName("Saxena"); 
        AddressDto add = new AddressDto(1L, "New Delhi","New Delhi","RK puram","110042");
        personDto.setAddress(add);
 
        PersonEntity personEntity = modelMapper.map(personDto, PersonEntity.class);
        assertEquals(personDto.getId(), personEntity.getId());
        assertEquals(personDto.getFirstName(), personEntity.getFirstName());
        assertEquals(personDto.getLastName(), personEntity.getLastName());
        assertEquals(personDto.getAddress().getCity(), personEntity.getAddress().getCity());
    }
}
