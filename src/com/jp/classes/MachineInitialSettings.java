/**
 * 
 */
package com.jp.classes;

import java.util.HashMap;

/**
 * @author 
 *
 */
public class MachineInitialSettings {

	private char[] rotor1 = new char[26];
	private char[] rotor2 = new char[26];
	private char[] rotor3 = new char[26];
	
	private char[] rotor1Map = new char[26];
	private char[] rotor2Map = new char[26];
	private char[] rotor3Map = new char[26];
    
    private char turnOverPosition1;
    private char turnOverPosition2;
    
    private char[] reflector1 = new char[26];
    private char[] reflector2 = new char[26];
    private char[] reflector1Map = new char[26];
    private char[] reflector2Map = new char[26];
    
    private HashMap<Character, Character> plugBoard = new HashMap<>();

    public MachineInitialSettings() {
    	String str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	String str2="BCDEFGHIJKLMNOPQRSTUVWXYZA";
    	String str3="CDEFGHIJKLMNOPQRSTUVWXYZAB";
    	
    	String str4="DEFGHIJKLMNOPQRSTUVWXYZABC";
    	String str5="FGHIJKLMNOPQRSTUVWXYZABCDE";
    	String str6="CBAZYXWVUTSRQPONMLKJIHGFED";
    	String str7="EDCVPZYXWBUTSRQAONMLKJIHGF";
    	
    	String str8="EDCBAZYXWVUTSRQPONMLKJIHGF";
    	
    	this.rotor1=str1.toCharArray();
    	this.rotor2=str2.toCharArray();
    	this.rotor3=str3.toCharArray();
    	
    	this.rotor1Map=str7.toCharArray();
    	this.rotor2Map=str5.toCharArray();
    	this.rotor3Map=str5.toCharArray();
    	
    	this.reflector1=str4.toCharArray();
    	this.reflector2=str5.toCharArray();
    	
    	this.reflector1Map=str6.toCharArray();
    	this.reflector2Map=str8.toCharArray();
        
        turnOverPosition1 = 'C';
        turnOverPosition2 = 'E';

        for (char c = 'A'; c <= 'Z'; c++) {
            char nextChar;
            if ((c - 'A') % 2 == 0) {
                nextChar = (char) (((c - 'A' + 1) % 26) + 'A');
            } else {
                nextChar = (char) (((c - 'A' - 1) % 26) + 'A');
            }
          
            plugBoard.put(c, nextChar);
        }
    }

	public MachineInitialSettings(char[] rotor1, char[] rotor2, char[] rotor3, char[] rotor1Map, char[] rotor2Map,
			char[] rotor3Map, char turnOverPosition1, char turnOverPosition2, char[] reflector1, char[] reflector2,
			char[] reflector1Map, char[] reflector2Map, HashMap<Character, Character> plugBoard) {
		
		this.rotor1 = rotor1;
		this.rotor2 = rotor2;
		this.rotor3 = rotor3;
		this.rotor1Map = rotor1Map;
		this.rotor2Map = rotor2Map;
		this.rotor3Map = rotor3Map;
		this.turnOverPosition1 = turnOverPosition1;
		this.turnOverPosition2 = turnOverPosition2;
		this.reflector1 = reflector1;
		this.reflector2 = reflector2;
		this.reflector1Map = reflector1Map;
		this.reflector2Map = reflector2Map;
		this.plugBoard = plugBoard;
	}

	public char[] getRotor1() {
		return rotor1;
	}

	public void setRotor1(char[] rotor1) {
		this.rotor1 = rotor1;
	}

	public char[] getRotor2() {
		return rotor2;
	}

	public void setRotor2(char[] rotor2) {
		this.rotor2 = rotor2;
	}

	public char[] getRotor3() {
		return rotor3;
	}

	public void setRotor3(char[] rotor3) {
		this.rotor3 = rotor3;
	}

	public char[] getRotor1Map() {
		return rotor1Map;
	}

	public void setRotor1Map(char[] rotor1Map) {
		this.rotor1Map = rotor1Map;
	}

	public char[] getRotor2Map() {
		return rotor2Map;
	}

	public void setRotor2Map(char[] rotor2Map) {
		this.rotor2Map = rotor2Map;
	}

	public char[] getRotor3Map() {
		return rotor3Map;
	}

	public void setRotor3Map(char[] rotor3Map) {
		this.rotor3Map = rotor3Map;
	}

	public char getTurnOverPosition1() {
		return turnOverPosition1;
	}

	public void setTurnOverPosition1(char turnOverPosition1) {
		this.turnOverPosition1 = turnOverPosition1;
	}

	public char getTurnOverPosition2() {
		return turnOverPosition2;
	}

	public void setTurnOverPosition2(char turnOverPosition2) {
		this.turnOverPosition2 = turnOverPosition2;
	}

	public char[] getReflector1() {
		return reflector1;
	}

	public void setReflector1(char[] reflector1) {
		this.reflector1 = reflector1;
	}

	public char[] getReflector2() {
		return reflector2;
	}

	public void setReflector2(char[] reflector2) {
		this.reflector2 = reflector2;
	}

	public char[] getReflector1Map() {
		return reflector1Map;
	}

	public void setReflector1Map(char[] reflector1Map) {
		this.reflector1Map = reflector1Map;
	}

	public char[] getReflector2Map() {
		return reflector2Map;
	}

	public void setReflector2Map(char[] reflector2Map) {
		this.reflector2Map = reflector2Map;
	}

	public HashMap<Character, Character> getPlugBoard() {
		return plugBoard;
	}

	public void setPlugBoard(HashMap<Character, Character> plugBoard) {
		this.plugBoard = plugBoard;
	}

    
}