package com.samuel.service;

import com.samuel.entity.Address;
import com.samuel.repository.DbServiceInt;

import static com.samuel.service.MyConnection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements DbServiceInt<Address> {

	@Override
	public void save(Address p) {
		String query = "insert into address (state, township, street) values (?,?,?);";			
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, p.getState());
			statement.setString(2, p.getTownship());
			statement.setString(3, p.getStreet());
			int result = statement.executeUpdate();
			
			System.out.println("Result : " + result);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM address WHERE ID = ?;";			
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Address p) {
		String query = "UPDATE address SET stae = ?, township = ?, street = ? WHERE id = ?;";
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, p.getState());
			statement.setString(2, p.getTownship());
			statement.setString(3, p.getStreet());
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Address> getAll() {
		String query = "";			
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}