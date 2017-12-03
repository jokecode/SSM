package httpInterface.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class GetVehicleInfoDao {
	
	@Autowired  
    private JdbcTemplate jdbcTemplate; 
	
	public List<Map<String, Object>> queryVehicleInfoForCno(String cno){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.ID as vehicleInfoId, A.csno as cno, C.xlmmc as strainName, A.pcode as pName, '' as sourceType, ");
		sql.append("  A.cert, A.bdno as vin, B.jxsmc as dealerName, B.FDJH as engineCode, B.CPH as licenseCode, B.YHNAME as termCustName, ");
		sql.append("  B.xsrq as termSaleDate, B.CCRQ as hostSaleDate ");
		sql.append(" FROM offline A ");
		sql.append(" LEFT JOIN crmfwbdata2004_test B ON A.csno = B.dph ");
		sql.append(" LEFT JOIN xlmtable C ON A.xlm = C.xlm ");
		sql.append("WHERE A.csno = ?");
		list = jdbcTemplate.queryForList(sql.toString(), cno);
		return list;
	}
	
	public List<Map<String, Object>> queryRecordInfoForCno(String dph){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.dph, A.YHNAME as reportMan, A.MOVEPHONE as reportPhone, A.GZRQ as reportDate,  ");
		sql.append("  '' as repairState, A.gzxt as faultDesc, A.YYFX as dealWayDesc, B.ZMQC as channelName ");
		sql.append("  FROM jdkdfylfwbdata2003 A ");
		sql.append("  LEFT JOIN jsbzk B ON A.JDZH = B.jdzh WHERE A.dph = ? ");
		list = jdbcTemplate.queryForList(sql.toString(), dph);
		return list;
	}
}
