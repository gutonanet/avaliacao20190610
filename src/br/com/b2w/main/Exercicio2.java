package br.com.b2w.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Exercicio2 {

	public static void 
	possibilidades(Set<Integer> items, Stack<Integer> possibilidades, int size) {

	    if(possibilidades.size() == size) {
	    	String valor = Arrays.toString(possibilidades.toArray(new Integer[0]));
	    	valor = valor.replaceAll(",", "");
	    	valor = valor.replace('[', ' ');
	    	valor = valor.replace(']', ' ');
	    	Long valorLong = Long.valueOf(valor.replaceAll(" ", ""));
	    	if(valorLong.toString().length() == size) {
	    		  System.out.println(Arrays.toString(possibilidades.toArray(new Integer[0])));
	    	}
	      
	    }

	    Integer[] itemsTemp = items.toArray(new Integer[0]);
	    for(Integer i : itemsTemp) {
	    	possibilidades.push(i);
	        items.remove(i);
	        possibilidades(items, possibilidades, size);
	        items.add(possibilidades.pop());
	    }
	}
	
	public static void main(String[] args) {
		
		if(args == null) {
			System.out.println("Digite um número.");
		}
		
		if(args[0] == null && "".equals(args[0])) {
			System.out.println("Digite um número.");
		}
		
		try {
			Long.parseLong(args[0]);
		}catch(Exception e) {
			System.out.println("Digite um número válido.");
		}
		
		char[] numeros = args[0].toCharArray();
	    Set<Integer> s = new HashSet<Integer>();
		for(char c:numeros) {
			s.add(new Integer(c+""));
		}
		

	    possibilidades(s, new Stack<Integer>(), s.size());
	}

}
