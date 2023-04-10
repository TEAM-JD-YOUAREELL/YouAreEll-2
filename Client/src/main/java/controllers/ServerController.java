//import spiffyUrlManipulator
package controllers;
import models.Id;

import javax.json.JsonString;
import java.net.MalformedURLException;
import java.net.URL;


public class ServerController {
    URL urlID = new URL("http://zipcode.rocks:8085/ids");


    private String rootURL = "http://zipcode.rocks:8085";

    private ServerController svr = new ServerController();

    public ServerController() throws MalformedURLException {}

    public ServerController shared() {
        return svr;
    }

    public JsonString idGet() {
        // url -> /ids/
        //http://zipcode.rocks:8085/ids is where we get the info.
        // send the server a get with url
        //git from http://zipcode.rocks:8085/ids
        // return json from server

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