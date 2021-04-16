package com.example.demo.service.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.justa.ConvertApplication;
import com.justa.service.convert.Convert;

import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConvertApplication.class)
public class ConvertTest {
    
    @Autowired
    private Convert service;
    
    @Test
    public void getUnitNameTest() {
	String expression = "(degree/(minute*hectare))";
	String convertExpression = service.getUnitName(expression);
	
	assertEquals(convertExpression, "(rad/(s*m²))");
    }
    
    @Test
    public void getUnitNameWithInvalidExpressionTest() {
	String expression = "(degree/(minutes*hectare))";
	String convertExpression = service.getUnitName(expression);
	assertNotEquals(convertExpression, "(rad/(s*m²))");
    }
    
    @Test
    public void getMultiplicationFactorTest() {
	String expression = "(degree/(minute*hectare))";
	String convertExpression = service.getMultiplicationFactor(expression);
	
	assertEquals(convertExpression, "0,000000029088820866572");
    }
    
    @Test(expected = UnknownFunctionOrVariableException.class)
    public void getMultiplicationFactorWithInvalidExpressionTest() {
	String expression = "(degree/(minutes*hectare))";
	service.getMultiplicationFactor(expression);
    }

}
