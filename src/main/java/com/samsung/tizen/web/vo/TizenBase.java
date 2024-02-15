package com.samsung.tizen.web.vo;

import java.util.Date;

public class TizenBase
{
	private Date firstRegDt;
	private String firstRegId;
	private Date lastModDt;
	private String lastModrId;

	public TizenBase()
	{
	}

	public Date getFirstRegDt()
	{
		return firstRegDt;
	}

	public void setFirstRegDt(Date firstRegDt)
	{
		this.firstRegDt = firstRegDt;
	}

	public String getFirstRegId()
	{
		return firstRegId;
	}

	public void setFirstRegId(String firstRegId)
	{
		this.firstRegId = firstRegId;
	}

	public Date getLastModDt()
	{
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt)
	{
		this.lastModDt = lastModDt;
	}

	public String getLastModrId()
	{
		return lastModrId;
	}

	public void setLastModrId(String lastModrId)
	{
		this.lastModrId = lastModrId;
	}
}
