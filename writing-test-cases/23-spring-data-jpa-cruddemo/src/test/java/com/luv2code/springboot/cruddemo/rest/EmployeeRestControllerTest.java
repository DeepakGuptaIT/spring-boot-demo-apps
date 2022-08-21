package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeRestControllerTest {

    @MockBean
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        System.out.println("Before each Test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each Test");
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(Stream.of(new Employee(1, "Deepak", "Controller", "deepak@gmai.com"), new Employee(2, "Rahul", "Gupta", "rahul@gmai.com"))
                .collect(Collectors.toList()));
        assertEquals(2, service.findAll().size());
    }

    @Test
    void getEmployee() {
        int id = 5;
        when(service.findById(id)).thenReturn(new Employee(5, "Deepak", "Controller", "deepak@gmai.com"));
        assertThat(service.findById(id).getId()).isEqualTo(5);
    }

    @Test
    void addEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}