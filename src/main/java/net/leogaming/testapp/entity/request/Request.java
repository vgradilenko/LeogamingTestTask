package net.leogaming.testapp.entity.request;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request {

    @XmlAttribute(required = true)
    private int point;

    @XmlElementRef
    private List<? extends AbstractRequestBody> requestBody;

    public Request() {
    }

    public Request(int point, List<? extends AbstractRequestBody> requestBody) {
        this.point = point;
        this.requestBody = requestBody;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<? extends AbstractRequestBody> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(List<? extends AbstractRequestBody> requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "Request{" +
                "point=" + point +
                ", requestBody=" + requestBody +
                '}';
    }
}
