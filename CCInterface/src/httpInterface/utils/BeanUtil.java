package httpInterface.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");

	public static Object transMap2Bean(Map<String, Object> map, Object obj) {

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (map.containsKey(key)) {
					Object value = map.get(key);
					
					Class<?> type = property.getPropertyType();
					System.out.println(type.getName());
					if(type.getName().equals("java.util.Date") && value != null){
						value = sdf.parse(String.valueOf(value));
					} else if (type.getName().equals("java.lang.Long")) {
						value = Long.parseLong(String.valueOf(value));
					}
					
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;

	}

	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}
	
	/**
	 * 
	 * @author InoriHimea
	 * @param javaBean
	 * @return
	 */
	public static boolean isNullOrEmpty(Object javaBean) {
		Field[] field = javaBean.getClass().getDeclaredFields();
		List<Object> list = new ArrayList<Object>();
		try {
			for (Field f : field) {
				String propertyName = f.getName();
				String getterMethod = "get" + propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
				Method m = javaBean.getClass().getMethod(getterMethod);
				Object object = m.invoke(javaBean);
				if (object != null) {
					list.add(object);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
