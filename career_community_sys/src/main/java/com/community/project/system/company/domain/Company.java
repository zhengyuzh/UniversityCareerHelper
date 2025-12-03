package com.community.project.system.company.domain;

import com.community.framework.aspectj.lang.annotation.Excel;
import com.community.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 【岗位模块】对象 sys_company
 * 
 * @author author
 * @date 2025-01-09
 */
public class Company extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 发布者 */
    @Excel(name = "发布者")
    private String userName;

    /** 用户主键 */
    @Excel(name = "用户主键")
    private Long userId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

    /** 公司地点 */
    @Excel(name = "公司地点")
    private String address;

    /** 薪资范围 */
    @Excel(name = "薪资范围")
    private String salary;

    /** 工作 */
    @Excel(name = "工作")
    private String job;

    /** 公司人数 */
    @Excel(name = "公司人数")
    private Long peopleNums;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 投递时间 */
    @Excel(name = "投递时间")
    private String avatar;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    @Excel(name = "工作类型")
    private String companyType;

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public String getSalary()
    {
        return salary;
    }
    public void setJob(String job)
    {
        this.job = job;
    }

    public String getJob()
    {
        return job;
    }
    public void setPeopleNums(Long peopleNums)
    {
        this.peopleNums = peopleNums;
    }

    public Long getPeopleNums()
    {
        return peopleNums;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("address", getAddress())
            .append("salary", getSalary())
            .append("job", getJob())
            .append("peopleNums", getPeopleNums())
            .append("phone", getPhone())
            .append("avatar", getAvatar())
            .append("note", getNote())
            .toString();
    }
}
