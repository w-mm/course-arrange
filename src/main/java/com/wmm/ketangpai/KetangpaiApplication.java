package com.wmm.ketangpai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wmm.ketangpai.dao")
@SpringBootApplication
public class KetangpaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KetangpaiApplication.class, args);
    }

}
