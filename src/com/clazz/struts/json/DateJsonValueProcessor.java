package com.clazz.struts.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {

	private String format="yyyy-MM-dd";
	private SimpleDateFormat sdf = new SimpleDateFormat(format);
	
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return null;
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		if(arg1==null){
			return "";
		}else if(arg1 instanceof Date){
			return sdf.format((Date)arg1);
		}else{
			return arg1.toString();
		}
	}
	

}

