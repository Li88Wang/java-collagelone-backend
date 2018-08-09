package com.lonedog.platform.common.dto;


/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.dto.SupportResult</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 结果包装类-非线程安全的
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class SupportResult<T> extends Result<T> {

  private static final Result DEFAULT_RES = Result.create();
  
  private Result<T> result;
  
  public static <T> SupportResult<T> create(Result<T> result) {
    SupportResult<T> temp = new SupportResult<T>();
    temp.result = result;
    return temp;
  }
  
  public static <T> SupportResult<T> create() {
    SupportResult<T> temp = new SupportResult<T>();
    temp.result = DEFAULT_RES;
	return temp;
  }

  public SupportResult<T> success(){
	return success(null);
  }

  /**
   * 赋予一个新的对象
   */
  void merge(){
    if(result == DEFAULT_RES){
      result = Result.create();
    }
  }
  public SupportResult<T> success(T data){
    merge();
    result.setSuccess(true);
    result.setData(data);
	return this;
  }
  public SupportResult<T> fail(String code,String description){
    merge();
    result.setSuccess(false);
	result.setCode(code);
	result.setDescription(description);
	return this;
  }

   public SupportResult<T> fail(String code){
     return fail(code, null);
   }
  
   public SupportResult<T> code(String code){
     merge();
     result.setCode(code);
     return this;
   }
   public SupportResult<T> description(String description){
     merge();
     result.setDescription(description);
     return this;
   }

  public SupportResult<T> sid(String sid){
    merge();
    result.setSid(sid);
    return this;
  }
  
  public SupportResult<T> data(T data){
    merge();
    result.setData(data);
    return this;
  }
  
  public T getData() {
     return result.getData();
  }
  
  /**
  * 是否成功返回并带回数据
  * @return
  */
  public boolean isFailedOrDataEmpty(){
     return result.isFailedOrDataEmpty();
  }
}