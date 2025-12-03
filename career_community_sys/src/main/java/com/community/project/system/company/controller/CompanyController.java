package com.community.project.system.company.controller;

import java.util.ArrayList;
import java.util.List;

import com.community.common.utils.StringUtils;
import com.community.common.utils.security.ShiroUtils;
import com.community.project.system.notice.domain.Notice;
import com.community.project.system.role.domain.Role;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.project.system.company.domain.Company;
import com.community.project.system.company.service.ICompanyService;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.common.utils.poi.ExcelUtil;
import com.community.framework.web.page.TableDataInfo;

/**
 * 【企业招聘功能模块】Controller
 * 
 * @author author
 * @date 2025-01-09
 */
@Controller
@RequestMapping("/system/company")
public class CompanyController extends BaseController
{
    private String prefix = "system/company";

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("system:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询【公司岗位信息】列表
     */
    @RequiresPermissions("system:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Company company)
    {

        Long userId = ShiroUtils.getUserId();
        String userName = ShiroUtils.getLoginName();
        User user = userService.selectUserById(userId);
        List<Role> roleList = user.getRoles();
        Role role = roleList.get(0);
        startPage();
        List<Company> list = new ArrayList<>();
        if(StringUtils.isNotNull(role.getRoleId())&& role.isAdmin()){
            //管理员
            list = companyService.selectCompanyList(company);
        }else{
            //普通用户
            company.setUserId(userId);
            company.setUserName(userName);
            list = companyService.selectCompanyList(company);
        }
        return getDataTable(list);
    }

    /**
     * 导出【公司岗位信息】列表
     */
    @RequiresPermissions("system:company:export")
    @Log(title = "【企业招聘功能模块】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
        List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "【企业招聘功能模块】数据");
    }

    /**
     * 新增【公司岗位信息】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【公司岗位信息】
     */
    @RequiresPermissions("system:company:add")
    @Log(title = "【公司岗位信息】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Company company)
    {
        Long userId = ShiroUtils.getUserId();
        String userName = ShiroUtils.getLoginName();
        company.setUserName(userName);
        company.setUserId(userId);
        return toAjax(companyService.insertCompany(company));
    }

    /**
     * 修改【公司岗位信息】
     */
    @RequiresPermissions("system:company:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Company company = companyService.selectCompanyById(id);
        mmap.put("company", company);
        return prefix + "/edit";
    }

    /**
     * 修改保存【公司岗位信息】
     */
    @RequiresPermissions("system:company:edit")
    @Log(title = "【公司岗位信息】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Company company)
    {
        return toAjax(companyService.updateCompany(company));
    }

    /**
     * 删除【公司岗位信息】
     */
    @RequiresPermissions("system:company:remove")
    @Log(title = "【公司岗位信息】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyService.deleteCompanyByIds(ids));
    }
}
