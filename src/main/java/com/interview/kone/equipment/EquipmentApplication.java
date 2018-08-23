package com.interview.kone.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:cloudant.properties")
public class EquipmentApplication {

		public static void main(String[] args) {
				SpringApplication.run(EquipmentApplication.class, args);
		}
}
