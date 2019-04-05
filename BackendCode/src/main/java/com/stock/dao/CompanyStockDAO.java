package com.stock.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stock.model.CompanyInfo;



public interface CompanyStockDAO extends MongoRepository<CompanyInfo,String>{
	List<CompanyInfo> findByCompanyId(String id);
	List<CompanyInfo> getBystockPriceDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);
	void deleteByCompanyId(String companyId);
}
