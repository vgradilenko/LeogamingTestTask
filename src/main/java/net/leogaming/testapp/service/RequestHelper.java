package net.leogaming.testapp.service;

import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.response.Response;
import net.leogaming.testapp.entity.response.ResultEntity;
import net.leogaming.testapp.utils.XmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.security.SignatureException;
import java.util.List;

@Component
public class RequestHelper {
    private final static String URL = "https://test.lgaming.net/external/extended";
    private final RestTemplate restTemplate;
    private final XmlConverter converter;
    private final EncryptionService encryptionService;

    @Autowired
    public RequestHelper(RestTemplate restTemplate, XmlConverter converter, EncryptionService encryptionService) {
        this.restTemplate = restTemplate;
        this.converter = converter;
        this.encryptionService = encryptionService;
    }

    public Response executeRequest(Request request) throws JAXBException, SignatureException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        String preparedXml = converter.convertToString(request);

        headers.add("PayLogic-Signature", encryptionService.sign(preparedXml));
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(preparedXml, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, requestHttpEntity, String.class);

        String string = responseEntity.getBody();
        HttpHeaders responseHeader = responseEntity.getHeaders();
        List<String> value = responseHeader.get("PayLogic-Signature");
        boolean bool = encryptionService.verify(string, value.get(0));

        return converter.convertXmlToResponse(responseEntity.toString());
    }
}
