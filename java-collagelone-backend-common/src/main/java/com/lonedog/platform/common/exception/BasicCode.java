package com.lonedog.platform.common.exception;


/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.exception.BasicCode</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 
 * </li>
 * </ul>
 * 
 * @author zollty
 * @version 1.0
 */
public class BasicCode {
   
    /**
     * ReadMe：
     * ----每一条错误信息应该包括：错误代码和注释。
     * 
     * ----命名规范如下：
     * 例如：000000、000001等，代表公用的、常见的一些错误类型。
     * 
     * ----特别提醒：
     *  一定要写注释，方便自己和别人快速查看！
     */
    
    // 00开头 -- 公用的、常见的错误类型
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    /** 未知错误，参见：{}！ */
    public static final CodeMeta UNKNOWN_ERROR = new CodeMeta("000000", "UNKNOWN_ERROR",
            "未知错误，参见：{}！", "Unknown error, see: {}");
    
    /** UNDEFINED_ERROR */
    public static final CodeMeta UNDEFINED_ERROR = new CodeMeta("000001", "UNDEFINED_ERROR",
            "{}", "{}");
    
    /** 无效的参数：{} */
    public static final CodeMeta INVALID_PARAM = new CodeMeta("000002", "UNVALID_PARAM",
            "无效的参数：{}", "unvalid param: {}");
    
    /** 参数({})不能为空！ */
    public static final CodeMeta PARAM_NULL = new CodeMeta("000003", "PARAM_ERROR",
            "参数({})不能为空！", "this argument ({}) is required; it must not be null");
    
    
    
    /** 数据({})状态不正常！ */
    public static final CodeMeta DATA_STATE_NOT_NORMAL = new CodeMeta("000011", 
            "BUSINESS_CHECK_ERROR", "数据({})状态不正常！", "");
    
    /** 数据({})不存在！ */
    public static final CodeMeta DATA_NOT_EXIST = new CodeMeta("000012", "DATA_NOT_EXIST",
            "数据({})不存在！", " Data ({}) is not exist!");
    
    
    
    /** 删除数据({})失败! */
    public static final CodeMeta DB_DELETE_FAILED = new CodeMeta("000030", 
            "DB_ERROR", "数据({})删除失败!", "data ({}) delete failed!");
    
    /** 更新数据({})失败! */
    public static final CodeMeta DB_UPDATE_FAILED = new CodeMeta("000031", 
            "DB_ERROR", "数据({})更新失败!", "data ({}) update failed!");
    
    /** 插入数据({})失败! */
    public static final CodeMeta DB_INSERT_FAILED = new CodeMeta("000032", 
            "DB_ERROR", "数据({})插入失败!", "data ({}) insert failed!");
    
    /** 数据表中没有找到该记录({})! */
    public static final CodeMeta DB_DATA_NOT_FOUND = new CodeMeta("000033", 
            "DB_ERROR", "数据表中没有找到该记录({})!", "data ({}) not found!");
    
}