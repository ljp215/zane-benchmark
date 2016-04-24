package com.zane.test.common.practice.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: luojinping
 * Date: 15/3/4
 * Time: 下午1:28
 */
public class InjectTestMain {
    private static final Logger LOG = LoggerFactory.getLogger(InjectTestMain.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("classpath:applicationContext-practice.xml");

        DogStrategy dogStrategy = context.getBean(DogStrategy.class);
        dogStrategy.goldenRetrieverBark();
    }
}
