package com.community.project.system.music.service;

import com.github.pagehelper.PageInfo;
import com.community.project.system.music.domain.Music;

import java.util.List;

/**
 * 【岗位模块】Service接口
 * 
 * @author ruoyi
 * @date 2025-01-09
 */
public interface IMusicService 
{
    /**
     * 查询【岗位模块】
     * 
     * @param musicid 【岗位模块】主键
     * @return 【岗位模块】
     */
    public Music selectMusicByMusicid(Long musicid);

    /**
     * 查询【岗位模块】列表
     * 
     * @param music 【岗位模块】
     * @return 【岗位模块】集合
     */
    public List<Music> selectMusicList(Music music);

    /**
     * 新增【岗位模块】
     * 
     * @param music 【岗位模块】
     * @return 结果
     */
    public int insertMusic(Music music);

    /**
     * 修改【岗位模块】
     * 
     * @param music 【岗位模块】
     * @return 结果
     */
    public int updateMusic(Music music);

    /**
     * 批量删除【岗位模块】
     * 
     * @param musicids 需要删除的【岗位模块】主键集合
     * @return 结果
     */
    public int deleteMusicByMusicids(String musicids);

    /**
     * 删除【岗位模块】信息
     * 
     * @param musicid 【岗位模块】主键
     * @return 结果
     */
    public int deleteMusicByMusicid(Long musicid);


    /**
     * 添加音乐
     * @param music
     */
    int addMusic(Music music);

    /**
     * 音乐前台 分页展示
     * @param page
     * @param count
     * @param musicTitle
     * @return
     */
    PageInfo<Music> selectMusicWithPage(int page, int count, String musicTitle);
}
