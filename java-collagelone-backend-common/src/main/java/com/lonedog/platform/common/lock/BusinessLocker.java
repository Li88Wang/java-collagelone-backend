package com.lonedog.platform.common.lock;


/**
 * 业务锁
 * Created by wzp on 17/03/26.
 */
public interface BusinessLocker {

    /**获取业务锁
     * @param bussinessCode
     * @param key
     * @return
     */
    public boolean getBusinessLock(String bussinessCode, String key);
    /**获取业务锁可重试
     * @param bussinessCode
     * @param key
     * @return
     */
    public boolean getBusinessLockRetry(String bussinessCode, String key);
    /**解锁
     * @param bussinessCode
     * @param key
     */
    public void unlock(String bussinessCode, String key);

}
