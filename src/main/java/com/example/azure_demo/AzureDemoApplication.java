package com.example.azure_demo;

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
	@Value("${message}")
	String message;
	@Value("${setting}")
	String deploymentSlotSettingMsg;
	@RequestMapping("/")
	String home() throws IOException {
		String title="This is Staging env";
			return "title:"+title+"  message:"+message+"  deploymentSlotSettingMsg:"+deploymentSlotSettingMsg;
	}
	public static void main(String[] args) {
		SpringApplication.run(AzureDemoApplication.class, args);
	}

}
