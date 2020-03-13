package com.workforce.SpringPagination;

import com.workforce.SpringPagination.dao.StudentDao;
import com.workforce.SpringPagination.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.workforce.SpringPagination")
public class SpringPaginationApplication implements CommandLineRunner {

	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringPaginationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentDao.save(new Student("Amit","amit@yahoo.com","1234567890"));
		studentDao.save(new Student("Ram","Ram@yahoo.com","2345678901"));
		studentDao.save(new Student("Sumit","Sumit@yahoo.com","3456789012"));
		studentDao.save(new Student("Kumar","Kumar@yahoo.com","4567890123"));
		studentDao.save(new Student("Suraj","Suraj@yahoo.com","5678901234"));
		studentDao.save(new Student("Mario","Mario@yahoo.com","6789012345"));
		studentDao.save(new Student("Anna","Anna@yahoo.com","7890123456"));
		studentDao.save(new Student("Paul","Paul@yahoo.com","8901234567"));
		studentDao.save(new Student("Anna","Anna@yahoo.com","9012345678"));
		studentDao.save(new Student("Amit","Bob@yahoo.com","1234567890"));
		studentDao.save(new Student("Joe","Joe@yahoo.com","1234567890"));
	}
}
