/**
 * 
 */
package com.jp.main;

import java.util.Arrays;
import java.util.Scanner;

import com.jp.classes.MachineInitialSettings;



/**
 * @author
 *
 */
public class Tester {
	
	public static MachineInitialSettings obj;

    public static char EncryptorDecryptMessage(char c) {
    	
        char temp = obj.getPlugBoard().get(c);
        System.out.println("\n\n\nCharacter " + c + " after passing through Plug Board : " + temp);
      
        int index=-1;
         
        
        temp = obj.getRotor1()[temp-'A'];
        
        for(int i=0;i<26;i++) {
        	if(obj.getRotor1Map()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
       
        temp = obj.getRotor2()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getRotor2Map()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
        temp = obj.getRotor3()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getRotor3Map()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        System.out.println("Character " + c + " after passing through Rotors: " + temp);
       

        temp = obj.getReflector1()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getReflector1Map()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
       
        temp = obj.getReflector2()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getReflector2Map()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
        temp = obj.getReflector1Map()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getReflector1()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        System.out.println("Character " + c + " after passing through Reflectors: " + temp);

       
        temp = obj.getRotor3Map()[index];
       
        for(int i=0;i<26;i++) {
        	if(obj.getRotor3()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
        temp = obj.getRotor2Map()[index];
        
        for(int i=0;i<26;i++) {
        	if(obj.getRotor2()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
       
        temp = obj.getRotor1Map()[index];
        for(int i=0;i<26;i++) {
        	if(obj.getRotor1()[i]==temp) {
        		 index=i;
        		 break;
        	}
        }
        
        temp = obj.getRotor1()[index];
        System.out.println("Character " + c + " after passing through Rotors Backward: " + temp);
        

        temp=(char) (obj.getPlugBoard().keySet()).toArray()[index];
        temp=(char) (obj.getPlugBoard().values()).toArray()[index];
        System.out.println("Character " + c + " after passing backward through PlugBoard: " + temp);
        
        changeRotorsposition();
        return temp;
    }


    public static void changeRotorsposition() {

    	String temp1=new String();
    	String temp2=new String();
    	
    	for(int i=2;i<26;i++) {
        	temp1+=obj.getRotor1()[i];
        	temp2+=obj.getRotor1Map()[i];
        }
    	temp1+=obj.getRotor1()[0];
    	temp1+=obj.getRotor1()[1];
    	
    	temp2+=obj.getRotor1Map()[0];
    	temp2+=obj.getRotor1Map()[1];
    	obj.setRotor1(temp1.toCharArray());
    	obj.setRotor1Map(temp2.toCharArray());

        
        if (obj.getRotor1()[0] == obj.getTurnOverPosition1()) {
        	temp1=""; temp2="";
        	for(int i=2;i<26;i++) {
            	temp1+=obj.getRotor2()[i];
            	temp2+=obj.getRotor2Map()[i];
            }
        	temp1+=obj.getRotor2()[0];
        	temp1+=obj.getRotor2()[1];
        	
        	temp2+=obj.getRotor2Map()[0];
        	temp2+=obj.getRotor2Map()[1];
        	obj.setRotor2(temp1.toCharArray());
        	obj.setRotor2Map(temp2.toCharArray());
        }

        
        if (obj.getRotor2()[0] == obj.getTurnOverPosition2()) {
        	temp1=""; temp2="";
        	for(int i=2;i<26;i++) {
            	temp1+=obj.getRotor3()[i];
            	temp2+=obj.getRotor3Map()[i];
            }
        	temp1+=obj.getRotor3()[0];
        	temp1+=obj.getRotor3()[1];
        	
        	temp2+=obj.getRotor3Map()[0];
        	temp2+=obj.getRotor3Map()[1];
        	obj.setRotor3(temp1.toCharArray());
        	obj.setRotor3Map(temp2.toCharArray());
        }
    }

    public static void main(String[] args) {
    	
    	try {
    	obj = new MachineInitialSettings();
    	Scanner sc=new Scanner(System.in);
    	
    	String message = "";
    	String encryptedMessage = "";
    	String decryptedMessage = "";
    	
        
    	System.out.println("Enter the text to be encrypted: \n");
        message=sc.next();
        
        System.out.println("\n\nInitialized the Enigma Machine Settings");
       
        Object[] plugBoardKeys=(obj.getPlugBoard().keySet()).toArray();
        Object[] plugBoardValues=(obj.getPlugBoard().values()).toArray();
        
        
        
        
        for (char letter : message.toUpperCase().toCharArray()) {
        	System.out.println("\n\nReflector2    Reflector1    Rotor3    Rotor2    Rotor1    PlugBoard\n");
            for(int i=0;i<26;i++) {
   
            	System.out.println(obj.getReflector2Map()[i]+"        "+obj.getReflector2()[i]+"    "+
            	obj.getReflector1Map()[i]+"        "+obj.getReflector1()[i]+"    "+
            			obj.getRotor3Map()[i]+"    "+obj.getRotor3()[i]+"    "+obj.getRotor2Map()[i]+"    "+obj.getRotor2()[i]+"    "+
            			obj.getRotor1Map()[i]+"    "+obj.getRotor1()[i]+"     "+plugBoardKeys[i]+"    "+plugBoardValues[i]);
            }
            encryptedMessage += EncryptorDecryptMessage(letter);
        }

        System.out.println("\n\n----------********************----------");
        System.out.println("Encrypted Message: " + encryptedMessage);

        
        
        
        
        
        
        
        
        
        System.out.println("\n\nReset the Enigma Machine Settings");
        obj = new MachineInitialSettings();
        for (char letter : encryptedMessage.toCharArray()) {
        	System.out.println("\n\nReflector2    Reflector1    Rotor3    Rotor2    Rotor1    PlugBoard\n");
            for(int i=0;i<26;i++) {
            	
            	System.out.println(obj.getReflector2Map()[i]+"        "+obj.getReflector2()[i]+"    "+
            	obj.getReflector1Map()[i]+"        "+obj.getReflector1()[i]+"    "+
            			obj.getRotor3Map()[i]+"    "+obj.getRotor3()[i]+"    "+obj.getRotor2Map()[i]+"    "+obj.getRotor2()[i]+"    "+
            			obj.getRotor1Map()[i]+"    "+obj.getRotor1()[i]+"     "+plugBoardKeys[i]+"    "+plugBoardValues[i]);
            }
            decryptedMessage += EncryptorDecryptMessage(letter);
        }

        System.out.println("\n\n----------********************----------");
        System.out.println("Decrypted Message: " + decryptedMessage);
    	}
    	
    	
    	
    	catch(Exception e) {
    		System.out.println("\n\n\n\n\n\n--------------------------Invalid! ❌-------------------------------");
    	}
    }
}


