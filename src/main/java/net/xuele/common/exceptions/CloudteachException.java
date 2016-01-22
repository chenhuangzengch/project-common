package net.xuele.common.exceptions;

/**
 * Created by Administrator on 2015/6/8 0008.
 */
public class CloudteachException extends XueleLogicException {

    public CloudteachException(){
        super();
    }

    public CloudteachException(String msg){
        super(msg);
    }

    public CloudteachException(String msg,String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }


    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_CLOUDTEACH;
    }
}
