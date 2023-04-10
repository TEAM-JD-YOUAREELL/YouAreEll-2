//import spiffyUrlManipulator
package controllers;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import org.apache.http.client.methods.HttpGet;


import javax.json.JsonString;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private HttpGet requestId = new HttpGet("http://zipcode.rocks:8085/ids");
    private HttpGet requestMessage = new HttpGet("http://zipcode.rocks:8085/messages");


    private ServerController svr = new ServerController();

    private ServerController() throws MalformedURLException {
        ids = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public ServerController shared() {
        return svr;
    }


    // url -> /ids/
    //http://zipcode.rocks:8085/ids is where we get the info.
    // send the server a get with url
    //git from http://zipcode.rocks:8085/ids
    // return json from server
    public JsonString idGet() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(rootURL + "/ids");
        ids = mapper.readValues(url, new TypeReference<List<Id>>(){});
        String studentJson = "";

        try{
            studentJson = mapper.writeValueAsString(ids);
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        return studentJson;
    }

    // url -> /ids/
    // create json from Id
    // request
    // reply
    // return json
    public JsonString idPost(Id id) {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(rootURL + "/ids");
        myId = id;

        String jsonInString = mapper.writeValueAsString(myId);
        System.out.println(jsonInString);

        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonInString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while((responseLine = br.readLine()) != null){
                response.append(responseLine.trim());
            }
            System.out.println(response);
        }

        return jsonInString;
    }
    public JsonString idPut(Id id) {
        // url -> /ids/
        Scanner console = new Scanner(System.in);
        String inputId = console.next();
        String inputName = console.next();
        String inputGit = console.next();
        myId = id;
        myId.setUid(inputId);
        myId.setName(inputId);
        myId.setGithub(inputId);
        return String.valueOf(myId);
    }


}

// ServerController.shared.doGet()