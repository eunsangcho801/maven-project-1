package com.samsung.tizen.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.tizen.web.service.TizenBomLicenseService;
import com.samsung.tizen.web.service.TizenCommonService;

@Controller
@RequestMapping("/dashboard")
public class TizenBomLicenseController
{
	@Autowired
	private TizenCommonService commonService;

	@Autowired
	private TizenBomLicenseService bomLicenseService;

	@RequestMapping("/bomLicenseList")
	public String idpProjectList(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion, Model model)
	{
		model.addAttribute("platformVersion", platformVersion);
		
		model.addAttribute("tizenVerList", commonService.getTizenVersionList());
		model.addAttribute("comStatus", commonService.getStatus(platformVersion));
		model.addAttribute("comLicense", commonService.getLicense(platformVersion));
		model.addAttribute("comFoss", commonService.getFoss(platformVersion));

		model.addAttribute("bomSummary", bomLicenseService.getSummary(platformVersion));
		model.addAttribute("bomList", bomLicenseService.getList(platformVersion));

		return "dashboard/bomLicenseList";
	}
}
