package org.fightteam.join.core.exception.database;

import org.fightteam.join.core.exception.BaseException;

/**
 * 数据查询没有结果异常
 *
 * 这种异常针对单数据对象
 *
 * @author excalibur
 * @since 0.0.1
 */
public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(message);
    }


    public NotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
