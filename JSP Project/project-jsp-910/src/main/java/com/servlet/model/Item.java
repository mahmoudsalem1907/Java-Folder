package com.servlet.model;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private int id;
	private String name;
	private double price;
	private int totalNumberOfItems;
	
	private ItemDetails itemDetails;
	
	public ItemDetails getItemDetails() {
		return itemDetails;
	}


	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}


	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}


	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public Item() {
		super();
	}


	public Item(String name, double price, int totalNumberOfItems) {
		super();
		this.name = name;
		this.price = price;
		this.totalNumberOfItems = totalNumberOfItems;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Item(int id, String name, double price, int totalNumberOfItems ,ItemDetails itemDeatils) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumberOfItems = totalNumberOfItems;
		this.itemDetails =itemDeatils;
	}



}