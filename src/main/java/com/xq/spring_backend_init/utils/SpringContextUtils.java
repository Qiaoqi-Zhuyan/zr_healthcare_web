package com.xq.spring_backend_init.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * spring 上下文获取
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 通过名称获得bean
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }


    /**
     *通过class获得bean
     *
     */
    public static <T> T getBean(Class<T> beanClass){
        return applicationContext.getBean(beanClass);
    }

    public static <T> T getBean(String name, Class<T> beanClass){
        return applicationContext.getBean(name, beanClass);
    }
}
