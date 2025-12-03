package com.community.project.system.scale.service;

import com.community.project.system.reportStatic.vo.DataScaleType;
import com.github.pagehelper.PageInfo;
import com.community.project.system.scale.domain.Scale;

import java.util.List;

/**
 * 职业测试量表管理Service接口
 * 
 * @author GH
 * @date 2025-01-01
 */
public interface IScaleService 
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
     * 查询职业测试量表管理
     *
     *
     * @return 职业测试量表管理集合
     */
    public List<Scale> selectScaleAll();

    public PageInfo<Scale> selectScaleWithPage(Integer page, Integer count,String scaleTitle);

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
     * 批量删除职业测试量表管理
     * 
     * @param scaleIds 需要删除的职业测试量表管理主键集合
     * @return 结果
     */
    public int deleteScaleByScaleIds(String scaleIds);

    /**
     * 删除职业测试量表管理信息
     * 
     * @param scaleId 职业测试量表管理主键
     * @return 结果
     */
    public int deleteScaleByScaleId(Long scaleId);

    /**
     * 查询问题总数
     * @param scaleId
     * @return
     */
    public int selectQuestionAll(Long scaleId);

    public Scale startScale(Long scaleId);

    /**
     * 查询测评表分类--每个企业招聘 发布的求职类型个数
     *
     * @param
     * @retur 个数
     */
    List<DataScaleType> selectDataScaleType();
}
