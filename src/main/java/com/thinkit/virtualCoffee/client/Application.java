package com.thinkit.virtualCoffee.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.thinkit.virtualCoffee.client.commands.SearchParticipantsCommand;

import picocli.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired SearchParticipantsCommand searchParticipantsCommand;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CommandLine commandLine = new CommandLine(searchParticipantsCommand);
		commandLine.parseWithHandler(new CommandLine.RunLast(),args);
	}

	
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
