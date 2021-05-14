package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Advertisement;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-15
 */
public interface IAdvertisementService extends IService<Advertisement> {
	/**
     * 根据条件查询广告列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectAdvertisements(String condition);
}
