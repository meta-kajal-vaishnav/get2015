package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NumOfUniqueCharInString
{
	HashMap cache = new HashMap();
	
	// finds number of unique characters
	public int findUniqueCharacters ( String strInput )   
	{
		// Get a set of entries
		Set set = cache.entrySet();
		// Get an iterator
		Iterator iterator = set.iterator();
		
		// if string already exists in cache then read its number of unique characters from cache
		while ( iterator.hasNext() )
		{
			Map.Entry me = (Map.Entry)iterator.next();
			
			if ( me.getKey().equals(strInput) )
			{
				return me.getValue().toString().length();   
			}
		}
		
		// remove spaces from input sting
		Set<Character> inputSet = new HashSet<Character>(); 
		for ( int index = 0; index<strInput.length(); index++ )
		{
			if ( strInput.charAt(index) != ' ' )
				inputSet.add(strInput.charAt(index));
		}
		
		String uniqueCharacters = "";  
		
		Iterator iterator1 = inputSet.iterator();
		
		while ( iterator1.hasNext() )
			uniqueCharacters += iterator1.next() ;  
		
		// if string does not exist in cache then add it in cache
		cache.put(strInput, uniqueCharacters); 
		
		return uniqueCharacters.length();    
	}

	// displays cache stored in map
	public void displayCache()
	{
		// Get a set of entries
		Set set = cache.entrySet();
		// Get an iterator
		Iterator iterator = set.iterator();
		
		while ( iterator.hasNext() )
		{
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.println ( me.getKey() +" : " + me.getValue() );
		}
	}
	
}
