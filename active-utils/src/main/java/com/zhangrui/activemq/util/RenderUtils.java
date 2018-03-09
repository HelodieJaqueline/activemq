package com.zhangrui.activemq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author ZhangRui
 */

public class RenderUtils {

    private RenderUtils() { }

    private static final Logger LOGGER = LoggerFactory.getLogger(RenderUtils.class);

    public static String render(String text, String contentType, HttpServletResponse response) {
        try {
            response.setContentType(contentType);
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().write(text);
            response.flushBuffer();
        } catch (IOException e) {
            LOGGER.warn("render:{} IOException:{}", (new StringBuilder("render\u51FA\u9519contentType: ")).append(contentType).append(",body:").append(text).toString(), e);
        }
        return null;
    }

    public static String renderText(String text, HttpServletResponse response) {
        return render(text, "text/plain;charset=UTF-8", response);
    }

    public static String renderHtml(String html, HttpServletResponse response) {
        return render(html, "text/html;charset=UTF-8", response);
    }

    public static String renderXML(String xml, HttpServletResponse response) {
        return render(xml, "text/xml;charset=UTF-8", response);
    }

    public static String renderJson(String json, HttpServletResponse response) {
        return render(json, "application/json;charset=UTF-8", response);
    }

}
