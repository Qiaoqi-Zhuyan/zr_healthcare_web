package com.xq.spring_backend_init.service.impl;


import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.mapper.FamilyMemeberMobileMapper;
import com.xq.spring_backend_init.mapper.ResidentsMapper;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ResidentDetailVO;
import com.xq.spring_backend_init.service.ResidentsDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentsDetailServiceImpl implements ResidentsDetailService {

    @Autowired
    private ResidentsMapper residentsMapper;

    @Autowired
    private FamilyMemeberMobileMapper familyMemeberMobileMapper;

    @Override
    public ResidentDetailVO getResidentDetailInfo(Integer resident_id) {

        // 查询老年人详细信息
        ResidentDetailVO residentDetailVO = new ResidentDetailVO();
        try{
            Residents resident = residentsMapper.selectResident(resident_id);
            String relation = familyMemeberMobileMapper.selectRelationship(resident_id, resident.getEmergencyContactName());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            BeanUtils.copyProperties(resident, residentDetailVO);
            residentDetailVO.setRelationship(relation);
            residentDetailVO.setDateOfBirth(formatter.format(resident.getDateOfBirth()));
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return residentDetailVO;
    }

    @Override
    public List<ResidentDetailVO> getResidentDetailInfo(String firstName) {
         // 查询老年人详细信息

        List<ResidentDetailVO> residentDetailVOList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Residents residents = new Residents();
            residents.setFirstName(firstName);
            List<Residents> residentsList = residentsMapper.selectResidentsList(residents);
            for(Residents resident : residentsList){
                String relation = familyMemeberMobileMapper.selectRelationship(resident.getResidentId(), resident.getEmergencyContactName());
                ResidentDetailVO residentDetailVO = new ResidentDetailVO();
                BeanUtils.copyProperties(resident, residentDetailVO);
                residentDetailVO.setRelationship(relation);
                residentDetailVO.setDateOfBirth(formatter.format(resident.getDateOfBirth()));
                residentDetailVOList.add(residentDetailVO);
            }
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return residentDetailVOList;
    }



}
