package org.excalibur.join.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: excalibur
 * Date: 13-5-5
 * Time: 上午10:25
 * 系统关键字定义
 */
@Component("key")
public class Key {
    public static final String meta = "meta";
    public static final String result = "result";
    public static final String id = "id";

    public static final String redirect = "redirect:";
    public static final String response = "response";
    public static final String user = "user";
    public static final String role = "role";
    public static final String address = "address";
    public static final String isLogin = "ls";
    public static final String isRegister = "rs";
    public static final String isEmailConfirmed = "ecs";
    public static final String captcha = "captcha";

    @Value("#{amProps['unf.msg']}")
    public String unfMsg;

    @Value("#{amProps['ise.code']}")
    public int iseCode;

    @Value("#{amProps['vdn.code']}")
    public int vdnCode;

    @Value("#{amProps['unf.code']}")
    public int unfCode;
}
