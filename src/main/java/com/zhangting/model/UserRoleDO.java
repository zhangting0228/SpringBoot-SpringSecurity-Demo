package com.zhangting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 17:53
 */
@Data
public class UserRoleDO {

    @Id
    @Column(name = "ID_")
    private String id;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "ROLE_ID")
    private String roleId;

}
