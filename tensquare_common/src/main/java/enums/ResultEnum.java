package enums;

/**
 * 状态码枚举类
 * @author TianCi.Xiong
 * @since 2020/10/13 19:24
 */
public enum ResultEnum {
    /** 查询成功 */
    QUERY_SUCCESS("20000", "查询成功"),
    /** 添加成功 */
    ADD_SUCCESS("20000", "添加成功"),
    /** 修改成功 */
    EDIT_SUCCESS("20000", "修改成功"),
    /** 删除成功 */
    DEL_SUCCESS("20000", "删除成功"),

    /** 失败 */
    FAIL("20001", "系统出现错误"),
    /** 查询失败 */
    QUERY_FAIL("20001", "查询失败"),
    /** 添加失败 */
    ADD_FAIL("20001", "添加失败"),
    /** 修改失败 */
    EDIT_FAIL("20001", "修改失败"),
    /** 删除失败 */
    DEL_FAIL("20001", "删除失败"),


    /** 用户名或密码错误 */
    LOGINERROR("20002", "用户名或密码错误"),
    /** 权限不足 */
    ACCESSERROR("20003", "权限不足"),
    /** 远程调用失败 */
    REMOTEERROR("20004", "远程调用失败"),
    /** 重复操作 */
    REPERROR("20005", "重复操作");

    private String code;
    private String msg;

    private ResultEnum(String status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
