package com.samsung.tizen.web.dao;

import java.util.List;

import com.samsung.tizen.web.vo.TizenFoss;
import com.samsung.tizen.web.vo.TizenLicense;
import com.samsung.tizen.web.vo.TizenProject;
import com.samsung.tizen.web.vo.TizenStatus;
import com.samsung.tizen.web.vo.TizenVersion;

public interface TizenCommonDao
{
	final String MAPPER_NS = "com.samsung.tizen.web.vo.TizenCommon";

	List<TizenVersion> getTizenVersionList();

	List<TizenStatus> getStatus(String platformVersion);

	List<TizenFoss> getFoss(String platformVersion);

	List<TizenLicense> getLicense(String platformVersion);

	List<TizenProject> getFossProject(String platformVersion, String fossComponent, String version);

	List<TizenProject> getLicenseProject(String platformVersion, String license);
}
