package com.afengzi.website.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    protected static ApplicationContext appContext;
    protected Logger log = Logger.getLogger(this.getClass());

//    @BeforeClass
    public static void setUp() throws Exception {
        try {
            long start = System.currentTimeMillis();
            System.out.println("正在加载配置文件...");

            appContext = new ClassPathXmlApplicationContext("classpath:spring-root-context.xml");

            System.out.println("配置文件加载完毕,耗时：" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterClass
    public static void tearDown() throws Exception {
    }

    protected boolean setProtected() {
        return false;
    }

//    @Before(value = "")
    public void autoSetBean() {
        appContext.getAutowireCapableBeanFactory().autowireBeanProperties(this, DefaultListableBeanFactory.AUTOWIRE_BY_NAME, false);
    }
}
