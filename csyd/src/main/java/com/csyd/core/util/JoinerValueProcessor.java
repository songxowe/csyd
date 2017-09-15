package com.csyd.core.util;

import com.csyd.pojo.Joiner;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JoinerValueProcessor implements JsonValueProcessor {
    public JoinerValueProcessor() {

    }

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value) {
        if (value instanceof Joiner) {
            return ((Joiner) value).getJoinerName();
        }
        return value == null ? "" : value.toString();
    }

}
