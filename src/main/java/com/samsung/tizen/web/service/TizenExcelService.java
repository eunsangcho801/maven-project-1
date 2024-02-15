package com.samsung.tizen.web.service;

import java.util.List;

public interface TizenExcelService
{
	public List<Object> getExcelList(String platformVersion, String target, String status);
}
