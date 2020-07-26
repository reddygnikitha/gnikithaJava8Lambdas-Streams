package lambdas_and_streams;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import javax.swing.text.StyledEditorKit.ForegroundAction;

interface FunctionalInterface
{
	public float average(ArrayList<Integer> al);
}
interface Filter
{
	public List<String> filterList(List<String> list,Predicate<String> predicate);
}	


interface IPalindrome
{
	 boolean isPalindrom(String s);
}
class PalindromePredicate
{
	public static boolean palindrome(String s)
	{
		return new StringBuffer(s).reverse().toString().equals(s);
	}
	
}


public class App
{
	public static List<String> filterList(List<String> list, Predicate<String> predicate)
	{
		List<String> result = new ArrayList<String>();
		for(String i : list)
		{
			if(predicate.test(i))
			{
				result.add(i);
			}
		}
		return result;
	}
    public static void main( String[] args )
    {
    //Average Of numbers using lambda Expressions
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	al.add(1);
    	al.add(2);
    	al.add(3);
    	al.add(4);
      FunctionalInterface fInterface = (lol)->
      {
    	   int sum = 0;
    	   for(int i:lol)
    	   {
    		   sum+=i;
    	   }
    	   return sum/al.size();
      };
      
     System.out.println("Average Of numbers is "+fInterface.average(al));
     
//     list of Strings that starts with 'a' and has only 3 letters
     
     String array[]= {"abb","abdd","abc","milk","covid-19"};
     List<String> listStrings = Arrays.asList(array);
    
     List<String> filteredList = filterList(listStrings,(String str)-> str.length()==3 && str.startsWith('a'+""));
     System.out.println("Filtered List "+filteredList);
     
     
     
 	
// 	Palindromes
 	List<String> inp = Arrays.asList("bob","mam","madam","yeah","test");
 	ArrayList<String> palindromes = new ArrayList<String>();
    App app=new App();

 	for(String i : inp)
 	{
 		IPalindrome predicate = PalindromePredicate::palindrome;
       if(predicate.isPalindrom(i))
       {
    	   palindromes.add(i);
       }
 	}
 	
 	System.out.println("Palindromes "+palindromes);
    }
}
