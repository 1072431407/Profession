package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Recruiter;
import cn.stylefeng.guns.modular.system.dao.RecruiterMapper;
import cn.stylefeng.guns.modular.system.service.IRecruiterService;
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
public class RecruiterServiceImpl extends ServiceImpl<RecruiterMapper, Recruiter> implements IRecruiterService {

	@Override
	public List<Map<String, Object>> selectRecruiters(String condition) {
		// TODO Auto-generated method stub
		return  this.baseMapper.selectRecruiters(condition);
	}

}
