package com.community.project.system.notice.controller;

import com.community.common.utils.StringUtils;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
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
public class NoticeShowController extends BaseController
{

    @Autowired
    private INoticeService noticeService;


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

}
