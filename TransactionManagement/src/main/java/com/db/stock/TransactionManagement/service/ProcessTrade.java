package com.db.stock.TransactionManagement.service;

import com.db.stock.TransactionManagement.Repository.TradeRepository;
import com.db.stock.TransactionManagement.model.Trade;

public interface ProcessTrade {
	
	void  setNextTradeType( ProcessTrade nextTradeProcessor);
	
	int process(Trade t,long existingLatestVersion,TradeRepository tradeRepository);

}
