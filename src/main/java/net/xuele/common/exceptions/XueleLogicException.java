package net.xuele.common.exceptions;

/**
 * Created by Administrator on 2015/5/30 0030.
 */
public abstract class XueleLogicException extends RuntimeException {

    public static final String ERROR_CODE_PREFIX_LOGIN = "ERROR_LOGIN_01_";
    public static final String ERROR_CODE_PREFIX_MEMBER = "ERROR_MEMBER_02_";
    public static final String ERROR_CODE_PREFIX_CLOUDTEACH = "ERROR_CLOUDTEACH_04_";
    public static final String ERROR_CODE_PREFIX_INFORMATION = "ERROR_INFORMATION_06_";
    public static final String ERROR_CODE_PREFIX_NOTIFY = "ERROR_NOTIFY_07_";
    public static final String ERROR_CODE_PREFIX_APPCENTER = "ERROR_NOTIFY_08_";


    protected String msg; //错误消息
    protected String errorCode;   //异常码
    protected Throwable throwable;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public abstract String getErrorCodePrifix();


    protected XueleLogicException(){
        super();
    }

    protected XueleLogicException(String msg){
        super(msg);
        this.msg = msg;

    }

    protected XueleLogicException(String msg,Throwable throwable){
        super(msg,throwable);
        this.msg = msg;
        this.throwable = throwable;
    }

    protected XueleLogicException(String msg,String errorCode){
        this(msg,null,errorCode);
    }

    protected XueleLogicException(String msg,Throwable throwable,String errorCode){
        super(msg);
        this.msg = msg;
        this.throwable = throwable;
        this.errorCode = errorCode;
    }

}
