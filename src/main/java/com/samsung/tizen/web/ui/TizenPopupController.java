package com.samsung.tizen.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.tizen.web.service.TizenCommonService;

@Controller
@RequestMapping("/popup")
public class TizenPopupController
{
	@Autowired
	private TizenCommonService commonService;

	@RequestMapping("/fossPop")
	public String fossPop(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion, Model model)
	{
		model.addAttribute("comFoss", commonService.getFoss(platformVersion));

		return "popup/fossPop";
	}

	@RequestMapping("/licensePop")
	public String licensePop(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion, Model model)
	{
		model.addAttribute("comLicense", commonService.getLicense(platformVersion));
		return "popup/licensePop";
	}

	@RequestMapping("/fossProjectPop")
	public String fossProjectPop(@RequestParam("platformVersion") String platformVersion, @RequestParam("fossComponent") String fossComponent,
			@RequestParam("version") String version, Model model)
	{
		model.addAttribute("popTitle", fossComponent);
		model.addAttribute("comProject", commonService.getFossProject(platformVersion, fossComponent, version));

		return "popup/projectPop";
	}

	@RequestMapping("/licenseProjectPop")
	public String licenseProjectPop(@RequestParam("platformVersion") String platformVersion, @RequestParam("license") String license, Model model)
	{
		model.addAttribute("popTitle", license);
		model.addAttribute("comProject", commonService.getLicenseProject(platformVersion, license));

		return "popup/projectPop";
	}
}
