package cn.stylefeng.guns.modular.system.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;

public class PositionWarper extends BaseControllerWrapper{

	public PositionWarper(List<Map<String, Object>> multi) {
		super(multi);
		// TODO Auto-generated constructor stub
	}

	public PositionWarper(Map<String, Object> single) {
        super(single);
    }
	
    public PositionWarper(Page<Map<String, Object>> page) {
        super(page);
    }

    public PositionWarper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }
	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		map.put("typeName", ConstantFactory.me().getJobTypeName((Integer) map.get("type")));
		map.put("isDeleted", ConstantFactory.me().getStatusName((Integer) map.get("isdeleted")));			
	}

}
