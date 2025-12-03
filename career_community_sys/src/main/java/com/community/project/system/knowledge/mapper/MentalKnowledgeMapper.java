package com.community.project.system.knowledge.mapper;

import com.community.project.system.knowledge.domain.MentalKnowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 职业生涯知识Mapper接口
 *
 * @author GH
 * @date 2025-01-01
 */
@Mapper
public interface MentalKnowledgeMapper
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
     * 删除职业生涯知识
     *
     * @param mentalKnowledgeId 职业生涯知识主键
     * @return 结果
     */
    public int deleteMentalKnowledgeByMentalKnowledgeId(Long mentalKnowledgeId);

    /**
     * 批量删除职业生涯知识
     *
     * @param mentalKnowledgeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMentalKnowledgeByMentalKnowledgeIds(String[] mentalKnowledgeIds);

    /**
     * 校验标题名称是否唯一
     *
     * @param mentalKnowledgeTitle 标题名称
     * @return 结果
     */
    public MentalKnowledge checkMentalKnowledgeTitleUnique(String mentalKnowledgeTitle);

    // 文章发分页查询
    public List<MentalKnowledge> selectMentalKnowledgeWithPage(String mentalKnowledgeTitle);

    /**
     * 下一篇
     * @param mental_knowledge_id
     * @return
     */
    @Select("select * FROM sys_mental_knowledge where   mental_knowledge_id >  #{mentalKnowledgeId} order by mental_knowledge_id asc limit 1")
    public MentalKnowledge selectNext(@Param("mentalKnowledgeId")  Long mentalKnowledgeId);

    /**
     * 上一篇
     * @param mental_knowledge_id
     * @return
     */
    @Select("select * FROM sys_mental_knowledge where   mental_knowledge_id <  #{mentalKnowledgeId} order by mental_knowledge_id desc limit 1")
    public MentalKnowledge selectUp(@Param("mentalKnowledgeId")  Long mentalKnowledgeId);
}
