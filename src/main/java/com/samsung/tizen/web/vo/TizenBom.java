package com.samsung.tizen.web.vo;

public class TizenBom extends TizenBase
{
	private String projectId;
	private String platformVersion;
	private String fossComponent;
	private String version;
	private String license;
	private int totalFiles;
	private int relatedProject;

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

	public String getFossComponent()
	{
		return fossComponent;
	}

	public void setFossComponent(String fossComponent)
	{
		this.fossComponent = fossComponent;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getLicense()
	{
		return license;
	}

	public void setLicense(String license)
	{
		this.license = license;
	}

	public int getTotalFiles()
	{
		return totalFiles;
	}

	public void setTotalFiles(int totalFiles)
	{
		this.totalFiles = totalFiles;
	}

	public int getRelatedProject()
	{
		return relatedProject;
	}

	public void setRelatedProject(int relatedProject)
	{
		this.relatedProject = relatedProject;
	}
}
