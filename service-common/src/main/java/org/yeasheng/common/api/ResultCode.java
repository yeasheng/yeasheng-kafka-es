package org.yeasheng.common.api;

/**
 * 枚举了一些常用API操作码
 *
 * @author yansh
 * @version 2021/4/17
 **/
public enum ResultCode implements IErrorCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(500, "操作失败"),
    /**
     * 校验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 未登录或者验证过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没有权限
     */
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
