package com.xq.spring_backend_init.controller;


import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.ResidentQueryRequest;
import com.xq.spring_backend_init.model.entity.Residents;
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

//    @PostMapping("/getResidentInfo/")
//    public BaseResponse<Residents> listResident(@RequestBody ResidentQueryRequest residentQueryRequest){
//        return null;
//    }


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
        return ResultUtils.success(residentsListVOList);
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




}
