package com.vti.rw41.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Departments")
@Data
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String name;

}
