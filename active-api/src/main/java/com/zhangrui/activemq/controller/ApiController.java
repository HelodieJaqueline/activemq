package com.zhangrui.activemq.controller;

import com.alibaba.fastjson.JSON;
import com.zhangrui.activemq.domain.BaseResponse;
import com.zhangrui.activemq.util.RenderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zhangrui.activemq.domain.Constant.SUCCESS;

@Controller
@Slf4j
public class ApiController {


    @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletRequest request,HttpServletResponse response){
        BaseResponse baseResponse = new BaseResponse("000",SUCCESS);
        RenderUtils.renderJson(JSON.toJSONString(baseResponse),response);
        log.info("##############测试测试#################");
    }
}
