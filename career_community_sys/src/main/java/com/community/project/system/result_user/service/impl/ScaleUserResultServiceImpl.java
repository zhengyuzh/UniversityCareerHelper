package com.community.project.system.result_user.service.impl;

import com.community.common.utils.DateUtils;
import com.community.common.utils.text.Convert;
import com.community.project.system.result_user.domain.ScaleUserResult;
import com.community.project.system.result_user.mapper.ScaleUserResultMapper;
import com.community.project.system.result_user.service.IScaleUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报告信息Service业务层处理
 * 
 * @author GH
 * @date 
 */
@Service
public class ScaleUserResultServiceImpl implements IScaleUserResultService
{
    @Autowired
    private ScaleUserResultMapper scaleUserResultMapper;

    /**
     * 查询报告信息
     * 
     * @param resultId 报告信息主键
     * @return 报告信息
     */
    @Override
    public ScaleUserResult selectScaleUserResultByResultId(Long resultId)
    {
        return scaleUserResultMapper.selectScaleUserResultByResultId(resultId);
    }

    /**
     * 查询报告信息列表
     * 
     * @param scaleUserResult 报告信息
     * @return 报告信息
     */
    @Override
    public List<ScaleUserResult> selectScaleUserResultList(ScaleUserResult scaleUserResult)
    {
        return scaleUserResultMapper.selectScaleUserResultList(scaleUserResult);
    }

    /**
     * 新增报告信息
     * 
     * @param scaleUserResult 报告信息
     * @return 结果
     */
    @Override
    public int insertScaleUserResult(ScaleUserResult scaleUserResult)
    {
        scaleUserResult.setCreateTime(DateUtils.getNowDate());
        return scaleUserResultMapper.insertScaleUserResult(scaleUserResult);
    }

    /**
     * 修改报告信息
     * 
     * @param scaleUserResult 报告信息
     * @return 结果
     */
    @Override
    public int updateScaleUserResult(ScaleUserResult scaleUserResult)
    {
        scaleUserResult.setUpdateTime(DateUtils.getNowDate());
        return scaleUserResultMapper.updateScaleUserResult(scaleUserResult);
    }

    /**
     * 批量删除报告信息
     * 
     * @param resultIds 需要删除的报告信息主键
     * @return 结果
     */
    @Override
    public int deleteScaleUserResultByResultIds(String resultIds)
    {
        return scaleUserResultMapper.deleteScaleUserResultByResultIds(Convert.toStrArray(resultIds));
    }

    /**
     * 删除报告信息信息
     * 
     * @param resultId 报告信息主键
     * @return 结果
     */
    @Override
    public int deleteScaleUserResultByResultId(Long resultId)
    {
        return scaleUserResultMapper.deleteScaleUserResultByResultId(resultId);
    }
}
