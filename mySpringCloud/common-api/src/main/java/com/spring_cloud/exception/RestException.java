/*****************************************************************************
 * Copyright (C) 2019 TP-LINK TECHNOLOGIES CO.,LTD. All Rights Reserved.
 * 本软件由普联技术有限公司开发，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * @FileName: RestException.java
 * @Description:
 * @Version: since 0.1.0
 * @History:
 * 2019/8/7 zhaoge@tp-link.com.cn create
 *****************************************************************************/

package com.spring_cloud.exception;

import lombok.Getter;

/**
 * @Description:
 * @History: 2019/8/7 zhaoge@tp-link.com.cn create
 */
@Getter
public abstract class RestException extends Exception {

    protected Object businessParams;

    public RestException() {
        super();
    }

    public RestException(Exception e) {
        super(e);
    }

    protected void setBusinessParams(Object businessParams) {
        this.businessParams = businessParams;
    }

    public abstract Object[] getMessageArgs();

}
