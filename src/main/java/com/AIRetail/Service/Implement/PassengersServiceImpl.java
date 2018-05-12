package com.AIRetail.Service.Implement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AIRetail.DAO.InPassengersDAO;
import com.AIRetail.DAO.OutPassengersDAO;
import com.AIRetail.DAO.PassengersDAO;
import com.AIRetail.DAO.UserDAO;
import com.AIRetail.Model.CustomerData;
import com.AIRetail.Model.CustomerDataAge;
import com.AIRetail.Model.CustomerDataGender;
import com.AIRetail.Service.PassengersService;

@Service
public class PassengersServiceImpl implements PassengersService {
	
	@Autowired
	private InPassengersDAO inpassendao;
	@Autowired
	private OutPassengersDAO outpassendao;
	
	public List<CustomerDataAge> getInDataByAge(Timestamp st, Timestamp et, String type) {
		List<CustomerDataAge> temp= new ArrayList<CustomerDataAge>();
		if(type.equals("hour")) {
			temp=inpassendao.getDataByAgeHour(st, et);
		}
		else if(type.equals("day")){
			temp=inpassendao.getDataByAgeDay(st, et);
		}
		else {
			temp=inpassendao.getDataByAgeMonth(st, et);
		}
		return temp;
	}

	public List<CustomerDataGender> getInDataByGender(Timestamp st, Timestamp et, String type) {
		List<CustomerDataGender> temp= new ArrayList<CustomerDataGender>();
		if(type.equals("hour")) {
			temp=inpassendao.getDataByGenderHour(st, et);
		}
		else if(type.equals("day")) {
			temp=inpassendao.getDataByGenderDay(st, et);
		}
		else {
			temp=inpassendao.getDataByGenderMonth(st, et);
		}
		return temp;
	}
	public List<CustomerDataAge> getOutDataByAge(Timestamp st, Timestamp et, String type) {
		List<CustomerDataAge> temp= new ArrayList<CustomerDataAge>();
		if(type.equals("hour")) {
			temp=outpassendao.getDataByAgeHour(st, et);
		}
		else if(type.equals("day")){
			temp=outpassendao.getDataByAgeDay(st, et);
		}
		else {
			temp=outpassendao.getDataByAgeMonth(st, et);
		}
		return temp;
	}

	public List<CustomerDataGender> getOutDataByGender(Timestamp st, Timestamp et, String type) {
		List<CustomerDataGender> temp= new ArrayList<CustomerDataGender>();
		if(type.equals("hour")) {
			temp=outpassendao.getDataByGenderHour(st, et);
		}
		else if(type.equals("day")) {
			temp=outpassendao.getDataByGenderDay(st, et);
		}
		else {
			temp=outpassendao.getDataByGenderMonth(st, et);
		}
		return temp;
	}

	@Override
	public List<CustomerData> getCustomerData(Timestamp st, Timestamp et, String type) {
		List<CustomerData> temp= new ArrayList<CustomerData>();
		if(type.equals("In")) {
			temp=inpassendao.getData(st, et);
		}
		else {
			temp=outpassendao.getData(st, et);
		}
		return temp;
	}

}
