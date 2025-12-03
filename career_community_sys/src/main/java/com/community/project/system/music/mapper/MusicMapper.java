package com.community.project.system.music.mapper;

import com.community.project.system.music.domain.Music;

import java.util.List;

/**
 * 【岗位模块】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-09
 */
public interface MusicMapper 
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
     * 删除【岗位模块】
     * 
     * @param musicid 【岗位模块】主键
     * @return 结果
     */
    public int deleteMusicByMusicid(Long musicid);

    /**
     * 批量删除【岗位模块】
     * 
     * @param musicids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMusicByMusicids(String[] musicids);

    /**
     * 添加音乐
     * @param music
     * @return
     */
    int addMusice(Music music);

    /**
     * 前台音乐分页
     * @param musicTitle
     * @return
     */
    List<Music> selectMusicWithPage(String musicTitle);
}
