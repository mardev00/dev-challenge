package com.dev.calculator;

import java.util.function.BinaryOperator;

public class Calculator {

	/**
	 * Method eval takes a BinaryOperator as parameter therefore we can use Java
	 * 8 Lambdas to execute the operations in the client or test classes.
	 * Example: = Calculator myCal = new Calculator(); //Addition int result =
	 * myCalc.eval((i, j ) -> i + j , 10, 20); // result = 30
	 * 
	 * //Median int result = myCalc.eval((i, j ) -> (i + j)/2 , 20, 30); //
	 * result = 25
	 * 
	 * //Division int result = myCalc.eval((i, j ) -> i / j , 20, 2); // result
	 * = 10
	 * 
	 * @param oper
	 * @param i1
	 * @param i2
	 * @return int
	 */
	public int eval(BinaryOperator<Integer> oper, int i1, int i2) {
		return oper.apply(i1, i2);
	}

}
