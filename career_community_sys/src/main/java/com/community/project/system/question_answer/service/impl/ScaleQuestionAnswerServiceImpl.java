package com.community.project.system.question_answer.service.impl;

import com.community.common.utils.DateUtils;
import com.community.common.utils.text.Convert;
import com.community.project.system.question_answer.domain.ScaleQuestionAnswer;
import com.community.project.system.question_answer.mapper.ScaleQuestionAnswerMapper;
import com.community.project.system.question_answer.service.IScaleQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职业测评选项Service业务层处理
 * 
 * @author GH
 * @date 
 */
@Service
public class ScaleQuestionAnswerServiceImpl implements IScaleQuestionAnswerService 
{
    @Autowired
    private ScaleQuestionAnswerMapper scaleQuestionAnswerMapper;

    /**
     * 查询职业测评选项
     * 
     * @param questionId 职业测评选项主键
     * @return 职业测评选项
     */
    @Override
    public ScaleQuestionAnswer selectScaleQuestionAnswerByQuestionId(Long questionId)
    {
        return scaleQuestionAnswerMapper.selectScaleQuestionAnswerByQuestionId(questionId);
    }

    /**
     * 查询职业测评选项列表
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 职业测评选项
     */
    @Override
    public List<ScaleQuestionAnswer> selectScaleQuestionAnswerList(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        return scaleQuestionAnswerMapper.selectScaleQuestionAnswerList(scaleQuestionAnswer);
    }

    /**
     * 新增职业测评选项
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 结果
     */
    @Override
    public int insertScaleQuestionAnswer(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        scaleQuestionAnswer.setCreateTime(DateUtils.getNowDate());
        return scaleQuestionAnswerMapper.insertScaleQuestionAnswer(scaleQuestionAnswer);
    }

    /**
     * 修改职业测评选项
     * 
     * @param scaleQuestionAnswer 职业测评选项
     * @return 结果
     */
    @Override
    public int updateScaleQuestionAnswer(ScaleQuestionAnswer scaleQuestionAnswer)
    {
        scaleQuestionAnswer.setUpdateTime(DateUtils.getNowDate());
        return scaleQuestionAnswerMapper.updateScaleQuestionAnswer(scaleQuestionAnswer);
    }

    /**
     * 批量删除职业测评选项
     * 
     * @param questionIds 需要删除的职业测评选项主键
     * @return 结果
     */
    @Override
    public int deleteScaleQuestionAnswerByQuestionIds(String questionIds)
    {
        return scaleQuestionAnswerMapper.deleteScaleQuestionAnswerByQuestionIds(Convert.toStrArray(questionIds));
    }

    /**
     * 删除职业测评选项信息
     * 
     * @param questionId 职业测评选项主键
     * @return 结果
     */
    @Override
    public int deleteScaleQuestionAnswerByQuestionId(Long questionId)
    {
        return scaleQuestionAnswerMapper.deleteScaleQuestionAnswerByQuestionId(questionId);
    }
}
