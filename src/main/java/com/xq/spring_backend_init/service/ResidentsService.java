package com.xq.spring_backend_init.service;



import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ExceptionAlert1VO;
import com.xq.spring_backend_init.model.vo.ExceptionCountVO;
import com.xq.spring_backend_init.model.vo.ResidentsListVO;
import com.xq.spring_backend_init.model.vo.ResidentsVO;

import java.util.List;

public interface ResidentsService {

     /**
      * 查询所有信息
      * @param residents
      * @return
      */
     List<Residents> selectAllResidents(Residents residents);

     /**
      * 分页查询信息
      * @param page
      * @return
      */
     List<ResidentsVO> pageSelectResidents(Integer page);


     List<ExceptionAlert1VO> getAllExceptions(int staffId);

     /**
      * 查询所有老年人的姓名、管理人员(姓名, 联系方式)、房间号
      * @return
      */
     List<ResidentsListVO> getResidentsVOList();


     /**
      * 获取过去15天的警报统计数据
      * @param residentId
      * @return
      */
     public ExceptionCountVO getHistoryExceptionInfo(Integer residentId);

}
