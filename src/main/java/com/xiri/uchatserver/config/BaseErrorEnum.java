package com.xiri.uchatserver.config;

/**
 * BaseErrorEnum类
 *
 * <p>
 * <b>History:</b>
 * <table border="1">
 * <tr>
 * <th>Date</th>
 * <th>Operator</th>
 * <th>Memo</th>
 * </tr>
 * <tr>
 * <td>2021/8/31 9:39</td>
 * <td>zrc</td>
 * <td>Create</td>
 * </tr>
 * </table>
 *
 * @author zrc
 * @version 1.0.0
 * @since 1.0.0
 */

public enum BaseErrorEnum implements BaseErrorInfoInterface {

    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!"),
    REQUEST_METHOD_SUPPORT_ERROR("40001", "当前请求方法不支持"),
    REQUEST_DATA_NULL("200904", "当前请求参数为空!"),
    USER_NOT_EXISTS("10010", "该用户不存在!"),
    USER_INVALID("401", "当前登录信息已失效,请重新登录！"),
    PASSWORD_ERROR("10011", "密码错误"),
    PHONE_HAS_REGISTER("10012", "该账号已注册"),
    PHONE_REGISTER_ERROR("10013", "注册账号失败"),
    RESOURCE_NOT_EXISTS("10014", "未找到该资源!"),
    INSERT_WRONG("10019","数据库插入失败!"),
    UPDATE_WRONG("10020","数据库更新失败!"),

    REQUIRED_ITEM_NULL("10018", "必传项为空！"),
    USER_NAME_LOCK("100002", "该账号已被锁定!");




    /**
     * 错误码
     */
    private String resultCode;
    /**
     * 错误描述
     */
    private String resultMsg;


    BaseErrorEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
