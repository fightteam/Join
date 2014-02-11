package org.fightteam.join.samples.filter.security;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public abstract class AbstractJacksonMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    private static final ObjectMapper transformerFactory = new ObjectMapper();

    protected AbstractJacksonMessageConverter(MediaType supportedMediaType) {
        super(MediaType.APPLICATION_JSON);
    }

    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readFromSource(clazz, inputMessage.getHeaders(), new StreamSource(inputMessage.getBody()));
    }

    @Override
    protected void writeInternal(T t, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        writeToResult(t, outputMessage.getHeaders(), new StreamResult(outputMessage.getBody()));
    }

    protected abstract T readFromSource(Class<? extends T> clazz, HttpHeaders headers, Source source)
            throws IOException;

    protected abstract void writeToResult(T t, HttpHeaders headers, Result result)
            throws IOException;
}
