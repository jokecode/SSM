package httpInterface.service;

import httpInterface.dao.GetVehicleInfoDao;
import httpInterface.entity.MaintenanceRecord;
import httpInterface.entity.VehicleInfo;
import httpInterface.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service
public class GetVehicleInfoService {

	@Resource
	private GetVehicleInfoDao getVehicleInfoDao;
	
	public List<VehicleInfo> getVehicleInfoByCno(String cno){
		List<VehicleInfo> vehicleInfoList = new ArrayList<VehicleInfo>();
		
		List<Map<String, Object>> list = getVehicleInfoDao.queryVehicleInfoForCno(cno);
		
		for(Map<String, Object> map : list){
			List<MaintenanceRecord> maintenanceRecordList = new ArrayList<MaintenanceRecord>();
			VehicleInfo vehicleInfo = (VehicleInfo) BeanUtil.transMap2Bean(map, new VehicleInfo());
			String dph = vehicleInfo.getCno();
			List<Map<String, Object>> recordList = getVehicleInfoDao.queryRecordInfoForCno(dph);
			for(Map<String, Object> recordMap : recordList){
				MaintenanceRecord maintenanceRecord = (MaintenanceRecord) BeanUtil.transMap2Bean(recordMap, new MaintenanceRecord());
				maintenanceRecordList.add(maintenanceRecord);
			}
			vehicleInfo.setMaintenanceRecords(maintenanceRecordList);
			
			vehicleInfoList.add(vehicleInfo);
		}
		return vehicleInfoList;
	}
	
}
