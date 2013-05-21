package org.excalibur.join.framework.core.response;

import org.excalibur.join.framework.core.common.Key;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 下午12:58
 *
 */

@XmlRootElement(name = Key.response)
public class Response implements Serializable {
    private class Result {}
    @XmlElement(type = Object.class)
    private Object result;
    @XmlElement
    private Meta meta = new Meta();


    public void setError(int code, String msg) {
        meta.setCode(code);
        result = msg;
    }


    public void setError(int code, Object msg) {
        meta.setCode(code);
        result = msg;
    }

    public Object getResult() {
        return result;
    }


    public void setResult(Object result) {
        this.result = result;
    }


    public Meta getMeta() {
        return meta;
    }


    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    public String toString() {
        return "Response{" +
                "result=" + result +
                ", meta=" + meta +
                '}';
    }
}
