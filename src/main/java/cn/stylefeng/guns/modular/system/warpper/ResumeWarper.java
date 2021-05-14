package cn.stylefeng.guns.modular.system.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;

public class ResumeWarper extends BaseControllerWrapper{

	public ResumeWarper(List<Map<String, Object>> multi) {
		super(multi);
		// TODO Auto-generated constructor stub
	}

	public ResumeWarper(Map<String, Object> single) {
        super(single);
    }
	
    public ResumeWarper(Page<Map<String, Object>> page) {
        super(page);
    }

    public ResumeWarper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }
	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		 map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
		 map.put("statusName", ConstantFactory.me().getApplyStatusName((Integer) map.get("statue")));
		 map.put("typeName", ConstantFactory.me().getJobTypeName((Integer) map.get("jobtype")));
		 map.put("isDeleted", ConstantFactory.me().getStatusName((Integer) map.get("isdeleted")));
					
	}

}
