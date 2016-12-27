package com.ljc.service.impl;

import com.ljc.service.SortService;
import com.sun.org.apache.bcel.internal.generic.SWAP;

public class SortServiceImpl implements SortService{

	 /**
	 * @override
	 * @author li jianchun
	 * @param nums
	 * @return
	 * 
	 */
	 
	@Override
	public int[] getIntArry(String nums) {
		// TODO Auto-generated method stub
		
		String[] arr=nums.split(",");
		int len =arr.length;
		int numarr[] = new int[len];
		for (int i = 0; i < len; i++) 
		{
			numarr[i]=Integer.parseInt(arr[i]);
		}
		
		return numarr;
	}
	
	 /**
	 * @override
	 * @author li jianchun
	 * @param numarr
	 * @return
	 * 
	 */
	 
	@Override
	public String bubbleSort(int[] numarr) 
	{
	// TODO Auto-generated method stub
	int len =numarr.length;
	int ex;
	String nums = "";	
	for (int i=0; i<len;i++)
	{
		for (int j=i+1;j<len;j++)
		{
			if (numarr[j]>numarr[i])
			{
				ex=numarr[j];
				numarr[j]=numarr[i];
				numarr[i]=ex;
			}
					
		}
	}
	
	for (int i : numarr) 
	{
		nums += String.valueOf(i)+",";

	}
	return nums;
}

	@Override
	public String quickSort(int[] numarr) {
		// TODO Auto-generated method stub
		
		
		int middle=getMiddle(numarr,low,high);
		
		return null;
	}
	private int getMiddle(int[] numarr,int low,int high){
		
		int tmp =low;
		while(low!=high)
		{
			if (numarr[tmp]>numarr[low])
			{
				swap(tmp,low);
			}
			low++;
			if(numarr[tmp]<numarr[high])
			{
				swap(tmp,low);
			}
		}
		return middle;
	}

	private void quickSortFun(int[] numarr, int low, int high) {
		// TODO Auto-generated method stub
		int middle=getMiddle(numarr, low, high);
		quickSortFun(numarr, low, middle-1);
		quickSortFun(numarr, middle+1,high );
	}
	
}