package com.semantyca.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

public class ClientRequest {
    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String args[]) throws Exception {
        putReq();
    }

    private static void getReq() throws IOException {
        HttpGet httpget = new HttpGet("http://localhost:7044/0.14.0/tasks");
        System.out.println("Request Type: " + httpget.getMethod());
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        System.out.println(httpresponse.getStatusLine());
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

    private static void putReq() {
        RequestBuilder reqbuilder = RequestBuilder.put();
        String inputJson = "{\"workQueue\": \"bla-bla\",\"priority\": \"123456789012345\"}";
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(inputJson);

            RequestBuilder requestBuilder = reqbuilder.setUri("http://localhost:7044/0.14.0/tasks/1496765").setEntity(stringEntity);
            requestBuilder.setHeader(new BasicHeader("Content-Type", "application/json"));
            HttpUriRequest httpUriRequest = requestBuilder.build();
            HttpResponse httpresponse = httpclient.execute(httpUriRequest);
            System.out.println(httpresponse.getStatusLine());

            //It is extra code fragment in order to see verbose log information
            Scanner sc = new Scanner(httpresponse.getEntity().getContent());
            while (sc.hasNext()) {
                System.out.println("content=" + sc.nextLine());
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
