package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.MedicalStaffMapper;
import com.xq.spring_backend_init.mapper.ResidentExceptionHistoryMapper;
import com.xq.spring_backend_init.mapper.ResidentsMapper;
import com.xq.spring_backend_init.model.entity.MedicalStaff;
import com.xq.spring_backend_init.model.entity.ResidentExceptionHistory;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.*;
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

    @Autowired
    private ResidentExceptionHistoryMapper residentExceptionHistoryMapper;

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

    /**
     * 查询所有老年人的姓名、管理人员(姓名, 联系方式)、房间号
     * @return
     */
    @Override
    public List<ResidentsListVO> getResidentsVOList() {

        List<ResidentsListVO> residentsListVOList = new ArrayList<>();
        List<Residents> residentsList = residentsMapper.selectResidentsList(null);
        for(Residents resident : residentsList){
            Integer staff_id = resident.getStaffId();
            MedicalStaff medicalStaff = medicalStaffMapper.selectMedicalStaffById(staff_id);
            ResidentMedicalStaffVO residentMedicalStaffVO = new ResidentMedicalStaffVO();
            residentMedicalStaffVO.setStaffName(medicalStaff.getStaffName());
            residentMedicalStaffVO.setPhone(medicalStaff.getPhone());
            ResidentsListVO  residentsListVO = new ResidentsListVO();
            BeanUtils.copyProperties(resident, residentsListVO);
            residentsListVO.setResidentMedicalStaffVO(residentMedicalStaffVO);
            residentsListVOList.add(residentsListVO);
        }

        return residentsListVOList;
    }


    /**
     * 获取过去15天的警报统计数据
     * @param residentId
     * @return
     */
    @Override
    public ExceptionCountVO getHistoryExceptionInfo(Integer residentId) {

        List<ResidentExceptionHistory> temperatureExceptionHistory = residentExceptionHistoryMapper.getHistoryExceptionInfo(residentId, "体温异常");
        List<ResidentExceptionHistory> oxygenLevelExceptionHistory = residentExceptionHistoryMapper.getHistoryExceptionInfo(residentId, "血氧异常");
        List<ResidentExceptionHistory> heartRateExceptionHistory = residentExceptionHistoryMapper.getHistoryExceptionInfo(residentId, "心率异常");

        ExceptionCountVO exceptionCountVO = new ExceptionCountVO();
        exceptionCountVO.setHeartExceptionCnt(heartRateExceptionHistory.size());
        exceptionCountVO.setTemperatureExceptionCnt(temperatureExceptionHistory.size());
        exceptionCountVO.setOxygenLevelExceptionCnt(oxygenLevelExceptionHistory.size());

        return exceptionCountVO;
    }


}
