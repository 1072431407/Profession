package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>user_status
 * 
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
@TableName("sys_resume")
public class Resume extends Model<Resume> {

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
     * 出生年月
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date birthday;
    /**
     * 电话号码
     */
    private String phonenum;
    /**
     * Email
     */
    private String email;
    /**
     * 学校名称
     */
    private String schoolname;
    /**
     * 入学时间到毕业时间
     */
    private String time;
    /**
     * 学历
     */
    private String education;
    /**
     * 专业
     */
    private String major;
    /**
     * 工作经验
     */
    private String experience;
    /**
     * 求职意向
     */
    private String jobintension;
    /**
     * 求职类型
     */
    private Integer jobtype;
    /**
     * 学生证图片
     */
    private String cardimage;
    /**
     * 用户id
     */
    private Long user;
    /**
     * 状态
     */
    private Integer statue;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 删除标记
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobintension() {
        return jobintension;
    }

    public void setJobintension(String jobintension) {
        this.jobintension = jobintension;
    }

    public Integer getJobtype() {
        return jobtype;
    }

    public void setJobtype(Integer jobtype) {
        this.jobtype = jobtype;
    }

    public String getCardimage() {
        return cardimage;
    }

    public void setCardimage(String cardimage) {
        this.cardimage = cardimage;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
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
        return "Resume{" +
        ", id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", phonenum=" + phonenum +
        ", email=" + email +
        ", schoolname=" + schoolname +
        ", time=" + time +
        ", education=" + education +
        ", major=" + major +
        ", experience=" + experience +
        ", jobintension=" + jobintension +
        ", jobtype=" + jobtype +
        ", cardimage=" + cardimage +
        ", user=" + user +
        ", statue=" + statue +
        ", createtime=" + createtime +
        ", isdeleted=" + isdeleted +
        "}";
    }
}
