package ru.sadikov.dz.magafondz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class MagafondzApplicationTests {
	@Value("${spring.datasource.url}")
	String jdbcUrl;
	@Value("${spring.datasource.username}")
	String user;
	@Value("${spring.datasource.password}")
	String pass ;
	@Test
	void testDBConnection() {



		try {
			System.out.println("Connection to database:"+jdbcUrl);

			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!!");

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
