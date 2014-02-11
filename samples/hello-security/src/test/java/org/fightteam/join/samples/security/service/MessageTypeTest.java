package org.fightteam.join.samples.security.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MessageTypeTest {

    @Test
    public void test01(){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> maps = new HashMap<>();
        maps.put("message","aaaa");
        try {
            mapper.writeValue(System.out,maps);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
