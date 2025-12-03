package com.community.project.system.reportStatic;

import com.community.project.system.company.service.ICompanyService;
import com.community.project.system.dict.service.IDictDataService;
import com.community.project.system.notice.service.INoticeService;
import com.community.project.system.reportStatic.vo.DataScaleType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

@RestController
public class ReportTwoController {

    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IDictDataService iDictDataService;

    @Autowired
    private INoticeService iNoticeService;


    /**
     * @description: 去测评统计页面
     * @author: author
     * @return: java.lang.String
     **/
    @GetMapping(value = "/system/eport/list")
    public List<DataScaleType> listReport(ModelMap mp){
        List<DataScaleType> scaleTypeList = iCompanyService.selectDataScaleType();
        List<DataScaleType> scaleTypeListResult = new LinkedList<>();
        List<String> typeList = new LinkedList<>();
        for (int i = 0; i < scaleTypeList.size(); i++) {
            DataScaleType dataScaleType = scaleTypeList.get(i);
            String value = iDictDataService.selectDictLabel("sys_company_type",dataScaleType.getType());
            dataScaleType.setType(value);
            typeList.add(value);
            scaleTypeListResult.add(dataScaleType);
        }
        System.out.println(scaleTypeListResult.toString());

        return scaleTypeListResult;


    }


    /**
     * @description: 统计学生发布的求职类型数据
     * @author: author
     * @return: java.lang.String
     **/
    @RequestMapping(value = "/system/eport/listByClass",method = RequestMethod.POST)
    public List<DataScaleType> listReportByClassName(@RequestParam("classType") String classType){
        System.out.println("获取前端传递的值：" + classType);
        List<DataScaleType> scaleTypeList = new LinkedList<>();
        List<DataScaleType> scaleTypeListResult = new LinkedList<>();
        List<String> typeList = new LinkedList<>();

        if(classType == null || classType.isEmpty()){
            scaleTypeList = iNoticeService.selectDataScaleTypeByCLassNameAll();

        }else{
            scaleTypeList = iNoticeService.selectDataScaleTypeByCLassNameAll();
        }

        for (int i = 0; i < scaleTypeList.size(); i++) {
            DataScaleType dataScaleType = scaleTypeList.get(i);
            //用户求职类型
            String value = iDictDataService.selectDictLabel("sys_notice_type",dataScaleType.getType());
            dataScaleType.setType(value);
            typeList.add(value);
            scaleTypeListResult.add(dataScaleType);
        }

        return scaleTypeListResult;


    }
}
