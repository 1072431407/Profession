package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Position;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
public interface PositionMapper extends BaseMapper<Position> {
	/**
     * 根据条件查询职位列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectPositions(@Param("condition") String condition);
}
