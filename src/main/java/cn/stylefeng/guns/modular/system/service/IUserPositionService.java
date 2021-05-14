package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.UserPosition;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
public interface IUserPositionService extends IService<UserPosition> {
    int userPositionsave(UserPosition userPosition);

    List<Map<String, Object>> findApplyByid(Integer id);

    List<Map<String, Object>>findApplyByPid(Integer id);
    int updateStatus(Map<String, Object> queryMap);

}
