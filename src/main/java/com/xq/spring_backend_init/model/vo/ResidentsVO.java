package com.xq.spring_backend_init.model.vo;


import com.xq.spring_backend_init.model.entity.MedicalStaff;
import com.xq.spring_backend_init.model.entity.Residents;
import lombok.Data;

/**
 * 老登分页信息视图
 */
@Data
public class ResidentsVO {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     *  基本信息
     */
    private String firstName;

    private String lastName;

    private MedicalStaff medicalStaff;

    private String roomNumber;

    public ResidentsVO EntityToVo(Residents residents, MedicalStaff medicalStaff){
        if(residents == null || medicalStaff == null)
            return null;
        ResidentsVO residentsVO = new ResidentsVO();
        residentsVO.setFirstName(residents.getFirstName());
        residentsVO.setLastName(residents.getLastName());
        residentsVO.setRoomNumber(residents.getRoomNumber());
        residentsVO.setRoomNumber(residents.getRoomNumber());
        residentsVO.setMedicalStaff(medicalStaff);

        return residentsVO;
    }

}
