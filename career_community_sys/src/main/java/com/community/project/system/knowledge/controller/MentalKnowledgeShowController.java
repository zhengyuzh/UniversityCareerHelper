package com.community.project.system.knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.web.controller.BaseController;
import com.community.project.system.knowledge.domain.MentalKnowledge;
import com.community.project.system.knowledge.service.IMentalKnowledgeService;
import com.community.project.system.user.domain.User;
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
 * 职业生涯知识Controller
 *
 * @author GH
 * @date 2025-01-01
 */
@Controller
public class MentalKnowledgeShowController extends BaseController
{
    @Autowired
    private IMentalKnowledgeService mentalKnowledgeService;
    /**
     *  去经验分享展示页面
     */
    @RequestMapping(value ="/system/knowledge/toKnowledgePage")
    private String ShowMentalKnowledge(HttpServletRequest request,ModelMap mp,String mentalKnowledgeTitle ) {
        User user = ShiroUtils.getSysUser();
        mp.put("user",user);
        return this.ShowMentalKnowledge(request, 1, 5,mp,mentalKnowledgeTitle);
    }
    @GetMapping(value = "/pageMentalKnowledge/{p}")
    public String ShowMentalKnowledge(HttpServletRequest request, @PathVariable("p") int page,
                                      @RequestParam(value = "count", defaultValue = "5") int count,ModelMap modelMap,String mentalKnowledgeTitle) {
        PageInfo<MentalKnowledge> mentalKnowledges = mentalKnowledgeService.selectMentalKnowledgeWithPage(page, count,mentalKnowledgeTitle);
        List<MentalKnowledge> mentalKnowledgeList = mentalKnowledgeService.selectMentalKnowledgeList(null);
        User user1 = ShiroUtils.getSysUser();
        modelMap.put("user",user1);
        request.setAttribute("mentalKnowledges", mentalKnowledges);
        request.setAttribute("mentalKnowledgeTitle", mentalKnowledgeTitle);
        request.setAttribute("mentalKnowledgeList", mentalKnowledgeList);
        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "foreground/client/show_knowledge";
    }



}
