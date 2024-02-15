package com.samsung.tizen.web.service;

import java.util.List;

import com.samsung.tizen.web.vo.TizenIdp;
import com.samsung.tizen.web.vo.TizenSummary;

public interface TizenIdpService
{
	TizenSummary getSummary(String platformVersion);
	
	List<TizenIdp> getList(String platformVersion, String status);
}
