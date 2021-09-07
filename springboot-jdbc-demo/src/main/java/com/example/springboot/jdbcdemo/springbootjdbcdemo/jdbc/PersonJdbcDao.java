package com.example.springboot.jdbcdemo.springbootjdbcdemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.jdbcdemo.springbootjdbcdemo.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//creating custom row maaper
	class PersonCustomRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person=new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Person> findAll(){
		//using default row mapper
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findAllByCustomRowMapper(){
		//using default row mapper
		return jdbcTemplate.query("select * from person", new PersonCustomRowMapper());
	}
	
	public Person findById(int id){
		//using default row mapper
		return jdbcTemplate.queryForObject("select * from person where id = ?"
		, new BeanPropertyRowMapper<Person>(Person.class),id);
	}
	
	public int deleteById(int id){
		return jdbcTemplate.update("delete from person where id = ?",id);
	}
	
	public int insert(Person person){
		return jdbcTemplate.update("insert into person (id,name,location,birth_date) values(?,?,?,?) ",person.getId(),person.getName(),person.getLocation(),person.getBirthDate());
	}
	
	public int update(Person person){
		return jdbcTemplate.update("update person set name = ? ,location=? where id= ? ",person.getName(),person.getLocation(),person.getId());
	}



}
