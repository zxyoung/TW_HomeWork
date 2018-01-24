package com.zhang;

public class RomanNumerals {
	
	private char symbol;
    private int value;
    private int subtractedDestence;
	private boolean isAllowedSubtracted;
	private boolean isAllowedRepeated;
	
	public RomanNumerals(){}
	public RomanNumerals(char symbol, int vaule, int subtractedDestence, boolean isAllowedSubtracted,
			boolean isAllowedRepeated) {
		this.symbol = symbol;
		this.value = vaule;
		this.subtractedDestence = subtractedDestence;
		this.isAllowedRepeated = isAllowedRepeated;
		this.isAllowedSubtracted = isAllowedSubtracted;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSubtractedDestence() {
		return subtractedDestence;
	}
	public void setSubtractedDestence(int subtractedDestence) {
		this.subtractedDestence = subtractedDestence;
	}
	public boolean isAllowedSubtracted() {
		return isAllowedSubtracted;
	}
	public void setAllowedSubtracted(boolean isAllowedSubtracted) {
		this.isAllowedSubtracted = isAllowedSubtracted;
	}
	public boolean isAllowedRepeated() {
		return isAllowedRepeated;
	}
	public void setAllowedRepeated(boolean isAllowedRepeated) {
		this.isAllowedRepeated = isAllowedRepeated;
	}
}
