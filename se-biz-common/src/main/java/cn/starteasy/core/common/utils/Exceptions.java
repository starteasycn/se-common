package cn.starteasy.core.common.utils;


import cn.starteasy.core.common.exception.BizException;

/**
 * Created by Michael on 11/6/14.
 */
public class Exceptions {

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static BizException bizException(Throwable ex) {
        if (ex instanceof BizException) {

            return (BizException) ex;
        } else {
            return new BizException("error code",ex.getMessage(),ex.getCause());
        }
    }
}
