package org.tmt.demo.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ** created by DawnSailing at 2020/2/21
 *
 * @author DawnSailing
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        long begin = System.currentTimeMillis();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();

        String threadInfo = "当前线程的Id：" + Thread.currentThread().getId() + "，当前线程的名字：" + Thread.currentThread().getName();

        long time = end - begin;

        String result = "接口耗时：" + time + "毫秒，" + threadInfo;

        LOGGER.info(result);

        return result;
    }

}
