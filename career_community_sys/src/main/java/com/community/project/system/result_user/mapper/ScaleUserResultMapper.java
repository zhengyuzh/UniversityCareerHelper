package com.community.project.system.result_user.mapper;

import java.util.List;
import com.community.project.system.result_user.domain.ScaleUserResult;

/**
 * 报告信息Mapper接口
 * 
 * @author GH
 * @date 
 */
public interface ScaleUserResultMapper 
{
    /**
     * 查询报告信息
     * 
     * @param resultId 报告信息主键
     * @return 报告信息
     */
    public ScaleUserResult selectScaleUserResultByResultId(Long resultId);

    /**
     * 查询报告信息列表
     * 
     * @param scaleUserResult 报告信息
     * @return 报告信息集合
     */
    public List<ScaleUserResult> selectScaleUserResultList(ScaleUserResult scaleUserResult);

    /**
     * 新增报告信息
     * 
     * @param scaleUserResult 报告信息
     * @return 结果
     */
    public int insertScaleUserResult(ScaleUserResult scaleUserResult);

    /**
     * 修改报告信息
     * 
     * @param scaleUserResult 报告信息
     * @return 结果
     */
    public int updateScaleUserResult(ScaleUserResult scaleUserResult);

    /**
     * 删除报告信息
     * 
     * @param resultId 报告信息主键
     * @return 结果
     */
    public int deleteScaleUserResultByResultId(Long resultId);

    /**
     * 批量删除报告信息
     * 
     * @param resultIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScaleUserResultByResultIds(String[] resultIds);
}
