package com.example.azure_demo;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.Inet4Address;

@RestController
@SpringBootApplication
public class AzureDemoApplication {

	@Value("${connectionString}")
	String connectionString;

	@RequestMapping("/")
	String home() throws IOException {
		ConfigurationClient configurationClient = new ConfigurationClientBuilder()
				.connectionString(connectionString)
				.buildClient();
		String message=configurationClient.getConfigurationSetting("message","").getValue();
		return message;
	}
	public static void main(String[] args) {
		SpringApplication.run(AzureDemoApplication.class, args);
	}

}
