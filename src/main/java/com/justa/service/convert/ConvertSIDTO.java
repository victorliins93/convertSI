package com.justa.service.convert;

public class ConvertSIDTO {
    private String unit_name;
    private String multiplication_factor;
    
    public ConvertSIDTO(String unit_name, String multiplication_factor) {
	    this.unit_name = unit_name;
	    this.multiplication_factor = multiplication_factor;
	  }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getMultiplication_factor() {
        return multiplication_factor;
    }

    public void setMultiplication_factor(String multiplication_factor) {
        this.multiplication_factor = multiplication_factor;
    }
    
}
