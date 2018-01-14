package net.leogaming.testapp.entity.request;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({VerifyEntity.class, PaymentEntity.class, StatusEntity.class})
public abstract class AbstractRequestBody {
}
