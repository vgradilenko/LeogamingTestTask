package net.leogaming.testapp.entity.request;

import net.leogaming.testapp.entity.AttributeEntity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "verify")
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyEntity extends AbstractRequestBody {

    @XmlAttribute(required = true)
    private int service;

    @XmlAttribute(required = true)
    private String account;

    @XmlElement
    private List<AttributeEntity> attributes;

    public VerifyEntity() {
    }

    public VerifyEntity(int service, String account, List<AttributeEntity> attributes) {
        this.service = service;
        this.account = account;
        this.attributes = attributes;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<AttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeEntity> attributes) {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "VerifyEntity{" +
                "service=" + service +
                ", account='" + account + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
