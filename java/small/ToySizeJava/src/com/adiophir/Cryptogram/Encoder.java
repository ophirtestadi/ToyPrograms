package com.adiophir.Cryptogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class Encoder 
{
    public Encoder(final Vector<Character> alphabet, final Vector<Character> mapping) 
        throws IllegalArgumentException
    {
    	if (alphabet.size() != mapping.size())
    	{
    		throw new IllegalArgumentException("alphabet and mapping should have the same size");
    	}
    	
    	encoding = new HashMap<Character, Character>();
    	for(int i=0; i<alphabet.size(); i++)
    	{
    	    encoding.put(alphabet.elementAt(i), mapping.elementAt(i));    	
    	}
	}
    
    public Character encode(Character c)
    {
    	return encoding.get(c);
    }

    public String encode(Vector<Character> arr)
    {
    	String ret = "";
    	for(int i=0; i<arr.size(); i++)
    	{
    		arr.set(i, (Character)encoding.get(arr.elementAt(i)));
    		ret = ret + arr.get(i);
    	}
    	
    	return ret;
    }    
    
    private Map<Character, Character> encoding;
}
