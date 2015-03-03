package com.example.collegelist;



// Store information about the item that is for sale
public class ItemForSale {
	
	private String title;
	private String description;
	private int imgID;
	
	public ItemForSale(String itemTitle, String itemDescription, int itemImgID){
		super();
		this.title = itemTitle;
		this.description = itemDescription;
		this.imgID = itemImgID;
		
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getPictureID(){
		return imgID;
	}

}
