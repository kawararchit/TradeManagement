package com.db.stock.TransactionManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.stock.TransactionManagement.Exception.RejectTradeException;
import com.db.stock.TransactionManagement.model.Trade;
import com.db.stock.TransactionManagement.service.ITradeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tradeservice")
@Api(value = "Trade Store Services", description = "This gives you liberation to Update and Add the trade")
public class TradeController {
	
	@Autowired
	ITradeService tradeService;
	
	@PostMapping(value = "/trade", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "To Add/update Trade use this Service",consumes =  "application/json")
	public String addTrade(@RequestBody @Validated Trade trade) {
		int result=tradeService.ExecuteTrade(trade);
		
		if (result==1)
			return "Trade Added Succesfully";
		else if (result==2)
			return "Trade Updated Succesfully";
		else if (result==3)
			throw new RejectTradeException("HIGHER VERSION IS ALREADY PRESENT");
		else
			throw new RuntimeException("ADD/Update Trade Failed");
		
					
	}
	
	@GetMapping(value = "/ExpiryFlag", produces = "application/json")
	@ApiOperation(value = "TO Update Expiry Flag")
	public long updateExpiryFlag() {
		return tradeService.updateExpiry();
	}


}
