package com.xxxx.common.pojo;

import java.io.Serializable;

public class TAdmin implements Serializable {
    /**
    * 用户id
    */
    private Short adminId;

    /**
    * 用户名
    */
    private String userName;

    /**
    * email
    */
    private String email;

    /**
    * 密码
    */
    private String password;

    /**
    * 秘钥
    */
    private String ecSalt;

    /**
    * 添加时间
    */
    private Integer addTime;

    /**
    * 最后登录时间
    */
    private Integer lastLogin;

    /**
    * 最后登录ip
    */
    private String lastIp;

    /**
    * 权限
    */
    private String navList;

    /**
    * lang_type
    */
    private String langType;

    /**
    * agency_id
    */
    private Short agencyId;

    /**
    * suppliers_id
    */
    private Short suppliersId;

    /**
    * todolist
    */
    private String todolist;

    /**
    * 角色id
    */
    private Short roleId;

    public Short getAdminId() {
        return adminId;
    }

    public void setAdminId(Short adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEcSalt() {
        return ecSalt;
    }

    public void setEcSalt(String ecSalt) {
        this.ecSalt = ecSalt;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getNavList() {
        return navList;
    }

    public void setNavList(String navList) {
        this.navList = navList;
    }

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType;
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    public Short getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }
}