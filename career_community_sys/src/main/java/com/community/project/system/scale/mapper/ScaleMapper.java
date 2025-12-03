package com.community.project.system.scale.mapper;

import com.community.project.system.question.domain.ScaleQuestion;
import com.community.project.system.scale.domain.Scale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职业测试量表管理Mapper接口
 *
 * @author GH
 * @date 
 */
public interface ScaleMapper
{
    /**
     * 查询职业测试量表管理
     *
     * @param scaleId 职业测试量表管理主键
     * @return 职业测试量表管理
     */
    public Scale selectScaleByScaleId(Long scaleId);

    /**
     * 查询职业测试量表管理列表
     *
     * @param scale 职业测试量表管理
     * @return 职业测试量表管理集合
     */
    public List<Scale> selectScaleList(Scale scale);

    /**
     * 新增职业测试量表管理
     *
     * @param scale 职业测试量表管理
     * @return 结果
     */
    public int insertScale(Scale scale);

    /**
     * 修改职业测试量表管理
     *
     * @param scale 职业测试量表管理
     * @return 结果
     */
    public int updateScale(Scale scale);

    /**
     * 删除职业测试量表管理
     *
     * @param scaleId 职业测试量表管理主键
     * @return 结果
     */
    public int deleteScaleByScaleId(Long scaleId);

    /**
     * 批量删除职业测试量表管理
     *
     * @param scaleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScaleByScaleIds(String[] scaleIds);

    /**
     * 批量删除测评量表问题信息
     *
     * @param scaleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScaleQuestionByScaleIds(String[] scaleIds);

    /**
     * 批量新增测评量表问题信息
     *
     * @param scaleQuestionList 测评量表问题信息列表
     * @return 结果
     */
    public int batchScaleQuestion(List<ScaleQuestion> scaleQuestionList);


    /**
     * 通过职业测试量表管理主键删除测评量表问题信息信息
     *
     * @param scaleId 职业测试量表管理ID
     * @return 结果
     */
    public int deleteScaleQuestionByScaleId(Long scaleId);

    public int selectQuestionAll(Long scaleId);

    public List<Scale> selectScaleAll();

    public List<Scale> selectScaleWithPage(@Param("scaleTitle") String scaleTitle);

    public Scale startScale(Long scaleId);
}
