package com.adiophir.Cryptogram;

import java.util.Vector;

public class Cryptogram 
{
    public Cryptogram(final Vector<Character> alphabet)
    {
    	Vector<Character> shuffledAlphabet = new Vector<Character>(alphabet);
    	Shuffler.shuffle(shuffledAlphabet);
    	
    	encrypter = new Encoder(alphabet, shuffledAlphabet);
    	decrypter = new Encoder(shuffledAlphabet, alphabet);
    }
    
    public Cryptogram(final String ab)
    {
    	Vector<Character> alphabet = new Vector<Character>();
    	Vector<Character> shuffledAlphabet = new Vector<Character>();
    	for(int i=0; i<ab.length(); i++)
    	{
    		alphabet.add(Character.valueOf(ab.charAt(i)));
    		shuffledAlphabet.add(Character.valueOf(ab.charAt(i)));
    	}
    	Shuffler.shuffle(shuffledAlphabet);
    	
    	encrypter = new Encoder(alphabet, shuffledAlphabet);
    	decrypter = new Encoder(shuffledAlphabet, alphabet);
    }    
    
    public String encrypt(Vector<Character> plainMessage)
    {
    	return encrypter.encode(plainMessage);
    }
    
    public String encrypt(String plainMessage)
    {
    	Vector<Character> message = new Vector<Character>();
    	for(int i=0; i<plainMessage.length(); i++)
    	{
    		message.add(Character.valueOf(plainMessage.charAt(i)));
    	}
    	
    	return this.encrypt(message);
    }    
    
    public String decrypt(Vector<Character> encryptedMessage)
    {
    	return decrypter.encode(encryptedMessage);
    }    
    
    public String decrypt(String encryptedMessage)
    {
    	Vector<Character> message = new Vector<Character>();
    	for(int i=0; i<encryptedMessage.length(); i++)
    	{
    		message.add(Character.valueOf(encryptedMessage.charAt(i)));
    	}
    	
    	return this.decrypt(message);
    }    
    
    private Encoder encrypter;
    private Encoder decrypter;
}
