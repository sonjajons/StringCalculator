package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		if(text.contains("//")){
			text = formatStrDelim(text);
		}
		if(text.contains("\n")){
			text = text.replace("\n", ",");
		}

		if(!text.equals("")){
			text = removeFirst(text);
		}

		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.equals("")){
			return 0;
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) < 0){
	        		throw new RuntimeException("Negatives not allowed: " + number);
	        }
		    total += toInt(number);
		}
		return total;
    }

    private static String formatStrDelim(String text){
    	String delim = text.substring(2,3);
		
		text = text.substring(3);
		text = text.replace(delim, ",");
		return text;
    }

    private static String removeFirst(String text){
    	String first = text.substring(0,1);
			if(first.equals(",")){
				text = text.replaceFirst(",", "");
			}
		return text;
    }



}