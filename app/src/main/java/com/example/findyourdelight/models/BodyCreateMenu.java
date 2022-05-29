package com.example.findyourdelight.models;

import com.google.gson.annotations.SerializedName;

public class BodyCreateMenu{

	@SerializedName("menuname")
	private String menuname;

	@SerializedName("description")
	private String description;

	public void setMenuname(String menuname){
		this.menuname = menuname;
	}

	public String getMenuname(){
		return menuname;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"BodyCreateMenu{" + 
			"menuname = '" + menuname + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}