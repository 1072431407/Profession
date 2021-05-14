package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Advertisement;
import cn.stylefeng.guns.modular.system.dao.AdvertisementMapper;
import cn.stylefeng.guns.modular.system.service.IAdvertisementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mike
 * @since 2019-01-15
 */
@Service
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements IAdvertisementService {

	@Override
	public List<Map<String, Object>> selectAdvertisements(String condition) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectAdvertisements(condition);
	}

}
