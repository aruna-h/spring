package com.bridgelabz.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.Customer;

/**
 * @author bridgelabz
 *
 */
@RestController
public class SpringBootController {

	@PostMapping(path = "/save-cust-info")
	public String customerInformation(@RequestBody Customer cust) {
		return "Customer information saved successfully ::." + cust.getCustNo() + " " + cust.getName() + " "
				+ cust.getCountry();
	}
}
// http://localhost:8080/spring-boot-restful-post-json/save-cust-info