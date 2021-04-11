package com.db.stock.TransactionManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TradeID.class)
public class Trade {

	@Id
	String tradeId;
	@Id
    long version;
    String counterPartyId;
    String bookId;
    Date maturityDate;
    Date createdDate;
    String isExpired;
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String isExpired() {
		return isExpired;
	}
	public void setExpired(String isExpired) {
		this.isExpired = isExpired;
	}
}
