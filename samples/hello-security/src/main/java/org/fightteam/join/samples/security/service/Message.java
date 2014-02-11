package org.fightteam.join.samples.security.service;

/**
 * 返回信息
 *
 * 简单返回信息封装
 *
 * @author faith
 * @since 0.0.1
 */
public class Message {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
