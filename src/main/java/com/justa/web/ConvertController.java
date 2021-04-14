package com.justa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.justa.service.convert.Convert;
import com.justa.service.convert.ConvertSIDTO;

@RestController
@RequestMapping("units")
@CrossOrigin("*")
public class ConvertController {

    @Autowired
    private Convert convertService;

    @GetMapping("/si")
    public ConvertSIDTO convertSI(@RequestParam(required = true) String units) {

	try {
	    return this.convertService.convertSI(units);
	} catch (Exception e) {
	    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
	}
    }

}
