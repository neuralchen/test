package com.AIRetail.DAO;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.AIRetail.Entity.InPassengersEntity;
import com.AIRetail.Entity.OutPassengersEntity;
import com.AIRetail.Model.CustomerData;
import com.AIRetail.Model.CustomerDataAge;
import com.AIRetail.Model.CustomerDataGender;

public interface InPassengersDAO {
	public List<CustomerData> getData(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataAge> getDataByAgeHour(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataAge> getDataByAgeDay(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataAge> getDataByAgeMonth(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataGender> getDataByGenderHour(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataGender> getDataByGenderDay(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public List<CustomerDataGender> getDataByGenderMonth(@Param("st")Timestamp st, @Param("et")Timestamp et);
	public Integer insertInPassenger(InPassengersEntity passenger);
}
