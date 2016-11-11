package com.app.utiles.other;

import android.text.TextUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2016/10/9.
 */
public class Json {
    // ----------------jackson--------------------//
    /** bean转string */
    public static String obj2Json(Object obj) {
        if (obj == null) {
            return null;
        }
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     *
     * @param json
     * @param cl
     * @return
     */
    public static Object json2Obj(String json, Class<?> cl) {
        Object obj = null;
        if (TextUtils.isEmpty(json)) {
            return obj;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
                true);
        try {
            obj = objectMapper.readValue(json, cl);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     *
     * @param json
     *            解析源
     * @param base
     * @param bean
     *            形如base<bean>
     * @return
     */
    public static Object json2Obj(String json, Class<?> base, Class<?> bean) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
                true);
        JavaType javaType = objectMapper.getTypeFactory()
                .constructParametricType(base, bean);
        Object obj = null;
        try {
            obj = objectMapper.readValue(json, javaType);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
