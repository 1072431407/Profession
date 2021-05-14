package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.UserPosition;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
public interface UserPositionMapper extends BaseMapper<UserPosition> {
        int userPositionsave(UserPosition userPosition);
        List<Map<String, Object>> findApplyByid(@Param("id") Integer id);

        List<Map<String, Object>>findApplyByPid(@Param("id") Integer id);

        int updateStatus(Map<String, Object> queryMap);
}
