package com.fsnip.platform.module.console.entity;

import com.fsnip.platform.core.BaseEntity;
import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;

import java.util.Date;

/**
 * Created by HY on 2015/7/20.
 * desc:  流通监督抽检计划
 */
@Table("JG_LTJTCJ")
public class JG_LTJTCJ extends BaseEntity {

    private static final long serialVersionUID = 6053407245560170123L;

    @Id     private Long ID;
    @Column private String CUUID; //系统编号
    @Column private String CJCLX; //检测类型 快检/监督抽查
    @Column private Integer CJHND;
    @Column private String CJHDW;//计划单位
    @Column private String CJHGK;//计划归口 流通/餐饮/生产
    @Column private String CJHDJ;//计划等级国检省市县
    @Column private String CJHBH;//计划编号
    @Column private String CBZDWBH;//计划编制单位编号
    @Column private String CBZDW;//计划编制单位
    @Column private String CBZDWSF;//编制单位身份
    @Column private String CBZZBH;//编制者编号
    @Column private String CBZZ;//编制者
    @Column private Date CZHBZRQ;//计划编制日期
    @Column private String CJHSM;//计划说明
    @Column private String CLXDH;//联系电话
    @Column private String CSHRBH;//审核人编号
    @Column private String CSHR;//审核人
    @Column private Date CSHRQ;//审核日期
    @Column private String CSHYJ;//审核意见
    @Column private String CFFDW;//在计划编制界面上显示：拟承办处室，下拉框，综合流通餐饮生产，该单位将有权限进行计划分解
    @Column private String CFFDWBH;//分发单位编号
    @Column private String CFFDWSF;//分发单位身份
    @Column private String CJHZT;//计划状态

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCUUID() {
        return CUUID;
    }

    public void setCUUID(String CUUID) {
        this.CUUID = CUUID;
    }

    public String getCJCLX() {
        return CJCLX;
    }

    public void setCJCLX(String CJCLX) {
        this.CJCLX = CJCLX;
    }

    public Integer getCJHND() {
        return CJHND;
    }

    public void setCJHND(Integer CJHND) {
        this.CJHND = CJHND;
    }

    public String getCJHDW() {
        return CJHDW;
    }

    public void setCJHDW(String CJHDW) {
        this.CJHDW = CJHDW;
    }

    public String getCJHGK() {
        return CJHGK;
    }

    public void setCJHGK(String CJHGK) {
        this.CJHGK = CJHGK;
    }

    public String getCJHDJ() {
        return CJHDJ;
    }

    public void setCJHDJ(String CJHDJ) {
        this.CJHDJ = CJHDJ;
    }

    public String getCJHBH() {
        return CJHBH;
    }

    public void setCJHBH(String CJHBH) {
        this.CJHBH = CJHBH;
    }

    public String getCBZDWBH() {
        return CBZDWBH;
    }

    public void setCBZDWBH(String CBZDWBH) {
        this.CBZDWBH = CBZDWBH;
    }

    public String getCBZDW() {
        return CBZDW;
    }

    public void setCBZDW(String CBZDW) {
        this.CBZDW = CBZDW;
    }

    public String getCBZDWSF() {
        return CBZDWSF;
    }

    public void setCBZDWSF(String CBZDWSF) {
        this.CBZDWSF = CBZDWSF;
    }

    public String getCBZZBH() {
        return CBZZBH;
    }

    public void setCBZZBH(String CBZZBH) {
        this.CBZZBH = CBZZBH;
    }

    public String getCBZZ() {
        return CBZZ;
    }

    public void setCBZZ(String CBZZ) {
        this.CBZZ = CBZZ;
    }

    public Date getCZHBZRQ() {
        return CZHBZRQ;
    }

    public void setCZHBZRQ(Date CZHBZRQ) {
        this.CZHBZRQ = CZHBZRQ;
    }

    public String getCJHSM() {
        return CJHSM;
    }

    public void setCJHSM(String CJHSM) {
        this.CJHSM = CJHSM;
    }

    public String getCLXDH() {
        return CLXDH;
    }

    public void setCLXDH(String CLXDH) {
        this.CLXDH = CLXDH;
    }

    public String getCSHRBH() {
        return CSHRBH;
    }

    public void setCSHRBH(String CSHRBH) {
        this.CSHRBH = CSHRBH;
    }

    public String getCSHR() {
        return CSHR;
    }

    public void setCSHR(String CSHR) {
        this.CSHR = CSHR;
    }

    public Date getCSHRQ() {
        return CSHRQ;
    }

    public void setCSHRQ(Date CSHRQ) {
        this.CSHRQ = CSHRQ;
    }

    public String getCSHYJ() {
        return CSHYJ;
    }

    public void setCSHYJ(String CSHYJ) {
        this.CSHYJ = CSHYJ;
    }

    public String getCFFDW() {
        return CFFDW;
    }

    public void setCFFDW(String CFFDW) {
        this.CFFDW = CFFDW;
    }

    public String getCFFDWBH() {
        return CFFDWBH;
    }

    public void setCFFDWBH(String CFFDWBH) {
        this.CFFDWBH = CFFDWBH;
    }

    public String getCFFDWSF() {
        return CFFDWSF;
    }

    public void setCFFDWSF(String CFFDWSF) {
        this.CFFDWSF = CFFDWSF;
    }

    public String getCJHZT() {
        return CJHZT;
    }

    public void setCJHZT(String CJHZT) {
        this.CJHZT = CJHZT;
    }
}
