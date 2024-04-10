package com.xq.spring_backend_init.service;



import com.xq.spring_backend_init.model.dto.residents.ResidentQueryRequest;
import com.xq.spring_backend_init.model.entity.Residents;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ResidentsService {

     /**
      * 查询所有信息
      * @param residents
      * @return
      */
     List<Residents> selectAllResidents(Residents residents);

}
