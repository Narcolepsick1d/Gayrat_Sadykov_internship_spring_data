package ru.sadikov.dz.magafondz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class MagafondzApplicationTests {

	@Test
	void testDBConnection() {
		String jdbcUrl="jdbc:postgresql://localhost:5432/gayrat_internship";
		String user= "postgres";
		String pass = "12345";

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
