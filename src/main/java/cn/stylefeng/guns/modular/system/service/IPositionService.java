package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Position;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
public interface IPositionService extends IService<Position> {
	/**
     * 根据条件查询职位列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectPositions(String condition);
}
