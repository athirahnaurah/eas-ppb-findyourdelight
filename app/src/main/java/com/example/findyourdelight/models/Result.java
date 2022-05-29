package com.example.findyourdelight.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("images")
	private List<String> images;

	@SerializedName("imageId")
	private List<String> imageId;

	@SerializedName("menuname")
	private String menuname;

	@SerializedName("__v")
	private int V;

	@SerializedName("description")
	private String description;

	@SerializedName("_id")
	private String id;

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setImageId(List<String> imageId){
		this.imageId = imageId;
	}

	public List<String> getImageId(){
		return imageId;
	}

	public void setMenuname(String menuname){
		this.menuname = menuname;
	}

	public String getMenuname(){
		return menuname;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"images = '" + images + '\'' + 
			",imageId = '" + imageId + '\'' + 
			",menuname = '" + menuname + '\'' + 
			",__v = '" + V + '\'' + 
			",description = '" + description + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}