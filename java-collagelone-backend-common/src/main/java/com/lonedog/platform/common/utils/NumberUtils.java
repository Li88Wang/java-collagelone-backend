package com.lonedog.platform.common.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.utils.NumberUtils</li>
 * <li>创建时间 : 2018年8月14日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 数值工具类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class NumberUtils {
  public static final Logger log = LoggerFactory.getLogger(NumberUtils.class);
  /**除法转换
   * @param a 被除数
   * @param b 除数
   * @param scale 保留几位有效小数
   * @return
   */
  public static BigDecimal divide(BigDecimal a,double b,int scale){
    return divide(a,b,scale,null);
  }
  /**除法转换
   * @param a 被除数
   * @param b 除数
   * @param scale 保留几位有效小数
   * @return
   */
  public static BigDecimal divide(BigDecimal a,double b,int scale,Integer bmode){
    BigDecimal ret = null;
    try{
      if(bmode != null){
        ret = a.divide(BigDecimal.valueOf(b),scale,bmode);
      }else{
        ret = a.divide(BigDecimal.valueOf(b),scale,BigDecimal.ROUND_HALF_UP);
      }
    }catch(Exception e){
      log.error("com.lonedog.platform.common.utils.NumberUtils.divide",e);
    }
    return ret;
  }
  /**除法转换
   * @param a 被除数
   * @param b 除数
   * @param scale 保留几位有效小数
   * @return
   */
  public static BigDecimal divide(Long a,double b,int scale){
    return divide(BigDecimal.valueOf(a),b,scale);
  }
  /**除法转换
   * @param a 被除数
   * @param b 除数
   * @param scale 保留几位有效小数
   * @return
   */
  public static BigDecimal divide(Long a,double b,int scale,int bmode){
    return divide(BigDecimal.valueOf(a),b,scale,bmode);
  }
  
  public static double add(double d1,double d2){  
    BigDecimal b1 = BigDecimal.valueOf(d1);  
    BigDecimal b2 = BigDecimal.valueOf(d2);  
    return b1.add(b2).doubleValue();  
  }  
  
  public static double sub(double d1,double d2){  
    BigDecimal b1 = BigDecimal.valueOf(d1);  
    BigDecimal b2 = BigDecimal.valueOf(d2);  
    return b1.subtract(b2).doubleValue();  
  }  
  
  public static double mul(double d1,double d2){  
    BigDecimal b1 = BigDecimal.valueOf(d1);  
    BigDecimal b2 = BigDecimal.valueOf(d2);  
    return b1.multiply(b2).doubleValue();  
  }
  
  public static Long mul(BigDecimal a,Long b){  
    BigDecimal b2 = BigDecimal.valueOf(b);  
    return a.multiply(b2).longValue();  
  }
  
  public static Long mul(BigDecimal a,double b){  
    BigDecimal b2 = BigDecimal.valueOf(b);  
    return a.multiply(b2).longValue();  
  }
  
  /**判断数值型是否为null或0
   * @param o
   * @return
   */
  public static boolean isNullOrZero(Number o){
    if(o == null || o.intValue() == 0){
      return true;
    }
    return false;
  }
  /**判断数值型是否为null或<=0
   * @param o
   * @return
   */
  public static boolean isNullOrLqZero(Number o){
    if(o == null || o.intValue() <= 0){
      return true;
    }
    return false;
  }
 
  /**判断o1是为null，否则选o2
   * @param o
   * @return
   */
  public static Number select(Number o1,Number o2){
    return isNullOrZero(o1) ? o2 : o1;
  }
  
}