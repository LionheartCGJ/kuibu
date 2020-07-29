package com.kuibu.beans.java;

import com.kuibu.beans.java.po.Person;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @ClassName demo
 *
 * Java beans 示例
 *
 * @Date 2020/07/15
 * @Author chenguangjin
 */
public class Demo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);

            if("age".equals(propertyDescriptor.getName())) {
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertiesEditor.class);

                // TODO ??
                propertyDescriptor.createPropertyEditor(new Person());
            }
        });
    }


    public static Integer string2Integer(String input) {
        return Integer.valueOf(input);
    }

    static class StringToIntegerPropertiesEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
                setValue(Integer.valueOf(text));
        }

    }
}
