package com.community.project.system.company.mapper;

import java.util.List;

import com.community.project.system.reportStatic.vo.DataScaleType;
import com.github.pagehelper.PageInfo;
import com.community.project.system.company.domain.Company;

/**
 * 【企业招聘功能模块】Mapper接口
 * 
 * @author author
 * @date 2025-01-09
 */
public interface CompanyMapper 
{
    /**
     * 查询【企业招聘功能模块】
     * 
     * @param id 【企业招聘功能模块】主键
     * @return 【企业招聘功能模块】
     */
    public Company selectCompanyById(Long id);

    /**
     * 查询【企业招聘功能模块】列表
     * 
     * @param company 【企业招聘功能模块】
     * @return 【企业招聘功能模块】集合
     */
    public List<Company> selectCompanyList(Company company);

    /**
     * 新增【企业招聘功能模块】
     * 
     * @param company 【企业招聘功能模块】
     * @return 结果
     */
    public int insertCompany(Company company);

    /**
     * 修改【企业招聘功能模块】
     * 
     * @param company 【企业招聘功能模块】
     * @return 结果
     */
    public int updateCompany(Company company);

    /**
     * 删除【企业招聘功能模块】
     * 
     * @param id 【企业招聘功能模块】主键
     * @return 结果
     */
    public int deleteCompanyById(Long id);

    /**
     * 批量删除【企业招聘功能模块】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyByIds(String[] ids);

    List<Company> selectCompanyWithPage(String musicTitle);

    List<DataScaleType> selectDataScaleType();
}
