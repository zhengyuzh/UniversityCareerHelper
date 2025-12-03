package com.community.project.system.question_answer.controller;

import com.community.common.utils.poi.ExcelUtil;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
import com.community.project.system.question_answer.domain.ScaleQuestionAnswer;
import com.community.project.system.question_answer.service.IScaleQuestionAnswerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 职业测评选项Controller
 * 
 * @author GH
 * @date 
 */
@Controller
@RequestMapping("/system/question_answer")
public class ScaleQuestionAnswerController extends BaseController
{
    private String prefix = "system/question_answer";

    @Autowired
    private IScaleQuestionAnswerService scaleQuestionAnswerService;

    @RequiresPermissions("system:question_answer:view")
    @GetMapping()
    public String question_answer()
    {
        return prefix + "/question_answer";
    }

    /**
     * 查询职业测评选项列表
     */
    @RequiresPermissions("system:question_answer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        startPage();
        List<ScaleQuestionAnswer> list = scaleQuestionAnswerService.selectScaleQuestionAnswerList(scaleQuestionAnswer);
        return getDataTable(list);
    }

    /**
     * 导出职业测评选项列表
     */
    @RequiresPermissions("system:question_answer:export")
    @Log(title = "职业测评选项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        List<ScaleQuestionAnswer> list = scaleQuestionAnswerService.selectScaleQuestionAnswerList(scaleQuestionAnswer);
        ExcelUtil<ScaleQuestionAnswer> util = new ExcelUtil<ScaleQuestionAnswer>(ScaleQuestionAnswer.class);
        return util.exportExcel(list, "职业测评选项数据");
    }

    /**
     * 新增职业测评选项
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存职业测评选项
     */
    @RequiresPermissions("system:question_answer:add")
    @Log(title = "职业测评选项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        return toAjax(scaleQuestionAnswerService.insertScaleQuestionAnswer(scaleQuestionAnswer));
    }

    /**
     * 修改职业测评选项
     */
    @GetMapping("/edit/{questionId}")
    public String edit(@PathVariable("questionId") Long questionId, ModelMap mmap)
    {
        ScaleQuestionAnswer scaleQuestionAnswer = scaleQuestionAnswerService.selectScaleQuestionAnswerByQuestionId(questionId);
        mmap.put("scaleQuestionAnswer", scaleQuestionAnswer);
        return prefix + "/edit";
    }

    /**
     * 修改保存职业测评选项
     */
    @RequiresPermissions("system:question_answer:edit")
    @Log(title = "职业测评选项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        return toAjax(scaleQuestionAnswerService.updateScaleQuestionAnswer(scaleQuestionAnswer));
    }

    /**
     * 删除职业测评选项
     */
    @RequiresPermissions("system:question_answer:remove")
    @Log(title = "职业测评选项", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(scaleQuestionAnswerService.deleteScaleQuestionAnswerByQuestionIds(ids));
    }
}
