package com.community.project.system.knowledge.controller;

import com.community.common.utils.poi.ExcelUtil;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.aspectj.lang.annotation.Log;
import com.community.framework.aspectj.lang.enums.BusinessType;
import com.community.framework.web.controller.BaseController;
import com.community.framework.web.domain.AjaxResult;
import com.community.framework.web.page.TableDataInfo;
import com.community.project.system.comment.service.ICommentService;
import com.community.project.system.knowledge.domain.MentalKnowledge;
import com.community.project.system.knowledge.service.IMentalKnowledgeService;
import com.community.project.system.knowledge_collection.domain.KnowledgeCollection;
import com.community.project.system.knowledge_collection.service.IKnowledgeCollectionService;
import com.community.project.system.role.service.IRoleService;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 职业生涯知识Controller
 *
 * @author GH
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/knowledge")
public class MentalKnowledgeController extends BaseController
{
    private String prefix = "system/knowledge";

    @Autowired
    private IMentalKnowledgeService mentalKnowledgeService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IKnowledgeCollectionService collectionService;
    @Autowired
    private IUserService userService; @Autowired
    private IRoleService roleService;


    @RequiresPermissions("system:knowledge:view")
    @GetMapping()
    public String knowledge(ModelMap mp)
    {
        mp.put("userLoginName",ShiroUtils.getLoginName());
        return prefix + "/knowledge";
    }

    /**
     * 查询职业生涯知识列表
     */
    @RequiresPermissions("system:knowledge:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MentalKnowledge mentalKnowledge)
    {
        startPage();
        // 判断是否是系统管理员 不是就赋予 userId 实现个人发布的
             Long roleId =    userService.selectRoleId();
            if (roleId!= 1   ){
                if (roleId != 2){
                String loginName = ShiroUtils.getLoginName();
                mentalKnowledge.setLoginName(loginName);
                }
            }
        List<MentalKnowledge> list = mentalKnowledgeService.selectMentalKnowledgeList(mentalKnowledge);
        return getDataTable(list);
    }

    // 文章详情查询
    @GetMapping(value = "/mentalKnowledge/{id}")
    public String getArticleById(@PathVariable("id") Long id, HttpServletRequest request,ModelMap mp){
        MentalKnowledge mentalKnowledge = mentalKnowledgeService.selectMentalKnowledgeByMentalKnowledgeId(id);
        User user = ShiroUtils.getSysUser();
        Long userId = user.getUserId();
        KnowledgeCollection collection = collectionService.selectKnowledgeCollectionByUserId(userId,id);
        mp.put("user",user);
        if(mentalKnowledge != null){
            request.setAttribute("mentalKnowledge",mentalKnowledge);
            if (collection != null){
            request.setAttribute("collection",collection);}
            System.out.println("collection:::"+collection);
            return "foreground/client/mentalKnowledgeDetails";
        }else {
            logger.warn("查询文章详情结果为空，查询文章id: "+id);
            // 未找到对应文章页面，跳转到提示页
            return "foreground/comm/error_404";
        }
    }

    /**
     * 导出职业生涯知识列表
     */
    @RequiresPermissions("system:knowledge:export")
    @Log(title = "职业生涯知识", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MentalKnowledge mentalKnowledge)
    {
        List<MentalKnowledge> list = mentalKnowledgeService.selectMentalKnowledgeList(mentalKnowledge);
        ExcelUtil<MentalKnowledge> util = new ExcelUtil<MentalKnowledge>(MentalKnowledge.class);
        return util.exportExcel(list, "职业生涯知识数据");
    }

    /**
     * 新增职业生涯知识
     */
    @GetMapping("/add")
    public String add( )
    {
        return prefix + "/add";
    }

    /**
     * 新增保存职业生涯知识
     */
    @RequiresPermissions("system:knowledge:add")
    @Log(title = "职业生涯知识", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MentalKnowledge mentalKnowledge)
    {
        String loginName = ShiroUtils.getLoginName();
        mentalKnowledge.setLoginName(loginName);
        return toAjax(mentalKnowledgeService.insertMentalKnowledge(mentalKnowledge));
    }

    /**
     * 修改职业生涯知识
     */
    @GetMapping("/edit/{mentalKnowledgeId}")
    public String edit(@PathVariable("mentalKnowledgeId") Long mentalKnowledgeId, ModelMap mmap)
    {
        MentalKnowledge mentalKnowledge = mentalKnowledgeService.selectMentalKnowledgeByMentalKnowledgeId(mentalKnowledgeId);
        mmap.put("mentalKnowledge", mentalKnowledge);
        return prefix + "/edit";
    }

    /**
     * 修改保存职业生涯知识
     */
    @RequiresPermissions("system:knowledge:edit")
    @Log(title = "职业生涯知识", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MentalKnowledge mentalKnowledge)
    {
        return toAjax(mentalKnowledgeService.updateMentalKnowledge(mentalKnowledge));
    }

    /**
     * 删除职业生涯知识
     */
    @RequiresPermissions("system:knowledge:remove")
    @Log(title = "职业生涯知识", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mentalKnowledgeService.deleteMentalKnowledgeByMentalKnowledgeIds(ids));
    }

    /**
     * 校验知识标题名称
     */
    @PostMapping("/checkMentalKnowledgeTitleUnique")
    @ResponseBody
    public String checkMentalKnowledgeTitleUnique(MentalKnowledge mentalKnowledge)
    {
        return mentalKnowledgeService.checkMentalKnowledgeTitleUnique(mentalKnowledge);
    }




}
