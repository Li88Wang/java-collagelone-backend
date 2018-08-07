package com.lonedog.platform.common;
/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.AjaxListResult</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * ajaxlist结果
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class AjaxListResult extends AjaxResult {

    private static final long serialVersionUID = 2365563244335133694L;

    public AjaxListResult(int status, String message, Object data, long recordsFiltered) {
        super(status, message, data);
        this.recordsFiltered = recordsFiltered;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AjaxListResult{");
        sb.append("recordsFiltered=").append(recordsFiltered);
        sb.append('}');
        return super.toString() + ":" + sb.toString();
    }

    private long recordsFiltered = 0L;

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}