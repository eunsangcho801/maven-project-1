package com.samsung.tizen.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samsung.tizen.web.vo.TizenFoss;
import com.samsung.tizen.web.vo.TizenLicense;
import com.samsung.tizen.web.vo.TizenProject;
import com.samsung.tizen.web.vo.TizenStatus;
import com.samsung.tizen.web.vo.TizenVersion;

@Repository
public class TizenCommonDaoImpl implements TizenCommonDao
{
	@Autowired
	private SqlSession session;

	@Override
	public List<TizenVersion> getTizenVersionList()
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		return session.selectList(String.format("%s.selectTizenVerList", MAPPER_NS), condition);
	}

	@Override
	public List<TizenStatus> getStatus(String platformVersion)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		return session.selectList(String.format("%s.selectTizenStatusList", MAPPER_NS), condition);
	}

	@Override
	public List<TizenFoss> getFoss(String platformVersion)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		return session.selectList(String.format("%s.selectTizenFossList", MAPPER_NS), condition);
	}

	@Override
	public List<TizenLicense> getLicense(String platformVersion)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		return session.selectList(String.format("%s.selectTizenLicenseList", MAPPER_NS), condition);
	}

	@Override
	public List<TizenProject> getFossProject(String platformVersion, String fossComponent, String version)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		condition.put("fossComponent", fossComponent);
		condition.put("version", version);
		
		return session.selectList(String.format("%s.selectTizenFossProjectList", MAPPER_NS), condition);
	}

	@Override
	public List<TizenProject> getLicenseProject(String platformVersion, String license)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		condition.put("license", license);
		
		return session.selectList(String.format("%s.selectTizenLicenseProjectList", MAPPER_NS), condition);
	}
}
