package org.sic.contract.entity;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable
{
	private static final long serialVersionUID = 351953605173085300L;
	private static long cid;
	private static String ctype;
	private static long uid;
	private static Date date_start;
	private static Date date_end;
	private static long contract_length;
	private static long trail_length;
	private static int hand_book_exist;

	public long getCid()
	{
		return cid;
	}

	public void setCid(long cid)
	{
		Contract.cid = cid;
	}

	public static String getCtype()
	{
		return ctype;
	}

	public static void setCtype(String ctype)
	{
		Contract.ctype = ctype;
	}

	public static long getUid()
	{
		return uid;
	}

	public static void setUid(long uid)
	{
		Contract.uid = uid;
	}

	public static Date getDate_start()
	{
		return date_start;
	}

	public static void setDate_start(Date date_start)
	{
		Contract.date_start = date_start;
	}

	public static Date getDate_end()
	{
		return date_end;
	}

	public static void setDate_end(Date date_end)
	{
		Contract.date_end = date_end;
	}

	public static long getContract_length()
	{
		return contract_length;
	}

	public static void setContract_length(long contract_length)
	{
		Contract.contract_length = contract_length;
	}

	public static long getTrail_length()
	{
		return trail_length;
	}

	public static void setTrail_length(long trail_length)
	{
		Contract.trail_length = trail_length;
	}

	public static int getHand_book_exist()
	{
		return hand_book_exist;
	}

	public static void setHand_book_exist(int hand_book_exist)
	{
		Contract.hand_book_exist = hand_book_exist;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
