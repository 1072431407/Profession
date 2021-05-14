package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.News;
import cn.stylefeng.guns.modular.system.service.INewsService;
import cn.stylefeng.guns.modular.system.warpper.NewsWarper;

/**
 * 新闻控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:38:22
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    private String PREFIX = "/system/news/";

    @Autowired
    private INewsService newsService;

    /**
     * 跳转到新闻首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "news.html";
    }

    /**
     * 跳转到添加新闻
     */
    @RequestMapping("/news_add")
    public String newsAdd() {
        return PREFIX + "news_add.html";
    }

    /**
     * 跳转到修改新闻
     */
    @RequestMapping("/news_update/{newsId}")
    public String newsUpdate(@PathVariable Integer newsId, Model model) {
        News news = newsService.selectById(newsId);
        model.addAttribute("item",news);
        LogObjectHolder.me().set(news);
        return PREFIX + "news_edit.html";
    }

    /**
     * 获取新闻列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String, Object>> news = newsService.selectNews(condition);
        return new NewsWarper(news).wrap();
    }

    /**
     * 新增新闻
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(News news) {
    	news.setCreatetime(new Date());
        newsService.insert(news);
        return SUCCESS_TIP;
    }

    /**
     * 删除新闻
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer newsId) {
        News news = newsService.selectById(newsId);
        news.setIsdeleted(3);
        newsService.updateById(news);
        return SUCCESS_TIP;
    }

    /**
     * 修改新闻
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(News news) {
        newsService.updateById(news);
        return SUCCESS_TIP;
    }

    /**
     * 新闻详情
     */
    @RequestMapping(value = "/detail/{newsId}")
    @ResponseBody
    public Object detail(@PathVariable("newsId") Integer newsId) {
        return newsService.selectById(newsId);
    }
}
