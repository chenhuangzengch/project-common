package net.xuele.common.exceptions;

/**
 * Created by Administrator on 2015/6/3 0003.
 * 会员子系统异常，用于抽象会员子系统所产生的业务异常
 */
public class MemberException extends XueleLogicException {


    public MemberException(){
        super();
    }

    public MemberException(String msg){
        super(msg);
    }

    public MemberException(String msg,String errorCode){
        super(msg,errorCode);
        this.msg = msg;
        this.errorCode = getErrorCodePrifix()+errorCode;
    }

    @Override
    public String getErrorCodePrifix() {
        return XueleLogicException.ERROR_CODE_PREFIX_MEMBER;
    }
}