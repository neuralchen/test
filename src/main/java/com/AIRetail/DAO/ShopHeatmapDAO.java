package com.AIRetail.DAO;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.AIRetail.Entity.HeatmapDataEntity;
import com.AIRetail.Entity.ShopStructureEntity;

public interface ShopHeatmapDAO {
	ShopStructureEntity getShopStructure(Integer rank_id);
	List<HeatmapDataEntity> getHeatmapDataByHour(@Param("rank_id") Integer rank_id, @Param("st")Timestamp st, @Param("et")Timestamp et);
	List<HeatmapDataEntity> getHeatmapDataByDay(@Param("rank_id") Integer rank_id, @Param("st")Timestamp st, @Param("et")Timestamp et);
	List<HeatmapDataEntity> getHeatmapDataByMonth(@Param("rank_id") Integer rank_id, @Param("st")Timestamp st, @Param("et")Timestamp et);
	Integer insertmapData(HeatmapDataEntity heatmap);
}
