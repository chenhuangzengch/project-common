package net.xuele.common.exceptions;

/**
 * Created by Administrator on 2015/6/3 0003.
 * 登陆异常对象，抽象和登陆子系统相关的业务异常
 *
 */
public class LoginException extends XueleLogicException {

    public LoginException(){
        super();
    }

    public LoginException(String msg){
        super(msg);
    }

    public LoginException(String msg,String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }

    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_LOGIN;
    }
}
