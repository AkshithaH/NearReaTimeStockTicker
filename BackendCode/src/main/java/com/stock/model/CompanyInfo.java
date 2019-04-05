package com.stock.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class CompanyInfo {
	
	String companyId;
	
	String companyName;
	
	@Id
	String DateId;
	
	LocalDate stockPriceDate;
	
	double stockPrice;
	
	public CompanyInfo() {
		
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDateId() {
		return DateId;
	}

	public void setDateId(String dateId) {
		DateId = dateId;
	}

	public LocalDate getStockPriceDate() {
		return stockPriceDate;
	}

	public void setStockPriceDate(LocalDate stockPriceDate) {
		this.stockPriceDate = stockPriceDate;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateId == null) ? 0 : DateId.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(stockPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stockPriceDate == null) ? 0 : stockPriceDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyInfo other = (CompanyInfo) obj;
		if (DateId == null) {
			if (other.DateId != null)
				return false;
		} else if (!DateId.equals(other.DateId))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (Double.doubleToLongBits(stockPrice) != Double.doubleToLongBits(other.stockPrice))
			return false;
		if (stockPriceDate == null) {
			if (other.stockPriceDate != null)
				return false;
		} else if (!stockPriceDate.equals(other.stockPriceDate))
			return false;
		return true;
	}
	
	
}
