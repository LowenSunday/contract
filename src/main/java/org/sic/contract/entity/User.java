package org.sic.contract.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{

	private static final long serialVersionUID = 6874476411700853379L;
	private long uid;
	private String utype;
	private String emall;
	private String password;
	private String remember_token;
	private Date created_at;
	private Date updated_at;
	private String surname;
	private String first_name;
	private String gender;
	private String nationality;
	private String political_status;
	private Date birthday;
	private String china_id_num;
	private String edu_stats;
	private String graduated_from;
	private String hj_location;
	private String hk_type;
	private String hk_address;
	private String hk_postcode;
	private String now_address;
	private String now_postcode;
	private String mobile_num;
	private String tele_num;

	public long getUid()
	{
		return uid;
	}

	public void setUid(long uid)
	{
		this.uid = uid;
	}

	public String getUtype()
	{
		return utype;
	}

	public void setUtype(String utype)
	{
		this.utype = utype;
	}

	public String getEmall()
	{
		return emall;
	}

	public void setEmall(String emall)
	{
		this.emall = emall;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRemember_token()
	{
		return remember_token;
	}

	public void setRemember_token(String remember_token)
	{
		this.remember_token = remember_token;
	}

	public Date getCreated_at()
	{
		return created_at;
	}

	public void setCreated_at(Date created_at)
	{
		this.created_at = created_at;
	}

	public Date getUpdated_at()
	{
		return updated_at;
	}

	public void setUpdated_at(Date updated_at)
	{
		this.updated_at = updated_at;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getFirst_name()
	{
		return first_name;
	}

	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	public String getPolitical_status()
	{
		return political_status;
	}

	public void setPolitical_status(String political_status)
	{
		this.political_status = political_status;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String getChina_id_num()
	{
		return china_id_num;
	}

	public void setChina_id_num(String china_id_num)
	{
		this.china_id_num = china_id_num;
	}

	public String getEdu_stats()
	{
		return edu_stats;
	}

	public void setEdu_stats(String edu_stats)
	{
		this.edu_stats = edu_stats;
	}

	public String getGraduated_from()
	{
		return graduated_from;
	}

	public void setGraduated_from(String graduated_from)
	{
		this.graduated_from = graduated_from;
	}

	public String getHj_location()
	{
		return hj_location;
	}

	public void setHj_location(String hj_location)
	{
		this.hj_location = hj_location;
	}

	public String getHk_type()
	{
		return hk_type;
	}

	public void setHk_type(String hk_type)
	{
		this.hk_type = hk_type;
	}

	public String getHk_address()
	{
		return hk_address;
	}

	public void setHk_address(String hk_address)
	{
		this.hk_address = hk_address;
	}

	public String getHk_postcode()
	{
		return hk_postcode;
	}

	public void setHk_postcode(String hk_postcode)
	{
		this.hk_postcode = hk_postcode;
	}

	public String getNow_address()
	{
		return now_address;
	}

	public void setNow_address(String now_address)
	{
		this.now_address = now_address;
	}

	public String getNow_postcode()
	{
		return now_postcode;
	}

	public void setNow_postcode(String now_postcode)
	{
		this.now_postcode = now_postcode;
	}

	public String getMobile_num()
	{
		return mobile_num;
	}

	public void setMobile_num(String mobile_num)
	{
		this.mobile_num = mobile_num;
	}

	public String getTele_num()
	{
		return tele_num;
	}

	public void setTele_num(String tele_num)
	{
		this.tele_num = tele_num;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
