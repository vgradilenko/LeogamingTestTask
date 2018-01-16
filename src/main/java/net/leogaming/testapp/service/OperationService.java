package net.leogaming.testapp.service;

import net.leogaming.testapp.entity.request.PaymentEntity;
import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.request.StatusEntity;
import net.leogaming.testapp.entity.request.VerifyEntity;

import net.leogaming.testapp.entity.response.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Component
public class OperationService {
    private static Logger logger = Logger.getLogger(OperationService.class.getName());
    private final RequestHelper requestHelper;

    @Autowired
    public OperationService(RequestHelper requestHelper) {
        this.requestHelper = requestHelper;
    }

    public ResultEntity verify(int point, VerifyEntity verifyEntity) throws JAXBException, SignatureException {
        Request request = new Request(point, Collections.singletonList(verifyEntity));
        return  requestHelper.executeRequest(request).getResponseBody().get(0);
    }

    public List<ResultEntity> payment(int point, List<PaymentEntity> paymentEntityList) throws JAXBException, SignatureException {
        Request request = new Request(point, paymentEntityList);
        List<ResultEntity> responseBodies = requestHelper.executeRequest(request).getResponseBody();
        return responseBodies;
    }

    public List<ResultEntity> status(int point, List<StatusEntity> statusEntityList) throws JAXBException, SignatureException {
        Request request = new Request(point, statusEntityList);
        List<ResultEntity> responses = requestHelper.executeRequest(request).getResponseBody();
        return responses;
    }
}

