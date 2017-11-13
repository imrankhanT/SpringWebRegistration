package com.bridgelabz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bridgelabz.model.Employee;
import com.bridgelabz.service.DAOMethods;

public class DataBaseOperation implements DAOMethods {

	@Autowired
	Employee employee;

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String fetchEmployee() {
		return jdbcTemplate.query("select * from Employee77", new ResultSetExtractor<String>() {
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					String name = rs.getString(1);
					String mail_Id = rs.getString(2);
					String password = rs.getString(3);

					if (mail_Id.equals(employee.getMail()) && password.equals(employee.getPassword())) {
						System.out.println(name);
						return name;
					}
				}
				return null;
			}
		});
	}

	public String emailValidaton() {

		return jdbcTemplate.query("select * from Employee77 where mail='" + employee.getMail() + "'",
				new ResultSetExtractor<String>() {
					public String extractData(ResultSet result) {
						String name = null;
						try {
							if (result.next()) {
								name = "User Already Exist with this Email or mobile number";
							} else {
								String query = "insert into Employee77 values('" + employee.getName() + "','"
										+ employee.getMail() + "','" + employee.getPassword() + "','"
										+ employee.getConfirmPassword() + "','" + employee.getMobileNum() + "')";
								int queryResult = jdbcTemplate.update(query);
								if (queryResult > 0) {
									name = "login";
								} else {
									name = "Registration UnSuccessfull, Please Register Again...";
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return name;
					}
				});
	}

}
