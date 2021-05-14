package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Resume;
import cn.stylefeng.guns.modular.system.service.IResumeService;
import cn.stylefeng.guns.modular.system.warpper.ResumeWarper;

/**
 * 简历控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:46:07
 */
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController {

    private String PREFIX = "/system/resume/";

    @Autowired
    private IResumeService resumeService;

    /**
     * 跳转到简历首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "resume.html";
    }

    /**
     * 跳转到添加简历
     */
    @RequestMapping("/resume_add")
    public String resumeAdd() {
        return PREFIX + "resume_add.html";
    }

    /**
     * 跳转到修改简历
     */
    @RequestMapping("/resume_update/{resumeId}")
    public String resumeUpdate(@PathVariable Integer resumeId, Model model) {
        Resume resume = resumeService.selectById(resumeId);
        model.addAttribute("item",resume);
        model.addAttribute("sexName", ConstantFactory.me().getSexName(resume.getSex()));
        model.addAttribute("jobTypeName", ConstantFactory.me().getJobTypeName(resume.getJobtype()));
        LogObjectHolder.me().set(resume);
        LogObjectHolder.me().set(ConstantFactory.me().getSexName(resume.getSex()));
        return PREFIX + "resume_edit.html";
    }

    /**
     * 获取简历列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        ShiroUser user = ShiroKit.getUser();
        List<Map<String, Object>> resumes=null;
        if(user.getRoleNames().contains("超级管理员")){
            //表示是管理员
            resumes = resumeService.selectResumes(condition);
        }else if(user.getRoleNames().contains("应聘者")){
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("userId",user.getId());
            resumes= resumeService.selectResumesById(queryMap);
        }
        return new ResumeWarper(resumes).wrap();
    }

    /**
     * 新增简历
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Resume resume) {
        ShiroUser user = ShiroKit.getUser();
        resume.setUser(user.getId().longValue());
        resume.setCreatetime(new Date());
        resume.setStatue(1);
        resume.setIsdeleted(1);
        resumeService.insert(resume);
        return SUCCESS_TIP;
    }

    /**
     * 删除简历
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer resumeId) {
    	Resume resume = resumeService.selectById(resumeId);
    	resume.setIsdeleted(3);
        resumeService.updateById(resume);
        return SUCCESS_TIP;
    }

    /**
     * 修改简历
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Resume resume) {
        resumeService.updateById(resume);
        return SUCCESS_TIP;
    }

    /**
     * 简历更新
     */
    @RequestMapping(value = "/update/{resumeId}")
    @ResponseBody
    public String updateResume(@PathVariable("resumeId") Integer resumeId,Model model) {
        Resume resume = resumeService.selectById(resumeId);
        model.addAttribute(resume);
        model.addAttribute("sex", ConstantFactory.me().getSexName(resume.getSex()));
        return PREFIX + "/resume_edit.html";
    }
    /**
     * 简历详情
     */
    @RequestMapping(value = "/resume_detail/{resumeId}")
    public String detail(@PathVariable("resumeId") Integer resumeId,Model model) {
        Resume resume = resumeService.selectById(resumeId);
        model.addAttribute("resume",resume);
        model.addAttribute("sex", ConstantFactory.me().getSexName(resume.getSex()));
        return PREFIX + "/resume_detail.html";
    }

    /**
     * 简历详情
     */
    @RequestMapping(value = "/view_resume_detail/{resumeId}")
    public String viewResumeDetail(@PathVariable("resumeId") Integer resumeId,Model model) {
        Resume resume = resumeService.selectById(resumeId);
        model.addAttribute("resume",resume);
        model.addAttribute("sex", ConstantFactory.me().getSexName(resume.getSex()));
        return PREFIX + "/view_resume_detail.html";
    }
}
