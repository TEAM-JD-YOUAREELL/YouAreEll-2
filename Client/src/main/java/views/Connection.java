package views;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection extends HttpURLConnection {



    /**
     * Constructor for the HttpURLConnection.
     *
     * @param u the URL
     */
    public Connection(URL u) {

        super(u);
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {


    }
}
