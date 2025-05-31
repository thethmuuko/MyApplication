package com.samuel.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.samuel.entity.Person;
import com.samuel.repository.DbServiceInt;

import static com.samuel.service.MyConnection.getConnection;

public class PersonService implements DbServiceInt<Person> {
	
	@Override
	public void save(Person p) {
		try (Connection con = getConnection()) {
			Statement statement  = con.createStatement();
			statement.executeUpdate("insert into person (name, age, nrc) values ('%s', %d, '%s');".formatted(p.getName(), p.getAge(), p.getNrc()));
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Connection con = getConnection()) {
			Statement statement = con.createStatement();
			int result = statement.executeUpdate("delete from person where id = %d;".formatted(id));
			System.out.println(result);
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Person p) {
		try (Connection con = getConnection()) {
			Statement statement = con.createStatement();
			statement.executeUpdate("update person set name = %s, age  = %d, nrc = %s where id = %d;".formatted(p.getName(), p.getAge(), p.getNrc(), p.getId()));
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Person> getAll() {
		List<Person> persons = new ArrayList<>();
		
		try (Connection con = getConnection()) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from person;");
			while (rs.next()) {
				persons.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("nrc")));
			}
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return persons;
	}
}