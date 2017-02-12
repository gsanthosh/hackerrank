package com.santhosh.hackerrank.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatcher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		TreeSet<String> compareTreeSet = new TreeSet<>();
		Pattern p = Pattern.compile(".*@gmail\\.com$");
		Map<String,Integer> nameCountMap=new HashMap<>();
		for (int a0 = 0; a0 < N; a0++) {
			String firstName = in.next();
			String emailID = in.next();
			Matcher emailMatcher = p.matcher(emailID);
			if (emailMatcher.matches()) {
				System.out.println(emailID);
				if(compareTreeSet.contains(firstName)){
					int cnt=nameCountMap.get(firstName);
					nameCountMap.put(firstName,++cnt);
				}
				else{
					nameCountMap.put(firstName,1);
				}
				compareTreeSet.add(firstName);
			}
		}
		for (String name : compareTreeSet) {
			int count=nameCountMap.get(name);
			for(int i=0;i<count;i++){
				System.out.println(name);
			}
		}
	}

}
 