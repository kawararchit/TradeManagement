package com.db.stock.TransactionManagement.service;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;

public class RejectTrade implements ProcessTrade {

	private ProcessTrade nextTradeProcessor;

	@Override
	public void setNextTradeType(ProcessTrade nextTradeProcessor) {
		this.nextTradeProcessor=nextTradeProcessor;
		
	}

	@Override
	public int process(Trade t, long existingLatestVersion,TradeRepository tradeRepository) {
	if (t.getVersion()<existingLatestVersion)
		return 3;
	else 
		return this.nextTradeProcessor.process(t, existingLatestVersion,tradeRepository);
	}

}
