/**
 * 
 */
package com.puzzle;

import java.util.Scanner;

/**
 * @author Sayantan Saha
 *
 */
public class BalancedOrNot {

	
	static int[] balancedOrNot(String[] expression,int[] maxreplacement){
		
		
		int [] result = new int[expression.length];
		int count=0;
		for (String expr : expression) {
			
			int lessThanCount = 0;
			int greaterThanCount=0;
			for(int i=0;i<expr.length();i++){
				
				if(expr.charAt(i)=='<')
					lessThanCount++;
				else if(expr.charAt(i)=='>')
					greaterThanCount++;
			}
			
			if(lessThanCount==greaterThanCount){
				
				result[count]=1;
			}
			
			else{
				
				
				int replacementStep=0;
				
				String balancedString = "";
				
				int i=0;
				boolean balanced=false;
				for(;i<expr.length();i++){
					
					if(expr.charAt(i)=='<')
						balancedString+='<';
					else if(expr.charAt(i)=='>'){
						
						balancedString+="<>";
						replacementStep++;
					}
					
					String stringToBeChecked = balancedString+expr.substring(i+1, expr.length());
					lessThanCount=0;
					greaterThanCount=0;
					for(int k=0;k<stringToBeChecked.length();k++){
						
						if(expr.charAt(k)=='<')
							lessThanCount++;
						else if(expr.charAt(k)=='>')
							greaterThanCount++;
					}
					
					if(lessThanCount==greaterThanCount){
						
						balanced=true;
						break;
					}
						
				}
				
				
				if(balanced&&replacementStep<=maxreplacement[count]){
					
					result[count]=1;
				}
				
				else{
					
					result[count]=0;
				}
				
				
				
				
			}
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number Of Test Cases");
		int count = Integer.parseInt(scan.nextLine());
		String [] info = new String[count];
		int[] maxRep = new int[count];
		for(int i=0;i<count;i++){
			
			System.out.println("Enter Expr");
			info[i]=scan.nextLine();
			System.out.println("Enter Max rep");
			maxRep[i]=Integer.parseInt(scan.nextLine());
		}
		
		int []res=BalancedOrNot.balancedOrNot(info, maxRep);
		for (int i : res) {
			
			System.out.println(i);
		}
	}
}
