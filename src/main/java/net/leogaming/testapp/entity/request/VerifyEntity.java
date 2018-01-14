package net.leogaming.testapp.entity.request;

import com.sun.istack.internal.NotNull;
import net.leogaming.testapp.entity.AttributeEntity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "verify")
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyEntity extends AbstractRequestBody {

    @NotNull
    @XmlAttribute private int service;

    @NotNull
    @XmlAttribute private String account;

    @XmlElement private List<AttributeEntity> attributes;

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
        this.attributes = attributes;
    }
}
