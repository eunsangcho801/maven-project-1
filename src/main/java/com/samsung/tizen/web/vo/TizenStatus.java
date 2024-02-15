package com.samsung.tizen.web.vo;

public class TizenStatus
{
	private String status;
	private int cnt;
	private int tot;
	private String percent;

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getCnt()
	{
		return cnt;
	}

	public void setCnt(int cnt)
	{
		this.cnt = cnt;
	}

	public int getTot()
	{
		return tot;
	}

	public void setTot(int tot)
	{
		this.tot = tot;
	}

	public String getPercent()
	{
		try
		{
			percent = String.format("%.1f", cnt / (double) tot * 100.0);
		}
		catch (Exception e)
		{
			percent = "0.0";
		}
		finally
		{
			percent = ("NaN".equals(percent) ? "0.0" : percent);
		}

		return percent;
	}

	public void setPercent(String percent)
	{
		this.percent = percent;
	}
}
