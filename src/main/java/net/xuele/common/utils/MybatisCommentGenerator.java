package net.xuele.common.utils;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 用于mybatis 生成domain时附带注释信息
 * Created by Zhihuan.cai on 2015/5/21 0021.
 */
public class MybatisCommentGenerator extends DefaultCommentGenerator {

    public MybatisCommentGenerator() {
        super();
    }

    /**
     * 属性注释
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
    }


    /**
     * set方法注释
     *
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            StringBuilder sb = new StringBuilder();
            method.addJavaDocLine("/**");
            method.addJavaDocLine(" * 设置[" + introspectedTable.getFullyQualifiedTable().toString().toUpperCase() +
                    "]的属性" + introspectedColumn.getRemarks());
            method.addJavaDocLine(" */");
        }
    }

    /**
     * get方法注释
     *
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            StringBuilder sb = new StringBuilder();
            method.addJavaDocLine("/**");
            method.addJavaDocLine(" * 获取 [" + introspectedTable.getFullyQualifiedTable().toString().toUpperCase() + "] 的属性 " + introspectedColumn.getRemarks());
            method.addJavaDocLine(" */");
        }
    }

    /**
     * sqlmapper xml方法注释
     *
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
    }

    /**
     * mapper接口方法的注释
     *
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    }
}
