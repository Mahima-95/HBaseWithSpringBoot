package com.hadoop.dao.impl;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hadoop.dao.HbaseDao;
import com.hadoop.entity.Hbase;

@Repository
public class HbaseDaoImpl implements HbaseDao {

	@Autowired
	private HbaseDao hbaseDao;

	@Override
	public String createTable(Hbase hbase) {
		Configuration con = HBaseConfiguration.create();

		// Instantiating HbaseAdmin class
		HBaseAdmin admin = null;
		try {
			admin = new HBaseAdmin(con);
		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Instantiating table descriptor class
		HTableDescriptor tableDescriptor = new HTableDescriptor(
				TableName.valueOf("emp"));

		// Adding column families to table descriptor
		tableDescriptor.addFamily(new HColumnDescriptor("personal"));
		tableDescriptor.addFamily(new HColumnDescriptor("professional"));

		// Execute the table through admin
		try {
			admin.createTable(tableDescriptor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Table created ");
		return hbaseDao.createTable(hbase);
	}
}
