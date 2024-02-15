package com.samsung.tizen.web.service;

import java.util.List;

import com.samsung.tizen.web.vo.TizenBom;
import com.samsung.tizen.web.vo.TizenSummary;

public interface TizenBomLicenseService
{
	TizenSummary getSummary(String platformVersion);

	List<TizenBom> getList(String platformVersion);
}
