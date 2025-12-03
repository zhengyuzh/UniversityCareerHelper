package com.community.project.system.company.controller;

import com.github.pagehelper.PageInfo;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.web.controller.BaseController;
import com.community.project.system.company.domain.Company;
import com.community.project.system.company.service.ICompanyService;
import com.community.project.system.knowledge.service.IMentalKnowledgeService;
import com.community.project.system.music.domain.Music;
import com.community.project.system.music.service.IMusicService;
import com.community.project.system.posts.domain.Posts;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author author
 * @version 1.0
 * @data 2025-01-09 19:38
 * @Description:
 */
@Controller
public class CompanyShowController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICompanyService iCompanyService;

    /**
     *  去活跃用户展示页面
     */
    @RequestMapping(value ="/system/Company/toCompany")
    private String ShowCompany(HttpServletRequest request, ModelMap mp, String job ) {
        User user = ShiroUtils.getSysUser();
        mp.put("user",user);
        return this.ShowCompany(request, 1, 5,mp,job);

    }
    @GetMapping(value = "/pageCompany/{p}")
    public String ShowCompany(HttpServletRequest request, @PathVariable("p") int page,
                                      @RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap, String job) {
        PageInfo<Company> companyPageInfo = iCompanyService.selectCompanyWithPage(page, count,job);
        List<Company> companyList = iCompanyService.selectCompanyList(null);
        User user1 = ShiroUtils.getSysUser();
        modelMap.put("user",user1);
        request.setAttribute("companys", companyPageInfo);
        request.setAttribute("mentalKnowledgeTitle", job);
        request.setAttribute("companyList", companyList);
        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "foreground/client/show_company";
    }


    // 职位查询
    @GetMapping(value = "/detailCompany/{companyId}")
    public String getCompanyById(@PathVariable("companyId") Long companyId, HttpServletRequest request, ModelMap mp) {

        User user1 = ShiroUtils.getSysUser();
        mp.put("user", user1);
        Company company = iCompanyService.selectCompanyById(companyId);

        if (company != null) {
            //返回岗位信息

            request.setAttribute("company", company);
            return "foreground/client/companyDetails";
        } else {
            logger.warn("查询岗位详情结果为空，查询文岗位id: " + companyId);
            // 未找到对应岗位页面，跳转到提示页
            return "foreground/comm/deleteOk";
        }
    }


}
