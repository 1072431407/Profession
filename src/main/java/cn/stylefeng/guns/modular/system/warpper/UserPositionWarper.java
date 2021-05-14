package cn.stylefeng.guns.modular.system.warpper;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

public class UserPositionWarper extends BaseControllerWrapper{

	public UserPositionWarper(List<Map<String, Object>> multi) {
		super(multi);
		// TODO Auto-generated constructor stub
	}

	public UserPositionWarper(Map<String, Object> single) {
        super(single);
    }

    public UserPositionWarper(Page<Map<String, Object>> page) {
        super(page);
    }

    public UserPositionWarper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }
	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		map.put("isDeleted", ConstantFactory.me().getStatusName((Integer) map.get("isdeleted")));
		map.put("status",ConstantFactory.me().getApplayStatus((Integer) map.get("status")));
	}

}
