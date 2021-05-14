package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Position;
import cn.stylefeng.guns.modular.system.dao.PositionMapper;
import cn.stylefeng.guns.modular.system.service.IPositionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {
	/**
     * 根据条件查询职位列表
     *
     * @return
     */
	@Override
	public List<Map<String, Object>> selectPositions(String condition) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectPositions(condition);
	}

}
