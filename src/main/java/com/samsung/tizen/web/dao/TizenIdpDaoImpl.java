package com.samsung.tizen.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samsung.tizen.web.vo.TizenIdp;
import com.samsung.tizen.web.vo.TizenSummary;

@Repository
public class TizenIdpDaoImpl implements TizenIdpDao
{
	@Autowired
	private SqlSession session;

	@Override
	public TizenSummary getSummary(String platformVersion)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		return session.selectOne(String.format("%s.selectTizenSummary", MAPPER_NS), condition);
	}

	@Override
	public List<TizenIdp> getList(String platformVersion, String status)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		condition.put("status", status);
		return session.selectList(String.format("%s.selectTizenIdpList", MAPPER_NS), condition);
	}

	@Override
	public List<Object> getExcelList(String platformVersion, String status)
	{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("platformVersion", platformVersion);
		condition.put("status", status);
		return session.selectList(String.format("%s.selectTizenIdpList", MAPPER_NS), condition);
	}
}
