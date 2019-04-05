package com.stock.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stock.dao.CompanyStockDAO;
import com.stock.model.CompanyInfo;
import com.stock.model.ResponseStock;
import com.stock.service.CompanyStockService;

@RestController
@RequestMapping({ "/api/v1/" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockController {

	@Autowired
	CompanyStockService stockService;

	@Autowired
	CompanyInfo companyStock;

	@Autowired
	CompanyStockDAO companyStockdao;

	List<CompanyInfo> companyStockList;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public List<ResponseStock> findAll() {
		return stockService.getAllCompanyStock();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public CompanyInfo add(@RequestBody(required = true) CompanyInfo companyInfo) throws NullPointerException {
		companyStockList = new ArrayList<CompanyInfo>();
		LocalDate now = LocalDate.now();
		List<CompanyInfo> companyStockList = companyStockdao.findByCompanyId(companyInfo.getDateId());

		System.out.println(companyStockList);
		if (!companyStockList.isEmpty()) {
			for (CompanyInfo cs : companyStockList) {
				if (cs.getStockPriceDate().equals(now)) {
					cs.setCompanyId(cs.getCompanyId());
					cs.setCompanyName(cs.getCompanyName());
					cs.setStockPrice(companyInfo.getStockPrice());
					cs.setStockPriceDate(now);
					cs.setDateId(now + companyInfo.getCompanyId());
					companyStockdao.save(cs);
				}
				
			}
		} else {
			companyStock.setCompanyId(companyInfo.getCompanyId());
			companyStock.setCompanyName(companyInfo.getCompanyName());
			companyStock.setStockPrice(companyInfo.getStockPrice());
			companyStock.setStockPriceDate(now);
			companyStock.setDateId(now + companyInfo.getCompanyId());
			companyStockdao.save(companyStock);
		}

		return companyInfo;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{companyId}")
	public Map<String, Boolean> delete(@PathVariable("companyId") String companyId) {
		stockService.deleteById(companyId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping
	public CompanyInfo Update(@PathVariable CompanyInfo companyInfo) {
		return companyInfo;

	}

}
