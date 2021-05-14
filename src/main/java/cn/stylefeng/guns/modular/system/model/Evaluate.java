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
 * @author stylefeng
 * @since 2018-12-29
 */
@TableName("sys_evaluate")
public class Evaluate extends Model<Evaluate> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 评价者ID
     */
    private Integer user;
    /**
     * 职位
     */
    private Integer position;
    /**
     * 招聘者资料ID
     */
    private Integer recruiter;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Integer recruiter) {
        this.recruiter = recruiter;
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
        return "Evaluate{" +
        ", id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", user=" + user +
        ", position=" + position +
        ", recruiter=" + recruiter +
        ", createtime=" + createtime +
        ", isdeleted=" + isdeleted +
        "}";
    }
}
