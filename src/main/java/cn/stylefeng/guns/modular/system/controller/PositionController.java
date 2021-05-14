package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.util.BytesUtils;
import cn.stylefeng.guns.modular.system.model.Resume;
import cn.stylefeng.guns.modular.system.model.UserPosition;
import cn.stylefeng.guns.modular.system.service.IResumeService;
import cn.stylefeng.guns.modular.system.service.IUserPositionService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.system.model.Position;
import cn.stylefeng.guns.modular.system.service.IPositionService;
import cn.stylefeng.guns.modular.system.warpper.PositionWarper;

/**
 * 兼职任务控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:41:56
 */
@Controller
@RequestMapping("/position")
public class PositionController extends BaseController {

    private String PREFIX = "/system/position/";

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IResumeService resumeService;

    @Autowired
    private IUserPositionService userPositionService;
    /**
     * 跳转到兼职任务首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "position.html";
    }

    /**
     * 跳转到添加兼职任务
     */
    @RequestMapping("/position_add")
    public String positionAdd() {
        return PREFIX + "position_add.html";
    }

    /**
     * 跳转到修改兼职任务
     */
    @RequestMapping("/position_update/{positionId}")
    public String positionUpdate(@PathVariable Integer positionId, Model model) {
        Position position = positionService.selectById(positionId);
        model.addAttribute("item",position);
        model.addAttribute("jobTypeName", ConstantFactory.me().getJobTypeName(position.getType()));
        LogObjectHolder.me().set(position);
        LogObjectHolder.me().set(position.getType());
        return PREFIX + "position_edit.html";
    }

    /**
     * 获取兼职任务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Map<String, Object>> positions = positionService.selectPositions(condition);
        
    	return new PositionWarper(positions).wrap();
    }

    @RequestMapping(value = "/view_position/{id}",method = RequestMethod.GET)
    public String viewPosition(Model model,@PathVariable(name = "id") Integer id) {
        model.addAttribute("pid",id);
        return PREFIX + "view_position.html";
    }

    @RequestMapping(value = "/position_launch/{id}",method = RequestMethod.GET)
    public String positionLaunch(Model model,@PathVariable(name = "id") Integer id) {
        ShiroUser user = ShiroKit.getUser();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId",user.getId());
        List<Map<String, Object>> resumeList = resumeService.selectResumesById(queryMap);
        model.addAttribute("resumeList",resumeList);
        model.addAttribute("id",id);
        return PREFIX + "position_launch.html";
    }

    /**
     * 新增兼职任务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Position position) {
        ShiroUser user = ShiroKit.getUser();
        Integer id = user.getId();
        position.setUser(id);
        position.setCreatetime(new Date());
        positionService.insert(position);
        return SUCCESS_TIP;
    }

    /**
     * 删除兼职任务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer positionId) {
    	Position position = positionService.selectById(positionId);
    	position.setIsdeleted(3);
        positionService.updateById(position);
        return SUCCESS_TIP;
    }


    /**
     * 投放简历操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/position_launch",method = RequestMethod.POST)
    public Object resumeLaunch(@RequestParam(name = "id",required = true)Integer id,@RequestParam(name = "pid")Integer pid) throws IOException {
        SuccessResponseData successTip = SUCCESS_TIP;
        ShiroUser user = ShiroKit.getUser();
        Resume resume = resumeService.selectById(id);
        Position position = positionService.selectById(pid);
        UserPosition userPosition = new UserPosition();
        userPosition.setUser(user.getId());
        byte[] bytes = BytesUtils.objectToBytes(position);
        userPosition.setPosition(bytes);
        userPosition.setPositionId(position.getId());
        userPosition.setUsername(resume.getName());
        userPosition.setIsdeleted(1);
        userPosition.setStatus(1);
        userPosition.setIntention(resume.getJobintension());
        userPosition.setResume(resume.getId());
        userPosition.setCreatetime(new Date());
        if(userPositionService.userPositionsave(userPosition)<=0){
            successTip.setCode(-1001);
            successTip.setMessage("投放简历失败,请联系管理员!");
          return successTip;
        }
        return successTip;
    }

    /**
     * 修改兼职任务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Position position) {
        positionService.updateById(position);
        return SUCCESS_TIP;
    }

    /**
     * 兼职任务详情
     */
    @RequestMapping(value = "/detail/{positionId}")
    @ResponseBody
    public Object detail(@PathVariable("positionId") Integer positionId) {
        return positionService.selectById(positionId);
    }

}
