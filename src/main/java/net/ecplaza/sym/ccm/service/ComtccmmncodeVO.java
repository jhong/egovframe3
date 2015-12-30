package net.ecplaza.sym.ccm.service;

/**
 * @Class Name : ComtccmmncodeVO.java
 * @Description : Comtccmmncode VO class
 * @Modification Information
 *
 * @author jhong
 * @since 2015.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ComtccmmncodeVO extends ComtccmmncodeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** CODE_ID */
    private java.lang.String codeId;
    
    /** CODE_ID_NM */
    private java.lang.String codeIdNm;
    
    /** CODE_ID_DC */
    private java.lang.String codeIdDc;
    
    /** USE_AT */
    private java.lang.String useAt;
    
    /** CL_CODE */
    private java.lang.String clCode;
    
    /** FRST_REGIST_PNTTM */
    private java.sql.Date frstRegistPnttm;
    
    /** FRST_REGISTER_ID */
    private java.lang.String frstRegisterId;
    
    /** LAST_UPDT_PNTTM */
    private java.sql.Date lastUpdtPnttm;
    
    /** LAST_UPDUSR_ID */
    private java.lang.String lastUpdusrId;
    
    public java.lang.String getCodeId() {
        return this.codeId;
    }
    
    public void setCodeId(java.lang.String codeId) {
        this.codeId = codeId;
    }
    
    public java.lang.String getCodeIdNm() {
        return this.codeIdNm;
    }
    
    public void setCodeIdNm(java.lang.String codeIdNm) {
        this.codeIdNm = codeIdNm;
    }
    
    public java.lang.String getCodeIdDc() {
        return this.codeIdDc;
    }
    
    public void setCodeIdDc(java.lang.String codeIdDc) {
        this.codeIdDc = codeIdDc;
    }
    
    public java.lang.String getUseAt() {
        return this.useAt;
    }
    
    public void setUseAt(java.lang.String useAt) {
        this.useAt = useAt;
    }
    
    public java.lang.String getClCode() {
        return this.clCode;
    }
    
    public void setClCode(java.lang.String clCode) {
        this.clCode = clCode;
    }
    
    public java.sql.Date getFrstRegistPnttm() {
        return this.frstRegistPnttm;
    }
    
    public void setFrstRegistPnttm(java.sql.Date frstRegistPnttm) {
        this.frstRegistPnttm = frstRegistPnttm;
    }
    
    public java.lang.String getFrstRegisterId() {
        return this.frstRegisterId;
    }
    
    public void setFrstRegisterId(java.lang.String frstRegisterId) {
        this.frstRegisterId = frstRegisterId;
    }
    
    public java.sql.Date getLastUpdtPnttm() {
        return this.lastUpdtPnttm;
    }
    
    public void setLastUpdtPnttm(java.sql.Date lastUpdtPnttm) {
        this.lastUpdtPnttm = lastUpdtPnttm;
    }
    
    public java.lang.String getLastUpdusrId() {
        return this.lastUpdusrId;
    }
    
    public void setLastUpdusrId(java.lang.String lastUpdusrId) {
        this.lastUpdusrId = lastUpdusrId;
    }
    
}
