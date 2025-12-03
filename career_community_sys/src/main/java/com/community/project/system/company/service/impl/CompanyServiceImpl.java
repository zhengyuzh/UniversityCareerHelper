package com.community.project.system.company.service.impl;

import java.util.List;

import com.community.project.system.reportStatic.vo.DataScaleType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.community.project.system.music.domain.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.community.project.system.company.mapper.CompanyMapper;
import com.community.project.system.company.domain.Company;
import com.community.project.system.company.service.ICompanyService;
import com.community.common.utils.text.Convert;

/**
 * 【企业招聘功能模块】Service业务层处理
 * 
 * @author author
 * @date 2025-01-09
 */
@Service
public class CompanyServiceImpl implements ICompanyService 
{
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询【企业招聘功能模块】
     * 
     * @param id 【企业招聘功能模块】主键
     * @return 【企业招聘功能模块】
     */
    @Override
    public Company selectCompanyById(Long id)
    {
        return companyMapper.selectCompanyById(id);
    }

    /**
     * 查询【企业招聘功能模块】列表
     * 
     * @param company 【企业招聘功能模块】
     * @return 【企业招聘功能模块】
     */
    @Override
    public List<Company> selectCompanyList(Company company)
    {
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 新增【企业招聘功能模块】
     * 
     * @param company 【企业招聘功能模块】
     * @return 结果
     */
    @Override
    public int insertCompany(Company company)
    {
        return companyMapper.insertCompany(company);
    }

    /**
     * 修改【企业招聘功能模块】
     * 
     * @param company 【企业招聘功能模块】
     * @return 结果
     */
    @Override
    public int updateCompany(Company company)
    {
        return companyMapper.updateCompany(company);
    }

    /**
     * 批量删除【企业招聘功能模块】
     * 
     * @param ids 需要删除的【企业招聘功能模块】主键
     * @return 结果
     */
    @Override
    public int deleteCompanyByIds(String ids)
    {
        return companyMapper.deleteCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【企业招聘功能模块】信息
     * 
     * @param id 【企业招聘功能模块】主键
     * @return 结果
     */
    @Override
    public int deleteCompanyById(Long id)
    {
        return companyMapper.deleteCompanyById(id);
    }

    @Override
    public PageInfo<Company> selectCompanyWithPage(int page, int count, String job) {

        PageHelper.startPage(page, count);
        List<Company> companyList = companyMapper.selectCompanyWithPage(job);
        PageInfo<Company> pageInfo=new PageInfo<>(companyList);
        return pageInfo;
    }

    /**
     * @description: 企业招聘工作类型个数
     * @author: author
     * @date: 2025/2/13 13:55
     * @param: []
     **/

    @Override
    public List<DataScaleType> selectDataScaleType() {
        return companyMapper.selectDataScaleType();
    }
}
