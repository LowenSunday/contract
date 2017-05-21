package org.sic.contract.entity;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable
{
	private static final long serialVersionUID = 351953605173085300L;
	private long cid;
	private String ctype;
	private long uid;
	private Date date_start;
	private Date date_end;
	private long contract_length;
	private long trail_length;
	private int hand_book_exist;

	public long getCid()
	{
		return cid;
	}

	public void setCid(long cid)
	{
		this.cid = cid;
	}

	public String getCtype()
	{
		return ctype;
	}

	public void setCtype(String ctype)
	{
		this.ctype = ctype;
	}

	public long getUid()
	{
		return uid;
	}

	public void setUid(long uid)
	{
		this.uid = uid;
	}

	public Date getDate_start()
	{
		return date_start;
	}

	public void setDate_start(Date date_start)
	{
		this.date_start = date_start;
	}

	public Date getDate_end()
	{
		return date_end;
	}

	public void setDate_end(Date date_end)
	{
		this.date_end = date_end;
	}

	public long getContract_length()
	{
		return contract_length;
	}

	public void setContract_length(long contract_length)
	{
		this.contract_length = contract_length;
	}

	public long getTrail_length()
	{
		return trail_length;
	}

	public void setTrail_length(long trail_length)
	{
		this.trail_length = trail_length;
	}

	public int getHand_book_exist()
	{
		return hand_book_exist;
	}

	public void setHand_book_exist(int hand_book_exist)
	{
		this.hand_book_exist = hand_book_exist;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
