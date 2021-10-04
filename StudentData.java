package com.te.first.prg2;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

public class StudentData{
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InvalidChoiceException  {
	System.out.println("==================Welcome to student-Block==================");
	System.out.println("Enter Your Choice: ");
	System.out.println("\n1.Insert student data\n2.View Students\n3.View Student\n4.Update Student\n5.Modified student Data ");
	int key = sc.nextInt();
	try {
		switch (key) {
		case 1:insertstudent();
			break;
		case 2 : ViewStudents();
			break;
		case 3 : ViewStudent();
		break;
		case 4 : updateStudent();
		break;
		case 5: modified();
		break;
		}
	} 
	
	catch (Exception e) 
	{
		throw new InvalidChoiceException("Invalid Input");
		//e.printStackTrace();
	}
	
}

private static void modified() throws InvaildIdException {
	try {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the id to be Delete: ");
		int rollno = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		String delete = "Delete from Student where rollno = :rollno";
		
		Query query = manager.createQuery(delete);
		
	query.setParameter("rollno", rollno);
		
		int result = query.executeUpdate();
		transaction.commit();
		
	}
	catch (Exception e) 
	{
		throw new InvaildIdException("Enter proper Id");
		//e.printStackTrace();
	}
	}

private static void updateStudent() {
	try {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		System.out.println("Enter your Selection\n1.UpdateName\n2.UpdateClass\n3.phno");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.print("Enter the name: ");
			String name = sc.next().trim().toLowerCase();
			System.out.print("Enter Roll-No: ");
			int rollno = sc.nextInt();
			String update = "update Student set name = :name  where rollno = :rollno";
			Query query = manager.createQuery(update);
			query.setParameter("name", name);
			query.setParameter("rollno", rollno);
			 query.executeUpdate();
			transaction.commit();
			break;
		
		case 2:
			System.out.print("Enter the class to update: ");
			String std = sc.next().trim().toLowerCase();
			System.out.print("Enter Roll-No: ");
			int srollno = sc.nextInt();
			String updatecls = "update Student set standard = :std  where rollno = :rollno";
			Query queryS= manager.createQuery(updatecls);
			queryS.setParameter("std", std);
			queryS.setParameter("rollno", srollno);
			 queryS.executeUpdate();
			transaction.commit();
			break;
			
		case 3:
			System.out.print("Enter the Phone  new number: ");
			long phno = sc.nextLong();
			System.out.print("Enter Roll-No: ");
			int rollno1 = sc.nextInt();
			String update1 = "update Student set phno = :phno  where rollno = :rollno1";
			Query query1 = manager.createQuery(update1);
			query1.setParameter("phno", phno);
			query1.setParameter("rollno1", rollno1);
			 query1.executeUpdate();
			transaction.commit();
			break;	
		default:
			break;
		}

		
	}
	catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
	}	
	}

private static void ViewStudent() {
		
	try {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stu");
		EntityManager manager = factory.createEntityManager();
		System.out.print("Enter the Roll Number to be search: ");
		int roll = sc.nextInt();
		String find = "from Student where rollno = :roll";

		Query query = manager.createQuery(find);
		
		query.setParameter("roll", roll);
		
		List<Student> list = query.getResultList();

		Student e1 = (Student) query.getSingleResult();
		System.out.println(e1);
	
	} 
	catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
	}
	}

private static void ViewStudents() {
	try {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("stu");
		EntityManager manager = factory.createEntityManager();

		String findAll = "from Student";

		Query query = manager.createQuery(findAll);
		
		List<Student> list = query.getResultList();

		for (Student student : list)
		{
			System.out.println(student);
		}
	} 
	catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
	}
		
	}

private static void insertstudent() {
	// TODO Auto-generated method stub
	try {
		boolean b = false;
			while(!b) {
				
			
			Student student = new Student();
			
			System.out.print("Enter the student Name: ");
			String name = sc.next().toLowerCase().trim();
			
			System.out.print("Enter the Student class: ");
			String std= sc.next().trim();
			
			System.out.print("Enter the Roll  Number: ");
			int roll = sc.nextInt();
			
			System.out.print("Enter the Phone number: ");
			long phno = sc.nextLong();
			
			student.setName(name);
			student.setStandard(std);
			student.setRollno(roll);
			student.setPhno(phno);
			
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("stu");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			
			
			manager.persist(student);
			transaction.commit();
			
			System.out.println("If you want to continue: y/Y");
			char c= sc.next().charAt(0);
			if (c == 'y' || c=='Y')
			{
				b= false;
			}
			else
				b= true;
			
			}
		}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
