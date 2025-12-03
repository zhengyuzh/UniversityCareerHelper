package com.community.project.system.music.controller;

import com.github.pagehelper.PageInfo;
import com.community.common.utils.security.ShiroUtils;
import com.community.framework.web.controller.BaseController;
import com.community.project.system.knowledge.domain.MentalKnowledge;
import com.community.project.system.knowledge.service.IMentalKnowledgeService;
import com.community.project.system.music.domain.Music;
import com.community.project.system.music.service.IMusicService;
import com.community.project.system.notice.domain.Notice;
import com.community.project.system.notice.service.INoticeService;
import com.community.project.system.user.domain.User;
import com.community.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2025-01-09 19:38
 * @Description:
 */
@Controller
public class MusicShowController extends BaseController {

    @Autowired
    private IMusicService musicService;

    @Autowired
    private IMentalKnowledgeService mentalKnowledgeService;

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IUserService userService;

    /**
     *  去活跃用户展示页面
     */
    @RequestMapping(value ="/system/Music/toMusicPage")
    private String ShowMusic(HttpServletRequest request, ModelMap mp, String musicTitle ) {
        User user = ShiroUtils.getSysUser();
        mp.put("user",user);
        return this.ShowMusic(request, 1, 5,mp,musicTitle);

    }
    @GetMapping(value = "/pageMusic/{p}")
    public String ShowMusic(HttpServletRequest request, @PathVariable("p") int page,
                                      @RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap, String musicTitle) {
        PageInfo<Music> musicPageInfo = musicService.selectMusicWithPage(page, count,musicTitle);
        List<Music> musicList = musicService.selectMusicList(null);
        List<Notice> noticeList =  noticeService.getNotice();
        User user1 = ShiroUtils.getSysUser();
        modelMap.put("user",user1);
        request.setAttribute("mentalKnowledges", musicPageInfo);
        request.setAttribute("noticeList", noticeList);
        request.setAttribute("mentalKnowledgeTitle", musicTitle);
        request.setAttribute("mentalKnowledgeList", musicList);
        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "foreground/client/show_music";
    }


    /**
     *  去活跃用户展示页面
     */
    @RequestMapping(value ="/system/User/toUserPage")
    private String ShowUser(HttpServletRequest request, ModelMap mp, String userName ) {
        User user = ShiroUtils.getSysUser();
        mp.put("user",user);
        return this.ShowUser(request, 1, 5,mp,userName);

    }

    @GetMapping(value = "/pageUser/{p}")
    public String ShowUser(HttpServletRequest request, @PathVariable("p") int page,
                            @RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap, String userName) {
        PageInfo<Music> musicPageInfo = musicService.selectMusicWithPage(page, count,userName);

        PageInfo<User> userPageInfo = userService.selectUserWithPage(page, count,userName);
        List<User> userList = userService.selectAllUser();

        List<Music> musicList = musicService.selectMusicList(null);
        List<Notice> noticeList =  noticeService.getNotice();
        User user1 = ShiroUtils.getSysUser();
        modelMap.put("user",user1);
        // request.setAttribute("mentalKnowledges", musicPageInfo);
        // request.setAttribute("mentalKnowledgeTitle", userName);
        // request.setAttribute("mentalKnowledgeList", musicList);

        request.setAttribute("noticeList", noticeList);
        request.setAttribute("userPageInfo", userPageInfo);

        request.setAttribute("userList", userList);


        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "foreground/client/show_music";
    }

}
