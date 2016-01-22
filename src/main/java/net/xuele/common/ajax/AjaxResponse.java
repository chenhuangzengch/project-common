package net.xuele.common.ajax;

import net.xuele.common.utils.XueleWebContext;

/**
 * 用于返回ajax json/jsonb对象给前端，实际返回数据放入wrapper中。
 * Created by tao.zheng on 2015/6/19 0019.
 */
public final class AjaxResponse<T> implements java.io.Serializable {


    private static final long serialVersionUID = 266696159469987136L;


    public AjaxResponse() {

    }

    public AjaxResponse(T wrapper) {
        this.wrapper = wrapper;
    }

    /**
     * 返回的状态1成功，0失败。default success
     */
    private String status = XueleWebContext.MEMBER_RESPONSE_STATUS_SUCCESS;


    /**
     * 失败情况下返回失败的原因
     */
    private String errorMsg;


    /**
     * 实际返回的数据实体
     */
    private T wrapper;


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getWrapper() {
        return wrapper;
    }

    public void setWrapper(T wrapper) {
        this.wrapper = wrapper;
    }

}
