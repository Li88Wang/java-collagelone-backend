package com.lonedog.platform.common.spring.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.client.RestTemplate;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.spring.utils.RestTemplateUtils</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * restTemplate工具类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class RestTemplateUtils {
  
  private static RestTemplate restTemplate = null;
  
  public static RestTemplate getRestTemplate(){
    if(restTemplate == null){
      synchronized (RestTemplateUtils.class) {
        if(restTemplate == null){
          restTemplate = new RestTemplate();
        }
      }
    }
    return restTemplate;
  }
  /**map转换成restTemplate.url canshu={canshu}
   * @param c
   * @param methodName
   * @return
   */
  public static String mapToVariUrl(Map<String,String> map){
    StringBuffer st = new StringBuffer();
    Iterator<Entry<String,String>> entrys =  map.entrySet().iterator();
    while(entrys.hasNext()){
      Entry<String,String> entry = entrys.next();
      if(entry.getValue() != null){
        if(st.length() == 0){//首次添加无&
          st.append(entry.getKey()).append("={").append(entry.getKey()).append("}");
        }else{
          st.append("&").append(entry.getKey()).append("={").append(entry.getKey()).append("}");
        }
      }else{
        if(st.length() == 0){//首次添加无&
          st.append(entry.getKey()).append("=");
        }else{
          st.append("&").append(entry.getKey()).append("=");
        }
      }
    }
    return st.toString();
  }
}
