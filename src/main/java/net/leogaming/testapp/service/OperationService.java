package net.leogaming.testapp.service;

import net.leogaming.testapp.entity.request.PaymentEntity;
import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.request.StatusEntity;
import net.leogaming.testapp.entity.request.VerifyEntity;

import net.leogaming.testapp.entity.response.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class OperationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RequestHelper requestHelper;

    @Autowired
    public OperationService(RequestHelper requestHelper) {
        this.requestHelper = requestHelper;
    }

    public ResultEntity verify(int point, VerifyEntity verifyEntity) throws JAXBException, SignatureException {
        Request request = new Request(point, Collections.singletonList(verifyEntity));
        logger.debug("verify: requestEntity " + request.toString());
        ResultEntity resultEntity = requestHelper.executeRequest(request).getResponseBody().get(0);
        logger.debug("verify: ResultEntity " + resultEntity.toString());
        return  resultEntity;
    }

    public List<ResultEntity> payment(int point, List<PaymentEntity> paymentEntityList) throws JAXBException, SignatureException {
        Request request = new Request(point, paymentEntityList);
        logger.debug("payment: " + request.toString());
        List<ResultEntity> responseBodies = requestHelper.executeRequest(request).getResponseBody();
        logger.debug("payment: " + responseBodies.toString());
        return responseBodies;
    }

    public List<ResultEntity> status(int point, List<StatusEntity> statusEntityList) throws JAXBException, SignatureException {
        Request request = new Request(point, statusEntityList);
        logger.debug("status: " + request.toString());
        List<ResultEntity> responses = requestHelper.executeRequest(request).getResponseBody();
        logger.debug("status: " + responses.toString());
        return responses;
    }
}

