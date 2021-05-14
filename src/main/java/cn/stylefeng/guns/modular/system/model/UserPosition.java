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
@TableName("sys_user_position")
public class UserPosition extends Model<UserPosition> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 申请人
     */
    private Integer user;

    private String username;

    private byte[] position;

    private Integer positionId;
    /**
     * 求职意向s
     */
    private String intention;
    /**
     * 简历ID
     */
    private Integer resume;
    /**
     * 职位申请状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 删除标志
     */
    private Integer isdeleted;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public byte[] getPosition() {
        return position;
    }

    public void setPosition(byte[] position) {
        this.position = position;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public Integer getResume() {
        return resume;
    }

    public void setResume(Integer resume) {
        this.resume = resume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserPosition{" +
                "id=" + id +
                ", user=" + user +
                ", username='" + username + '\'' +
                ", position='" + position + '\'' +
                ", resume=" + resume +
                ", status=" + status +
                ", createtime=" + createtime +
                ", isdeleted=" + isdeleted +
                '}';
    }
}
