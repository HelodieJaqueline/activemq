package com.zhangrui.activemq.controller;

import com.alibaba.fastjson.JSON;
import com.zhangrui.activemq.domain.BaseResponse;
import com.zhangrui.activemq.service.IMessageConsumeService;
import com.zhangrui.activemq.service.IMessageProducerService;
import com.zhangrui.activemq.util.RenderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zhangrui.activemq.domain.Constant.SUCCESS;

@Controller
@Slf4j
public class ApiController {

    @Autowired IMessageProducerService messageProducerService;
    @Autowired IMessageConsumeService messageConsumeService;

    @RequestMapping("/sendMessage")
    @ResponseBody
    public void sendMessage(@RequestParam String phoneNo,
        HttpServletRequest request,HttpServletResponse response){
        this.messageProducerService.send("phoneNo", phoneNo);
        BaseResponse baseResponse = new BaseResponse("000", SUCCESS);
        RenderUtils.renderJson(JSON.toJSONString(baseResponse),response);
        log.info("##############测试{}发送#################",phoneNo);
    }

    @RequestMapping("/produceMessage")
    @ResponseBody
    public void produceMessage(@RequestParam String phoneNo,
        HttpServletRequest request,HttpServletResponse response){
        Object object = this.messageConsumeService.consume("phoneNo");
        BaseResponse baseResponse = new BaseResponse("000", SUCCESS);
        RenderUtils.renderJson(JSON.toJSONString(baseResponse),response);
        log.info("##############测试{}发送#################",object);
    }

}
