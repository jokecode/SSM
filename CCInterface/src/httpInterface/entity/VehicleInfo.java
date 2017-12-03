package httpInterface.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author InoriAsuka
 * @time 2017/11/13 14:48
 * @since jdk1.8
 */
public class VehicleInfo {

	private String cno;
	private Long vehicleInfoId;
    private String strainName;
    private String pName;
    private String sourceType;
    private String vin;
    private String dealerName;
    private String cert;
    private String engineCode;
    private String licenseCode;
    private String termCustName;
    private Date termSaleDate;
    private Date hostSaleDate;
    private List<MaintenanceRecord> maintenanceRecords;

    public VehicleInfo() {

    }

    public VehicleInfo(String cno, Long vehicleInfoId, String strainName, String pName, String sourceType, String vin, String dealerName, String cert, String engineCode, String licenseCode, String termCustName, Date termSaleDate, Date hostSaleDate, List<MaintenanceRecord> maintenanceRecords) {
        this.cno = cno;
    	this.vehicleInfoId = vehicleInfoId;
    	this.strainName = strainName;
        this.pName = pName;
        this.sourceType = sourceType;
        this.vin = vin;
        this.dealerName = dealerName;
        this.cert = cert;
        this.engineCode = engineCode;
        this.licenseCode = licenseCode;
        this.termCustName = termCustName;
        this.termSaleDate = termSaleDate;
        this.hostSaleDate = hostSaleDate;
        this.maintenanceRecords = maintenanceRecords;
    }

    
    public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public Long getVehicleInfoId() {
		return vehicleInfoId;
	}

	public void setVehicleInfoId(Long vehicleInfoId) {
		this.vehicleInfoId = vehicleInfoId;
	}

	public String getStrainName() {
        return strainName;
    }

    public void setStrainName(String strainName) {
        this.strainName = strainName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getTermCustName() {
        return termCustName;
    }

    public void setTermCustName(String termCustName) {
        this.termCustName = (termCustName == null) ? "" : termCustName;
    }

    public Date getTermSaleDate() {
        return termSaleDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    public void setTermSaleDate(Date termSaleDate) {
        this.termSaleDate = termSaleDate;
    }

    public Date getHostSaleDate() {
        return hostSaleDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    public void setHostSaleDate(Date hostSaleDate) {
        this.hostSaleDate = hostSaleDate;
    }

    public List<MaintenanceRecord> getMaintenanceRecords() {
        return maintenanceRecords;
    }

    public void setMaintenanceRecords(List<MaintenanceRecord> maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }

	@Override
	public String toString() {
		return "VehicleInfo [cno=" + cno + ", vehicleInfoId=" + vehicleInfoId
				+ ", strainName=" + strainName + ", pName=" + pName
				+ ", sourceType=" + sourceType + ", vin=" + vin
				+ ", dealerName=" + dealerName + ", cert=" + cert
				+ ", engineCode=" + engineCode + ", licenseCode=" + licenseCode
				+ ", termCustName=" + termCustName + ", termSaleDate="
				+ termSaleDate + ", hostSaleDate=" + hostSaleDate
				+ ", maintenanceRecords=" + maintenanceRecords + "]";
	}


}
