package com.samsung.tizen.web.dao;

import java.util.List;

import com.samsung.tizen.web.vo.TizenIdp;
import com.samsung.tizen.web.vo.TizenSummary;

public interface TizenIdpDao
{
	final String MAPPER_NS = "com.samsung.tizen.web.vo.TizenIdp";

	TizenSummary getSummary(String platformVersion);

	List<TizenIdp> getList(String platformVersion, String status);

	List<Object> getExcelList(String platformVersion, String status);
}
