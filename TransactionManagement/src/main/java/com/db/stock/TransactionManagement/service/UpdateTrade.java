package com.db.stock.TransactionManagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;

public class UpdateTrade implements ProcessTrade {

	private ProcessTrade nextTradeProcessor;

	@Override
	public void setNextTradeType(ProcessTrade nextTradeProcessor) {
		this.nextTradeProcessor=nextTradeProcessor;
		
	}

	@Override
	public int process(Trade t, long existingLatestVersion,TradeRepository tradeRepository) {
	if(t.getVersion()==existingLatestVersion)
	{
		try
		{
			tradeRepository.save(t);
		return 2;
		}
		catch (Exception e) {
			return 0;
		}
	
	}
	else
		return this.nextTradeProcessor.process(t, existingLatestVersion,tradeRepository);
		
	}

}
