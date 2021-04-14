package com.justa.service.convert;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.justa.Util.Parameters;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


@Service
public class Convert {

    public ConvertSIDTO convertSI(String expression) {
	return new ConvertSIDTO(getUnitName(expression), getMultiplicationFactor(expression));

    }

    public String getUnitName(String expression) {
	for (Map.Entry<String, String> entry : Parameters.getParametersUnit().entrySet()) {
	    expression = expression.replace(entry.getKey(), entry.getValue());
	}
	return expression;
    }

    public String getMultiplicationFactor(String expression) {
	final short significantDigits = 15;
	for (Map.Entry<String, String> entry : Parameters.getParametersMultiplicationFactor().entrySet()) {
	    expression = expression.replace(entry.getKey(), entry.getValue());
	}
	Expression expressionConverted = new ExpressionBuilder(expression).build();
	double result = expressionConverted.evaluate();
	short offset = (short) Math.ceil(Math.log10(result) + 1);
	return String.format("%,." + (significantDigits - offset) + "f", result);
    }
}
