package com.db.stock.TransactionManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;

@ExtendWith(MockitoExtension.class)
public class TestTradeService {
	
	@Mock
	TradeRepository tradeRepository;
	
	@InjectMocks
	TradeService tradeService;

	@Test
	void testAddTrade()
	{
		Trade t =  new Trade();
		t.setBookId("B1");
        t.setCounterPartyId("c1");
        SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        t.setCreatedDate(now);
        t.setMaturityDate(now);
        t.setTradeId("t1");
        t.setVersion(1);
        
        Mockito.when(tradeRepository.save(Mockito.any(Trade.class))).thenReturn(t);
        int result=tradeService.ExecuteTrade(t);
        
        assertEquals(1, result);
        
			
		}
	
	@Test
	void testUpdateMaturityFlag()
	{
		Trade t =  new Trade();
        
        Mockito.when(tradeRepository.updateExpiryFlag()).thenReturn(0);
        int result=tradeService.updateExpiry();
        
        assertEquals(0, result);
        
			
		}
	
}
