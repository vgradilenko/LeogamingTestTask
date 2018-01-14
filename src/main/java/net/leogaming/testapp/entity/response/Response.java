package net.leogaming.testapp.entity.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElementRef
    private List<AbstractResponseBody> responseBody;

    public List<AbstractResponseBody> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(List<AbstractResponseBody> responseBody) {
        this.responseBody = responseBody;
    }
}
