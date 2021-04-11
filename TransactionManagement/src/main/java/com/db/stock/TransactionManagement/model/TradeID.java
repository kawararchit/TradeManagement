package com.db.stock.TransactionManagement.model;

import java.io.Serializable;

public class TradeID  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tradeId;
	private long version;
	
	public TradeID()
	{
		
	}

	public TradeID(String tradeId,long version)
	{
		this.tradeId=tradeId;
		this.version=version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + (int) (version ^ (version >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeID other = (TradeID) obj;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
