package com.aibot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;
    
    @Autowired
    private RestTemplate template;
    
    
    
    
    
    
    
    
    
    @GetMapping("/chatbot")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        System.out.println(chatGptResponse);
        return  chatGptResponse.getChoices().get(0).getMessage().getContent();
         
    }
    
    
    
    
    
    
    
    
    
    
}