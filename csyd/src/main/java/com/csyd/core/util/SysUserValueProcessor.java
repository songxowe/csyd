package com.csyd.core.util;

import com.csyd.pojo.SysUser;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class SysUserValueProcessor implements JsonValueProcessor{
    public SysUserValueProcessor() {

    }

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value) {
        if (value instanceof SysUser) {
            return ((SysUser) value).getUserFlag();
        }
        return value == null ? "" : value.toString();
    }

}
