package com.samsung.tizen.web.vo;

public class TizenSummary
{
	private int cnt;
	private int owner;
	private int totalFiles;
	private int matchedFiles;
	private int pendingFiles;
	private String pendingPercent;

	private int conflict;

	public int getCnt()
	{
		return cnt;
	}

	public void setCnt(int cnt)
	{
		this.cnt = cnt;
	}

	public int getOwner()
	{
		return owner;
	}

	public void setOwner(int owner)
	{
		this.owner = owner;
	}

	public int getTotalFiles()
	{
		return totalFiles;
	}

	public void setTotalFiles(int totalFiles)
	{
		this.totalFiles = totalFiles;
	}

	public int getMatchedFiles()
	{
		return matchedFiles;
	}

	public void setMatchedFiles(int matchedFiles)
	{
		this.matchedFiles = matchedFiles;
	}

	public int getPendingFiles()
	{
		return pendingFiles;
	}

	public void setPendingFiles(int pendingFiles)
	{
		this.pendingFiles = pendingFiles;
	}

	public String getPendingPercent()
	{
		try
		{
			pendingPercent = String.format("%.1f", pendingFiles / (double) matchedFiles * 100.0);
		}
		catch (Exception e)
		{
			pendingPercent = "0.0";
		}
		finally
		{
			pendingPercent = ("NaN".equals(pendingPercent) ? "0.0" : pendingPercent);
		}

		return pendingPercent;
	}

	public void setPendingPercent(String pendingPercent)
	{
		this.pendingPercent = pendingPercent;
	}

	public int getConflict()
	{
		return conflict;
	}

	public void setConflict(int conflict)
	{
		this.conflict = conflict;
	}
}
