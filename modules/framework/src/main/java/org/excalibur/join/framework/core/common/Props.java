package org.excalibur.join.framework.core.common;


import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzy77_000
 * Date: 13-3-23
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
public class Props {
    public @Value("#{fProps['avalon.host']}") String fHost;
    public @Value("#{fProps['avalon.api.path']}") String fApiPath;
    public @Value("#{fProps['avalon.web.path']}") String fWebPath;
    public @Value("#{fProps['avalon.user.country']}") String fUserCountry;

    public @Value("#{mailProps['mail.fromAddress']}") String fromAddress;
    public @Value("#{mailProps['mail.sub.verificationEmail']}") String subVerificationEmail;
    public @Value("#{mailProps['mail.sub.confirmationEmail']}") String subConfirmationEmail;
    public @Value("#{mailProps['mail.sub.registerEmail']}") String subRegisterEmail;

    public @Value("#{mailProps['mail.verifyUrl']}") String verifyUrl;
    public @Value("#{mailProps['mail.maxVerfyMinutes']}") String maxVerfyMinutes;

    public @Value("#{mailProps['mail.attachmentPath']}") String attachmentPath;

    public List<String> webAuthRoutes;
    public List<String> apiAuthRoutes;




}
