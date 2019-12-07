package com.zhangting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 17:52
 */
@Data
public class RoleDO {

    @Id
    @Column(name = "ID_")
    private String id;
    @Column(name = "ROLE_NAME")
    private String roleName;

}
