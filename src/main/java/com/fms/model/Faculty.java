package com.fms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_data")
public class Faculty {

	@Id
	private Integer id;

	@Column(name = "faculty_name")
	private String name;

	@Column(name = "faculty_address")
	private String address;

	public Faculty() {
	}

	public Faculty(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
