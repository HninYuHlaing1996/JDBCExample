package com.variable;

class Marks {
	int engMarks;
	int mathsMarks;
	int phyMarks;
}

class InstanceVariable {
	public static void main(String args[]) {

		Marks obj1 = new Marks();
		obj1.engMarks = 50;
		obj1.mathsMarks = 80;
		obj1.phyMarks = 90;
		
		System.out.println("Marks for object:");
		System.out.println(obj1.engMarks);
		System.out.println(obj1.mathsMarks);
		System.out.println(obj1.phyMarks);
	}
}