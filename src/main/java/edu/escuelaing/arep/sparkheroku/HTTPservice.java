package edu.escuelaing.arep.sparkheroku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public abstract class  HTTPservice {
    private static final String USER_AGENT = "Mozilla/5.0";
    private HashMap<URL, String> Cache = new HashMap <URL, String> ();
    public String TimeSeriesDaily () throws IOException {
        String response = "None";
        URL url = new URL(getURL());
        if(Cache.containsKey(url)){
            return Cache.get(url);
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode==HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responsee = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responsee.append(inputLine);
            }
            in.close();
            response = responsee.toString();
        }
        else {
            System.out.println("get request not work");

        }
        Cache.put(url,response);
        return response;

    }
    abstract public String getURL();
    abstract public void setStock(String stock);
    abstract public String getStock();





}
