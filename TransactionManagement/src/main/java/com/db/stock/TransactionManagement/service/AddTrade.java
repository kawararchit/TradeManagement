package com.db.stock.TransactionManagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;

public class AddTrade implements ProcessTrade {
	
	private ProcessTrade nextTradeProcessor;

	

	@Override
	public void setNextTradeType(ProcessTrade nextTradeProcessor) {
		this.nextTradeProcessor=nextTradeProcessor;
		
	}

	@Override
	public int process(Trade t, long existingLatestVersion,TradeRepository tradeRepository) {
		try
		{
			tradeRepository.save(t);
		return 1;
		}
		catch (Exception e) {
			return 0;
		}
		
	}

	
	

}
