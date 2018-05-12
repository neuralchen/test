package com.AIRetail.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.AIRetail.Entity.ShopStructureEntity;
import com.AIRetail.Model.*;
import com.AIRetail.Service.*;

@Controller
public class RetailController {
	@Autowired
	PassengersService passenser;
	@Autowired
	HeatmapService heatmap;
	/**
	 * 请求客户统计信息页面
	 * @return
	 */
	@RequestMapping(value = "customers")
	public String CustomersStatistics() {
		return "customersstatistics";
	}
	
	@RequestMapping(value = "report")
	public String CustomerReport() {
		return "customerreport";
	}
	
	@RequestMapping(value = "getCustomerData")
	public @ResponseBody List<CustomerData> GetOutData(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerData> data = passenser.getCustomerData(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
	
	@RequestMapping(value = "getInDatabyG")
	public @ResponseBody List<CustomerDataGender> GetInDataByGender(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataGender> data = passenser.getInDataByGender(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	@RequestMapping(value = "getInDatabyA")
	public @ResponseBody List<CustomerDataAge> GetInDataByAge(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataAge> data = passenser.getInDataByAge(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
	@RequestMapping(value = "getOutDatabyG")
	public @ResponseBody List<CustomerDataGender> GetOutDataByGender(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataGender> data = passenser.getOutDataByGender(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	@RequestMapping(value = "getOutDatabyA")
	public @ResponseBody List<CustomerDataAge> GetOutDataByAge(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataAge> data = passenser.getOutDataByAge(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	/**
	 * 请求热力图页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "heatmap")
	public String Heatmap() {
//		// 验证用户，根据用户信息在数据库中查询相关的店铺信息
//		ZoneModel info = new ZoneModel();
//		info.setName("浙江省");
//		info.setZoneID(32);
//		CityModel wocao = new CityModel();
//		wocao.setName("杭州");
//		wocao.setCityID(320);
//		ShopInfoModel shop1 = new ShopInfoModel();
//		shop1.setName("玉泉超市");
//		shop1.setShopID(32001);
//		wocao.getShopes().add(shop1);
//		ShopInfoModel shop2 = new ShopInfoModel();
//		shop2.setName("黄龙超市");
//		shop2.setShopID(32002);
//		wocao.getShopes().add(shop2);
//		ShopInfoModel shop3 = new ShopInfoModel();
//		shop3.setName("西湖文化广场店");
//		shop3.setShopID(32003);
//		wocao.getShopes().add(shop3);
//
//		CityModel wocao1 = new CityModel();
//		wocao1.setName("嘉兴");
//		wocao1.setCityID(321);
//		ShopInfoModel shop4 = new ShopInfoModel();
//		shop4.setName("南湖超市");
//		shop4.setShopID(32101);
//		wocao1.getShopes().add(shop4);
//		ShopInfoModel shop5 = new ShopInfoModel();
//		shop5.setName("乌镇超市");
//		shop5.setShopID(32102);
//		wocao1.getShopes().add(shop5);
//		ShopInfoModel shop6 = new ShopInfoModel();
//		shop6.setName("嘉善店");
//		shop6.setShopID(32103);
//		wocao1.getShopes().add(shop6);
//
//		info.getCities().add(wocao);
//		info.getCities().add(wocao1);
//
//		model.addAttribute("info", info);
		return "heatmap";
	}

	@RequestMapping(value = "getheatmapdata")
	@ResponseBody
	public HeatMapDataModel HeatMapData(@RequestParam("rankid") Integer rankid, @RequestParam("st") String st,
			@RequestParam("et") String et, @RequestParam("type") String type) {		
		HeatMapDataModel data = heatmap.getHmDataANDStruct(rankid, Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
}
