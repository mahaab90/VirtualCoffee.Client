package com.thinkit.virtualCoffee.client.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SearchResponseModel {
  List<String> participants;
  public List<String> getParticipants() {
	return participants;
}
public void setParticipants(List<String> participants) {
	this.participants = participants;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}
int start;
  int end;
  
}
