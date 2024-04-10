package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.MedicalStaff;
import org.apache.ibatis.annotations.Mapper;
import org.w3c.dom.stylesheets.MediaList;

import java.util.List;

@Mapper
public interface MedicalStaffMapper {

    /**
     * 根据姓名密码查询
     * @param userName
     * @param password
     * @return
     */
    public MedicalStaff selectMedicalStaff(String userName, String password);

    /**
     *
     * 根据护工id查询
     *
     */
    public MedicalStaff selectMedicalStaffById(Integer id);

    /**
     * 查询护工信息
     * @param medicalStaff
     * @return
     */
    public List<MedicalStaff> selectMedicalStaffList(MedicalStaff medicalStaff);

    /**
     * 更新护工信息
     *
     * @param medicalStaff
     */
    public void updateMedicalStaff(MedicalStaff medicalStaff);

    /**
     * 插入护工信息
     * @param medicalStaff
     */
    public void insertMedicalStaff(MedicalStaff medicalStaff);

    /**
     * 删除护工信息
     * @param medicalStaff
     */
    public void deleteMedicalStaff(MedicalStaff medicalStaff);
}
