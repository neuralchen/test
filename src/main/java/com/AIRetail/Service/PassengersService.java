package com.AIRetail.Service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.AIRetail.Model.CustomerData;
import com.AIRetail.Model.CustomerDataAge;
import com.AIRetail.Model.CustomerDataGender;

public interface PassengersService {
	public List<CustomerData> getCustomerData(Timestamp st, Timestamp et, String type);
	public List<CustomerDataAge> getInDataByAge(Timestamp st, Timestamp et, String type);
	public List<CustomerDataGender> getInDataByGender(Timestamp st,Timestamp et, String type);
	public List<CustomerDataAge> getOutDataByAge(Timestamp st, Timestamp et, String type);
	public List<CustomerDataGender> getOutDataByGender(Timestamp st,Timestamp et, String type);
}
