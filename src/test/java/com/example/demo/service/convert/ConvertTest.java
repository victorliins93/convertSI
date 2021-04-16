package com.example.demo.service.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.justa.ConvertApplication;
import com.justa.service.convert.Convert;


@SpringBootTest(classes = ConvertApplication.class)
public class ConvertTest {
    
    @SpyBean
    Convert service;
    
    @Test
    private String getUnitNameTest() {
	String expression = "(degree/(minute*hectare))";
	String convertExpression = service.getUnitName(expression);
	
	assertEquals(convertExpression, "(rad/(s*m²))");
	return expression;
    }
    
    @Test
    private String getMultiplicationFactorTest() {
	String expression = "(degree/(minute*hectare))";
	String convertExpression = service.getMultiplicationFactor(expression);
	
	assertEquals(convertExpression, "0,000000029088820866572");
	return expression;
    }

}
