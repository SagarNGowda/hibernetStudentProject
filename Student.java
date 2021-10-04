package com.te.first.prg2;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable{
@Id
	private int rollno;
	private String name;
	private String standard;
	private long phno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", standard=" + standard + ", rollno=" + rollno + ", phno=" + phno + "]";
	}
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String standard, int rollno, long phno) {
		
		this.name = name;
		this.standard = standard;
		this.rollno = rollno;
		this.phno = phno;
	}
	
	
	
	
}
