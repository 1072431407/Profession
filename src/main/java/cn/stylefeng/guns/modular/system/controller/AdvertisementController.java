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
import cn.stylefeng.guns.modular.system.model.Advertisement;
import cn.stylefeng.guns.modular.system.service.IAdvertisementService;
import cn.stylefeng.guns.modular.system.warpper.AdvertisementWarper;

/**
 * 广告管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-15 14:58:44
 */
@Controller
@RequestMapping("/advertisement")
public class AdvertisementController extends BaseController {

    private String PREFIX = "/system/advertisement/";

    @Autowired
    private IAdvertisementService advertisementService;

    /**
     * 跳转到广告管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "advertisement.html";
    }

    /**
     * 跳转到添加广告管理
     */
    @RequestMapping("/advertisement_add")
    public String advertisementAdd() {
        return PREFIX + "advertisement_add.html";
    }

    /**
     * 跳转到修改广告管理
     */
    @RequestMapping("/advertisement_update/{advertisementId}")
    public String advertisementUpdate(@PathVariable Integer advertisementId, Model model) {
        Advertisement advertisement = advertisementService.selectById(advertisementId);
        model.addAttribute("item",advertisement);
        LogObjectHolder.me().set(advertisement);
        return PREFIX + "advertisement_edit.html";
    }

    /**
     * 获取广告管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String, Object>> advertisements = advertisementService.selectAdvertisements(condition);
        return new AdvertisementWarper(advertisements).wrap();
    }

    /**
     * 新增广告管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Advertisement advertisement) {
    	advertisement.setCreatetime(new Date());
        advertisementService.insert(advertisement);
        return SUCCESS_TIP;
    }

    /**
     * 删除广告管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer advertisementId) {
    	Advertisement advertisement = advertisementService.selectById(advertisementId);
        advertisement.setIsdeleted(3);
    	advertisementService.updateById(advertisement);
        return SUCCESS_TIP;
    }

    /**
     * 修改广告管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Advertisement advertisement) {
        advertisementService.updateById(advertisement);
        return SUCCESS_TIP;
    }

    /**
     * 广告管理详情
     */
    @RequestMapping(value = "/detail/{advertisementId}")
    @ResponseBody
    public Object detail(@PathVariable("advertisementId") Integer advertisementId) {
        return advertisementService.selectById(advertisementId);
    }
}
