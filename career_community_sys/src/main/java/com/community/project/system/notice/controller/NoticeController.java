package com.community.project.system.notice.controller;

import com.community.common.utils.StringUtils;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
import com.community.project.system.company.domain.Company;
import com.community.project.system.notice.domain.Notice;
import com.community.project.system.notice.service.INoticeService;
import com.community.project.system.role.domain.Role;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 求职信息 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/notice")
public class NoticeController extends BaseController
{
    private String prefix = "system/notice";

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("system:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询求职信息列表
     */
    @RequiresPermissions("system:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Notice notice)
    {
        Long userId = ShiroUtils.getUserId();
        User user = userService.selectUserById(userId);
        List<Role> roleList = user.getRoles();
        Role role = roleList.get(0);
        startPage();
        List<Notice> list = new ArrayList<>();
        if(StringUtils.isNotNull(role.getRoleId())&& role.isAdmin()){
            //管理员
            list = noticeService.selectNoticeList(notice);
        }else{
            //普通用户
            notice.setUserId(userId);
            list = noticeService.selectNoticeList(notice);
        }

        return getDataTable(list);
    }

    /**
     * 新增求职信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存求职信息
     */
    @RequiresPermissions("system:notice:add")
    @Log(title = "通知求职信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Notice notice)
    {
        Long userId = ShiroUtils.getUserId();
        notice.setUserId(userId);
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改求职信息
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("notice", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存求职信息
     */
    @RequiresPermissions("system:notice:edit")
    @Log(title = "通知求职信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Notice notice)
    {
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除求职信息
     */
    @RequiresPermissions("system:notice:remove")
    @Log(title = "通知求职信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }

    @RequestMapping("/noticeDetails/{noticeId}")
    public String noticeDetails(@PathVariable("noticeId") Long noticeId,ModelMap modelMap){
        User user = ShiroUtils.getSysUser();
        Notice notice = noticeService.selectNoticeById(noticeId);
        modelMap.put("notice",notice);
        modelMap.put("user",user);
        return "foreground/client/noticeDetails";
    }

    /**
     *  去活跃用户展示页面
     */
    @RequestMapping(value ="/toNotice")
    private String ShowCompany(HttpServletRequest request, ModelMap mp) {
        User user = ShiroUtils.getSysUser();
        mp.put("user",user);
        return this.ShowNotice(request, 1, 5,mp);

    }

    @GetMapping(value = "/pageNotice/{p}")
    public String ShowNotice(HttpServletRequest request, @PathVariable("p") int page,
                              @RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap) {
        PageInfo<Notice> noticePageInfo = noticeService.selectNoticeWithPage(page, count);
        List<Notice> noticeList = noticeService.selectNoticeList(new Notice());
        User user1 = ShiroUtils.getSysUser();
        modelMap.put("user",user1);
        request.setAttribute("notices", noticePageInfo);
        request.setAttribute("noticeList", noticeList);
        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "foreground/client/show_notice";
    }

    // 职位查询
    @GetMapping(value = "/detailNotice/{noticeId}")
    public String getNoticeById(@PathVariable("noticeId") Long noticeId, HttpServletRequest request, ModelMap mp) {

        User user1 = ShiroUtils.getSysUser();
        mp.put("user", user1);
        Notice notice = noticeService.selectNoticeById(noticeId);

        if (notice != null) {
            //返回求职信息
            request.setAttribute("notice", notice);
            return "foreground/client/noticeDetails";
        } else {
            logger.warn("查询求职详情结果为空，查询id: " + noticeId);
            // 未找到对应求职页面，跳转到提示页
            return "foreground/comm/deleteOk";
        }
    }

}
