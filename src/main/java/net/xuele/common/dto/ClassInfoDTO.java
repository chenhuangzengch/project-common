package net.xuele.common.dto;

import java.io.Serializable;

/**
 * Created by zhongjian.xu on 2015/7/10 0010.
 */
public class ClassInfoDTO implements Serializable {

    private static final long serialVersionUID = -9075246658613581979L;
    /**
     * 班级ID
     */
    private String classId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 班级别名
     */
    private String aliasName;
    /**
     * 年级 1->1年级
     */
    private int gradeNum;
    /**
     * 学期 1->1学期
     */
    private int semester;
    /**
     * 学界
     */
    private int year;
    /**
     * 班级人数
     */
    private int studentCount;
    /**
     * 班主任ID
     */
    private String chargeId;
    /**
     * 班主任名称
     */
    private String chargeName;
    /**
     * 班级图标
     */
    private String mImage;
    /**
     * 年级名称
     */
    private String gradeName;
    /**
     *学校ID
     */
    private String schoolId;
    /**
     * 学校名称
     */
    private String schoolName;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
