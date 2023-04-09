//import spiffyUrlManipulator
package controllers;
import models.Id;
import views.Connection;

import javax.json.JsonString;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;



public class ServerController {
    URL urlID = new URL("http://zipcode.rocks:8085/ids");


    private String rootURL = "http://zipcode.rocks:8085";

    private ServerController svr = new ServerController();

    private ServerController() throws MalformedURLException {}

    public ServerController shared() {
        return svr;
    }

    public JsonString idGet() {
        // url -> /ids/
        //http://zipcode.rocks:8085/ids is where we get the info.
        // send the server a get with url
        //git from http://zipcode.rocks:8085/ids
        // return json from server
        Connection con = new Connection(urlID);

        return null;
    }


    public JsonString idPost(Id id) {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        return null;
    }
    public JsonString idPut(Id id) {
        // url -> /ids/
        return null;
    }


}

// ServerController.shared.doGet()