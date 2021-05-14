package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.common.constant.state.ApplayStatus;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.util.BytesUtils;
import cn.stylefeng.guns.modular.system.model.Position;
import cn.stylefeng.guns.modular.system.model.Resume;
import cn.stylefeng.guns.modular.system.model.UserPosition;
import cn.stylefeng.guns.modular.system.service.IPositionService;
import cn.stylefeng.guns.modular.system.service.IResumeService;
import cn.stylefeng.guns.modular.system.service.IUserPositionService;
import cn.stylefeng.guns.modular.system.warpper.PositionWarper;
import cn.stylefeng.guns.modular.system.warpper.UserPositionWarper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 申请职位管理控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:41:56
 */
@Controller
@RequestMapping("/userPosition")
public class UserPositionController extends BaseController {

    private String PREFIX = "/system/user_position/";

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
        return PREFIX + "user_position.html";
    }


    /**
     * 获取兼职任务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) throws IOException, ClassNotFoundException {
        List<Map<String, Object>> applyByid=null;
        ShiroUser user = ShiroKit.getUser();
        if( user.getRoleNames().contains("应聘者")){
            applyByid = userPositionService.findApplyByid(user.getId());
        }else{
            applyByid= userPositionService.findApplyByid(null);
        }
        return new UserPositionWarper(applyByid).wrap();
    }
    /**
     * 获取兼职任务列表
     */
    @RequestMapping(value = "/view_list")
    @ResponseBody
    public Object list(@RequestParam(name = "id",required = true,defaultValue = "") Integer pid) throws IOException, ClassNotFoundException {
        List<Map<String, Object>> applyByPid = userPositionService.findApplyByPid(pid);
        return new UserPositionWarper(applyByPid).wrap();
    }


    /**
     * 审阅操作
     */
    @RequestMapping(value = "/review")
    @ResponseBody
    public Object review(@RequestParam(name = "id",required = true,defaultValue = "")Integer id) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id",id);
        queryMap.put("status",ApplayStatus.YIYUE.getCode());
        userPositionService.updateStatus(queryMap);
        return SUCCESS_TIP;
    }

}
