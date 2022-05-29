package com.example.findyourdelight.models;

import com.google.gson.annotations.SerializedName;

public class CreateMenuResponse{

	@SerializedName("success")
	private boolean success;

	@SerializedName("Result")
	private Result result;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"CreateMenuResponse{" + 
			"success = '" + success + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}