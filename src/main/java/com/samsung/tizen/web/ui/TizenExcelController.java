package com.samsung.tizen.web.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.tizen.web.service.TizenExcelService;

@Controller
@RequestMapping("/excel")
public class TizenExcelController
{
	@Autowired
	private TizenExcelService excelService;

	@RequestMapping("/excelDown")
	public String excelDown(@RequestParam(value = "platformVersion", defaultValue = "-1") String platformVersion, @RequestParam String target,
			@RequestParam(value = "status", defaultValue = "all") String status, Model model) throws Exception
	{
		List<Object> excelList = excelService.getExcelList(platformVersion, target, status);
		model.addAttribute("excelList", excelList);
		model.addAttribute("target", target);

		return "excelView";
	}
}
