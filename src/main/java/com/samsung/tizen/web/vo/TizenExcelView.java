package com.samsung.tizen.web.vo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class TizenExcelView extends AbstractExcelView
{
	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> ModelMap, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String excelName = ModelMap.get("target").toString();
		HSSFSheet worksheet = workbook.createSheet(excelName);
		HSSFRow row = worksheet.createRow(0);

		if ("idpProjectList".equals(excelName))
		{
			row.createCell(0).setCellValue("Project");
			row.createCell(1).setCellValue("Owner");
			row.createCell(2).setCellValue("Status");
			row.createCell(3).setCellValue("Last Analyzed");
			row.createCell(4).setCellValue("Last Modified");
			row.createCell(5).setCellValue("Total Files");
			row.createCell(6).setCellValue("Matched Files");
			row.createCell(7).setCellValue("Pending Files");
			row.createCell(8).setCellValue("Default License");
			row.createCell(9).setCellValue("Conflict License");
			row.createCell(10).setCellValue("git");

			List<TizenIdp> list = (List<TizenIdp>) ModelMap.get("excelList");
			for (int i = 1; i < list.size() + 1; i++)
			{
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i - 1).getProjectName());
				row.createCell(1).setCellValue(list.get(i - 1).getOwner());
				row.createCell(2).setCellValue(list.get(i - 1).getStatus());
				row.createCell(3).setCellValue(list.get(i - 1).getLastAnalyzed());
				row.createCell(4).setCellValue(list.get(i - 1).getLastModified());
				row.createCell(5).setCellValue(list.get(i - 1).getTotalFiles());
				row.createCell(6).setCellValue(list.get(i - 1).getMatchedFiles());
				row.createCell(7).setCellValue(list.get(i - 1).getPendingFiles());
				row.createCell(8).setCellValue(list.get(i - 1).getDefaultLicense());
				row.createCell(9).setCellValue(list.get(i - 1).getConflict());
				row.createCell(10).setCellValue(list.get(i - 1).getGit());
			}
		}
		else if ("bomComponentList".equals(excelName))
		{
			row.createCell(0).setCellValue("FOSS Component");
			row.createCell(1).setCellValue("Version");
			row.createCell(2).setCellValue("License");
			row.createCell(3).setCellValue("Total Files");
			row.createCell(4).setCellValue("Related Projects");

			List<TizenBom> list = (List<TizenBom>) ModelMap.get("excelList");
			for (int i = 1; i < list.size() + 1; i++)
			{
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i - 1).getFossComponent());
				row.createCell(1).setCellValue(list.get(i - 1).getVersion());
				row.createCell(2).setCellValue(list.get(i - 1).getLicense());
				row.createCell(3).setCellValue(list.get(i - 1).getTotalFiles());
				row.createCell(4).setCellValue(list.get(i - 1).getRelatedProject());
			}
		}
		else if ("bomLicenseList".equals(excelName))
		{
			row.createCell(0).setCellValue("License");
			row.createCell(1).setCellValue("Total Files");
			row.createCell(2).setCellValue("Related Projects");

			List<TizenBom> list = (List<TizenBom>) ModelMap.get("excelList");
			for (int i = 1; i < list.size() + 1; i++)
			{
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i - 1).getLicense());
				row.createCell(1).setCellValue(list.get(i - 1).getTotalFiles());
				row.createCell(2).setCellValue(list.get(i - 1).getRelatedProject());
			}
		}

		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename=" + excelName + "-excel");
	}
}