package com.db.stock.TransactionManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db.stock.TransactionManagement.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {
	
    @Query("select max(version) from Trade where tradeId=:tradeId")
	long findByTradeId(@Param("tradeId") String tradeId);
    
    @Query("update Trade t set t.isExpired='Y' where t.isExpired='N' and t.maturityDate < CURRENT_DATE")
    @Modifying
	int updateExpiryFlag ();
    
  

    
    

}
