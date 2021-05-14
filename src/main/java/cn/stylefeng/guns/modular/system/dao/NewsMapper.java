package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.News;

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
 * @since 2018-12-29
 */
public interface NewsMapper extends BaseMapper<News> {
	/**
     * 根据条件查询职位列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectNews(@Param("condition") String condition);
}
