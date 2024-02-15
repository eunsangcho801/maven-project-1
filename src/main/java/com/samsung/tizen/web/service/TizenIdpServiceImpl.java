package com.samsung.tizen.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.tizen.web.dao.TizenIdpDao;
import com.samsung.tizen.web.vo.TizenIdp;
import com.samsung.tizen.web.vo.TizenSummary;

@Service
public class TizenIdpServiceImpl implements TizenIdpService
{
	@Autowired
	private TizenIdpDao idpDao;

	@Override
	public TizenSummary getSummary(String platformVersion)
	{
		return idpDao.getSummary(platformVersion);
	}

	@Override
	public List<TizenIdp> getList(String platformVersion, String status)
	{
		return idpDao.getList(platformVersion, status);
	}
}
