/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_task_comments;

import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author a.bahgat
 */
public class HttpClient {
    
    public String GetAPI(String url) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);

            // In case of code status is not 200 return Error
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed Http Error Code: " + response.getStatusLine().getStatusCode());
            }

            HttpEntity httpEntity = response.getEntity();
            String apiOutPut = EntityUtils.toString(httpEntity);
            System.out.println(apiOutPut);
            return apiOutPut;

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
