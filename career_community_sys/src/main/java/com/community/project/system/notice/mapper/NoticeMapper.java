package com.community.project.system.notice.mapper;

import com.community.project.system.notice.domain.Notice;
import com.community.project.system.reportStatic.vo.DataScaleType;

import java.util.List;

/**
 * 求职信息 数据层
 * 
 * @author ruoyi
 */
public interface NoticeMapper
{
    /**
     * 查询求职信息信息
     * 
     * @param noticeId 求职信息ID
     * @return 求职信息信息
     */
    public Notice selectNoticeById(Long noticeId);

    /**
     * 查询求职信息列表
     * 
     * @param notice 求职信息信息
     * @return 求职信息集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增求职信息
     * 
     * @param notice 求职信息信息
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改求职信息
     * 
     * @param notice 求职信息信息
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 批量删除求职信息
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);

    public List<Notice> getNotice();

    List<Notice> selectNoticeWithPage();

    List<DataScaleType> selectDataScaleTypeByCLassNameAll();
}