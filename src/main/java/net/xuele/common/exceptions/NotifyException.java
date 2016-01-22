package net.xuele.common.exceptions;

/**
 * Created by shaokun.zhi on 2015/7/8 0003.
 * 会员子系统异常，用于抽象会员子系统所产生的业务异常
 */
public class NotifyException extends XueleLogicException {

    public NotifyException(){
        super();
    }

    public NotifyException(String msg){
        super(msg);
    }

    public NotifyException(String msg, String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }

    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_NOTIFY;
    }
}