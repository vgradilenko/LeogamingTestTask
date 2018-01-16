package net.leogaming.testapp.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeEntity {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String value;

    public AttributeEntity() {
    }

    public AttributeEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AttributeEntity{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
