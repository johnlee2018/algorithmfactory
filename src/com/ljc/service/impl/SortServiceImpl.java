package com.ljc.service.impl;

import com.ljc.service.SortService;
import com.sun.org.apache.bcel.internal.generic.SWAP;

public class SortServiceImpl implements SortService{

	private int numarr[];
	private String nums = "";
	private int len;
	@Override
	public String bubbleSort(String nums) 
	{
		
		this.nums=nums;
		if (nums != null)
		{
			getIntArry();
		}
			
		for (int i=0; i<len;i++)
		{
			for (int j=i+1;j<len;j++)
			{
				if (numarr[j]<numarr[i])
				{
					swap(i,j);
				}
						
			}
		}
		
		integNums();
		return this.nums;
	}

	@Override
	public String quickSort(String nums) {
		// TODO Auto-generated method stub
		
		this.nums=nums;
		if (nums != null)
		{
			getIntArry();
		}
		int low = 0;
		int high=numarr.length-1;
		quickSortFun(low,high);
		integNums();
		
		return this.nums;
	}
	
	private void getIntArry() {
		// TODO Auto-generated method stub
		
		String[] arr=nums.split(",");
		len =arr.length;
		numarr = new int[len];
		


		for (int i = 0; i < len; i++) 
		{
			numarr[i]=Integer.parseInt(arr[i]);
		}
		
	}
	
	private void swap(int i, int j) {
		int ex;
		ex=numarr[j];
		numarr[j]=numarr[i];
		numarr[i]=ex;
	}

	
	private void integNums() {
		// TODO Auto-generated method stub
		String nums="";
	    for(int i=0;i<numarr.length;i++)
	    {
	        System.out.println("%%integNums%%");
	        System.out.println(numarr[i]);  
	    }
		
		for (int i : numarr) 
		{
			nums += String.valueOf(i)+",";
		}
		this.nums=nums;
	}

	private int getMiddle(int[] numarr,int low,int high){
		
		int key =numarr[low];
		while(low<high)
		{
			while(low<high && key<=numarr[high])
			{
				high=high-1;
			}
			numarr[low]=numarr[high];
			while(low<high && key>=numarr[low])
			{
				low=low+1;
			}
			numarr[high]=numarr[low];
		}
		numarr[high]=key;
		this.numarr=numarr;
	    for(int i=0;i<numarr.length;i++)
	    {
	        System.out.println("%%%%");
	        System.out.println(numarr[i]);  
	    }
		
		return low;
	}

	private void quickSortFun( int low, int high) {
		// TODO Auto-generated method stub
	if (low < high) { 
			int middle=getMiddle(numarr, low, high);
			quickSortFun(low, middle-1);
			quickSortFun(middle+1,high );
		}
	}
}