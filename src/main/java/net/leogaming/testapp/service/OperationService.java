package net.leogaming.testapp.service;

import net.leogaming.testapp.entity.request.PaymentEntity;
import net.leogaming.testapp.entity.request.Request;
import net.leogaming.testapp.entity.request.StatusEntity;
import net.leogaming.testapp.entity.request.VerifyEntity;

import net.leogaming.testapp.entity.response.AbstractResponseBody;
import net.leogaming.testapp.entity.response.Response;
import net.leogaming.testapp.entity.response.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OperationService {
    private final RequestHelper requestHelper;

    @Autowired
    public OperationService(RequestHelper requestHelper) {
        this.requestHelper = requestHelper;
    }

    public ResultEntity verify(int point, VerifyEntity verifyEntity) {
        Request request = new Request(point, Collections.singletonList(verifyEntity));
        Response response = requestHelper.makeRequest(request);
        return (ResultEntity) response.getResponseBody().get(0);
    }

    public List<ResultEntity> payment(int point, List<PaymentEntity> paymentEntityList) {
        Request request = new Request(point, paymentEntityList);
        List<AbstractResponseBody> responseBodies = requestHelper.makeRequest(request).getResponseBody();
        return getResultEntity(responseBodies);
    }

    public List<ResultEntity> status(int point, List<StatusEntity> statusEntityList) {
        Request request = new Request(point, statusEntityList);
        List<AbstractResponseBody> responses = requestHelper.makeRequest(request).getResponseBody();
        return getResultEntity(responses);
    }

    private List<ResultEntity> getResultEntity(List<AbstractResponseBody> abstractResponseBodies) {
        List<ResultEntity> resultEntities = new ArrayList<>();
        for(AbstractResponseBody body: abstractResponseBodies) {
            resultEntities.add((ResultEntity)body);
        }

        return resultEntities;
    }
}
