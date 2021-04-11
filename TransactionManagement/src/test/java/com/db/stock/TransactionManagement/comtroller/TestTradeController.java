package com.db.stock.TransactionManagement.comtroller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.db.stock.TransactionManagement.controller.TradeController;
import com.db.stock.TransactionManagement.model.Trade;
import com.db.stock.TransactionManagement.service.ITradeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TradeController.class)
@ActiveProfiles("test")

public class TestTradeController {
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	ITradeService tradeService;
	
	@Test
	public void AddTrade() throws Exception {

		Trade t =  new Trade();
		t.setBookId("B1");
        t.setCounterPartyId("c1");
        SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        t.setCreatedDate(now);
        t.setMaturityDate(now);
        t.setTradeId("t1");
        t.setVersion(1);
        
        Mockito.when(tradeService.ExecuteTrade(Mockito.any(Trade.class))).thenReturn(1);
        
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/tradeservice/trade")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(t));
        
        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void UpdateTrade() throws Exception {

		Trade t =  new Trade();
		t.setBookId("B1");
        t.setCounterPartyId("c1");
        SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        t.setCreatedDate(now);
        t.setMaturityDate(now);
        t.setTradeId("t1");
        t.setVersion(1);
        
        
        
    	Trade t1 =  new Trade();
    	t1.setBookId("B1");
        t1.setCounterPartyId("c1");
        //SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        //Date now=new Date();
        t1.setCreatedDate(now);
        t1.setMaturityDate(now);
        t1.setTradeId("t1");
        t1.setVersion(1);
        Mockito.when(tradeService.ExecuteTrade(Mockito.any(Trade.class))).thenReturn(1);
        Mockito.when(tradeService.ExecuteTrade(Mockito.any(Trade.class))).thenReturn(2);
        
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/tradeservice/trade")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(t));
        MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.post("/tradeservice/trade")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(t1));
        
        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(builder1).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test()
	public void rejectTrade() throws Exception {

		Trade t =  new Trade();
		t.setBookId("B1");
        t.setCounterPartyId("c1");
        SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        t.setCreatedDate(now);
        t.setMaturityDate(now);
        t.setTradeId("t2");
        t.setVersion(2);
        
        
        
    	Trade t1 =  new Trade();
    	t1.setBookId("B1");
        t1.setCounterPartyId("c1");
        //SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        //Date now=new Date();
        t1.setCreatedDate(now);
        t1.setMaturityDate(now);
        t1.setTradeId("t2");
        t1.setVersion(1);
        Mockito.when(tradeService.ExecuteTrade(Mockito.any(Trade.class))).thenReturn(1);
        Mockito.when(tradeService.ExecuteTrade(Mockito.any(Trade.class))).thenReturn(3);
        
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/tradeservice/trade")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(t));
        MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.post("/tradeservice/trade")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(t1));
        
        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isNotAcceptable());
        mockMvc.perform(builder1).andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}


}
