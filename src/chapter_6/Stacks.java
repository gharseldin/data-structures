package chapter_6;

import java.util.Arrays;

public class Stacks {

	/**
	 * A generic method for reversing and array
	 * 
	 * @param a	an array of values
	 */
	public static <E> void reverse(E[] a){
		Stack<E> buffer = new ArrayStack<>(a.length);
		for(int i=0; i<a.length; i++)
			buffer.push(a[i]);
		for(int i=0; i<a.length; i++)
			a[i] = buffer.pop();
	}
	
	
	/**
	 * A method to test if delimiters in a given expression are matched properly
	 * @param expression	an expression with opening and closing delimiters
	 * @return 				whether the expression is valid or not
	 */
	public static boolean isMatched(String expression){
		final String opening = "({[";
		final String closing = ")}]";
		Stack<Character> buffer = new LinkedStack<>();
		for(char c: expression.toCharArray()){
			if(opening.indexOf(c)!= -1)
				buffer.push(c);
			else  if (closing.indexOf(c)!=-1){
				if(buffer.isEmpty())
					return false;
				if(closing.indexOf(c)!= opening.indexOf(buffer.pop()))
					return false;
			}
		}
		return buffer.isEmpty();
	}
	
	/**
	 * A method to verify the validity of an HTML string by making sure 
	 * each opening tag is matched with the appropriate closing tag
	 * @param html	The HTML string
	 * @return		whether the document is valid or not
	 */
	public static boolean isHTMLMAtched(String html){
		Stack<String> buffer = new LinkedStack<>();
		int j = html.indexOf('<');
		while(j != -1){
			int k = html.indexOf('>', j+1);
			if(k == -1)
				return false;
			String tag = html.substring(j+1, k);
			if(!tag.startsWith("/"))
				buffer.push(tag);
			else{
				if(buffer.isEmpty())
					return false;
				if(!tag.substring(1).equals(buffer.pop()))
					return false;
			}
			j = html.indexOf('<', k+1);
		}
		return buffer.isEmpty();
	}
	
	public static void main(String args[]){
		Integer[] a = { 4, 5, 6, 7, 8, 10};
		String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
		System.out.println("a = "+ Arrays.toString(a));
		System.out.println("s = "+ Arrays.toString(s));
		reverse(a);
		reverse(s);
		System.out.println("a = "+ Arrays.toString(a));
		System.out.println("s = "+ Arrays.toString(s));
	}
}
