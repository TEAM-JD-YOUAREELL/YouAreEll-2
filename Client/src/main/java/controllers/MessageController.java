package controllers;


import java.io.IOException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    private ServerController svr = new ServerController();
    private ObjectMapper mapper = new ObjectMapper();

    private String messages20;
    private String messagesForId;
    private String messageFromFriend;

    private Message messageSeq;

    private List<Message> messages;
    private List<Message> messagesId;
    private List<Message> messagesFromFriend;
    private Id myId;
    private Id told;

    // why a HashSet??
    private ServerController svr = new ServerController();
    private ObjectMapper mapper = new ObjectMapper();

    private String messages20;
    private String messagesForId;
    private String messageFromFriend;

    private Message messageSeq;

    private List<Message> messages;
    private List<Message> messagesId;
    private List<Message> messagesFromFriend;
    private Id myId;
    private Id told;

    public MessageController() throws MalformedURLException {
        messages = new ArrayList<>();
        messages20 ="";
        messagesId = new ArrayList<>();
        messagesFromFriend = new ArrayList<>();
    }


    public MessageController() throws MalformedURLException {
        messages = new ArrayList<>();
        messages20 ="";
        messagesId = new ArrayList<>();
        messagesFromFriend = new ArrayList<>();
    }


    public List<Message> getMessages()  throws Exception {
        messages = mapper.readValue(svr.messagesGet(), new TypeReference<List<Message>>());
        messages20 = mapper.writeValueAsString(messages);
        return messages;
    }

    public List<Message> getMessagesForId(Id Id) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getFromId().equals(Id.getGithub())){
                messagesId.add(messages.get(i));
            }

        }
        return messagesId;
    }
    public Message getMessageForSequence(String seq) {
        try {
            messageSeq = mapper.readValue(seq, Message.class);
        }catch (IOException e){
            throw new RuntimeException();
        }
        return messageSeq;
    }
    public List<Message> getMessagesFromFriend(Id myId, Id friendId) throws Exception {
        messages = new MessageController().getMessages();


        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}