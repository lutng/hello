package com.coding;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDataDemoApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {

		System.out.println(dataSource.getClass());


		Connection connection = dataSource.getConnection();

		System.out.println(connection);

		DruidDataSource druidDataSource =  (DruidDataSource)this.dataSource;
		System.out.println(druidDataSource.getActiveCount());
		System.out.println(druidDataSource.getActivePeak());

	}

}
