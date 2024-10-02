package com.firealgo.completerestapidemoapp;

import com.firealgo.completerestapidemoapp.dao.EmployeeRepository;
import com.firealgo.completerestapidemoapp.entity.Employee;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(
                    new Employee("deepak","kumar", "deep79@hotmail.com", 800)));
            log.info("Preloading " + repository.save(
                    new Employee("rahul","gupta", "rahul58@gmail.com", 500)));
        };
    }
}
