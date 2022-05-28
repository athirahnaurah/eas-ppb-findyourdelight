package com.example.findyourdelight.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultItem{
	private List<String> images;
	private String menuname;

	@SerializedName("__v")
	private int V;
	private String description;

	@SerializedName("_id")
	private String id;

	public ResultItem(List<String> images, String menuname, String description) {
		this.images = images;
		this.menuname = menuname;
		this.description = description;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
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
			"ResultItem{" + 
			"images = '" + images + '\'' + 
			",menuname = '" + menuname + '\'' + 
			",__v = '" + V + '\'' + 
			",description = '" + description + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}