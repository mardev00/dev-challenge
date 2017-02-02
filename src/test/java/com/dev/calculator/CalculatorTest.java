package com.dev.calculator;

import org.junit.Assert;
import org.junit.Test;

import com.dev.calculator.Calculator;

public class CalculatorTest {
	
	@Test
	public void testAddition() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i + j , 10, 20);
		Assert.assertEquals(30, result);
	}
	
	
	@Test
	public void testSubstraction() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i - j , 3, 1);
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void testMultiplication() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i * j , 3, 2);
		Assert.assertEquals(6, result);
	}
	
	
	@Test
	public void testDivision() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> i / j , 20, 2);
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void testMean() {
		Calculator myCalc = new Calculator();
		int result = myCalc.eval((i, j ) -> (i + j)/2 , 20, 30);
		Assert.assertEquals(25, result);
	}


}
