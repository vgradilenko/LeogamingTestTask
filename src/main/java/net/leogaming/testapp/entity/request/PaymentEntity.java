package net.leogaming.testapp.entity.request;

import com.sun.istack.internal.NotNull;
import net.leogaming.testapp.entity.AttributeEntity;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentEntity extends AbstractRequestBody {

    @NotNull
    @XmlAttribute private long id;

    @NotNull
    @XmlAttribute private int sum;

    @NotNull
    @XmlAttribute private int check;

    @NotNull
    @XmlAttribute private int service;

    @NotNull
    @XmlAttribute private String account;

    @NotNull
    @XmlAttribute private String date;

    @XmlElement private List<AttributeEntity> attributes;

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
