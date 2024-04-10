package com.xq.spring_backend_init.service;



import com.xq.spring_backend_init.model.entity.Residents;
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



}
