package com.xq.spring_backend_init.mapper;


import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ExceptionAlertVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 *  病人数据库操作
 */

@Mapper
public interface ResidentsMapper{

    /**
     *
     * 插入病人数据
     *
     * @param residents
     * @return 200: 成功插入 -1 失败
/*
     *//*

    public void insertResidents(Residents residents);

    */
/**
     *
     * 删除病人数据
     *
     * @param residents
     * @return 200: ok -1: fail
     *//*

    public void deletResidents(Residents residents);

    */
/**
     *
     * 更新病人数据
     *
     * @param residents
     * @return
     *//*

    public void updateResidents(Residents residents);
*/

    /**
     * 查询病人数据
     * @param residents
     * @return
     */
    public List<Residents> selectResidentsList(Residents residents);

    public List<ExceptionAlertVO> getAllExceptions(int staffId);


}
