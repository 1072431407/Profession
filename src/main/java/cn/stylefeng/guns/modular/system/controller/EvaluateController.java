package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Evaluate;
import cn.stylefeng.guns.modular.system.service.IEvaluateService;

/**
 * 广告控制器
 *
 * @author fengshuonan
 * @Date 2018-12-29 22:37:13
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController extends BaseController {

    private String PREFIX = "/system/evaluate/";

    @Autowired
    private IEvaluateService evaluateService;

    /**
     * 跳转到广告首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "evaluate.html";
    }

    /**
     * 跳转到添加广告
     */
    @RequestMapping("/evaluate_add")
    public String evaluateAdd() {
        return PREFIX + "evaluate_add.html";
    }

    /**
     * 跳转到修改广告
     */
    @RequestMapping("/evaluate_update/{evaluateId}")
    public String evaluateUpdate(@PathVariable Integer evaluateId, Model model) {
        Evaluate evaluate = evaluateService.selectById(evaluateId);
        model.addAttribute("item",evaluate);
        LogObjectHolder.me().set(evaluate);
        return PREFIX + "evaluate_edit.html";
    }

    /**
     * 获取广告列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return evaluateService.selectList(null);
    }

    /**
     * 新增广告
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Evaluate evaluate) {
        evaluateService.insert(evaluate);
        return SUCCESS_TIP;
    }

    /**
     * 删除广告
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer evaluateId) {
        evaluateService.deleteById(evaluateId);
        return SUCCESS_TIP;
    }

    /**
     * 修改广告
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Evaluate evaluate) {
        evaluateService.updateById(evaluate);
        return SUCCESS_TIP;
    }

    /**
     * 广告详情
     */
    @RequestMapping(value = "/detail/{evaluateId}")
    @ResponseBody
    public Object detail(@PathVariable("evaluateId") Integer evaluateId) {
        return evaluateService.selectById(evaluateId);
    }
}
