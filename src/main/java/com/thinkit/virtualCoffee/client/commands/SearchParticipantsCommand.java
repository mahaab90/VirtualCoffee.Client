package com.thinkit.virtualCoffee.client.commands;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.thinkit.virtualCoffee.client.models.SearchResponseModel;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
		  name = "find_chat"
		)
@Component
public class SearchParticipantsCommand implements Runnable{

	@Option(names = {"-s"}, required = true)
	private int start;
	@Option(names = {"-e"}, required = true)
	private int end;
	@Option(names = {"-o"}, required = true)
	private int offset;
	@Option(names = {"-n"}, required = true)
	private int participants;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ResponseEntity<SearchResponseModel> response = new RestTemplate().getForEntity(
				"http://localhost:8080/availabilities/chat?start="+start+"&end="+end+"&offset="+offset+"&numberOfParticipants="+participants, SearchResponseModel.class);
		
		if (response.getStatusCode() != HttpStatus.OK ) {
			System.out.println("Searching for available thinkiteers Failed: \n"+response.getBody().toString());
		}
		
		SearchResponseModel chat=response.getBody();
		if(chat == null) {
			System.out.println("No Thinkiteer is available for the given range of time");
			return;
		}
		System.out.println("Bellow the thinkiteers found for chat from :"+chat.getStart()+" to "+chat.getEnd());	
		System.out.println(chat.getParticipants().toString());
	}

}
