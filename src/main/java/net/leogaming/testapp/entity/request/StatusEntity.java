package net.leogaming.testapp.entity.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusEntity extends AbstractRequestBody {

    @XmlAttribute(required = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
