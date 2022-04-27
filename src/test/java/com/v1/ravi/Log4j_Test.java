package com.v1.ravi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Log4j_Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void test() {
        logger.info("info Test");
    }
}
