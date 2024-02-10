package com.aibot;


import lombok.Data;

@Data
public class Message {

    private String role;
    private String content;//prompt
	public Message(String role, String content) {
		super();
		this.role = role;
		this.content = content;
	}
	public Message() {
		
	}
    
    
    
}
