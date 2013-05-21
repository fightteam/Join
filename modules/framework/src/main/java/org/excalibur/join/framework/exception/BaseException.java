package org.excalibur.join.framework.exception;

/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 上午11:05
 * 自定义基础异常类
 * 自定义异常 都应该继承该类
 */
public class BaseException  extends Exception {
    private static final long serialVersionUID = 1L;

    //由异常类抛出
    protected Object errorCode;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Object getErrorCode() {
        return errorCode;
    }
}
