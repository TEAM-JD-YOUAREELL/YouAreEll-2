package controllers;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
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


    public ArrayList<Message> getMessages() {
        return null;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}