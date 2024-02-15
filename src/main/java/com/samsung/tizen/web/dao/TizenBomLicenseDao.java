package com.samsung.tizen.web.dao;

import java.util.List;

import com.samsung.tizen.web.vo.TizenBom;
import com.samsung.tizen.web.vo.TizenSummary;

public interface TizenBomLicenseDao
{
	final String MAPPER_NS = "com.samsung.tizen.web.vo.TizenBom";

	TizenSummary getSummary(String platformVersion);

	List<TizenBom> getList(String platformVersion);

	List<Object> getExcelList(String platformVersion);
}
