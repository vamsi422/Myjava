package Leetcode;

import java.util.*;





public class DsaLeetcode {
	static int[] targetValueArray(int[]arr,int target) {
		int [] res=new int[2];
		HashMap<Integer,Integer> a=new HashMap<>();
		int l=arr.length;
		for(int i=0;i<l;i++) {
			int req=target-arr[i];
			if(a.containsKey(req)) {
				res[0]=a.get(req);
				res[1]=i;
			}
			a.putIfAbsent(arr[i], i);
			
		}
		return res;
	}
	static int longestSubString(String str) {
		int res=0;
		int l=str.length();
		HashMap<Character,Integer> Arr=new HashMap<>();
		for (int i = 0; i < l; i++) {
			char c = str.charAt(i);
			if (Arr.containsKey(c)) {
				res = res < Arr.size() ? Arr.size() : res;
				i = Arr.get(c)-1;
				Arr.clear();
				Arr.put(c,i);
			} else {
				Arr.put(c,i);
			}
		}
		res = res > Arr.size() ? res : Arr.size();
		return res;
	}

	/*
	 * static int[] addTwoNum(int[] num1 ,int[]num2) { int n1=0; int n2=0; for(int
	 * i=num1.length-1;i>0;i--) { n1+=num1[i]*10^i; } for(int
	 * i=num2.length-1;i>0;i--) { n2+=num2[i]*10^i; } int sum=n1+n2;
	 * 
	 * return new int[] {sum}; }
	 */
	static int romanToInt(String s) {
		HashMap <Character,Integer> roman=new HashMap<Character,Integer>();
		roman.put('I',1);
		roman.put('V',5);
		roman.put('X',10);
		roman.put('L',50);
		roman.put('C',100);
		roman.put('D',500);
		roman.put('M',1000);
		
		int sum=0;
		for(int i=0;i<s.length();i++) {
            int curr=roman.get(s.charAt(i));
            int next=i+1<s.length()?roman.get(s.charAt(i+1)):-1;
			if(curr<next) {
				sum-=curr;
			}else sum+=curr;
		}
		
		return sum;
	}
	
	
	
	
	
	static String longestCommonPrefix(String[] strs) {

	    HashMap<Character,Integer> list=new HashMap<Character,Integer>();
	    String r="";
	    for(int i=0;i<strs.length;i++){
	        for(int j=0;j<strs[i].length();j++){
	            char l=strs[i].charAt(j);
	            if(list.containsKey(l)){
	                int val=list.get(l);
	                if(val==strs[i].length()){
	                    r=r+l;
	                }
	                list.put(l,val+1);
	            }else list.put(l,1);
	        }
	    }
	    return r;
	}
	
	
	
	static int kadanesAlgorithm(int[] arr) {
	


		int l = arr.length;
		int sum = arr[0];
		int curr = arr[0];
		for (int i = 1; i < l; i++) {
			curr = curr < 0 ? arr[i] : curr + arr[i];
			sum = sum < curr ? curr : sum;
		}
		return sum;
	}
	
	
	//Math factorial,npr ,ncr
	////////////////////////////////////////////////////////
	static int factorial(int n) {
		int s = 1;
		while (n > 0) {
			s *= n;
			n--;
		}
		return s;
	}
	///////////////////////////////////////////////////////////////////
	static int ncr(int n, int r) {
		return (factorial(n) / (factorial(n - r) * factorial(r)));
	}
    //////////////////////////////////////////////////////////////////////
	static int npr(int n, int r) {
		return (factorial(n) / (factorial(n - r)));
	}
	////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
			System.out.println((ncr(4,1)*ncr(6,3)) +(ncr(4,2)*ncr(6,2))+(ncr(4,3)*ncr(6,1))+ncr(4,4));

	}

}
