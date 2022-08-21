package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;

    @Test
    @DisplayName("findAll Employees")
    void findAll() {
        when(repository.findAll()).thenReturn(Stream.of(
                new Employee("deepak","kumar","abc@gmail.com")).collect(Collectors.toList()));
        assertEquals(1,service.findAll().size());
    }


    @Test
    void findById() {
        int id =5;
        when(repository.findById(id)).thenReturn(Optional.of(new Employee(5,"deepak", "kumar", "abc@gmail.com")));
        assertThat(service.findById(id).getId()).isEqualTo(5);
    }

    @Test
    void save() {
        Employee e = new Employee("deepak", "kumar", "abc@gmail.com");
        when(repository.save(e)).thenReturn(e);

        service.save(e);

    }

    @Test
    void deleteById() {
    }
}