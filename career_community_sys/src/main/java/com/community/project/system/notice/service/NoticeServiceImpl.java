package com.community.project.system.notice.service;

import com.community.common.utils.security.ShiroUtils;
import com.community.common.utils.text.Convert;
import com.community.project.system.company.domain.Company;
import com.community.project.system.notice.domain.Notice;
import com.community.project.system.notice.mapper.NoticeMapper;
import com.community.project.system.reportStatic.vo.DataScaleType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 求职信息 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class NoticeServiceImpl implements INoticeService
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询求职信息信息
     * 
     * @param noticeId 求职信息ID
     * @return 求职信息信息
     */
    @Override
    public Notice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询求职信息列表
     * 
     * @param notice 求职信息信息
     * @return 求职信息集合
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增求职信息
     * 
     * @param notice 求职信息信息
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        notice.setCreateBy(ShiroUtils.getLoginName());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改求职信息
     * 
     * @param notice 求职信息信息
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        notice.setUpdateBy(ShiroUtils.getLoginName());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除求职信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<Notice> getNotice(){
        return noticeMapper.getNotice();
    }

    @Override
    public PageInfo<Notice> selectNoticeWithPage(int page, int count) {
        PageHelper.startPage(page, count);
        List<Notice> companyList = noticeMapper.selectNoticeWithPage();
        PageInfo<Notice> pageInfo=new PageInfo<>(companyList);
        return pageInfo;
    }

    @Override
    public List<DataScaleType> selectDataScaleTypeByCLassNameAll() {
        return noticeMapper.selectDataScaleTypeByCLassNameAll();
    }
}
