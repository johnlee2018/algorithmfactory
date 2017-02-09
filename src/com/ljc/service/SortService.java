package com.ljc.service;



public interface SortService{
	

	
	/**
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	public String bubbleSort(String nums);
	
	/**
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	public String quickSort(String nums);
	
	/**
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	public String insertionSort(String nums); 
	
	/**
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	public String shellSort(String nums); 
	
	/**
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	public String simpleSelectionSort(String nums); 
}