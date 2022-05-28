package com.example.findyourdelight.models;

import java.util.List;

public class MenuResponse{
	private int totalMenu;
	private List<ResultItem> result;

	public void setTotalMenu(int totalMenu){
		this.totalMenu = totalMenu;
	}

	public int getTotalMenu(){
		return totalMenu;
	}

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"MenuResponse{" + 
			"total Menu = '" + totalMenu + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}