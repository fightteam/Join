#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.web.common;

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
    @Value("${symbol_pound}{heProps['br.msg']}")
    public String brMsg;
    @Value("${symbol_pound}{heProps['br.code']}")
    public int brCode;
    @Value("${symbol_pound}{heProps['ua.msg']}")
    public String uaMsg;
    @Value("${symbol_pound}{heProps['ua.code']}")
    public int uaCode;
    @Value("${symbol_pound}{heProps['nf.msg']}")
    public String nfMsg;
    @Value("${symbol_pound}{heProps['nf.code']}")
    public int nfCode;
    @Value("${symbol_pound}{heProps['mna.msg']}")
    public String mnaMsg;
    @Value("${symbol_pound}{heProps['mna.code']}")
    public int mnaCode;
    @Value("${symbol_pound}{heProps['rt.msg']}")
    public String rtMsg;
    @Value("${symbol_pound}{heProps['rt.code']}")
    public int rtCode;
    @Value("${symbol_pound}{heProps['umt.msg']}")
    public String umtMsg;
    @Value("${symbol_pound}{heProps['umt.code']}")
    public int umtCode;
    @Value("${symbol_pound}{heProps['ise.msg']}")
    public String iseMsg;
    @Value("${symbol_pound}{heProps['ise.code']}")
    public int iseCode;
    @Value("${symbol_pound}{heProps['ni.msg']}")
    public String niMsg;
    @Value("${symbol_pound}{heProps['ni.code']}")
    public int niCode;
    @Value("${symbol_pound}{heProps['su.msg']}")
    public String suMsg;
    @Value("${symbol_pound}{heProps['su.code']}")
    public int suCode;
}
