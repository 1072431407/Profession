package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.News;
import cn.stylefeng.guns.modular.system.dao.NewsMapper;
import cn.stylefeng.guns.modular.system.service.INewsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-29
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

	@Override
	public List<Map<String, Object>> selectNews(String condition) {
		
		return this.baseMapper.selectNews(condition);
	}

}
