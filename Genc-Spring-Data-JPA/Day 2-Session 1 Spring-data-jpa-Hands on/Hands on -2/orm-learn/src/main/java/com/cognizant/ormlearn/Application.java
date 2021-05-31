package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.StockService;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory; 
@SpringBootApplication
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static StockService stockService;
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		LOGGER.info("Inside main"); 
		stockService = context.getBean(StockService.class);
		//List<Stock> list=stockService.getByCodeAndDate();
		//List<Stock> list=stockService.getByCodeAndStockPrice();
		//List<Stock> list=stockService.getTop3ByVolume();
		List<Stock> list=stockService.getTop3ByCode();
		for(Stock s: list) {
			System.out.println(s.toString());
		}
		
		//System.out.println(stockService.getStocks());
		
		
		
	}

}
