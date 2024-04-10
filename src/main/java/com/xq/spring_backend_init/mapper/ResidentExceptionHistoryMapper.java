package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.ResidentExceptionHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 异常信息处理数据库操作
 */
@Mapper
public interface ResidentExceptionHistoryMapper {

    /**
     * 根据条件查询异常消息
     * @param residentExceptionHistory
     * @return
     */
    public List<ResidentExceptionHistory> selectExceptionList(ResidentExceptionHistory residentExceptionHistory);

    /**
     * 根据老登id查询异常记录
     * @param memberId
     * @return
     */
    public List<ResidentExceptionHistory> selectExceptionByResident(Integer memberId);


}
