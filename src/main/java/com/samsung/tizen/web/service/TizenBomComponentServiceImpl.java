package com.samsung.tizen.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.tizen.web.dao.TizenBomComponentDao;
import com.samsung.tizen.web.vo.TizenBom;
import com.samsung.tizen.web.vo.TizenSummary;

@Service
public class TizenBomComponentServiceImpl implements TizenBomComponentService
{
	@Autowired
	private TizenBomComponentDao bomComponentDao;

	@Override
	public TizenSummary getSummary(String platformVersion)
	{
		return bomComponentDao.getSummary(platformVersion);
	}
	@Override
	public List<TizenBom> getList(String platformVersion)
	{
		return bomComponentDao.getList(platformVersion);
	}
}
