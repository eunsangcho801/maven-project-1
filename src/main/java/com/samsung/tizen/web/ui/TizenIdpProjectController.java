package com.samsung.tizen.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.tizen.web.service.TizenCommonService;
import com.samsung.tizen.web.service.TizenIdpService;

@Controller
@RequestMapping("/dashboard")
public class TizenIdpProjectController
{
	@Autowired
	private TizenCommonService commonService;

	@Autowired
	private TizenIdpService idpService;

	@RequestMapping("/idpProjectList")
	public String idpProjectList(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion,
			@RequestParam(value = "status", defaultValue = "all") String status, Model model)
	{
		model.addAttribute("platformVersion", platformVersion);
		model.addAttribute("status", status);
		model.addAttribute("tizenVerList", commonService.getTizenVersionList());
		
		model.addAttribute("comStatus", commonService.getStatus(platformVersion));
		model.addAttribute("comLicense", commonService.getLicense(platformVersion));

		model.addAttribute("idpSummary", idpService.getSummary(platformVersion));
		model.addAttribute("idpList", idpService.getList(platformVersion, status));

		return "dashboard/idpProjectList";
	}
}
