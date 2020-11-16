package com.custodian.open.api.test;

import com.alibaba.fastjson.JSONObject;
import com.custodian.open.api.dto.WithdrawReq;
import com.custodian.open.api.enums.CoinTypeEnum;
import com.custodian.open.api.util.HmacSHA256Base64Util;
import okhttp3.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class WithdrawTest {

    String host = "https://preopenapi.safeoncustodian.com";
    private static final String apiKey = "2917395a08a443778bb65452998c9af8";
    private static final String apiSecret = "2f7f3b28-e873-4da7-af95-96778d8aaecf";
    private static final String apiPassphrase = "11111111";



    @Test
    public void withdraw() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "POST";
        String requestPath = "/v1/api/trans/withdrawal";
        String requestQueryStr = "";

        WithdrawReq req = new WithdrawReq();


        req.setRequest_id("test_txid-001");
        req.setCoin_type(CoinTypeEnum.ETH.value());
        req.setTo_address("0x2445Ef446edD1D949F9E958C86806ADF3BC82B7a");
        req.setTx_amount("0.001");
        req.setNote("test");


        TreeMap<String,String> map = JSONObject.parseObject(req.toString(),TreeMap.class);
        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, map);

        String authorizationStr = String.format("%s:%s:%s",apiKey,timeStampStr,sign);

        System.out.println("Request Url:"+ host+requestPath+"?"+requestQueryStr );
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, JSONObject.toJSONString(req));
        Request request = new Request.Builder()
                .url(host+requestPath)
                .post(body)
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
