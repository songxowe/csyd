package com.csyd.core.util;

import com.csyd.pojo.Organ;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 输出 JSON 值时部门 格式化转换
 * 
 * @author
 * 
 */
public class OrganValueProcessor implements JsonValueProcessor {
  public OrganValueProcessor() {

  }

  public Object processArrayValue(Object value, JsonConfig config) {
    return process(value);
  }

  public Object processObjectValue(String key, Object value, JsonConfig config) {
    return process(value);
  }

  private Object process(Object value) {
    if (value instanceof Organ) {
      return ((Organ) value).getOrganName();
    }
    return value == null ? "" : value.toString();
  }

}
