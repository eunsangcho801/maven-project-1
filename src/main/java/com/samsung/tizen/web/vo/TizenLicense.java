package com.samsung.tizen.web.vo;

public class TizenLicense
{
	private String name;
	private int license;
	private int total;
	private String percent;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLicense()
	{
		return license;
	}

	public void setLicense(int license)
	{
		this.license = license;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public String getPercent()
	{
		try
		{
			percent = String.format("%.1f", license / (double) total * 100.0);
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
