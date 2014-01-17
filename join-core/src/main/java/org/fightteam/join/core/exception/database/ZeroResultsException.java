package org.fightteam.join.core.exception.database;

import org.fightteam.join.core.exception.BaseException;

/**
 * 数据查询结果为0
 *
 * 主要针对集合
 *
 * @author excalibur
 * @since 0.0.1
 */
public class ZeroResultsException extends BaseException {

    public ZeroResultsException(String message) {
        super(message);
    }


    public ZeroResultsException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
