package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.FamilyMemberMobile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 家庭信息查询
 */
@Mapper
public interface FamilyMemeberMobileMapper {

    /**
     * 条件查询家属信息
     *
     * @param familyMemberMobile
     * @return
     */
    public List<FamilyMemberMobile> selectFamilyMemberMobileList(FamilyMemberMobile familyMemberMobile);

    /**
     * 查询老人所有亲属
     *
     * @param memberId
     * @return
     */
    public List<FamilyMemberMobile> selectFamilyMemeberMobileByMemeberId(Integer memberId);

    /**
     * 根据老登id和亲属名字查询关系
     * @param residentId
     * @param userName
     * @return
     */
    public String selectRelationship(Integer residentId, String userName);

    /**
     * 根据条件信息删除家属信息
     * @param familyMemberMobile
     */
    public void deletFamilyMemberMobile(FamilyMemberMobile familyMemberMobile);

    /**
     * 更新家属信息
     * @param familyMemberMobile
     */
    public void updateFamilyMemberMobile(FamilyMemberMobile familyMemberMobile);

    /**
     * 插入新的家属信息
     * @param familyMemberMobile
     */
    public void insertFamilyMemberMobile(FamilyMemberMobile familyMemberMobile);
}
