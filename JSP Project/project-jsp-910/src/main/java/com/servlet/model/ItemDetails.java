package com.servlet.model;
import java.sql.Date;
public class ItemDetails {
	
	
	private int detailId;

    private int itemId;

    private String description;

    private String category;

    private String brand;

    private String color;

    private double weight;

    private String imagePath;

    private Date manufactureDate;

    private Date expiryDate;

    private String status;
    
    public ItemDetails() {
    }

    public ItemDetails(
            int detailId,
            int itemId,
            String description,
            String category,
            String brand,
            String color,
            double weight,
            String imagePath,
            Date manufactureDate,
            Date expiryDate,
            String status) {

        this.detailId = detailId;
        this.itemId = itemId;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.weight = weight;
        this.imagePath = imagePath;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
    
    

}
