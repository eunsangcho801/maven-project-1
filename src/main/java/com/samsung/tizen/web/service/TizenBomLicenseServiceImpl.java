package com.samsung.tizen.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.tizen.web.dao.TizenBomLicenseDao;
import com.samsung.tizen.web.vo.TizenBom;
import com.samsung.tizen.web.vo.TizenSummary;

@Service
public class TizenBomLicenseServiceImpl implements TizenBomLicenseService
{
	@Autowired
	private TizenBomLicenseDao bomLicenseDao;

	@Override
	public List<TizenBom> getList(String platformVersion)
	{
		return bomLicenseDao.getList(platformVersion);
	}

	@Override
	public TizenSummary getSummary(String platformVersion)
	{
		return bomLicenseDao.getSummary(platformVersion);
	}
}
