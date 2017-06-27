package com.hadoop.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HbaseController {
	
	@RequestMapping(value = "/createTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public String createTable(@RequestBody Hbase hbase){
		
	}
}
