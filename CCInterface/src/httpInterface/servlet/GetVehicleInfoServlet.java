package httpInterface.servlet;

import httpInterface.entity.VehicleInfo;
import httpInterface.service.GetVehicleInfoService;
import httpInterface.utils.DataSecret;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * GetVehicleInfoServlet简述： 通过拿到的底盘号返回其相关的车辆信息和维修历史
 * GetVehicleInfoServlet详述：
 * 
 */
public class GetVehicleInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static WebApplicationContext applicationContext;
	private GetVehicleInfoService getVehicleInfoService;
	private ObjectMapper mapper = new ObjectMapper();
	
	{
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {  
			@Override
			public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
				// TODO Auto-generated method stub
				arg1.writeString("");
			}  
		});
	}
	
//	/**
//	 * @see javax.servlet.GenericServlet#init()
//	 */
//	public void init() throws ServletException {
//		super.init();
//		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
//		getVehicleInfoService = (GetVehicleInfoService) applicationContext.getBean("getVehicleInfoService");
//	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		getVehicleInfoService = (GetVehicleInfoService) applicationContext.getBean("getVehicleInfoService");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取参数
		String jsonString = request.getParameter("param");
		PrintWriter out = response.getWriter();
		
		try {
			jsonString = DataSecret.decryptDES(jsonString);// 解密
			System.out.println("jsonString：" + jsonString);
			String param = "{\"cno\" : \"" + jsonString + "\"}";
			VehicleInfo vehicleInfo = mapper.readValue(param, VehicleInfo.class);
			List<VehicleInfo> list = getVehicleInfoService.getVehicleInfoByCno(vehicleInfo.getCno());
			VehicleInfo returnVehicleInfo = null;
			if(list != null && list.size() > 0) {
				returnVehicleInfo = list.get(0);
			}
			if(returnVehicleInfo == null) {
				out.print("null");
				return;
			}
			String returnJson = DataSecret.encryptDES(mapper.writeValueAsString(returnVehicleInfo));
			out.print(returnJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
