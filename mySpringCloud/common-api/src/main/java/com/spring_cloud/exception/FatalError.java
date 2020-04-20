/*****************************************************************************
 * Copyright (C) 2019 TP-LINK TECHNOLOGIES CO.,LTD. All Rights Reserved.
 * 本软件由普联技术有限公司开发，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * @FileName: FatalError
 * @Description:
 * @Version: since 0.1.0
 * @History:
 * 2020/1/19 maihaosong@tp-link.com.cn create
 *****************************************************************************/

package com.spring_cloud.exception;

/**
 * @author maihaosong
 * @description 致命错误，表示出现了不符合系统逻辑的异常，可能系统设计存在缺陷
 * @history 2020/1/19 maihaosong@tp-link.com.cn create
 */
public class FatalError extends RuntimeException {
    public FatalError(String message) {
        super(message);
    }

    public FatalError(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalError(Throwable cause) {
        super(cause);
    }
}
