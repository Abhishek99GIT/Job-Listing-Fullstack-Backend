package com.example.joblisting.models;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sample_analytics")
public class Account {
	public Account(){}
	
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", limit=" + limit + ", products=" + Arrays.toString(products)
				+ "]";
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String[] getProducts() {
		return products;
	}
	public void setProducts(String[] products) {
		this.products = products;
	}
	private int account_id;
	private int limit;
	private String[] products;
}
