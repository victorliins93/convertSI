package com.justa.Util;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    
    private static double pi = Math.PI;
    
    private static Map<String, String> parametersUnit;
    static {
	parametersUnit = new HashMap<>();
	parametersUnit.put("degree", "rad");
	parametersUnit.put("minute", "s");
	parametersUnit.put("hour", "s");
	parametersUnit.put("day", "s");  
	parametersUnit.put("arcminute", "rad");    	
	parametersUnit.put("arcsecond", "rad");
	parametersUnit.put("hectare", "m²");
	parametersUnit.put("litre", "m³");
	parametersUnit.put("tonne", "kg");
    }
    
    private static Map<String, String> parametersMultiplicationFactor;
    static {
	parametersMultiplicationFactor = new HashMap<>();
	parametersMultiplicationFactor.put("degree", pi+"/180");
	parametersMultiplicationFactor.put("minute", "60");
	parametersMultiplicationFactor.put("hour", "3600");
	parametersMultiplicationFactor.put("day", "86400");  
	parametersMultiplicationFactor.put("arcminute", pi+"/10800");    	
	parametersMultiplicationFactor.put("arcsecond", pi+"/648000");
	parametersMultiplicationFactor.put("hectare", "10000");
	parametersMultiplicationFactor.put("litre", "0.001");
	parametersMultiplicationFactor.put("tonne", "1000");
    }
    public static Map<String, String> getParametersUnit() {
        return parametersUnit;
    }
    public static void setParametersUnit(Map<String, String> parametersUnit) {
        Parameters.parametersUnit = parametersUnit;
    }
    public static Map<String, String> getParametersMultiplicationFactor() {
        return parametersMultiplicationFactor;
    }
    public static void setParametersMultiplicationFactor(Map<String, String> parametersMultiplicationFactor) {
        Parameters.parametersMultiplicationFactor = parametersMultiplicationFactor;
    }



}
