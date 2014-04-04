package org.fightteam.join.auth.common;

import org.fightteam.join.auth.web.controller.UserController;
import org.junit.Test;
import org.springframework.security.config.http.MatcherType;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MatcherTypeTest {

    @Test
    public void test01(){

        System.out.println(MatcherType.ciRegex);
        System.out.println(MatcherType.ant);
        System.out.println(MatcherType.regex);
    }

    @Test
    public void test02(){
        Pattern pattern = Pattern.compile("");
        pattern.matcher("192.168.103.1");
    }

    @Test
    public void test03(){
        Method[] methods = UserController.class.getMethods();

        for (Method method:methods){
            System.out.println(method.getName());
        }
    }
}
