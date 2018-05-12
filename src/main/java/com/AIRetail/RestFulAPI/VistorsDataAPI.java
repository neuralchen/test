package com.AIRetail.RestFulAPI;

import java.sql.Timestamp;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AIRetail.DAO.InPassengersDAO;
import com.AIRetail.DAO.OutPassengersDAO;
import com.AIRetail.DAO.ShopHeatmapDAO;
import com.AIRetail.Entity.HeatmapDataEntity;
import com.AIRetail.Entity.InPassengersEntity;
import com.AIRetail.Entity.OutPassengersEntity;
import com.AIRetail.Model.PostHeatmapModel;
import com.AIRetail.Model.PostInPassengerModel;
import com.AIRetail.Model.PostOutPassengerModel;
import com.AIRetail.Model.Test.InPassengerDataModel;

@RestController
@RequestMapping(value = "api/vistors", method = RequestMethod.POST)
public class VistorsDataAPI {
	@Autowired
	private InPassengersDAO inpassendao;
	@Autowired
	private OutPassengersDAO outpassendao;
	@Autowired
	private ShopHeatmapDAO heatmapdao;

	@RequestMapping(value = "in")
	public String UploadInPassenger(@RequestBody PostInPassengerModel passenger) {
		// 此处确认权限
		if (passenger.getToken().equals("5B58D63AC8576F7F017B08A26C84E35A")) {
			InPassengersEntity temp = new InPassengersEntity();
			temp.setAge(passenger.getAge());
			temp.setFacepic(passenger.getFace_pic());
			temp.setRankid(passenger.getRankid());
			temp.setGender(passenger.getGender());
			temp.setWholebodypic(passenger.getWhole_body_pic());
			temp.setTimestamp(Timestamp.valueOf(passenger.getTimestamp()));
			Integer res = inpassendao.insertInPassenger(temp);
			if (res > 0)
				return "0";
		}
		return "11";
	}

	@RequestMapping(value = "out")
	public String UploadOutPassenger(@RequestBody PostOutPassengerModel passenger) {
		// 此处确认权限
		if (passenger.getToken().equals("5B58D63AC8576F7F017B08A26C84E35A")) {
			OutPassengersEntity temp = new OutPassengersEntity();
			temp.setAge(passenger.getAge());
			temp.setFacepic(passenger.getFace_pic());
			temp.setRankid(passenger.getRankid());
			temp.setGender(passenger.getGender());
			temp.setWholebodypic(passenger.getWhole_body_pic());
			temp.setTimestamp(Timestamp.valueOf(passenger.getTimestamp()));
			Integer res = outpassendao.insertOutPassenger(temp);
			if (res > 0)
				return "0";
		}
		return "11";
	}
	@RequestMapping(value = "heatmap")
	public String UploadHeatmap(@RequestBody PostHeatmapModel heatmap) {
		// 此处确认权限
		if (heatmap.getToken().equals("5B58D63AC8576F7F017B08A26C84E35A")) {
			HeatmapDataEntity temp = new HeatmapDataEntity();
			String s = heatmap.getData().toString();
			s = s.substring(1, s.length() - 1);
			temp.setData(s);
			temp.setRankid(heatmap.getRankid());
			temp.setTs(Timestamp.valueOf(heatmap.getTimestamp()));
			Integer res = heatmapdao.insertmapData(temp);
			if (res > 0)
				return "0";
		}
		return "11";
	}
	@RequestMapping(value = "uploaddata")
	public String UploadData(@RequestBody String reqstr) {
		reqstr = reqstr.trim();
		Integer rankid=666;
		try {  
			Map<String, Object> mapTypes = JSON.parseObject(reqstr);
			for (String tempstr : mapTypes.keySet()) {
				String valuestr = mapTypes.get(tempstr).toString();
				String keystr=tempstr.toLowerCase();//将所有字母小写化，以防名称不统一
				if (keystr.equals("in")) {
					PostInPassengerModel passenger = JSON.parseObject(valuestr, new TypeReference<PostInPassengerModel>() {
					});
					InPassengersEntity temp = new InPassengersEntity();
					temp.setAge(passenger.getAge());
					temp.setFacepic(passenger.getFace_pic());
					temp.setRankid(rankid);
					temp.setGender(passenger.getGender());
					temp.setWholebodypic(passenger.getWhole_body_pic());
					String date = passenger.getTimestamp();
					String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
					date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
					temp.setTimestamp(Timestamp.valueOf(date));
					Integer res = inpassendao.insertInPassenger(temp);
					if (res > 0)
						return "0";
				}
				if (keystr.equals("out")) {
					PostOutPassengerModel passenger = JSON.parseObject(valuestr,
							new TypeReference<PostOutPassengerModel>() {
							});
					OutPassengersEntity temp = new OutPassengersEntity();
					temp.setAge(passenger.getAge());
					temp.setFacepic(passenger.getFace_pic());
					temp.setRankid(rankid);
					temp.setGender(passenger.getGender());
					temp.setWholebodypic(passenger.getWhole_body_pic());
					String date = passenger.getTimestamp();
					String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
					date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
					temp.setTimestamp(Timestamp.valueOf(date));
					Integer res = outpassendao.insertOutPassenger(temp);
					if (res > 0)
						return "0";
				}
				if (keystr.equals("heatmap")) {
					PostHeatmapModel heatmap = JSON.parseObject(valuestr, new TypeReference<PostHeatmapModel>() {
					});
					HeatmapDataEntity temp = new HeatmapDataEntity();
					String s = heatmap.getData().toString();
					s = s.substring(1, s.length() - 1);
					temp.setData(s);
					temp.setRankid(rankid);
					String date = heatmap.getTimestamp();
					String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
					date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
					temp.setTs(Timestamp.valueOf(date));
					Integer res = heatmapdao.insertmapData(temp);
					if (res > 0)
						return "0";
				}
			} 
        } catch (Exception e) {  
            e.printStackTrace();
            return e.toString();
        }
		return "11";
	}
}
