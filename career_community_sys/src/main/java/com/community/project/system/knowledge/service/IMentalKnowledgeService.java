package com.community.project.system.knowledge.service;

import com.github.pagehelper.PageInfo;
import com.community.project.system.knowledge.domain.MentalKnowledge;

import java.util.List;

/**
 * 职业生涯知识Service接口
 *
 * @author GH
 * @date 2025-01-01
 */
public interface IMentalKnowledgeService
{
    /**
     * 查询职业生涯知识
     *
     * @param mentalKnowledgeId 职业生涯知识主键
     * @return 职业生涯知识
     */
    public MentalKnowledge selectMentalKnowledgeByMentalKnowledgeId(Long mentalKnowledgeId);

    /**
     * 查询职业生涯知识列表
     *
     * @param mentalKnowledge 职业生涯知识
     * @return 职业生涯知识集合
     */
    public List<MentalKnowledge> selectMentalKnowledgeList(MentalKnowledge mentalKnowledge);
    public List<MentalKnowledge> selectMentalKnowledgeListIndext(MentalKnowledge mentalKnowledge);

    /**
     * 新增职业生涯知识
     *
     * @param mentalKnowledge 职业生涯知识
     * @return 结果
     */
    public int insertMentalKnowledge(MentalKnowledge mentalKnowledge);

    /**
     * 修改职业生涯知识
     *
     * @param mentalKnowledge 职业生涯知识
     * @return 结果
     */
    public int updateMentalKnowledge(MentalKnowledge mentalKnowledge);

    /**
     * 批量删除职业生涯知识
     *
     * @param mentalKnowledgeIds 需要删除的职业生涯知识主键集合
     * @return 结果
     */
    public int deleteMentalKnowledgeByMentalKnowledgeIds(String mentalKnowledgeIds);

    /**
     * 删除职业生涯知识信息
     *
     * @param mentalKnowledgeId 职业生涯知识主键
     * @return 结果
     */
    public int deleteMentalKnowledgeByMentalKnowledgeId(Long mentalKnowledgeId);

    /**
     * 校验标题名称是否唯一
     *
     * @param mentalKnowledge 经验分享信息
     * @return 结果
     */
    public String checkMentalKnowledgeTitleUnique(MentalKnowledge mentalKnowledge);



    /**
     * 前台 分页查询文章列表
     * @param page
     * @param count
     * @return
     */
    public PageInfo<MentalKnowledge> selectMentalKnowledgeWithPage(Integer page, Integer count,String mentalKnowledgeTitle);

    public MentalKnowledge selectNext(Long mentalKnowledgeId);

    public MentalKnowledge selectUp(Long mentalKnowledgeId);
}
