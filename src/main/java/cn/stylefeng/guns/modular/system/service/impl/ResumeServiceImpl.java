package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Resume;
import cn.stylefeng.guns.modular.system.dao.ResumeMapper;
import cn.stylefeng.guns.modular.system.service.IResumeService;
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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements IResumeService {

	@Override
	public List<Map<String, Object>> selectResumes(String condition) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectResumes(condition);
	}

	@Override
	public List<Map<String, Object>> selectResumesById(Map<String, Object> queryMap) {
		return this.baseMapper.selectResumesById(queryMap);
	}


}
