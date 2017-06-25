package com.cibil.gst.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="USER")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="user")

public class UserEntity implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private Integer ID;
	@Column(name="name")
	private String name;
	@Column(name="Address")
	private String Address;
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println("Name");
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "UserEntity [ID=" + ID + ", name=" + name + ", Address=" + Address + "]";
	}
	
	
	
}
