package com.xxxx.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "t_admin")
public class TAdmin {
    /**
     * 用户id
     */
    @TableId(value = "admin_id", type = IdType.INPUT)
    private Short adminId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * email
     */
    @TableField(value = "email")
    private String email;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 秘钥
     */
    @TableField(value = "ec_salt")
    private String ecSalt;

    /**
     * 添加时间
     */
    @TableField(value = "add_time")
    private Integer addTime;

    /**
     * 最后登录时间
     */
    @TableField(value = "last_login")
    private Integer lastLogin;

    /**
     * 最后登录ip
     */
    @TableField(value = "last_ip")
    private String lastIp;

    /**
     * 权限
     */
    @TableField(value = "nav_list")
    private String navList;

    /**
     * lang_type
     */
    @TableField(value = "lang_type")
    private String langType;

    /**
     * agency_id
     */
    @TableField(value = "agency_id")
    private Short agencyId;

    /**
     * suppliers_id
     */
    @TableField(value = "suppliers_id")
    private Short suppliersId;

    /**
     * todolist
     */
    @TableField(value = "todolist")
    private String todolist;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Short roleId;

    public static final String COL_ADMIN_ID = "admin_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_EMAIL = "email";

    public static final String COL_PASSWORD = "password";

    public static final String COL_EC_SALT = "ec_salt";

    public static final String COL_ADD_TIME = "add_time";

    public static final String COL_LAST_LOGIN = "last_login";

    public static final String COL_LAST_IP = "last_ip";

    public static final String COL_NAV_LIST = "nav_list";

    public static final String COL_LANG_TYPE = "lang_type";

    public static final String COL_AGENCY_ID = "agency_id";

    public static final String COL_SUPPLIERS_ID = "suppliers_id";

    public static final String COL_TODOLIST = "todolist";

    public static final String COL_ROLE_ID = "role_id";

    /**
     * 获取用户id
     *
     * @return admin_id - 用户id
     */
    public Short getAdminId() {
        return adminId;
    }

    /**
     * 设置用户id
     *
     * @param adminId 用户id
     */
    public void setAdminId(Short adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取秘钥
     *
     * @return ec_salt - 秘钥
     */
    public String getEcSalt() {
        return ecSalt;
    }

    /**
     * 设置秘钥
     *
     * @param ecSalt 秘钥
     */
    public void setEcSalt(String ecSalt) {
        this.ecSalt = ecSalt;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login - 最后登录时间
     */
    public Integer getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLogin 最后登录时间
     */
    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 获取最后登录ip
     *
     * @return last_ip - 最后登录ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置最后登录ip
     *
     * @param lastIp 最后登录ip
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取权限
     *
     * @return nav_list - 权限
     */
    public String getNavList() {
        return navList;
    }

    /**
     * 设置权限
     *
     * @param navList 权限
     */
    public void setNavList(String navList) {
        this.navList = navList;
    }

    /**
     * 获取lang_type
     *
     * @return lang_type - lang_type
     */
    public String getLangType() {
        return langType;
    }

    /**
     * 设置lang_type
     *
     * @param langType lang_type
     */
    public void setLangType(String langType) {
        this.langType = langType;
    }

    /**
     * 获取agency_id
     *
     * @return agency_id - agency_id
     */
    public Short getAgencyId() {
        return agencyId;
    }

    /**
     * 设置agency_id
     *
     * @param agencyId agency_id
     */
    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 获取suppliers_id
     *
     * @return suppliers_id - suppliers_id
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * 设置suppliers_id
     *
     * @param suppliersId suppliers_id
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    /**
     * 获取todolist
     *
     * @return todolist - todolist
     */
    public String getTodolist() {
        return todolist;
    }

    /**
     * 设置todolist
     *
     * @param todolist todolist
     */
    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Short getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", ecSalt=").append(ecSalt);
        sb.append(", addTime=").append(addTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", navList=").append(navList);
        sb.append(", langType=").append(langType);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", todolist=").append(todolist);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TAdmin other = (TAdmin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEcSalt() == null ? other.getEcSalt() == null : this.getEcSalt().equals(other.getEcSalt()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
            && (this.getNavList() == null ? other.getNavList() == null : this.getNavList().equals(other.getNavList()))
            && (this.getLangType() == null ? other.getLangType() == null : this.getLangType().equals(other.getLangType()))
            && (this.getAgencyId() == null ? other.getAgencyId() == null : this.getAgencyId().equals(other.getAgencyId()))
            && (this.getSuppliersId() == null ? other.getSuppliersId() == null : this.getSuppliersId().equals(other.getSuppliersId()))
            && (this.getTodolist() == null ? other.getTodolist() == null : this.getTodolist().equals(other.getTodolist()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEcSalt() == null) ? 0 : getEcSalt().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getNavList() == null) ? 0 : getNavList().hashCode());
        result = prime * result + ((getLangType() == null) ? 0 : getLangType().hashCode());
        result = prime * result + ((getAgencyId() == null) ? 0 : getAgencyId().hashCode());
        result = prime * result + ((getSuppliersId() == null) ? 0 : getSuppliersId().hashCode());
        result = prime * result + ((getTodolist() == null) ? 0 : getTodolist().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}