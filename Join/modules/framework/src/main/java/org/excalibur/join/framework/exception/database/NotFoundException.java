package org.excalibur.join.framework.exception.database;


import org.excalibur.join.framework.exception.BaseException;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-24
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class NotFoundException extends BaseException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
