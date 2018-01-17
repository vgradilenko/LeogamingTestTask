package net.leogaming.testapp.utils;

import net.leogaming.testapp.config.RestTemplateConf;
import net.leogaming.testapp.entity.AttributeEntity;
import net.leogaming.testapp.entity.request.PaymentEntity;
import net.leogaming.testapp.entity.request.StatusEntity;
import net.leogaming.testapp.entity.request.VerifyEntity;
import net.leogaming.testapp.service.EncryptionService;
import net.leogaming.testapp.service.OperationService;
import net.leogaming.testapp.service.RequestHelper;
import net.leogaming.testapp.service.SecurityKeyReader;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//this monster must be delete =)
public class PreparedEntitys {
    private VerifyEntity verifyEntity;
    private PaymentEntity paymentEntity;
    private StatusEntity statusEntity;
    AttributeEntity attributeEntity;

    RestTemplateConf conf = new RestTemplateConf();
    PrivateKey privateKey = new SecurityKeyReader().getPrivateKey();
    PublicKey publicKey = new SecurityKeyReader().getPublicKey();
    EncryptionService encryptionService = new EncryptionService(privateKey, publicKey);
    RequestHelper helper = new RequestHelper(conf.restTemplate(), new XmlConverter(), encryptionService);

    public PreparedEntitys() throws Exception {
    }

    public VerifyEntity getPreparedVerifyEntity() {
        attributeEntity = new AttributeEntity("key", "value");
        verifyEntity = new VerifyEntity();

        List<AttributeEntity> entities = new ArrayList<>();
        entities.add(attributeEntity);

        VerifyEntity verifyEntity = new VerifyEntity();
        verifyEntity.setService(1);
        verifyEntity.setAccount("12345");
        verifyEntity.setAttributes(entities);
        return verifyEntity;
    }

    public PaymentEntity getPreparedPaymentEntity() {
        attributeEntity = new AttributeEntity("key", "value");
        paymentEntity = new PaymentEntity();
        paymentEntity.setId(14546);
        paymentEntity.setSum(1000);
        paymentEntity.setCheck(17235);
        paymentEntity.setService(2);
        paymentEntity.setAccount("12345");
        paymentEntity.setDate("2007-10-12T12:00:00+0300");
        paymentEntity.setAttributes(Collections.singletonList(attributeEntity));

        return paymentEntity;
    }

    public StatusEntity getStatusEntity() {
        statusEntity = new StatusEntity();
        statusEntity.setId(123);
        return statusEntity;
    }

    public OperationService getService(){
      return new OperationService(helper);
    }
}
