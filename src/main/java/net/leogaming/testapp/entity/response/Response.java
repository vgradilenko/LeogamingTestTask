package net.leogaming.testapp.entity.response;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlAttribute
    private String server;

    @XmlElementRef
    private List<ResultEntity> responseBody;


    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }


    public List<ResultEntity> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(List<ResultEntity> responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "Response{" +
                "server='" + server + '\'' +
                ", responseBody=" + responseBody +
                '}';
    }
}
