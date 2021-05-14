package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
@TableName("sys_recruiter")
public class Recruiter extends Model<Recruiter> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 电话号码
     */
    private String phonenum;
    /**
     * Email
     */
    private String email;
    /**
     * 身份证图片
     */
    private String idcardimage;
    /**
     * 公司名称
     */
    private String companyname;
    /**
     * 公司地址
     */
    private String companyplace;
    /**
     * 公司介绍
     */
    private String companyinfo;
    /**
     * 营业执照图片
     */
    private String companyimage;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 用户ID
     */
    private Integer user;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 删除标志
     */
    private Integer isdeleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdcardimage() {
        return idcardimage;
    }

    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyplace() {
        return companyplace;
    }

    public void setCompanyplace(String companyplace) {
        this.companyplace = companyplace;
    }

    public String getCompanyinfo() {
        return companyinfo;
    }

    public void setCompanyinfo(String companyinfo) {
        this.companyinfo = companyinfo;
    }

    public String getCompanyimage() {
        return companyimage;
    }

    public void setCompanyimage(String companyimage) {
        this.companyimage = companyimage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
        ", id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", phonenum=" + phonenum +
        ", email=" + email +
        ", idcardimage=" + idcardimage +
        ", companyname=" + companyname +
        ", companyplace=" + companyplace +
        ", companyinfo=" + companyinfo +
        ", companyimage=" + companyimage +
        ", status=" + status +
        ", user=" + user +
        ", createtime=" + createtime +
        ", isdeleted=" + isdeleted +
        "}";
    }
}
