package com.xq.spring_backend_init.model.vo;

import lombok.Data;

@Data
public class ExceptionCountVO {

    /**
     * 分别统计近15天的异常数据
     */
    private Integer heartExceptionCnt;

    private Integer oxygenLevelExceptionCnt;

    private Integer temperatureExceptionCnt;

}
