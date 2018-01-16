package net.leogaming.testapp.entity.request;

import net.leogaming.testapp.entity.AttributeEntity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentEntity extends AbstractRequestBody {

    @XmlAttribute(required = true)
    private long id;

    @XmlAttribute(required = true)
    private int sum;

    @XmlAttribute(required = true)
    private int check;

    @XmlAttribute(required = true)
    private int service;

    @XmlAttribute(required = true)
    private String account;

    @XmlAttribute(required = true)
    private String date;

    @XmlElement
    private List<AttributeEntity> attributes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<AttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeEntity> attributes) {
        this.attributes = attributes;
    }
}
