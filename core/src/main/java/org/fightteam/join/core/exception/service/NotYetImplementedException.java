package org.fightteam.join.core.exception.service;

import org.fightteam.join.core.exception.BaseException;

/**
 * 没有实现异常
 * <p/>
 * 在业务逻辑定义接口时候通常会有没有实现的，为了明白其运行过程。
 * 应该抛出这个异常
 *
 * @author excalibur
 * @since 0.0.1
 */
public class NotYetImplementedException extends BaseException {

    public NotYetImplementedException(String serviceName) {
        super("Service not yet implemented: " + serviceName);
    }


    public NotYetImplementedException(String serviceName, Object errorCode) {
        super("Service not yet implemented: " + serviceName, errorCode);
    }
}
