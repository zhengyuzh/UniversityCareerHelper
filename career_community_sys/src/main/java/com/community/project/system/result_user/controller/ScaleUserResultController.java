package com.community.project.system.result_user.controller;

import com.community.common.utils.StringUtils;
import com.community.common.utils.poi.ExcelUtil;
import com.community.common.utils.text.Convert;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
import com.community.project.system.result_user.domain.ScaleUserResult;
import com.community.project.system.result_user.service.IScaleUserResultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 报告信息Controller
 * 
 * @author GH
 * @date 
 */
@Controller
@RequestMapping("/system/result_user")
public class ScaleUserResultController extends BaseController
{
    private String prefix = "system/result_user";

    @Autowired
    private IScaleUserResultService scaleUserResultService;

    @RequiresPermissions("system:result_user:view")
    @GetMapping()
    public String result_user()
    {
        return prefix + "/result_user";
    }

    /**
     * 查询报告信息列表
     */
    @RequiresPermissions("system:result_user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ScaleUserResult scaleUserResult)
    {
        startPage();
        List<ScaleUserResult> list = scaleUserResultService.selectScaleUserResultList(scaleUserResult);
        return getDataTable(list);
    }

    /**
     * 导出报告信息列表
     */
    @RequiresPermissions("system:result_user:export")
    @Log(title = "报告信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScaleUserResult scaleUserResult)
    {
        List<ScaleUserResult> list = scaleUserResultService.selectScaleUserResultList(scaleUserResult);
        ExcelUtil<ScaleUserResult> util = new ExcelUtil<ScaleUserResult>(ScaleUserResult.class);
        return util.exportExcel(list, "报告信息数据");
    }


    /**
     * 选择  导出数据
     */
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportSelected(ScaleUserResult scaleUserResultModel, String resultIds) {
        List<ScaleUserResult> scaleUserResults = scaleUserResultService.selectScaleUserResultList(scaleUserResultModel);
        List<ScaleUserResult> scaleUserResultList = new ArrayList<ScaleUserResult>(Arrays.asList(new ScaleUserResult[scaleUserResults.size()]));
        Collections.copy(scaleUserResultList, scaleUserResults);

        // 条件过滤
        if (StringUtils.isNotEmpty(resultIds)) {
            scaleUserResultList.clear();
            for (Long resultId : Convert.toLongArray(resultIds)) {
                for (ScaleUserResult scaleUserResult : scaleUserResults) {
                    if (scaleUserResult.getResultId() == resultId) {
                        scaleUserResultList.add(scaleUserResult);
                    }
                }
            }
        }
        ExcelUtil<ScaleUserResult> util = new ExcelUtil<ScaleUserResult>(ScaleUserResult.class);
        return util.exportExcel(scaleUserResultList, "结果报告数据");
    }


    /**
     * 新增报告信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报告信息
     */
    @RequiresPermissions("system:result_user:add")
    @Log(title = "报告信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ScaleUserResult scaleUserResult)
    {
        return toAjax(scaleUserResultService.insertScaleUserResult(scaleUserResult));
    }

    /**
     * 修改报告信息
     */
    @GetMapping("/edit/{resultId}")
    public String edit(@PathVariable("resultId") Long resultId, ModelMap mmap)
    {
        ScaleUserResult scaleUserResult = scaleUserResultService.selectScaleUserResultByResultId(resultId);
        mmap.put("scaleUserResult", scaleUserResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存报告信息
     */
    @RequiresPermissions("system:result_user:edit")
    @Log(title = "报告信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ScaleUserResult scaleUserResult)
    {
        return toAjax(scaleUserResultService.updateScaleUserResult(scaleUserResult));
    }

    /**
     * 删除报告信息
     */
    @RequiresPermissions("system:result_user:remove")
    @Log(title = "报告信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(scaleUserResultService.deleteScaleUserResultByResultIds(ids));
    }
}
