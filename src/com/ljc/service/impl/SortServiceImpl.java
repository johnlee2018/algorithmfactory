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
		int len=0;
		int low = 0 ;
		int high = 0;
		numarr=	getIntArry(nums);
		len=numarr.length;
		
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			len=numarr.length;
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
			//return nums;
		}
		return nums;
	}

	
	
	
	
	private int[] getIntArry(String nums) {
		// TODO Auto-generated method stub
		
		String[] arr=nums.split(",");
		int len =arr.length;
		int[] numarr = new int[len];
		for (int i = 0; i < len; i++) 
		{
			numarr[i]=Integer.parseInt(arr[i]);
		}
		return numarr;
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
	    for(int i=0;i<numarr.length;i++)
	    {
	        System.out.println("%%integNums%%");
	        System.out.println(numarr[i]);  
	    }
		
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