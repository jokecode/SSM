package httpInterface.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author InoriAsuka
 * @time 2017/11/13 14:57
 * @since jdk1.8
 */
public class MaintenanceRecord {

    private String reportMan;
    private String reportPhone;
    private Date reportDate;
    private String repairState;
    private String faultDesc;
    private String dealWayDesc;
    private String channelName;

    public MaintenanceRecord() {

    }

    public MaintenanceRecord(String reportMan, String reportPhone, Date reportDate, String repairState, String faultDesc, String dealWayDesc, String channelName) {
        this.reportMan = reportMan;
        this.reportPhone = reportPhone;
        this.reportDate = reportDate;
        this.repairState = repairState;
        this.faultDesc = faultDesc;
        this.dealWayDesc = dealWayDesc;
        this.channelName = channelName;
    }

    public String getReportMan() {
        return reportMan;
    }

    public void setReportMan(String reportMan) {
        this.reportMan = reportMan;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public Date getReportDate() {
        return reportDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public String getFaultDesc() {
        return faultDesc;
    }

    public void setFaultDesc(String faultDesc) {
        this.faultDesc = faultDesc;
    }

    public String getDealWayDesc() {
        return dealWayDesc;
    }

    public void setDealWayDesc(String dealWayDesc) {
        this.dealWayDesc = dealWayDesc;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return "MaintenanceRecord{" +
                "reportMan='" + reportMan + '\'' +
                ", reportPhone='" + reportPhone + '\'' +
                ", reportDate=" + reportDate +
                ", repairState='" + repairState + '\'' +
                ", faultDesc='" + faultDesc + '\'' +
                ", dealWayDesc='" + dealWayDesc + '\'' +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
