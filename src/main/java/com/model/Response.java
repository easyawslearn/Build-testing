package com.model;

import org.apache.commons.lang3.SystemUtils;

import java.util.UUID;

public class Response {

    private boolean error;
    private String message;
    private String sysId;
    private PingAnalyticResponse pingAnalyticResponse;

    public Response(){
        error = false;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PingAnalyticResponse getPingAnalyticResponse() {
        return pingAnalyticResponse;
    }

    public void setPingAnalyticResponse(PingAnalyticResponse pingAnalyticResponse) {
        this.pingAnalyticResponse = pingAnalyticResponse;
    }
}
