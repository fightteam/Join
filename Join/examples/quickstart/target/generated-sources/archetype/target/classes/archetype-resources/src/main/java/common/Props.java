#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;


import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author: excalibur
 * Date: 13-5-5
 * Time: 上午10:28
 * 系统基本信息定义
 */
@Component("props")
public class Props {


    public List<String> webAuthRoutes;
    public List<String> apiAuthRoutes;
}
