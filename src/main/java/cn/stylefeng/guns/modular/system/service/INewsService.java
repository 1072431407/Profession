package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.News;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-29
 */
public interface INewsService extends IService<News> {
	/**
     * 根据条件查询新闻列表
     *
     * @return
     */
    List<Map<String, Object>> selectNews(String condition);
}
