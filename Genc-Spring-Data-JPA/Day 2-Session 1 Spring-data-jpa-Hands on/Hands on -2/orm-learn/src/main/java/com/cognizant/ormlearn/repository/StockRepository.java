package com.cognizant.ormlearn.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String>{
	
	List<Stock> findByCodeAndDateBetween(String code, Date dateBefore, Date dateAfter);
	List<Stock> findByCodeAndCloseGreaterThan(String code, java.math.BigDecimal close);
	List<Stock> findTop3ByOrderByVolumeAsc();
	List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
	}
