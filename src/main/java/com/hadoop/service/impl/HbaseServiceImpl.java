package com.hadoop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadoop.entity.Hbase;
import com.hadoop.service.HbaseService;

@Service
public class HbaseServiceImpl implements HbaseService {

	@Autowired
	private HbaseService hbaseService;

	@Override
	public String createTable(Hbase hbase) {
		return hbaseService.createTable(hbase);
	}

}
