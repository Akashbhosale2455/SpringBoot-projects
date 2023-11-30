package com.todo1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import com.todo1.dto.EmpDTO;

@Repository
public class EmpDAO implements EmpDAOin
{
	EmpDTO emp;
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnections() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee1");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnections() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			try {
				entityTransaction.rollback();
			} catch (TransactionException e) {
				System.out.println("Transaction already commited.");
			}
		}
	}

	@Override
	public EmpDTO addEmp() {
		openConnections();
		entityTransaction.begin();
		EmpDTO emp=new EmpDTO();
		emp.setEmpname("Akash");
		emp.setSalary(100000);
		emp.setAge(24);
		entityManager.persist(emp);
		entityTransaction.commit();
		closeConnections();
		
		return emp;
		
	}

}
