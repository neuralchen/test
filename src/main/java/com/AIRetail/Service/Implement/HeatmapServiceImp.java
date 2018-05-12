package com.AIRetail.Service.Implement;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AIRetail.DAO.ShopHeatmapDAO;
import com.AIRetail.Entity.HeatmapDataEntity;
import com.AIRetail.Entity.ShopStructureEntity;
import com.AIRetail.Model.HeatMapDataModel;
import com.AIRetail.Model.SingleHeatMapModel;
import com.AIRetail.Service.HeatmapService;

@Service
public class HeatmapServiceImp implements HeatmapService {
	@Autowired
	private ShopHeatmapDAO heatmapdao;
	public HeatMapDataModel getHmDataANDStruct(Integer rank_id, Timestamp st, Timestamp et, String type) {
		ShopStructureEntity shopstruct= heatmapdao.getShopStructure(rank_id);
		HeatMapDataModel temp=new HeatMapDataModel();
		temp.setShopstructure(shopstruct);
		if(type.equals("hour")) {
			List<HeatmapDataEntity> heatdata= heatmapdao.getHeatmapDataByHour(rank_id, st, et);
			temp.setData(OrderHeatmapData(heatdata,type));
		}
		else if(type.equals("day")){
			List<HeatmapDataEntity> heatdata= heatmapdao.getHeatmapDataByDay(rank_id, st, et); 
			temp.setData(OrderHeatmapData(heatdata,type));
		}
		else {
			List<HeatmapDataEntity> heatdata= heatmapdao.getHeatmapDataByMonth(rank_id, st, et); 
			temp.setData(OrderHeatmapData(heatdata,type));
		}
		return temp;
	}
	
	private ArrayList<SingleHeatMapModel> OrderHeatmapData(List<HeatmapDataEntity> heatdata, String type) {
		ArrayList<SingleHeatMapModel> temp=new ArrayList<SingleHeatMapModel>();
		DateFormat sdf,outsdf;
		if(type.equals("10min")) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			outsdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		}
		else if(type.equals("hour")) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH");
			outsdf= new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		}
		else if(type.equals("day")){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			outsdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		}
		else {
			sdf = new SimpleDateFormat("yyyy-MM");
			outsdf = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		}
		String cur = "";
		String tsstr="";
		List<Integer> buffer = null;
		HeatmapDataEntity temp1= null;
		for(int i=0;i<heatdata.size();i++) {
			temp1=heatdata.get(i);
			tsstr=sdf.format(temp1.getTs());
			if(type.equals("10min")) {
				tsstr=tsstr.substring(0,tsstr.length() - 1);
			}
			//在同一个时间段内，数据叠加
			if(cur.equals(tsstr)) {
				listadd(buffer,string2list(temp1.getData()));
			}
			else {
				SingleHeatMapModel tempsingle=new SingleHeatMapModel();
				cur=tsstr;
				tempsingle.setData(string2list(temp1.getData()));
				buffer=tempsingle.getData();   //将当前热力图的指针给buffer
				tempsingle.setTs(Timestamp.valueOf(outsdf.format(temp1.getTs())));
				temp.add(tempsingle);
			}
		}
		return temp;
	}
	
	private void listadd(List<Integer> list1,List<Integer> list2){
		for(int i=0;i<list1.size();i++) {
			list1.set(i, list1.get(i)+list2.get(i));
		}
	}
	
	private List<Integer> string2list(String str){
		List<Integer> res = new ArrayList<Integer>();
		List<String> wocao = Arrays.asList(str.split(",")); 
		for(String x:wocao) {
			res.add(Integer.parseInt(x.trim()));
		}
		return res;
	}
}
