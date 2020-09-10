package com.wmm.ketangpai.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success

    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //主页index
                registry.addViewController("/").setViewName("index");
                registry.addViewController("index").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("index");
                //登陆页面
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");

//                注册页面
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/register.html").setViewName("register");

                //学生界面
                registry.addViewController("/student").setViewName("student");
                registry.addViewController("/student.html").setViewName("student");

                //老师界面
                registry.addViewController("/teacher").setViewName("teacher");
                registry.addViewController("/teacher.html").setViewName("teacher");

                //学生提交作业界面
                registry.addViewController("/referHomework").setViewName("referHomework");

                //老师查看作业界面
                registry.addViewController("/teacherLh").setViewName("teacherLh");

            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //和页面有关的静态目录都放在项目的static目录下
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
                //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
                registry.addResourceHandler("/file/**").addResourceLocations("file:D:/Java/idea/wrokspace/ketangpai/");
            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//
//        return new MyLocaleResolver();
//    }

}
