package com.ljc.service.impl;

import java.util.Arrays;

import com.ljc.service.SortService;


public class SortServiceImpl implements SortService{

	private Integer numarr[];
	@Override
	public String bubbleSort(String nums) 
	{
		//System.out.//println(" %%%bubble%%%  ");
		Integer[] numarr = null;
		int len=0;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			len=numarr.length;
			for (int i=len-1; i>0;i--)
			{
				for (int j=0;j<i;j++)
				{
					if (numarr[j+1]<numarr[j])
					{
						numarr=swap(numarr,j+1,j);
					}
							
				}
			}

		}
			
		//print(numarr);
		//String[] numss={"a","vf","cd"};
		
		////print(numss);
		nums=integNums(numarr);
		
		//int[] numint1={3,2,3};
		//Integer[] numint2={3,2,3};
		////print(numint2);
		////print(numint1);

		return nums;
	}


	@Override
	public String quickSort(String nums) {
		// TODO Auto-generated method stub
		//System.out.//println(" %%%quick%%%  ");
		Integer[] numarr = null;
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
		//System.out.//println(" %%%insert%%%  ");
		Integer[] numarr = null;
		int len=0;

		if (nums != null)
		{
			
			int i = 0;
			int j=0;

			numarr=	getIntArry(nums);
			len=numarr.length;
			for (i=1;i<len;i++)
				
				{
					int tmp = numarr[i];
					for(j=i-1;j>=0 && tmp<numarr[j];j--)
					{
						numarr[j+1]=numarr[j];
					}
					numarr[j+1]=tmp;
				}
			nums=integNums(numarr);
			
		}
		return nums;
	}

	@Override
	public String shellSort(String nums) {
		// TODO Auto-generated method stub
		//System.out.//println(" %%%shell%%%  ");
		Integer[] numarr = null;
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
		//System.out.//println(" %%%simpleSelect%%%  ");
		Integer[] numarr = null;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			
		}
		for (int i=0;i<numarr.length-1;i++)
		{
			int lowIndex=i;
			for(int j=i+1;j<numarr.length;j++)
			{
				if (numarr[j]<numarr[lowIndex])
				{
					lowIndex=j;
				}
				
			}
			
			numarr=swap(numarr, i, lowIndex);
		}
		nums=integNums(numarr);
		return nums;

	}
	
	@Override
	public String heapSort(String nums) {
		// TODO Auto-generated method stub
		//System.out.//println(" %%%heap%%%  ");
		Integer[] numarr = null;
		
		int len=0;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
			
		}
		////print(numarr);
		len=numarr.length;
		for (int i=(len-2)/2;i>=0;--i)
		{
			numarr=siftAdjust(numarr,i,len-1);
			
		}
		for(int i=len-1;i>0;--i)
		{
			numarr=swap(numarr, 0, i);
			numarr=siftAdjust(numarr, 0, i-1);
		}
		
		nums=integNums(numarr);
		return nums;

	}  

	@Override
	public String mergeSort(String nums) {
		// TODO Auto-generated method stub
		//System.out.//println(" %%%merge%%%  ");
		Integer[] numarr = null;
		Integer[] tempNumarr=null;
		int len;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
		}
		len=numarr.length;
		tempNumarr=new Integer[len];
		numarr=mergeSortHelp(tempNumarr,numarr,0,len-1);
		nums=integNums(numarr);
		return nums;
	}

	@Override
	public String radixSort(String nums) {
		// TODO Auto-generated method stub
		//System.out.//println(" %%%radix%%%  ");
		Integer[] numarr = null;
		int key;
		if (nums != null)
		{
			numarr=	getIntArry(nums);
		}
		key=getKey(numarr);
		//System.out.//println("&&&&&&&+the value of key");
		//System.out.//println(key);
		numarr=radixSortHelp(numarr,10,key);
		nums=integNums(numarr);
		return nums;
	}

    public Integer[] radixSortHelp(Integer[] numarr, int radix, int d) 
    {  
        // 缓存数组  
    	Integer[] tmp = new Integer[numarr.length];  
        // buckets用于记录待排序元素的信息  
        // buckets数组定义了max-min个桶  
    	Integer[] buckets = new Integer[radix];  
  
        for (int i = 0, rate = 1; i < d; i++) {  
  
            // 重置count数组，开始统计下一个关键字  
            Arrays.fill(buckets, 0);  
            // 将data中的元素完全复制到tmp数组中  
            //System.arraycopy(numarr, 0, tmp, 0, numarr.length);  
  
            // 计算每个待排序数据的子关键字  
            for (int j = 0; j < numarr.length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  
                buckets[subKey]++;  
            }  
  
            for (int j = 1; j < radix; j++) {  
                buckets[j] = buckets[j] + buckets[j - 1];  
            }  
  
            // 按子关键字对指定的数据进行排序  
            for (int m = numarr.length - 1; m >= 0; m--) {  
                int subKey = (tmp[m] / rate) % radix;  
                numarr[--buckets[subKey]] = tmp[m];  
            }  
            rate *= radix;  
        }  
        return numarr;
    }  	
	
	private int getKey(Integer[] numarr) {
		// TODO Auto-generated method stub
		
		int len=numarr.length;
		int tmp = 0;
		for (int i=0;i<len;i++)
		{
			String s=String.valueOf(numarr[i]);
			if (tmp<s.length())
			{
				tmp=s.length();
			}
			/*
			if (numarr[i]<Math.pow(10,key))
			{
				i++;
			}
			else
			{
				i++;
				key++;
				tmp=key;
				continue;
			}
			*/
		}
		return tmp;
	}


	private Integer[] mergeSortHelp(Integer[] tempNumarr, Integer[] numarr, int low, int high) {
		// TODO Auto-generated method stub
		if (low>=high)
		{
			return numarr;
		}
		
		int mid=(low+high)/2;
		numarr=mergeSortHelp(tempNumarr, numarr, low, mid);
		numarr=mergeSortHelp(tempNumarr, numarr, mid+1, high);
		numarr=merge(tempNumarr,numarr,low,mid,high);
		
		return numarr;
	}

	private Integer[] merge(Integer[] tempNumarr, Integer[] numarr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i,j,k;
		for(i=low,j=mid+1,k=low;i<=mid && j<=high;k++)
		{
			if (numarr[i]<=numarr[j])
			{
				//print(numarr);
				//print(tempNumarr);
				tempNumarr[k]=numarr[i];
				i++;
			}
			else
			{
				tempNumarr[k]=numarr[j];
				j++;				
			}
		}
		for (;i<=mid;i++,k++)//归并numarr[low,mid]中剩余元素，和下一个for只能执行其中一个
		{
			tempNumarr[k]=numarr[i];
		}
		for (;j<=high;j++,k++)//归并numarr[mid+1,high]中剩余元素，和上一个for只能执行其中一个
		{
			tempNumarr[k]=numarr[j];
		}
		for(i=low;i<=high;i++)
		{
			numarr[i]=tempNumarr[i];
		}
		return numarr;
	}

		
	private Integer[] siftAdjust(Integer[] numarr, int low, int high) {
		for(int s=low,i=2*low+1;i<=high;i=2*i+1)
		{
//			if (len==i+1)//the right child exists;
//			{
//				if(numarr[s]<numarr[i])
//				{
//					numarr=swap(numarr, low, i);
//				}
//				
//			}
//			else
//			{
				if (i<high && numarr[i]<numarr[i+1])//短路与保证了右孩子存在性
				{
					i++;
				}
				if(numarr[s]>=numarr[i])
				{
					break;
					
				}
				numarr=swap(numarr, s, i);
				s=i;
				////System.out.//println("$$$$$$$$$");
				////print(numarr);
				
			//}
			s=i;
		}
		return numarr;
	}

	private Integer[] getIntArry(String nums) {
		// TODO Auto-generated method stub
		
		String[] arr=nums.split(",");
		int len =arr.length;
		Integer[] numarr = new Integer[len];
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
			System.out.println("  if the result is 0,0,0  ,the input is wrong ! ");
		}
		return new Integer[]{0,0,0};
	}
	
	private Integer[] swap(Integer[] numarr,int i, int j) {
		int ex;
		ex=numarr[j];
		numarr[j]=numarr[i];
		numarr[i]=ex;
		return numarr;
	}

	
	private String integNums(Integer [] numarr) {
		// TODO Auto-generated method stub
		String nums="";
		for (int i : numarr) 
		{
			nums += String.valueOf(i)+",";
		}
		return nums;
		
	}

	private int getMiddle(Integer[] numarr,int low,int high){
		
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

    private < T > void print(T[] data) {  
       
        for ( T element : data )
        {        
            System.out.printf( "%s ", element );
         }
        System.out.println();  
    }


	
}