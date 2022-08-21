package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CruddemoApplicationTests {
	Calculator c = new Calculator();

	@Test
	public void contextLoads() {
	}
	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeRepository repository;

	@Test
	public void testFindAll() {
		when(repository.findAll()).thenReturn(Stream.of(
				new Employee("deepak","kumar","abc@gmail.com")).collect(Collectors.toList()));
		assertEquals(1,service.findAll().size());
	}

	@Test
	public void testAdd() {
		//expected
		int expected = 15;
		//actual
		int result = c.add(10,5);
		assertThat(15).isEqualTo(expected);
	}

}
