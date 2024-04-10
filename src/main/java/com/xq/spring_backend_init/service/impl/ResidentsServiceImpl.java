package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.MedicalStaffMapper;
import com.xq.spring_backend_init.mapper.ResidentsMapper;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ExceptionAlert1VO;
import com.xq.spring_backend_init.model.vo.ExceptionAlertVO;
import com.xq.spring_backend_init.model.vo.ResidentsVO;
import com.xq.spring_backend_init.service.ResidentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentsServiceImpl implements ResidentsService {

    @Autowired
    private ResidentsMapper residentsMapper;

    @Autowired
    private MedicalStaffMapper medicalStaffMapper;
//    @Override
//    public QueryWrapper<Residents> getQueryWapper(ResidentQueryRequest request) {
//        QueryWrapper<Residents> queryWrapper = new QueryWrapper<>();
//        if(request == null)
//            return queryWrapper;
//        Integer residentId = request.getResidentId();
//        String nationalId = request.getNationalId();
//        String firstName = request.getFirstName();
//        String lastName = request.getLastName();
//
//        queryWrapper.eq(ObjectUtils.isNotEmpty(residentId),"resident_id", residentId);
//        queryWrapper.eq(StringUtils.isNotEmpty(nationalId), "national_id", nationalId);
//        queryWrapper.eq(StringUtils.isNotEmpty(firstName), "first_name", firstName);
//
//        return queryWrapper;
//    }

    @Override
    public List<Residents> selectAllResidents(Residents residents) {
        return residentsMapper.selectResidentsList(residents);
    }

    @Override
    public List<ResidentsVO> pageSelectResidents(Integer page){
        return null;
    }

    @Override
    public List<ExceptionAlert1VO> getAllExceptions(int staffId) {
        List<ExceptionAlertVO> allExceptions = residentsMapper.getAllExceptions(staffId);
        List<ExceptionAlert1VO> list2 = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ExceptionAlertVO e : allExceptions){
            ExceptionAlert1VO exceptionAlert1VO = new ExceptionAlert1VO();
            exceptionAlert1VO.setExceptionStartTime(formatter.format(e.getExceptionStartTime()));
            if(e.getExceptionEndTime()!=null){
                e.setIsCurrent(false);
                exceptionAlert1VO.setExceptionEndTime(formatter.format(e.getExceptionEndTime()));
                BeanUtils.copyProperties(e,exceptionAlert1VO);
            }else {
                BeanUtils.copyProperties(e,exceptionAlert1VO);
                e.setIsCurrent(true);
            }
            list2.add(exceptionAlert1VO);
        }
        return list2;
    }


}
