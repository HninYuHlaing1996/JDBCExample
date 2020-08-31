package com.testexam;

import java.util.Arrays;
import java.util.Scanner;

public class TestExam {

	public static void main(String[] args) {

		System.out.print("Enter no of array you want in array : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("Enter all the elements");
		
		int[] elements = new int[num];
	     
		for(int i = 0; i < num; i++) {
			elements[i] = sc.nextInt();
		}
		
		Arrays.sort(elements);
		System.out.print("Even numbers in ascending order : ");
		for(int j : elements) {
			if(j % 2 == 0)
				System.out.print(j+ "  ");
		}
		
		System.out.println("");
		Arrays.sort(elements);
		System.out.print("Odd numbers in ascending order : ");
		for(int j : elements) {
			if(j % 2 != 0)
				System.out.print(j+ "  ");
		}	
		
	}

}
