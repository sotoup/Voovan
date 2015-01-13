package org.hocate.http.server;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hocate.tools.TString;

public class HttpSession {
	private Map<String,Object> attributes;
	private String id ;
	private int maxInactiveInterval;
	private long createTimeillis;
	
	/**
	 * 构造函数
	 */
	public HttpSession(){
		attributes = new HashMap<String, Object>();
		this.id = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
		createTimeillis = System.currentTimeMillis();
		String sessionTimeout = TString.defaultValue(Config.getWebConfig().get("SessionTimeout"),"30");
		this.maxInactiveInterval = Integer.parseInt(sessionTimeout)*60*1000;
	}

	/**
	 * 获取当前 Session 属性
	 * @param name 属性名
	 * @return 属性值
	 */
	public Object getAttributes(String name) {
		return attributes.get(name);
	}

	/**
	 * 设置当前 Session 属性
	 * @param name	属性名
	 * @param value	属性值
	 */
	public void setAttribute(String name,Object value) {
		attributes.put(name, value);
	}

	/**
	 * 获取 Session ID
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 获取最大活动时间
	 * @return 最大活动时间
	 */
	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	/**
	 * 设置最大活动时间
	 * @param maxInactiveInterval 最大活动时间
	 */
	public void setMaxInactiveInterval(int maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}
	
	/**
	 * 当前 Session 是否失效
	 * @return  true: 失效,false: 有效
	 */
	public boolean isInvalid(){
		int intervalTime = (int)(System.currentTimeMillis() - createTimeillis);
		if(intervalTime>maxInactiveInterval){
			return true;
		}else{
			return false;
		}
	}
}