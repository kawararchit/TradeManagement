package com.db.stock.TransactionManagement.service;

import com.db.stock.TransactionManagement.model.Trade;

public interface ITradeService {
	
	public int ExecuteTrade(Trade t);
	public int updateExpiry();

}
