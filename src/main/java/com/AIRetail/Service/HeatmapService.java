package com.AIRetail.Service;

import java.sql.Timestamp;
import com.AIRetail.Model.HeatMapDataModel;

public interface HeatmapService {
	HeatMapDataModel getHmDataANDStruct(Integer rank_id, Timestamp st, Timestamp et,String type);
}
