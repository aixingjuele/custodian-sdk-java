package com.custodian.open.api.test;

import com.custodian.open.api.util.HmacSHA256Base64Util;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;


public class GetAccountTest {

    String host = "https://preopenapi.safeoncustodian.com";
    private static final String apiKey = "2917395a08a443778bb65452998c9af8";
    private static final String apiSecret = "2f7f3b28-e873-4da7-af95-96778d8aaecf";
    private static final String apiPassphrase = "11111111";



    @Test
    public void getCustomersAccountsTest() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "GET";
        String requestPath = "/v1/api/account";
        String requestQueryStr = "";

        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, null);

        String authorizationStr = String.format("%s:%s:%s",apiKey,timeStampStr,sign);

        System.out.println("Request Url:"+ host+requestPath+"?"+requestQueryStr );
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(host+requestPath)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("AUTHORIZATION",authorizationStr)
                .addHeader("CUSTODIAN-ACCESS-PASSPHRASE",apiPassphrase)
                .build();
        Response response = client.newCall(request).execute();
        //System.out.println("result="+response.isSuccessful());
        System.out.println();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }else{
            System.out.println("error... " + response.body().string());
        }
    }

}
