package net.xuele.common.utils;


import net.xuele.common.exceptions.MemberException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * zhihuan.cai 新建于 2015/6/4 0004.
 */
public final class MemberAssert {

    private MemberAssert() {

    }


    /**
     * 断言是否为真
     *
     * @param expression
     * @param message
     * @param errorCode
     */
    public static void isTrue(boolean expression, String message, String errorCode) {
        if (!expression) {
            throw new MemberException(message, errorCode);
        }
    }

    /**
     * 断言是否为空
     *
     * @param object
     * @param message
     * @param errorCode
     */
    public static void isNull(Object object, String message, String errorCode) {
        if (object != null) {
            throw new MemberException(message, errorCode);
        }
    }

    /**
     * 断言不为空
     *
     * @param object
     * @param message
     * @param errorCode
     */
    public static void notNull(Object object, String message, String errorCode) {
        if (object == null) {
            throw new MemberException(message, errorCode);
        }
    }

    /**
     * 断言长度
     *
     * @param text
     * @param message
     */
    public static void hasLength(String text, String message, String errorCode) {
        if (!StringUtils.hasLength(text)) {
            throw new MemberException(message, errorCode);
        }
    }


    /**
     * 断言包含文本
     *
     * @param text
     * @param message
     */
    public static void hasText(String text, String message, String errorCode) {
        if (!StringUtils.hasText(text)) {
            throw new MemberException(message, errorCode);
        }
    }

    /**
     * 断言去除左右空格字符串相等
     * @param source
     * @param target
     * @param message
     * @param errorCode
     */
    public static void isEquals(String source,String target, String message, String errorCode) {
        if(source == null || target == null){
            throw new MemberException(message,errorCode);
        }
        if(!StringUtils.trimWhitespace(source).equals(StringUtils.trimWhitespace(target))){
            throw new MemberException(message,errorCode);
        }
    }



    /**
     * 断言不是空数组
     *
     * @param array
     * @param message
     */
    public static void notEmpty(Object[] array, String message, String errorCode) {
        if (ObjectUtils.isEmpty(array)) {
            throw new MemberException(message, errorCode);
        }
    }


    /**
     * 断言数组中没有为空对象
     *
     * @param array
     * @param message
     * @param errorCode
     */
    public static void noNullElements(Object[] array, String message, String errorCode) {
        if (array != null) {
            Object[] arr$ = array;
            int len$ = array.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                Object element = arr$[i$];
                if (element == null) {
                    throw new MemberException(message, errorCode);
                }
            }
        }

    }

    /**
     * 断言不为空集合
     *
     * @param collection
     * @param message
     */
    public static void notEmpty(Collection collection, String message, String errorCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new MemberException(message, errorCode);
        }
    }

    /**
     * 断言map不为空
     *
     * @param map
     * @param message
     */
    public static void notEmpty(Map map, String message, String errorCode) {
        if (CollectionUtils.isEmpty(map)) {
            throw new MemberException(message, errorCode);
        }
    }


}
