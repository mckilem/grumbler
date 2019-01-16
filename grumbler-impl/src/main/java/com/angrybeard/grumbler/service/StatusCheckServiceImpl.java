package com.angrybeard.grumbler.service;

import com.angrybeard.grumbler.utility.ParameterStringBuilder;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatusCheckServiceImpl implements StatusCheckService {

    public int getStatusCheckResult(String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        /* params mapping */
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("param1", "val");
//
//        con.setDoOutput(true);
//        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//        out.flush();
//        out.close();

        con.setRequestProperty("Content-Type", "application/json");

        con.setConnectTimeout(1000);
        con.setReadTimeout(4000);

        int status = con.getResponseCode();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }

        return status;
    }
}