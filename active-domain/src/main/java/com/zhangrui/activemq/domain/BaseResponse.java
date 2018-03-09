package com.zhangrui.activemq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhangRui
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private String resultCode;

    private String resultMessage;

}
