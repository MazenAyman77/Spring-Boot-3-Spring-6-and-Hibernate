package com.mazenscode.cruddemo.entity;

public class ExceptionHandlerFormat {

    private int status;
    private String body;
    private long timeStamp;

    public ExceptionHandlerFormat(int status, String body, long timeStamp) {
        this.status = status;
        this.body = body;
        this.timeStamp = timeStamp;
    }

    public ExceptionHandlerFormat() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ExceptionHandlerFormat{" +
                "status=" + status +
                ", body='" + body + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
