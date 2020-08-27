package com.jdbcAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/userdb";
		String dbusername = "root";
		String dbpassword = "123456789";

		Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);
		connection.setAutoCommit(false);

		PreparedStatement ps = connection.prepareStatement("insert into customer values(?,?,?,?)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("enter customer id");
			String s1 = br.readLine();
			int id = Integer.parseInt(s1);

			System.out.println("enter customer name");
			String name = br.readLine();

			System.out.println("enter customer township");
			String township = br.readLine();

			System.out.println("enter amount");
			String s2 = br.readLine();
			double amount = Double.parseDouble(s2);

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, township);
			ps.setDouble(4, amount);
			ps.executeUpdate();

			System.out.println("saved/back");
			String answer = br.readLine();

			if (answer.equals("saved")) {
				connection.commit();
			}
			if (answer.equals("back")) {
				connection.rollback();
			}

			System.out.println("Want to add more records add/stop");

			String ans = br.readLine();
			if (ans.equals("stop")) {
				break;
			}
			connection.commit();
			System.out.println("Successfully inserted");
			
			Bank first = new Bank();
			first.setId(id);
			first.setAmount(amount);
			ps.executeUpdate();
			
			Bank second = new Bank();
			second.setId(id);
			second.setAmount(amount);
			ps.executeUpdate();
			
			System.out.printf("Account #%s has initial balance of $%.2f%n", first.getId(), first.getAmount());

			System.out.printf("Account #%s has initial balance of $%.2f%n", second.getId(), second.getAmount());
			
		}

		

	}
}
