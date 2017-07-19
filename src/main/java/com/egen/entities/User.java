package com.egen.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.egen.constraints.GenderPattern;
import com.egen.constraints.PhoneNumberPattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Pattern(regexp="[A-Za-z]+", message="first name can't have non-alphabets!")
	private String firstname;
	
	@Pattern(regexp="[A-Za-z]+", message="middle name can't have non-alphabets!")
	private String middlename;
	
	@NotNull
	@Pattern(regexp="[A-Za-z]+", message="last name can't have non-alphabets!")
	private String lastname;
	
	@NotNull
	@Range(min = 1)
	private int age;
	
	@NotNull
	@GenderPattern(regexp = "[MF", message = "The value of gender should be either male or female")
	private Character gender;

	@NotNull
	@PhoneNumberPattern(regexp = "^\\d{10}$", message = "The value of gender should be either male or female")
	private long phone;
	
	@Range(max = 99999)
	private long zip;
	
	public User() {
		super();
	}

	public User(String firstname, String middlename, String lastname, int age, Character gender, long phone, long zip) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.zip = zip;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}
	
	
}
