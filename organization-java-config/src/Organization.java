package com.capgemini.spring.model;
import java.util.*;

public class Organization {
	private int organizationId;
	private String organizationName;
	private double marketPrice;
	private Address address;
	private List<String> directors;
	private Set<String> branches;
	private Map<String,String> branchWiseHead;
	private Properties ipAddresses;
	private Properties databaseDetails;
	
	public Organization(int organizationId, String organizationName, double marketPrice, Address address,
			List<String> directors, Set<String> branches, Map<String,String> branchWiseHead, Properties ipAddresses,
			Properties databaseDetails) {
		
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.marketPrice = marketPrice;
		this.address = address;
		this.directors = directors;
		this.branches = branches;
		this.branchWiseHead = branchWiseHead;
		this.ipAddresses = ipAddresses;
		this.databaseDetails = databaseDetails;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	

	public void setBranches(Set<String> branches) {
		this.branches = branches;
	}

	
	public void setBranchWiseHead(Map<String, String> branchWiseHead) {
		this.branchWiseHead = branchWiseHead;
	}

	
	public void setIpAddresses(Properties ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	

	public void setDatabaseDetails(Properties databaseDetails) {
		this.databaseDetails = databaseDetails;
	}
	
	@Override
		public String toString() {
			return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", marketPrice=" + marketPrice + ", address=" + address + ", directors=" + directors + ", branches="
				+ branches + ", branchWiseHead=" + branchWiseHead + ", ipAddresses=" + ipAddresses
				+ ", databaseDetails=" + databaseDetails + "]";
		}
	
}