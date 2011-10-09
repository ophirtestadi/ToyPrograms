package com.adiophir.Cryptogram;

import java.util.Vector;

import junit.framework.TestCase;

public class CryptogramTest extends TestCase 
{	
	private Vector<Character> ab;
	private Cryptogram cryptogram = null;
	public void setUp()
	{
		ab = createAlphabet();
		cryptogram = new Cryptogram(ab);
	}
	
	public void tearDown()
	{
	    ab.clear();
	    cryptogram = null;
	}

    public void testOneLetterWord()
    {
    	encryptDecryptAssert("a", cryptogram);
    	encryptDecryptAssert("Z", cryptogram);
    	encryptDecryptAssert("!", cryptogram);
    }
	
    public void testAllLowerCase()
    {
    	encryptDecryptAssert("hello", cryptogram);
    	encryptDecryptAssert("thanks for all the fish", cryptogram);
    }
    
    public void testAllUpperCase()
    {
    	encryptDecryptAssert("AND", cryptogram);
    	encryptDecryptAssert("SO LONG", cryptogram);
    }
    
    public void testMixedrCase()
    {
    	encryptDecryptAssert("hEllo!", cryptogram);
    	encryptDecryptAssert("Thanks [foR aLl the fish].", cryptogram);
    }    
    
    public void testOneLetterAlphabet()
    {
		Vector<Character> oneLetterAlphabet = new Vector<Character>();
		oneLetterAlphabet.add(Character.valueOf('r'));
		Cryptogram crypt = new Cryptogram(oneLetterAlphabet);
		
		encryptDecryptAssert("r", crypt);
		encryptDecryptAssert("rrrr", crypt);
    }
    
    public void testTwoLetterAlphabet()
    {
		Vector<Character> twoLetterAlphabet = new Vector<Character>();
		twoLetterAlphabet.add(Character.valueOf('r'));
		twoLetterAlphabet.add(Character.valueOf('.'));
		Cryptogram crypt = new Cryptogram(twoLetterAlphabet);
		
		encryptDecryptAssert("r.", crypt);
		encryptDecryptAssert("rrr...r",  crypt);
    }        
    
//--------------------------------------------------

	private void encryptDecryptAssert(String message, Cryptogram crypt) 
	{
		String encryptedMessage = crypt.encrypt(message);
    	assertEquals(true, message.equals(crypt.decrypt(encryptedMessage)));
	}	
    
    private static Vector<Character> createAlphabet() 
	{
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
