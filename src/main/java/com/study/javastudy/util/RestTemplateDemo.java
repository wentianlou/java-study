package com.study.javastudy.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author wentianlou
 * @date 2020/3/9 10:02
 **/
public class RestTemplateDemo {
    @Value("${live.visitor.payment.address}")
    private String visitorAddress;
    private SimpleClientHttpRequestFactory requestFactory;

    public Result iosOrderVerification(String orderId, String payToken, String sign) {
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String url = visitorAddress + "/o/v1.0/live/checkPayOrder/ios";
        try{
            JSONObject postData = new JSONObject();
            postData.put("orderId", orderId);
            postData.put("payToken", payToken);
            postData.put("sign", sign);

            HttpEntity<String> formEntity = getHttpEntity(postData);

            JSONObject result = restTemplate.postForObject(url, formEntity, JSONObject.class);
            if(result == null) {
                return new Result(ResultCodeEnum.RPC_ERROR, "false", null);
            }
            if(result.getInteger("code") == 0){
                return new Result(200,"ok",result.get("data"));
            }else{
                return new Result(result.getInteger("code"), result.getString("msg"), result.get("data"));
            }
        }
        catch (Exception e){

        }

        return new Result(ResultCodeEnum.RPC_ERROR, "false",null);
    }

    private HttpEntity<String> getHttpEntity(JSONObject postData){
        //设置Http Header
        HttpHeaders headers = new HttpHeaders();
        //设置请求媒体数据类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //设置返回媒体数据类型
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(postData.toString(), headers);
        return formEntity;
    }
}
