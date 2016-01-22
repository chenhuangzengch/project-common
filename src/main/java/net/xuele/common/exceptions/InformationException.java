package net.xuele.common.exceptions;

/**
 * Created by Administrator on 2015/6/3 0003.
 */
public class InformationException extends XueleLogicException {


    public InformationException(){
        super();
    }

    public InformationException(String msg){
        super(msg);
    }

    public InformationException(String msg,String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }

    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_INFORMATION;
    }
}
