package com.salary.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salary.entity.Salary;
import com.salary.export.CsvExporter;
import com.salary.repository.SalaryRepository;
import com.salary.service.SalaryService;

@Controller
public class CsvController {
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	SalaryRepository salaryRepository;

	@GetMapping("/salary_csv")
	public void exportToCsv(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");

		// set date
		DateFormat dateFormat = new SimpleDateFormat();
		String currentdateandTime = dateFormat.format(new Date());

		String header = "Content-disposition";

		// set file name
		String headerValue = "attachment; filename=allsalary_" + currentdateandTime + ".csv";
		response.setHeader(header, headerValue);

		// get data to list
		List<Salary> salaryList = new ArrayList<Salary>();
		List<Salary> salaryListAll = new ArrayList<Salary>();
		salaryListAll = salaryService.searchAll();
		for (int i = 0; salaryListAll.size() > i; i++) {
			if (salaryListAll.get(i).getUser_id() == 1) { // user.getIdが１のところに来る
				salaryList.add(salaryListAll.get(i));
			}
		}

		// insert data to fileddd
		CsvExporter csvExporter = new CsvExporter(salaryList);

		csvExporter.exportData(response);

	}
	
	@GetMapping("/salary_csv1")
	public void exportTocsv(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");

		// set date
		DateFormat dateFormat = new SimpleDateFormat();
		String currentdateandTime = dateFormat.format(new Date());

		String header = "Content-disposition";

		// set file name
		String headerValue = "attachment; filename=allsalary_" + currentdateandTime + ".csv";
		response.setHeader(header, headerValue);

		// get data to list
		List<Salary> salaryList = new ArrayList<Salary>();
		List<Salary> salaryListAll = new ArrayList<Salary>();
		salaryListAll = salaryService.searchAll();
		for (int i = 0; salaryListAll.size() > i; i++) {
			if (salaryListAll.get(i).getUser_id() == 1) { // user.getIdが１のところに来る
				salaryList.add(salaryListAll.get(i));
			}
		}

		// insert data to files
		CsvExporter csvExporter = new CsvExporter(salaryList);

		csvExporter.exportData(response);

	}
}
