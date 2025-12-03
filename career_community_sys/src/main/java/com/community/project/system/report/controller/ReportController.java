package com.community.project.system.report.controller;

import com.community.common.utils.poi.ExcelUtil;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
import com.community.project.system.posts.domain.Posts;
import com.community.project.system.posts.service.IPostsService;
import com.community.project.system.report.domain.Report;
import com.community.project.system.report.service.IReportService;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 举报信息Controller
 * 
 * @author GH
 * @date 
 */
@Controller
@RequestMapping("/system/report")
public class ReportController extends BaseController
{
    private String prefix = "system/report";

    @Autowired
    private IReportService reportService;
    @Autowired
    private IPostsService postsService;
   @Autowired
    private IUserService userService;

    @RequiresPermissions("system:report:view")
    @GetMapping()
    public String report()
    {
        return prefix + "/report";
    }

    /**
     * 查询举报信息列表
     */
    @RequiresPermissions("system:report:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Report report)
    {
        startPage();
        List<Report> list = reportService.selectReportList(report);
        return getDataTable(list);
    }

    /**
     * 导出举报信息列表
     */
    @RequiresPermissions("system:report:export")
    @Log(title = "举报信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Report report)
    {
        List<Report> list = reportService.selectReportList(report);
        ExcelUtil<Report> util = new ExcelUtil<Report>(Report.class);
        return util.exportExcel(list, "举报信息数据");
    }

    /**
     * 新增举报信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存举报信息
     */
    @RequiresPermissions("system:report:add")
    @Log(title = "举报信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Report report)
    {
        return toAjax(reportService.insertReport(report));
    }

    /**
     * 新增举报信息
     */
    @GetMapping("/addReport/{postsId}")
    public String addReport(@PathVariable("postsId") Long postsId,ModelMap modelMap)
    {
        User user = userService.selectUserById(ShiroUtils.getUserId());
        Posts posts = postsService.selectPostsByPostsId(postsId);
        modelMap.put("user",user);
        modelMap.put("posts",posts);
        return prefix + "/addReport";
    }


    /**
     * 新增保存举报信息
     */
    @RequiresPermissions("system:user_report:add")
    @Log(title = "举报信息", businessType = BusinessType.INSERT)
    @PostMapping("/addReport")
    @ResponseBody
    public AjaxResult addSaveReport(Report report)
    {
        return toAjax(reportService.insertReport(report));
    }

    /**
     * 修改举报信息
     */
    @GetMapping("/edit/{reportId}")
    public String edit(@PathVariable("reportId") Long reportId, ModelMap mmap)
    {
        Report report = reportService.selectReportByReportId(reportId);
        Posts posts = postsService.selectPostsByPostsId(report.getPostsId());
        mmap.put("report", report);
        mmap.put("posts", posts);
        return prefix + "/edit";
    }

    /**
     * 修改保存举报信息
     */
    @RequiresPermissions("system:report:edit")
    @Log(title = "举报信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Report report)
    {
        return toAjax(reportService.updateReport(report));
    }

    /**
     * 删除举报信息
     */
    @RequiresPermissions("system:report:remove")
    @Log(title = "举报信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(reportService.deleteReportByReportIds(ids));
    }
}
