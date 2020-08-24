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
		}

		connection.commit();
		System.out.println("record successfully saved");

		/////////////
		String sql2 = "select * from customer";
		Statement statement2 = connection.createStatement(); // statement is create statement
		ResultSet result2 = statement2.executeQuery(sql2);

		while (result2.next()) {

			int id = result2.getInt("id");
			double amount = result2.getDouble("amount");

			System.out.println("Account Id : " + id + " has initial balance of " + amount);

			Bank first = new Bank();
			first.setId(id);
			first.setAmount(amount);
			ps.executeUpdate();

			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter transfer account id : ");
			String s1 = br1.readLine();
			int id1 = Integer.parseInt(s1);

			System.out.println("enter transfer amount :");
			String s2 = br1.readLine();
			double amount1 = Double.parseDouble(s2);

			Bank second = new Bank();
			second.setId(id1);
			second.setAmount(amount1);
			ps.executeUpdate();

			System.out.printf("Account #%s has initial balance of $%.2f%n", first.getId(), first.getAmount());

			System.out.printf("Account #%s has initial balance of $%.2f%n", second.getId(), second.getAmount());

			first.transferFundsA(second, amount1);

			// print new balances
			System.out.println("\nAfter \"first.transferFunds(second, 5000)\" ...");
			System.out.printf("Account #%s has new balance of $%.2f%n", first.getId(), first.getAmount());

		}

	}
}
