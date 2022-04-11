package com.tezzio.demo.Book.v1;

public class Sorter {
	private String sortBy;
	public Sorter(String sortBy) {
		this.sortBy = sortBy;
	}
	
	public String getSortBy() {
		return this.sortBy;
	}
	
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
