package net.leogaming.testapp.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

@Component
public class EncryptionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    @Autowired
    public EncryptionService(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String sign(String message) throws SignatureException {
        try {
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);
            sign.update(message.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(sign.sign()), "UTF-8");
        } catch (Exception ex) {
            logger.debug("some problem with sign message: " + ex);
            throw new SignatureException(ex);
        }
    }

    public boolean verify(String message, String signature) throws SignatureException {
        try {
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initVerify(publicKey);
            sign.update(message.getBytes("UTF-8"));
            return sign.verify(Base64.decodeBase64(signature.getBytes("UTF-8")));
        } catch (Exception ex) {
            logger.debug("problem with verify message: " + ex);
            throw new SignatureException(ex);
        }
    }
}
