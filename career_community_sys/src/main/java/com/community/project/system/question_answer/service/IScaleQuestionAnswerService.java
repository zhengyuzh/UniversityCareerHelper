package com.community.project.system.question_answer.service;

import java.util.List;
import com.community.project.system.question_answer.domain.ScaleQuestionAnswer;

/**
 * 职业测评选项Service接口
 * 
 * @author GH
 * @date 
 */
public interface IScaleQuestionAnswerService 
{
    /**
     * 查询职业测评选项
     * 
     * @param questionId 职业测评选项主键
     * @return 职业测评选项
     */
    public ScaleQuestionAnswer selectScaleQuestionAnswerByQuestionId(Long questionId);

    /**
     * 查询职业测评选项列表
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 职业测评选项集合
     */
    public List<ScaleQuestionAnswer> selectScaleQuestionAnswerList(ScaleQuestionAnswer scaleQuestionAnswer);

    /**
     * 新增职业测评选项
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 结果
     */
    public int insertScaleQuestionAnswer(ScaleQuestionAnswer scaleQuestionAnswer);

    /**
     * 修改职业测评选项
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 结果
     */
    public int updateScaleQuestionAnswer(ScaleQuestionAnswer scaleQuestionAnswer);

    /**
     * 批量删除职业测评选项
     * 
     * @param questionIds 需要删除的职业测评选项主键集合
     * @return 结果
     */
    public int deleteScaleQuestionAnswerByQuestionIds(String questionIds);

    /**
     * 删除职业测评选项信息
     * 
     * @param questionId 职业测评选项主键
     * @return 结果
     */
    public int deleteScaleQuestionAnswerByQuestionId(Long questionId);
}
