package org.fightteam.join.auth.common;

import org.junit.Test;
import org.springframework.security.config.http.MatcherType;

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
        //MatcherType matcherType = MatcherType.ciRegex.
        //System.out.println(MatcherType m);
    }
}
