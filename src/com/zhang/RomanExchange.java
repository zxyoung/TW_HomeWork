package com.zhang;

import java.util.ArrayList;
import java.util.List;

public class RomanExchange {

	private static char[] romansSymbol = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

	public static List<RomanNumerals> romansList;

	private static RomanExchange instance;

	public static RomanExchange getInstance() {
		if (instance == null) {
			instance = new RomanExchange();
		}
		return instance;
	}

	private RomanExchange() {
		int arr[] = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
		romansList = new ArrayList<RomanNumerals>();

		for (int i = 0; i < romansSymbol.length; i++) {
			RomanNumerals tmp = new RomanNumerals();
			tmp.setSymbol(romansSymbol[i]);
			tmp.setValue(arr[i]);
			int distance = (romansSymbol[i] == 'I' || romansSymbol[i] == 'X' || romansSymbol[i] == 'C') ? 2 : 0;
			tmp.setSubtractedDestence(distance);
			boolean isAllowedRepeated = romansSymbol[i] == 'I' || romansSymbol[i] == 'X' || romansSymbol[i] == 'C'
					|| romansSymbol[i] == 'M';
			tmp.setAllowedRepeated(isAllowedRepeated);
			boolean isAllowedSubtracted = romansSymbol[i] == 'I' || romansSymbol[i] == 'X' || romansSymbol[i] == 'C';
			tmp.setAllowedSubtracted(isAllowedSubtracted);

			romansList.add(tmp);
		}
	}

	public static RomanNumerals getCurrentSymbol(char chr) {
		RomanNumerals rns = null;
		for (int i = 0; i < romansList.size() - 1; i++) {
			if (chr == romansList.get(i).getSymbol()) {
				rns = romansList.get(i);
			}
		}
		return rns;
	}

	public int exchange(String str) throws Exception {
		if (str.equals("") || str == null) {
			return 0;
		}
		char symbolArray[] = str.toCharArray();
		int result = 0;

		if (symbolArray.length == 1) {
			return getCurrentSymbol(symbolArray[0]).getValue();
		}

		for (int i = 0; i < symbolArray.length - 1; i += 2) {
			
			RomanNumerals curr = getCurrentSymbol(symbolArray[i]);
			if (i >= symbolArray.length - 1) {
				result += curr.getValue();
				break;
			}
			RomanNumerals next = getCurrentSymbol(symbolArray[i + 1]);
			if (curr == null) {
				throw new Exception(String.format("unexpected romans Symbol char:{0}", symbolArray[i]));
			}
			if (next == null) {
				throw new Exception(String.format("unexpected roman Symbol char:{0}", symbolArray[i + 1]));
			}

			if (curr.getValue() > next.getValue()) {
				result += curr.getValue();
				i--;
			} else if (curr.getValue() == next.getValue()) {
				if (!curr.isAllowedRepeated()) {
					throw new Exception(
							String.format("The romans Symbol char:{0} not allowed repeated", curr.getSymbol()));
				}
				
				int repeatedCnt = 2; 
				for (int j = i + 2; j < symbolArray.length; j++) {
					
					if (symbolArray[j] != curr.getSymbol()) {
						break;
					}
					
					repeatedCnt++;
					if (repeatedCnt > 3) {
						throw new Exception(String.format(
								"The romans Symbol char:{0} not allowed repeated more than 3 times", curr.getSymbol()));
					}
				}
				result += curr.getValue();
				i--;
			} else {
				result += curr.getValue() - next.getValue();
			}
		}
		return result;
	}
}
