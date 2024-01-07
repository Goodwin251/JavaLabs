package com.solodkyi.java_labs.Lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;

public class WeatherAPIClient {
    public static String getWeatherData(String apiUrl) throws URISyntaxException, IOException  {
        URL url = new URI(apiUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        connection.disconnect();
        return response.toString();
    }
    
    public static void printPrettyTable(JsonNode jsonNode) {
    	String basicFormat = "| %-30s | %-50s |%n";
    	System.out.format("+--------------------------------+----------------------------------------------------+%n");
    	System.out.format("+             Keys               +                        Values                      +%n");
    	System.out.format("+--------------------------------+----------------------------------------------------+%n");
    	for (Iterator<Entry<String, JsonNode>> it = jsonNode.fields(); it.hasNext();) {
    		Entry<String, JsonNode> jsonObj = it.next();
    		if(jsonObj.getValue().isContainerNode()) {
    			System.out.format(basicFormat, jsonObj.getKey(), "");
    			if(jsonObj.getValue().fields().next().getValue().isContainerNode()) {
    				jsonObj.getValue().fields().forEachRemaining((f)-> {
    					System.out.format(basicFormat, f.getKey(), "");
        				f.getValue().elements().forEachRemaining((e)->{System.out.format(basicFormat, "", e);});
    				});
    				
    				
    			}
    			else {
    				jsonObj.getValue().elements().forEachRemaining((e) -> {System.out.format(basicFormat, "", e);});       				
    			}    			
    		}else {
    			System.out.format(basicFormat, jsonObj.getKey(), jsonObj.getValue());
    		}
    		System.out.format("+--------------------------------+----------------------------------------------------+%n");
		}
    }
}