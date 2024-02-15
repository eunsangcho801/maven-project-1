package com.samsung.tizen.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.tizen.web.service.TizenBomComponentService;
import com.samsung.tizen.web.service.TizenCommonService;

@Controller
@RequestMapping("/dashboard")
public class TizenBomComponentController
{
	@Autowired
	private TizenCommonService commonService;

	@Autowired
	private TizenBomComponentService bomComponentService;
	
	@RequestMapping("/bomComponentList")
	public String idpProjectList(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion, Model model)
	{
		model.addAttribute("platformVersion", platformVersion);

		model.addAttribute("tizenVerList", commonService.getTizenVersionList());
		model.addAttribute("comStatus", commonService.getStatus(platformVersion));
		model.addAttribute("comFoss", commonService.getFoss(platformVersion));
		model.addAttribute("comLicense", commonService.getLicense(platformVersion));
		
		model.addAttribute("bomSummary", bomComponentService.getSummary(platformVersion));
		model.addAttribute("bomList", bomComponentService.getList(platformVersion));

		return "dashboard/bomComponentList";
	}
}
