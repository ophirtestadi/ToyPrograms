package com.adiophir.Cryptogram;

import java.util.Vector;

public class Runner
{
	public static void main(String[] args) 
	{
		Vector<Character> ab = createAlphabet();		
				
		
		String plainMessage = "Hello, so long, (and thanks for all the FISH!).";
		Cryptogram cryptogram = new Cryptogram(ab);
		System.out.println("Input = " + plainMessage + "\n");
		
		String encryptedMessage = cryptogram.encrypt(plainMessage);
		System.out.println("encrypted-Input = " + encryptedMessage + "\n");
		
		String decryptedMessage = cryptogram.decrypt(encryptedMessage);
		System.out.println("decrypted-Input = " + decryptedMessage + "\n");
	}

	private static Vector<Character> createAlphabet() {
		Vector<Character> ab = new Vector<Character>();
		for (char c='a', upperC='A'; c<='z'; c++, upperC++)
		{
			ab.add(Character.valueOf(c));
			ab.add(Character.valueOf(upperC));
		}
		// punctuation and etc
		ab.add(Character.valueOf(' '));
		ab.add(Character.valueOf('.'));
		ab.add(Character.valueOf(','));
		ab.add(Character.valueOf('-'));
		ab.add(Character.valueOf('+'));
		ab.add(Character.valueOf('='));
		ab.add(Character.valueOf('!'));
		ab.add(Character.valueOf('@'));
		ab.add(Character.valueOf('#'));		
		ab.add(Character.valueOf('{'));
		ab.add(Character.valueOf('}'));
		ab.add(Character.valueOf('['));
		ab.add(Character.valueOf(']'));
		ab.add(Character.valueOf('%'));
		ab.add(Character.valueOf('^'));
		ab.add(Character.valueOf('&'));		
		ab.add(Character.valueOf('*'));
		ab.add(Character.valueOf('('));		
		ab.add(Character.valueOf(')'));
		ab.add(Character.valueOf('~'));
		return ab;
	}
}
