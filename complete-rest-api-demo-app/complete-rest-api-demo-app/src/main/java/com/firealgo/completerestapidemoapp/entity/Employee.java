package com.firealgo.completerestapidemoapp.entity;



import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sal")
	int salary;

	public Employee(String firstName, String lastName, String email, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Employee() {
	}
}
