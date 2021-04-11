package com.db.stock.TransactionManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;
@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TradeService implements ITradeService {

	@Autowired
	TradeRepository tradeRepository;
	@Override
	public int ExecuteTrade(Trade t) {
		long existingLatestVersion=0;
		try 
		{
		 existingLatestVersion=tradeRepository.findByTradeId(t.getTradeId());
		}
		catch (Exception e) {
			
		}
		ProcessTrade p1=new RejectTrade();
		ProcessTrade p2=new UpdateTrade();
		ProcessTrade p3=new AddTrade();
		p1.setNextTradeType(p2);
		p2.setNextTradeType(p3);
		return p1.process(t, existingLatestVersion,tradeRepository);
		
	}

	@Override
	@Scheduled(fixedDelay = 10000,initialDelay = 20000)
	public int updateExpiry() {
		// TODO Auto-generated method stub
		return tradeRepository.updateExpiryFlag();
	}

}
