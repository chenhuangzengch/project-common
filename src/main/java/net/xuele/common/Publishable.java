package net.xuele.common;

/**
 * Created by Administrator on 2015/6/3 0003.
 * 一切可发布的作品的抽象，
 * 包括[照片，视频，音频，活动，心情 等]，
 * 所有具体可发布的对象需要实现该接口
 */
public interface Publishable {

    public static final int ACTIVITY = 0;
    public static final int IMAGE = 1;
    public static final int VEDIO = 2;
    public static final int MOOD = 3;
    public static final int REDIO = 4;


    public static final int COMMENT = 10;


    /**
     *
     * @return 可发布的事物类型
     */
    public int getType();

}
