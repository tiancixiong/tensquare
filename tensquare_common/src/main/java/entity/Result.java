package entity;

/**
 * 返回结果类 用于控制器类返回结果
 * @author TianCi.Xiong
 * @since 2020/10/13 14:50
 **/
public class Result {
    /** 是否成功 */
    private boolean flag;
    /** 返回码 */
    private String code;
    /** 返回信息 */
    private String message;
    /** 返回数据 */
    private Object data;

    public Result() {
    }

    public Result(boolean flag, String code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, String code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}