package net.leogaming.testapp.utils;

import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.response.Response;
import net.leogaming.testapp.entity.response.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class XmlConverter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String convertToString(Request request) throws JAXBException {
        logger.debug(request.toString());

        StringWriter writer = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(request.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(request, writer);

        String xml = writer.toString();
        logger.debug(xml);
        return xml;
    }

    public Response convertXmlToResponse(String xml) throws JAXBException {
        logger.debug("convertXmlToResponse" + xml);

        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String preparedXml = xml.substring(xml.indexOf("<response"), xml.lastIndexOf(",{Date"));

        logger.debug("preparedXml " + preparedXml);

        Response response = (Response) unmarshaller.unmarshal(new StringReader(preparedXml));

        logger.debug("ResponseEntity " + response.toString());
        return  response;
    }
}
