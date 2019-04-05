package com.stock.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.CompanyStockDAO;
import com.stock.model.CompanyInfo;
import com.stock.model.ResponseStock;

@Service
public class CompanyStockService {

	@Autowired
	CompanyStockDAO companyStockdao;

	@Autowired
	ResponseStock responseStock;

	@Autowired
	CompanyInfo companyInfo;

	private LocalDate startDate;

	private LocalDate endDate;

	public List<ResponseStock> getAllCompanyStock() {

		getWeekDate();
		System.out.println(startDate);
		System.out.println(endDate);

		List<ResponseStock> reponseStockList = new ArrayList<ResponseStock>();

		List<CompanyInfo> companyDetails = companyStockdao.getBystockPriceDateGreaterThanEqual(startDate, endDate);

		List<String> companyIds = new ArrayList<>();

		for (CompanyInfo csl : companyDetails) {
			if (!companyIds.contains(csl.getCompanyId())) {
				companyIds.add(csl.getCompanyId());
			}
		}
		for (String id : companyIds) {
			ResponseStock responseStock = new ResponseStock();
			double Weekmax = companyDetails.stream().filter(cd -> cd.getCompanyId().equals(id))
					.max(Comparator.comparingDouble(CompanyInfo::getStockPrice)).get().getStockPrice();
			double Weekmin = companyDetails.stream().filter(cd -> cd.getCompanyId().equals(id))
					.min(Comparator.comparingDouble(CompanyInfo::getStockPrice)).get().getStockPrice();
			responseStock.setCompanyId(id);
			responseStock.setCompanyName(
					companyDetails.stream().filter(cd -> cd.getCompanyId().equals(id)).findFirst().get().getCompanyName());
			long val1 = companyDetails.stream()
					.filter(cd -> cd.getStockPriceDate().equals(LocalDate.now().minusDays(1)))
					.filter(cd -> cd.getCompanyId().equals(id)).count();
			double price_prev = 0.0;
			if (val1 > 0) {
				price_prev = companyDetails.stream()
						.filter(cd -> cd.getStockPriceDate().equals(LocalDate.now().minusDays(1)))
						.filter(cd -> cd.getCompanyId().equals(id)).findFirst().get().getStockPrice();
			}
			double price_today = 0.0;
			long val2 = companyDetails.stream().filter(cd -> cd.getStockPriceDate().equals(LocalDate.now()))
					.filter(cd -> cd.getCompanyId().equals(id)).count();
			if (val2 > 0) {
				price_today = companyDetails.stream().filter(cd -> cd.getStockPriceDate().equals(LocalDate.now()))
						.filter(cd -> cd.getCompanyId().equals(id)).findFirst().get().getStockPrice();
			}
			double todayprice = 0.0;
			
			long val3 = companyDetails.stream()
					.filter(cd -> cd.getStockPriceDate().equals(LocalDate.now())).filter(cd->cd.getCompanyId().equals(id)).count();
			
			if(val3 >0) {
				todayprice = companyDetails.stream()
				.filter(cd -> cd.getStockPriceDate().equals(LocalDate.now())).filter(cd->cd.getCompanyId().equals(id)).findFirst().get().getStockPrice();
			}
			responseStock.setDiffInStockFromLastDay(Math.abs(price_prev - price_today));
			responseStock.setWeekHigh(Weekmax);
			responseStock.setWeekLow(Weekmin);
			responseStock.setTodayDate(LocalDate.now().toString());
			responseStock.setStockPrice(todayprice);
			reponseStockList.add(responseStock);
		}
		return reponseStockList;
	}
	private void getWeekDate() {
		DayOfWeek FirstDayOfWeek = WeekFields.of(Locale.ENGLISH).getFirstDayOfWeek();

		DayOfWeek lastDayOfWeek = DayOfWeek.of(((FirstDayOfWeek.getValue() + 5) % DayOfWeek.values().length) + 1);
		startDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(FirstDayOfWeek));
		endDate = LocalDate.now().with(TemporalAdjusters.nextOrSame(lastDayOfWeek));

	}
	public List<CompanyInfo> getAllCompanyStocksById(String id) {
		return companyStockdao.findByCompanyId(id);
	}

	public String deleteById(String companyId) {
		companyStockdao.deleteByCompanyId(companyId);
		return "success";
	}
}
