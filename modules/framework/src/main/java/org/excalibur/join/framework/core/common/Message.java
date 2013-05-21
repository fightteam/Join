package org.excalibur.join.framework.core.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-23
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    @Value("#{msgProps['regSuccess']}")
    public String registerSuccess;
    @Value("#{msgProps['regError']}")
    public String registerError;
    @Value("#{msgProps['regCaptchaError']}")
    public String regCaptchaError;
    @Value("#{msgProps['loginSuccess']}")
    public String loginSuccess;
    @Value("#{msgProps['loginError']}")
    public String loginError;
    @Value("#{msgProps['loginCountError']}")
    public String loginCountError;
    @Value("#{msgProps['disableAccountError']}")
    public String disableAccountError;
    @Value("#{msgProps['resendEmail']}")
    public String resendEmail;
    @Value("#{msgProps['emailCnfSuccess']}")
    public String emailCnfSuccess;
    @Value("#{msgProps['userExists']}")
    public String userExists;
    @Value("#{msgProps['userExists']}")
    public String emailExists;

    @Value("#{msgProps['passwordConfirmError']}")
    public String passwordConfirmError;
    @Value("#{msgProps['passwordNull']}")
    public String passwordNull;

    @Value("#{msgProps['auth.captchaError']}")
    public String captchaError;
    @Value("#{msgProps['auth.userNotFound']}")
    public String aUserNotFound;
    @Value("#{msgProps['auth.userNotFound.code']}")
    public int aUserNotFoundCode;
    @Value("#{msgProps['auth.failed']}")
    public String aFailed;
    @Value("#{msgProps['auth.failed.code']}")
    public int aFailedCode;
    @Value("#{msgProps['auth.parametersMissing']}")
    public String aParamMissing;
    @Value("#{msgProps['auth.parametersMissing.code']}")
    public int aParamMissingCode;

    public static final String invLatitude = "Invalid latitude";
    public static final String invLongitude = "Invalid longitude";
}
