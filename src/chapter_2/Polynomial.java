package chapter_2;

public class Polynomial {
	
	int[] polynomial = new int[10];
	
	private boolean isInteger(char input){
		String inputString = String.valueOf(input);
		try{
			Integer.parseInt(inputString);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	// we will assume that a Polynomial string is input as follows
	// X^2+5X+10
	// we need to loop through operations
	
	public int[] setPolynomial(String input)throws IllegalArgumentException{
		
		int index = 0;
		
		while(index < input.length()){
			if(input.charAt(index) == '-' || input.charAt(index) == '+'){
				
				char powerChar = input.charAt(index-1);
				int power;
				int coefficient;
				
				if(isInteger(powerChar)){
					// Then it is a power value for sure
					power = powerChar;
					if(index - 4 < 0)
						// This element has a coefficient of 1
						coefficient = 1;
					else
						// This element has a coefficient of the number
						//TODO expand for Coefficients > 9
						coefficient = input.charAt(index-4);
					
				}else{
					//Then it is an X with power 1
					power = 1;
					if(index - 2 < 0)
						// This element has a coefficient of 1
						coefficient = 1;
					else
						// This element has a coefficient of the number
						//TODO expand for Coefficients > 9
						coefficient = input.charAt(index-2);
					

				}
				// Add the polynomial portion to the array
				polynomial[power] = coefficient;
				
			}
			index++;
		}
		
		// parse the last element
		char lastChar = input.charAt(input.length()-1);
		
		int power;
		int coefficient;
		
		if(isInteger(lastChar)){
			// Then it might be a power or a constant
			if(input.charAt(input.length()-3) == 'X'){
				//Then it is a power
				power = lastChar;
				//TODO expand for Coefficients > 9
				coefficient = input.charAt(index-4); 
			}else{
				index--;
				// This is a constant
				while(isInteger(input.charAt(index))){
					index--;
				}
				power = 0;
				coefficient = Integer.parseInt(input.substring(index+1, input.length()));
					
			}
			// Add the polynomial portion to the array
			polynomial[power] = coefficient;
		}
		
		return polynomial;
	}
}
