package org.fightteam.join.core.exception;

/**
 * 基础异常类
 *
 * 方便最得意异常
 *
 * @author faith
 * @since 0.0.1
 */
public class BaseException extends Exception {

    /**
     * 基于protected 子类可以继承
     *
     * 用于记录错误编码等等
     * 抛出的地方设置
     */
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
