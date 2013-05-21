package org.excalibur.join.framework.core.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-23
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */
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

    public static final String loginCount = "login_failure_count";

    //新设置
    public static final String loginFilter = "/admin/";
    public static final String EMAIL_DEFAULT_ENCODING = "UTF-8";

    public static final String regUserForm = "registerUserForm";
    public static final String loginUserForm = "loginUserForm";
    public static final String addUserForm = "addUserForm";
    public static final String changeAccountForm = "changeAccountForm";
    public static final String token = "token";

    public static final String userInSession = "com.yourpackagename.user";
    public static final String formEncoded = "application/x-www-form-urlencoded";

    @Value("#{amProps['unf.msg']}")
    public String unfMsg;

    @Value("#{amProps['ise.code']}")
    public int iseCode;

    @Value("#{amProps['vdn.code']}")
    public int vdnCode;

    @Value("#{amProps['unf.code']}")
    public int unfCode;
}
