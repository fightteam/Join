package it.pkg.api.web.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: excalibur
 * Date: 13-5-7
 * Time: 下午4:32
 * 定义http 错误提示信息
 * 基于配置文件
 */
@Component("httpError")
public class HttpError {
    // Common HTTP errors
    @Value("#{heProps['br.msg']}")
    public String brMsg;
    @Value("#{heProps['br.code']}")
    public int brCode;
    @Value("#{heProps['ua.msg']}")
    public String uaMsg;
    @Value("#{heProps['ua.code']}")
    public int uaCode;
    @Value("#{heProps['nf.msg']}")
    public String nfMsg;
    @Value("#{heProps['nf.code']}")
    public int nfCode;
    @Value("#{heProps['mna.msg']}")
    public String mnaMsg;
    @Value("#{heProps['mna.code']}")
    public int mnaCode;
    @Value("#{heProps['rt.msg']}")
    public String rtMsg;
    @Value("#{heProps['rt.code']}")
    public int rtCode;
    @Value("#{heProps['umt.msg']}")
    public String umtMsg;
    @Value("#{heProps['umt.code']}")
    public int umtCode;
    @Value("#{heProps['ise.msg']}")
    public String iseMsg;
    @Value("#{heProps['ise.code']}")
    public int iseCode;
    @Value("#{heProps['ni.msg']}")
    public String niMsg;
    @Value("#{heProps['ni.code']}")
    public int niCode;
    @Value("#{heProps['su.msg']}")
    public String suMsg;
    @Value("#{heProps['su.code']}")
    public int suCode;
}
