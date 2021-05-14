package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.UserPosition;
import cn.stylefeng.guns.modular.system.dao.UserPositionMapper;
import cn.stylefeng.guns.modular.system.service.IUserPositionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mike
 * @since 2018-12-29
 */
@Service
public class UserPositionServiceImpl extends ServiceImpl<UserPositionMapper, UserPosition> implements IUserPositionService {

    @Override
    public int userPositionsave(UserPosition userPosition) {
        return this.baseMapper.userPositionsave(userPosition);
    }

    @Override
    public List<Map<String, Object>> findApplyByid(Integer id) {
        return this.baseMapper.findApplyByid(id);
    }

    @Override
    public List<Map<String, Object>> findApplyByPid(Integer id) {
        return this.baseMapper.findApplyByPid(id);
    }

    @Override
    public int updateStatus(Map<String, Object> queryMap) {
        return this.baseMapper.updateStatus(queryMap);
    }

}
