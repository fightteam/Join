package org.excalibur.join.framework.core.response;

/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 下午1:00
 * To change this template use File | Settings | File Templates.
 */
public class Meta {
    private int code;
    private String responseTime;
    private long responseTimeL;
    private long timeOfRequest;


    public Meta() {
        this.timeOfRequest = System.currentTimeMillis();
    }
    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public long getTimeOfRequest() {
        return timeOfRequest;
    }


    public void setTimeOfRequest(long timeOfRequest) {
        this.timeOfRequest = System.currentTimeMillis();
    }


    public String getResponseTime() {
        responseTimeL = System.currentTimeMillis() - timeOfRequest;
        return responseTimeL + " ms";
    }


    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }


    @Override
    public String toString() {
        return "Meta{" +
                "code=" + code +
                ", responseTime=" + responseTime +
                '}';
    }
}
