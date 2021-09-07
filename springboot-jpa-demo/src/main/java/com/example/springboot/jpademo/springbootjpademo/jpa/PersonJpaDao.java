package com.example.springboot.jpademo.springbootjpademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.springboot.jpademo.springbootjpademo.entity.Person;

@Repository
@Transactional  // very important otherwise insert update delete will not work
public class PersonJpaDao {
	//connect to database
	@PersistenceContext
	private EntityManager entityManager;

	//note person class has defined query
	//@NamedQuery(name ="find_all_persons",query = "Select p from person p" )
	public List<Person> findAll(){
		 TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		 List<Person> personList = namedQuery.getResultList();
		 return personList;
	}
	
	public Person findById(int id){
		return entityManager.find(Person.class, id);
	}
	
	public void deleteById(int id){
		Person findById = findById(id);
		entityManager.remove(findById);
	}
	
	public Person insert(Person person){
		return entityManager.merge(person);
	}
	
	public Person update(Person person){
		return entityManager.merge(person);
	}



}
