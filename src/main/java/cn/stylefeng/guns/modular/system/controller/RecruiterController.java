package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Recruiter;
import cn.stylefeng.guns.modular.system.service.IRecruiterService;
import cn.stylefeng.guns.modular.system.warpper.RecruiterWarper;

/**
 * 招聘者控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:44:30
 */
@Controller
@RequestMapping("/recruiter")
public class RecruiterController extends BaseController {

    private String PREFIX = "/system/recruiter/";

    @Autowired
    private IRecruiterService recruiterService;

    /**
     * 跳转到招聘者首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "recruiter.html";
    }

    /**
     * 跳转到添加招聘者
     */
    @RequestMapping("/recruiter_add")
    public String recruiterAdd() {
        return PREFIX + "recruiter_add.html";
    }

    /**
     * 跳转到修改招聘者
     */
    @RequestMapping("/recruiter_update/{recruiterId}")
    public String recruiterUpdate(@PathVariable Integer recruiterId, Model model) {
        Recruiter recruiter = recruiterService.selectById(recruiterId);
        model.addAttribute("item",recruiter);   
        model.addAttribute("sexName", ConstantFactory.me().getSexName(recruiter.getSex()));
        LogObjectHolder.me().set(ConstantFactory.me().getSexName(recruiter.getSex()));
        LogObjectHolder.me().set(recruiter);
        return PREFIX + "recruiter_edit.html";
    }

    /**
     * 获取招聘者列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String, Object>> recruiters = recruiterService.selectRecruiters(condition);
        return new RecruiterWarper(recruiters).wrap();
    }

    /**
     * 新增招聘者
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Recruiter recruiter) {
        recruiterService.insert(recruiter);
        return SUCCESS_TIP;
    }

    /**
     * 删除招聘者
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer recruiterId) {
    	Recruiter recruiter = recruiterService.selectById(recruiterId);
    	recruiter.setIsdeleted(3);
        recruiterService.updateById(recruiter);
        return SUCCESS_TIP;
    }

    /**
     * 修改招聘者
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Recruiter recruiter) {
        recruiterService.updateById(recruiter);
        return SUCCESS_TIP;
    }

    /**
     * 招聘者详情
     */
    @RequestMapping(value = "/detail/{recruiterId}")
    @ResponseBody
    public Object detail(@PathVariable("recruiterId") Integer recruiterId) {
        return recruiterService.selectById(recruiterId);
    }
}
