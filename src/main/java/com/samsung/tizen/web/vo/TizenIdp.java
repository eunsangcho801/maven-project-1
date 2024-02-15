package com.samsung.tizen.web.vo;

public class TizenIdp extends TizenBase
{
	private String projectId;
	private String platformVersion;
	private String projectName;
	private String owner;
	private String status;
	private String lastAnalyzed;
	private String lastModified;
	private int totalFiles;
	private int matchedFiles;
	private int pendingFiles;
	private int conflict;
	private String defaultLicense;
	private String git;

	public String getProjectId()
	{
		return projectId;
	}

	public void setProjectId(String projectId)
	{
		this.projectId = projectId;
	}

	public String getPlatformVersion()
	{
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion)
	{
		this.platformVersion = platformVersion;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getLastAnalyzed()
	{
		return lastAnalyzed;
	}

	public void setLastAnalyzed(String lastAnalyzed)
	{
		this.lastAnalyzed = lastAnalyzed;
	}

	public String getLastModified()
	{
		return lastModified;
	}

	public void setLastModified(String lastModified)
	{
		this.lastModified = lastModified;
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

	public int getConflict()
	{
		return conflict;
	}

	public void setConflict(int conflict)
	{
		this.conflict = conflict;
	}

	public String getDefaultLicense()
	{
		return defaultLicense;
	}

	public void setDefaultLicense(String defaultLicense)
	{
		this.defaultLicense = defaultLicense;
	}

	public String getGit()
	{
		return git;
	}

	public void setGit(String git)
	{
		this.git = git;
	}
}
