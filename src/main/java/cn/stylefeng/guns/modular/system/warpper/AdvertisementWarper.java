package cn.stylefeng.guns.modular.system.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;

public class AdvertisementWarper extends BaseControllerWrapper{

	public AdvertisementWarper(List<Map<String, Object>> multi) {
		super(multi);
		// TODO Auto-generated constructor stub
	}

	public AdvertisementWarper(Map<String, Object> single) {
        super(single);
    }
	
    public AdvertisementWarper(Page<Map<String, Object>> page) {
        super(page);
    }

    public AdvertisementWarper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }
	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		 map.put("statusName", ConstantFactory.me().getApplyStatusName((Integer) map.get("status")));
		 map.put("isDeleted", ConstantFactory.me().getStatusName((Integer) map.get("isdeleted")));
					
	}

}
