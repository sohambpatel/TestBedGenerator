package org.testbedgenerator;

import org.apache.hc.client5.http.HttpResponseException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class OllamaGenAIRESTHandler {
    String OLLAMAURL="";
    String OLLAMAMODELNAME="";

    public OllamaGenAIRESTHandler(String ollamaurl, String ollamamodelname){
        this.OLLAMAURL=ollamaurl;
        this.OLLAMAMODELNAME=ollamamodelname;
    }

    //This is the java coded OLLAMA generate api which further reports if the OLLAMA is not returning 200
    public String generateOllamaResults(String prompt) throws Exception {
        String id = "";
        URL url = new URL(this.OLLAMAURL + "/api/generate");
        HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
        InputStream inputStream;
        try {
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
            writer.write("{\n" +
                    "  \"model\": \""+OLLAMAMODELNAME+"\",\n" +
                    "  \"prompt\":\""+prompt+"\"\n" +
                    "}");
            writer.flush();
            writer.close();
            String soham=httpConn.getOutputStream().toString();
            //httpConn.getOutputStream().close();
            int responseCode = httpConn.getResponseCode();
            if (200 <= responseCode && responseCode <= 299) {
                inputStream = httpConn.getInputStream();
            } else {
                inputStream = httpConn.getErrorStream();
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            inputStream));

            StringBuilder response = new StringBuilder();
            String currentLine;

            while ((currentLine = in.readLine()) != null)
                response.append(currentLine);
            System.out.println("We are getting response code " + responseCode);
            //System.out.println("Request which were hitting: "+httpConn.getRequestProperties());
            System.out.println("Response Message is: "+response.toString());
            in.close();
            return response.toString();
        } catch (HttpResponseException httpResponseException) {
            httpResponseException.printStackTrace();
            System.out.println("Recommendation not generated");
            return httpConn.getResponseMessage();
        }

    }
}
