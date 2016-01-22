package net.xuele.common.exceptions;

/**
 * Created by jdw on 2015/8/7 0007.
 */
public class AppCenterException extends XueleLogicException {

    public AppCenterException(){
        super();
    }

    public AppCenterException(String msg){
        super(msg);
    }

    public AppCenterException(String msg,String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }

    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_APPCENTER;
    }
}
