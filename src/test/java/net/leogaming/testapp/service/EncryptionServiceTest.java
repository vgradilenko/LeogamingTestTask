package net.leogaming.testapp.service;

import org.junit.Before;
import org.junit.Test;

import java.security.SignatureException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class EncryptionServiceTest {
    EncryptionService service;
    SecurityKeyReader reader;

    @Test
    public void sign() throws Exception {
        reader = new SecurityKeyReader();
        service = new EncryptionService(reader.getPrivateKey(), reader.getPublicKey());
        String preparedMassage = "nakXqK8IwKZiRaMFEKfTotzs0GZWUtIhs+M127b0US56TGleq8YTbqtf1uqPR3O+Q1gymsGRUrIp68B6f6Eznx7Zy+req3wKWd4Fs1uFfZWGL0UxRkDMUmMl4aubvCv4wiuKw3J2hsCIm4Ppt62IM5wuqdqL7yXmC3ZAB8zXsS8=";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<request point=\"327\">\n" +
                "    <verify service=\"1\" account=\"12345\">\n" +
                "        <attributes name=\"key\" value=\"value\"/>\n" +
                "    </verify>\n" +
                "</request>";

        String encrypted = service.sign(xml);

        assertThat(preparedMassage, is(encrypted));
    }

    @Test
    public void verify() throws Exception {
        reader = new SecurityKeyReader();
        service = new EncryptionService(reader.getPrivateKey(), reader.getPublicKey());
        String preparedMassage = "nakXqK8IwKZiRaMFEKfTotzs0GZWUtIhs+M127b0US56TGleq8YTbqtf1uqPR3O+Q1gymsGRUrIp68B6f6Eznx7Zy+req3wKWd4Fs1uFfZWGL0UxRkDMUmMl4aubvCv4wiuKw3J2hsCIm4Ppt62IM5wuqdqL7yXmC3ZAB8zXsS8=";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<request point=\"327\">\n" +
                "    <verify service=\"1\" account=\"12345\">\n" +
                "        <attributes name=\"key\" value=\"value\"/>\n" +
                "    </verify>\n" +
                "</request>";

        boolean testTrue = service.verify(xml, preparedMassage);
        boolean testFalse = service.verify("String", preparedMassage);

        assertTrue(testTrue);
        assertFalse(testFalse);

    }
}