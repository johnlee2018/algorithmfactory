package com.ljc.service.impl;

import com.ljc.service.SortService;


public class SortServiceImpl implements SortService{

	private int numarr[];
	private String nums = "";
	private int len;
	@Override
	public String bubbleSort(String nums) 
	{
		int[] numarr = null;
		int len=0;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			len=numarr.length;
			for (int i=0; i<len;i++)
			{
				for (int j=i+1;j<len;j++)
				{
					if (numarr[j]<numarr[i])
					{
						numarr=swap(numarr,i,j);
					}
							
				}
			}

		}
			
		
		nums=integNums(numarr);
		return nums;
	}

	@Override
	public String quickSort(String nums) {
		// TODO Auto-generated method stub
		int[] numarr = null;
		int low = 0 ;
		int high = 0;
		numarr=	getIntArry(nums);
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			low = 0;
			high=numarr.length-1;

		}
		this.numarr=numarr;
		quickSortFun(low,high);
		
		nums=integNums(this.numarr);
		return nums;
	}
	
	@Override
	public String insertionSort(String nums) {
		// TODO Auto-generated method stub
		int[] numarr = null;
		int len=0;

		this.nums=nums;
		if (nums != null)
		{
			int Sortnumarr[]=new int[len];
			int i = 0;
			int j=0;

			numarr=	getIntArry(nums);
			len=numarr.length;
			Sortnumarr[i]=numarr[i];
			for (i=1;i<len-1;i++)
			{
				for (j=0;j<i;j++)
				{
					if (Sortnumarr[j]>numarr[i])
					{
						Sortnumarr[j+1]=Sortnumarr[j];
						Sortnumarr[j]=numarr[i];
					}
					else
					{
						Sortnumarr[j+1]=numarr[i];
					}
				}
			}
			numarr=Sortnumarr;
			nums=integNums(numarr);
			
		}
		return nums;
	}

	@Override
	public String shellSort(String nums) {
		// TODO Auto-generated method stub
		int[] numarr = null;
		int len=0;

		this.nums=nums;
		if (nums != null)
		{
			
	        int h = 1;  
			numarr=	getIntArry(nums);
			h=numarr.length / 2;
	        while (h > 0) {
	            for (int i = h; i < numarr.length; i += h) {  
	                if (numarr[i] < numarr[i - h]) {  
	                    int tmp = numarr[i];  
	                    int j = i - h;  
	                    while (j >= 0 && numarr[j] > tmp) {  
	                    	numarr[j + h] = numarr[j];  
	                        j -= h;  
	                    }  
	                    numarr[j + h] = tmp;  
	                }  
	            }  
	        
	        	h=h / 2;
	        }
			
		}
		nums=integNums(numarr);
		return nums;
	
		//return null;
	}

	@Override
	public String simpleSelectionSort(String nums) {
		// TODO Auto-generated method stub
		int[] numarr = null;
		int len=0;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			
		}
		for (int i=0;i<numarr.length-1;i++)
		{
			int lowIndex=i;
			for(int j=i+1;j<numarr.length;j++)
			{
				if (numarr[j]>numarr[lowIndex])
				{
					lowIndex=j;
				}
				
			}
			
			numarr=swap(numarr, i, lowIndex);
		}
		nums=integNums(numarr);
		return nums;

	}
	
	
	private int[] getIntArry(String nums) {
		// TODO Auto-generated method stub
		
		String[] arr=nums.split(",");
		int len =arr.length;
		int[] numarr = new int[len];
		try
		{
			for (int i = 0; i < len; i++) 
			{
				numarr[i]=Integer.parseInt(arr[i]);
			}
			
			return numarr;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			System.out.println(" the result is 0,0,0  ,which is wrong ! ");
		}
		
		return new int[]{0,0,0};
	}
	
	private int[] swap(int[] numarr,int i, int j) {
		int ex;
		ex=numarr[j];
		numarr[j]=numarr[i];
		numarr[i]=ex;
		return numarr;
	}

	
	private String integNums(int [] numarr) {
		// TODO Auto-generated method stub
		String nums="";
		for (int i : numarr) 
		{
			nums += String.valueOf(i)+",";
		}
		return nums;
		
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