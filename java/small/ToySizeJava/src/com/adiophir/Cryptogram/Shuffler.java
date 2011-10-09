package com.adiophir.Cryptogram;

import java.util.Random;
import java.util.Vector;

public final class Shuffler 
{
    public static void shuffle(Vector<Character> arr)
    {
    	Random rand = new Random((long)(Math.random() * Integer.MAX_VALUE));
    	int randomIndex = 0;
    	for(int i=arr.size()-1; i>0; i--)
    	{
    		randomIndex = rand.nextInt(i);
    		
    		Character tmp = arr.elementAt(i);
    		arr.set(i, arr.elementAt(randomIndex));
    		arr.set(randomIndex, tmp);
    	}
    }
}
