package com.db.stock.TransactionManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransactionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementApplication.class, args);
	}

}
