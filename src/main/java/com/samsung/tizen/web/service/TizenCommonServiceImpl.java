package com.samsung.tizen.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.tizen.web.dao.TizenCommonDao;
import com.samsung.tizen.web.vo.TizenFoss;
import com.samsung.tizen.web.vo.TizenLicense;
import com.samsung.tizen.web.vo.TizenProject;
import com.samsung.tizen.web.vo.TizenStatus;
import com.samsung.tizen.web.vo.TizenVersion;

@Service
public class TizenCommonServiceImpl implements TizenCommonService
{
	@Autowired
	private TizenCommonDao commonDao;

	@Override
	public List<TizenVersion> getTizenVersionList()
	{
		return commonDao.getTizenVersionList();
	}

	@Override
	public List<TizenStatus> getStatus(String platformVersion)
	{
		return commonDao.getStatus(platformVersion);
	}

	@Override
	public List<TizenFoss> getFoss(String platformVersion)
	{
		return commonDao.getFoss(platformVersion);
	}

	@Override
	public List<TizenLicense> getLicense(String platformVersion)
	{
		return commonDao.getLicense(platformVersion);
	}

	@Override
	public List<TizenProject> getFossProject(String platformVersion, String fossComponent, String version)
	{
		return commonDao.getFossProject(platformVersion, fossComponent, version);
	}

	@Override
	public List<TizenProject> getLicenseProject(String platformVersion, String license)
	{
		return commonDao.getLicenseProject(platformVersion, license);
	}
}
