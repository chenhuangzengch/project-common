package net.xuele.common.kryo;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Kyro序列化最佳实践可以将被序列化类提前注册到VM中 Created by Zhihuan.cai on 2015/5/19 0019.
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    public static final Log logger = LogFactory.getLog(SerializationOptimizerImpl.class);

    private static final String DTO_PACKAGE = "net.xuele.*.dto";


    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = ClassScaner.scan(DTO_PACKAGE, java.io.Serializable.class);
        Collections.sort(classes, new Comparator<Class>() {
            @Override
            public int compare(Class o1, Class o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return classes;
    }
}