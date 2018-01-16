package net.leogaming.testapp.entity.response;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultEntity {

    @XmlAttribute
    private long id;

    @XmlAttribute
    private int state;

    @XmlAttribute
    private int substate;

    @XmlAttribute
    private int trans;

    @XmlAttribute
    private int service;

    @XmlAttribute
    private int sum;

    @XmlAttribute
    private int commission;

    @XmlAttribute(required = true)
    private int code;

    @XmlAttribute(name = "final")
    private int finalStatus;

    @XmlAttribute(name = "sum_prov")
    private int sumProv;

    @XmlAttribute(name = "server_time")
    private String serverTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSubstate() {
        return substate;
    }

    public void setSubstate(int substate) {
        this.substate = substate;
    }

    public int getTrans() {
        return trans;
    }

    public void setTrans(int trans) {
        this.trans = trans;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(int finalStatus) {
        this.finalStatus = finalStatus;
    }

    public int getSumProv() {
        return sumProv;
    }

    public void setSumProv(int sumProv) {
        this.sumProv = sumProv;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id=" + id +
                ", state=" + state +
                ", substate=" + substate +
                ", trans=" + trans +
                ", service=" + service +
                ", sum=" + sum +
                ", commission=" + commission +
                ", code=" + code +
                ", finalStatus=" + finalStatus +
                ", sumProv=" + sumProv +
                ", serverTime='" + serverTime + '\'' +
                '}';
    }
}
