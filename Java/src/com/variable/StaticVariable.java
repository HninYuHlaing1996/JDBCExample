package com.variable;

class Emp {

	public static double salary = 5000;
	public static String name = "Sithu";
	
}

public class StaticVariable {
	public static void main(String args[]) {

		Emp.salary = 1000;
		System.out.println(Emp.name + "'s average salary:" + Emp.salary);
		
	}
}