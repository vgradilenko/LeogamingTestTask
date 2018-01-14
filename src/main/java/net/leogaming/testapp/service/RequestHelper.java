package net.leogaming.testapp.service;

import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestHelper {
    private final static String URL = "https://test.lgaming.net/external/extended";
    private final RestTemplate restTemplate;

    @Autowired
    public RequestHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Response makeRequest(Request request){
        HttpHeaders headers = new HttpHeaders();
    //    headers.add("Content-Type", "application/xml");
        HttpEntity<Request> requestHttpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<Response> responseEntity = restTemplate.postForEntity(URL, requestHttpEntity, Response.class);
        return responseEntity.getBody();
    }
}
