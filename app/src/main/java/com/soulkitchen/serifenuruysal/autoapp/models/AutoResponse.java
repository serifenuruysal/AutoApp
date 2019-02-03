package com.soulkitchen.serifenuruysal.autoapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class AutoResponse {

	@SerializedName("wkda")
	private HashMap<String,String> wkda;

	@SerializedName("pageSize")
	private int pageSize;

	@SerializedName("totalPageCount")
	private int totalPageCount;

	@SerializedName("page")
	private int page;

	public void setWkda(HashMap<String,String> responseData){
		this.wkda=responseData;
	}

	public HashMap<String, String> getWkda() {
		return wkda;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setTotalPageCount(int totalPageCount){
		this.totalPageCount = totalPageCount;
	}

	public int getTotalPageCount(){
		return totalPageCount;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return
			"AutoResponse{" +
			"wkda = '" + wkda + '\'' +
			",pageSize = '" + pageSize + '\'' +
			",totalPageCount = '" + totalPageCount + '\'' +
			",page = '" + page + '\'' +
			"}";
		}
}