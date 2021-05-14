package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Advertisement;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-15
 */
public interface AdvertisementMapper extends BaseMapper<Advertisement> {
	/**
     * 根据条件查询广告列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectAdvertisements(@Param("condition") String condition);
}
