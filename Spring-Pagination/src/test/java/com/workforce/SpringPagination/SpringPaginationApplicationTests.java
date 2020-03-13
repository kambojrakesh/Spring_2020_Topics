package com.workforce.SpringPagination;


import com.workforce.SpringPagination.dao.StudentDao;
import com.workforce.SpringPagination.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringPaginationApplicationTests {

    @Autowired
    StudentDao studentDao;

    @Test
    public void springPaginationAndSorting() {
        System.out.println("\n---------Without Pagination----------");
        System.out.println("\nReturn All Student List");
        studentDao.findAll().forEach(System.out::println);

        System.out.println("\n -------------With Pagination------------");
        //Page Number Start with 0, So Page 1 become 0, 2 become 1 and so on..

        System.out.println("Get 1 page with 2 records");
        Page<Student> p = studentDao.findAll(PageRequest.of(0, 2));
        p.forEach(System.out::println);
        System.out.print("Page Information: Total Element-" + p.getTotalElements());
        System.out.print(", Total Page-" + p.getTotalPages());
        System.out.print(", firstPage-" + p.isFirst());
        System.out.print(", lastPage-" + p.isLast());
        System.out.print(", Sorted-" + p.getSort().isSorted());
        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println("Invalid Page Number");//Will Return Empty Page
        studentDao.findAll(PageRequest.of(6, 10)).forEach(System.out::println);
        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println("Get All Student list with Sorting Only");
        studentDao.findAll(Sort.by(Sort.Direction.ASC, "studentName")).forEach(System.out::println);
        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println("Get 2 page with 2 records with Sorting on Ph and Name");
        p = studentDao.findAll(PageRequest.of(2, 2, Sort.Direction.ASC, "ph", "studentName"));
        p.forEach(System.out::println);
        System.out.print("Page Information: Total Element-" + p.getTotalElements());
        System.out.print(", Total Page-" + p.getTotalPages());
        System.out.print(", isEmpty-" + p.isEmpty());
        System.out.print(", Sorted-" + p.getSort().isSorted());
        System.out.println("\n\n--------------------------------------------------\n");

        System.out.println("Pagination and sorting with searching");
        p = studentDao.findByPh("1234567890", PageRequest.of(0, 1));
        p.forEach(System.out::println);
        System.out.print("Page Information: Total Element-" + p.getTotalElements());
        System.out.print(", Total Page-" + p.getTotalPages());
        System.out.print(", isEmpty-" + p.isEmpty());
        System.out.println("\n--------------------------------------------------");
        p = studentDao.findByPh("1234567890", PageRequest.of(1, 1, Sort.Direction.ASC, "studentName"));
        p.forEach(System.out::println);
        System.out.print("Page Information: Total Element-" + p.getTotalElements());
        System.out.print(", Total Page-" + p.getTotalPages());
        System.out.print(", isEmpty-" + p.isEmpty());
    }

    @Test
    public void sprinFiltring() {

        System.out.println("Search student using Id");
        Optional<Student> o = studentDao.findById(1L);
        if (o.isPresent()) System.out.println(o.get().toString());
        else System.out.println("Not Found");
        System.out.println("\n--------------------------------------------------");

        System.out.println("Search student using list of ids");
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(4L);
        studentDao.findAllById(ids).forEach(System.out::println);
        System.out.println("\n--------------------------------------------------");

        System.out.println("Search student using Name");
        studentDao.findByStudentName("Amit").forEach(System.out::println);
        System.out.println("\n--------------------------------------------------");

        System.out.println("Using @Query to find by email");
        System.out.println(studentDao.findEmail("amit@yahoo.com").get());
        System.out.println("\n--------------------------------------------------");

        System.out.println("Using @Query to find by Ph and Name");
        studentDao.findPhAndName("1234567890", "Amit").forEach(System.out::println);
        System.out.println("\n--------------------------------------------------");

        System.out.println("Wrong Email address");
        System.out.println("Exist?-" + studentDao.findEmail("not@yahoo.com").isPresent());
        System.out.println("\n--------------------------------------------------");

        System.out.println("Using Native Query");
        studentDao.getStudent("Amit").forEach(System.out::println);
        System.out.println("\n--------------------------------------------------");

        System.out.println("Query By Example Interface");
        studentDao.findAll(Example.of(new Student("amit", null, null),
                ExampleMatcher.matching().withIgnoreCase()),
                Sort.by(Sort.Direction.DESC, "studentId")).forEach(System.out::println);
        System.out.println("\n--------------------------------------------------");
    }
}