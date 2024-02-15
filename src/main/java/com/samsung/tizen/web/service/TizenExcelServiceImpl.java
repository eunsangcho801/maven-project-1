package com.samsung.tizen.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.tizen.web.dao.TizenBomComponentDao;
import com.samsung.tizen.web.dao.TizenBomLicenseDao;
import com.samsung.tizen.web.dao.TizenIdpDao;

@Service
public class TizenExcelServiceImpl implements TizenExcelService
{
	@Autowired
	private TizenIdpDao idpDao;

	@Autowired
	private TizenBomComponentDao bomComponentDao;

	@Autowired
	private TizenBomLicenseDao bomLicenseDao;

	@Override
	public List<Object> getExcelList(String platformVersion, String target, String status)
	{
		if (target.equals("idpProjectList"))
			return idpDao.getExcelList(platformVersion, status);

		if (target.equals("bomComponentList"))
			return bomComponentDao.getExcelList(platformVersion);

		if (target.equals("bomLicenseList"))
			return bomLicenseDao.getExcelList(platformVersion);

		return null;
	}
}
