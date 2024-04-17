package com.xq.spring_backend_init.controller;


import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.ResidentQueryRequest;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ExceptionCountVO;
import com.xq.spring_backend_init.model.vo.ResidentDetailVO;
import com.xq.spring_backend_init.model.vo.ResidentsListVO;
import com.xq.spring_backend_init.model.vo.ResidentsVO;
import com.xq.spring_backend_init.service.ResidentsDetailService;
import com.xq.spring_backend_init.service.ResidentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Resident")
public class ResidentsController {
    @Autowired
    private ResidentsService residentsService;

    @Autowired
    private ResidentsDetailService residentsDetailService;

    /**
     * 测试
     * @return
     */
    @PostMapping("/getAll")
    public BaseResponse<List<Residents>> getAllResidentList(){
        List<Residents> residentsList = residentsService.selectAllResidents(null);
        return ResultUtils.success(residentsList);
    }

    /**
     * 信息查询主页面, 获取所有简略信息
     * @return
     */
    @PostMapping("/pageSelect")
    public BaseResponse<List<ResidentsListVO>> pageSelect(){
        List<ResidentsListVO> residentsListVOList = residentsService.getResidentsVOList();
        return residentsListVOList.isEmpty()?ResultUtils.error(202, "无数据"): ResultUtils.success(residentsListVOList);
    }

    /**
     * 查询体获取详细信息
     * @param request
     * @return
     */
    @PostMapping("/detailInfo")
    public BaseResponse<ResidentDetailVO> DetailInfo(@RequestBody ResidentQueryRequest request){
        ResidentDetailVO residentDetailVO = new ResidentDetailVO();
        if(request.getResidentId() != null){
            residentDetailVO = residentsDetailService.getResidentDetailInfo(request.getResidentId());
        }
        if(!StringUtils.isBlank(request.getFirstName())){
            return null;
        }
        return residentDetailVO != null ? ResultUtils.success(residentDetailVO):ResultUtils.error(ErrorCode.NOT_FOUND_ERROR);
    }

    /**
     * 详细信息, 通过id信息查询
     * @param residentId
     * @return
     */
    @PostMapping("/getDetailInfo/{residentId}")
    public BaseResponse<ResidentDetailVO> getDetailInfo(@PathVariable("residentId") Integer residentId){
        ResidentDetailVO residentDetailVO = new ResidentDetailVO();
        residentDetailVO = residentsDetailService.getResidentDetailInfo(residentId);
        return residentDetailVO != null ? ResultUtils.success(residentDetailVO):ResultUtils.error(ErrorCode.NOT_FOUND_ERROR);
    }


    /**
     * 获得近15日的异常统计
     * @param residentId
     * @return
     */
    @PostMapping("/getExceptionHistoryInfo/{residentId}")
    public BaseResponse<ExceptionCountVO> getExceptionHistoryInfo(@PathVariable("residentId") Integer residentId){
        ExceptionCountVO exceptionCountVO = residentsService.getHistoryExceptionInfo(residentId);
        return ResultUtils.success(exceptionCountVO);
    }
}
