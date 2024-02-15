package com.samsung.tizen.web.vo;

public class TizenFoss
{
	private String name;
	private int foss;
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

	public int getFoss()
	{
		return foss;
	}

	public void setFoss(int foss)
	{
		this.foss = foss;
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
			percent = String.format("%.1f", foss / (double) total * 100.0);
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
