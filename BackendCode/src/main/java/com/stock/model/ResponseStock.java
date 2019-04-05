package com.stock.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseStock {
	private String companyId;
	private String companyName;
	private double stockPrice;
	private double diffInStockFromLastDay;
	private double weekHigh;
	private double weekLow;
	private String todayDate;
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String localDateTime) {
		this.todayDate = localDateTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public double getDiffInStockFromLastDay() {
		return diffInStockFromLastDay;
	}
	public void setDiffInStockFromLastDay(double diffInStockFromLastDay) {
		this.diffInStockFromLastDay = diffInStockFromLastDay;
	}
	public double getWeekHigh() {
		return weekHigh;
	}
	public void setWeekHigh(double weekHigh) {
		this.weekHigh = weekHigh;
	}
	public double getWeekLow() {
		return weekLow;
	}
	public void setWeekLow(double weekLow) {
		this.weekLow = weekLow;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(diffInStockFromLastDay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stockPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((todayDate == null) ? 0 : todayDate.hashCode());
		temp = Double.doubleToLongBits(weekHigh);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weekLow);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ResponseStock other = (ResponseStock) obj;
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
		if (Double.doubleToLongBits(diffInStockFromLastDay) != Double.doubleToLongBits(other.diffInStockFromLastDay))
			return false;
		if (Double.doubleToLongBits(stockPrice) != Double.doubleToLongBits(other.stockPrice))
			return false;
		if (todayDate == null) {
			if (other.todayDate != null)
				return false;
		} else if (!todayDate.equals(other.todayDate))
			return false;
		if (Double.doubleToLongBits(weekHigh) != Double.doubleToLongBits(other.weekHigh))
			return false;
		if (Double.doubleToLongBits(weekLow) != Double.doubleToLongBits(other.weekLow))
			return false;
		return true;
	}

	

}
