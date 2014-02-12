package org.fightteam.join.samples.security.security;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 *
 * 主要是403没有权限异常
 *
 * 主要就返回json信息
 *
 * @author faith
 * @since 0.0.1
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> message = new HashMap<>();
//        message.put("message","Forbidden "+accessDeniedException.getMessage());
//        mapper.writeValue(response.getOutputStream(),message);

    }
}
