package org.yeasheng.common.api;

/**
 * 封装API的错误码
 *
 * @author yansh
 * @version 2021/4/17
 **/
public interface IErrorCode {
    long getCode();

    String getMessage();
}
