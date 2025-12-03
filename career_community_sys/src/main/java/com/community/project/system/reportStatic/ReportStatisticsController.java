package com.community.project.system.reportStatic;

import com.community.project.system.company.service.ICompanyService;
import com.community.project.system.dict.service.IDictDataService;
import com.community.project.system.notice.service.INoticeService;
import com.community.project.system.reportStatic.vo.DataScaleType;
import com.community.project.system.scale.service.IScaleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: ruoyi
 * @BelongsPackage: com.community.project.system.reportStatic
 * @Author: author
 * @CreateTime: 2025-02-13  13:24
 * @Description: TODO
 * @Version: 1.0
 */

@Controller
public class ReportStatisticsController {

    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IDictDataService iDictDataService;

    @Autowired
    private INoticeService iNoticeService;


    /**
     * @description: 去测评统计页面
     * @author: zhengyuzhu
     * @date: 2024/9/9 22:09
     * @return: java.lang.String
     **/
    @RequestMapping(value = "/system/eport/showReport")
    public String showReport( ModelMap mp) throws JsonProcessingException {
        List<DataScaleType> scaleTypeList = iNoticeService.selectDataScaleTypeByCLassNameAll();
        List<DataScaleType> scaleTypeListResult = new LinkedList<>();
        List<String> typeList = new LinkedList<>();
        for (int i = 0; i < scaleTypeList.size(); i++) {
            DataScaleType dataScaleType = scaleTypeList.get(i);
            String value = iDictDataService.selectDictLabel("sys_notice_type",dataScaleType.getType());
            dataScaleType.setType(value);
            typeList.add(value);
            scaleTypeListResult.add(dataScaleType);
        }
        System.out.println(scaleTypeListResult.toString());



        ObjectMapper objectMapper = new ObjectMapper();
        String scaleTypeListResultJson = objectMapper.writeValueAsString(scaleTypeListResult);

        mp.put("scaleTypeListResultJson", scaleTypeListResultJson);
        mp.put("scaleTypeListResult", scaleTypeListResult);
        mp.put("str", "我的测试");


        return "foreground/client/echarts";
    }

}
