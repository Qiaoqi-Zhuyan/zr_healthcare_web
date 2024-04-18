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
     * 查询病人数据
     * @param residents
     * @return
     */

    public List<Residents> selectResidentsList(Residents residents);

    /**
     * 通过id查询老登数据
     * @param residentId
     * @return
     */
    public Residents selectResident(Integer residentId);

    /**
     * 通过护工id获取房间号信息
     * @param staffId
     * @return
     */
    public String getRoomNumberByStaffId(Integer staffId);



    public List<ExceptionAlertVO> getAllExceptions(int staffId);


}
