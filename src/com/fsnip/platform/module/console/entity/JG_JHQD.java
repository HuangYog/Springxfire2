package com.fsnip.platform.module.console.entity;

import com.fsnip.platform.core.BaseEntity;
import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;

import java.util.Date;

/**
 * Created by HY on 2015/7/20.
 * desc: 计划清单
 */
@Table("JG_JHQD")
public class JG_JHQD extends BaseEntity {

    private static final long serialVersionUID = 7307927267794596391L;

    @Id     private Long  ID;
    @Column private String C1UUID; //系统编号
    @Column private String CJHDID; //计划单UUID
    @Column private Integer C1JHNF;//年份
    @Column private String C1JHYF;//计划月份
    @Column private Integer C1HXM;//行项目
    @Column private String C1ZL;//种类
    @Column private Integer C1FLBH;//分类编号
    @Column private String C1FLMC;//分类名称
    @Column private String C1PZBH;//品种编号
    @Column private String C1PZMC;//品种名称
    @Column private Integer C1CYPC;//抽样批次
    @Column private String C1JCFW;//监测范围
    @Column private String C1JCZB;//检测指标
    @Column private Date C1JHKSSJ;//计划开始时间
    @Column private Date C1JHWCSJ;//计划完成时间
    @Column private String C1JHZT;//计划状态

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getC1UUID() {
        return C1UUID;
    }

    public void setC1UUID(String c1UUID) {
        C1UUID = c1UUID;
    }

    public String getCJHDID() {
        return CJHDID;
    }

    public void setCJHDID(String CJHDID) {
        this.CJHDID = CJHDID;
    }

    public Integer getC1JHNF() {
        return C1JHNF;
    }

    public void setC1JHNF(Integer c1JHNF) {
        C1JHNF = c1JHNF;
    }

    public String getC1JHYF() {
        return C1JHYF;
    }

    public void setC1JHYF(String c1JHYF) {
        C1JHYF = c1JHYF;
    }

    public Integer getC1HXM() {
        return C1HXM;
    }

    public void setC1HXM(Integer c1HXM) {
        C1HXM = c1HXM;
    }

    public String getC1ZL() {
        return C1ZL;
    }

    public void setC1ZL(String c1ZL) {
        C1ZL = c1ZL;
    }

    public Integer getC1FLBH() {
        return C1FLBH;
    }

    public void setC1FLBH(Integer c1FLBH) {
        C1FLBH = c1FLBH;
    }

    public String getC1FLMC() {
        return C1FLMC;
    }

    public void setC1FLMC(String c1FLMC) {
        C1FLMC = c1FLMC;
    }

    public String getC1PZBH() {
        return C1PZBH;
    }

    public void setC1PZBH(String c1PZBH) {
        C1PZBH = c1PZBH;
    }

    public String getC1PZMC() {
        return C1PZMC;
    }

    public void setC1PZMC(String c1PZMC) {
        C1PZMC = c1PZMC;
    }

    public Integer getC1CYPC() {
        return C1CYPC;
    }

    public void setC1CYPC(Integer c1CYPC) {
        C1CYPC = c1CYPC;
    }

    public String getC1JCFW() {
        return C1JCFW;
    }

    public void setC1JCFW(String c1JCFW) {
        C1JCFW = c1JCFW;
    }

    public String getC1JCZB() {
        return C1JCZB;
    }

    public void setC1JCZB(String c1JCZB) {
        C1JCZB = c1JCZB;
    }

    public Date getC1JHKSSJ() {
        return C1JHKSSJ;
    }

    public void setC1JHKSSJ(Date c1JHKSSJ) {
        C1JHKSSJ = c1JHKSSJ;
    }

    public Date getC1JHWCSJ() {
        return C1JHWCSJ;
    }

    public void setC1JHWCSJ(Date c1JHWCSJ) {
        C1JHWCSJ = c1JHWCSJ;
    }

    public String getC1JHZT() {
        return C1JHZT;
    }

    public void setC1JHZT(String c1JHZT) {
        C1JHZT = c1JHZT;
    }
}
