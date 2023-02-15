package com.tmg.xpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;


@SpringBootApplication
public class XpensesApplication {

	public static void main(String[] args) {

		SpringApplication.run(XpensesApplication.class, args);
	}


	/**
	 * bean responsible to create connection to hosted astra db
	 * @param dataStaxAstraProperties
	 * @return
	 */
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties dataStaxAstraProperties, AstraDbConnectProperties connectProperties){
		Path bundle = dataStaxAstraProperties.getSecureConnectBundle().toPath();
		String clientId=connectProperties.getAstraDbUsername();
		String password= connectProperties.getAstraDbPassword();
		String token =connectProperties.getAstraDbToken();

		return builder-> builder
				.withAuthCredentials(clientId, password, token)
				.withCloudSecureConnectBundle(bundle);

	}

}
