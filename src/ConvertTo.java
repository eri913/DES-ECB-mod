public class ConvertTo {
	
	public static int[] toArrayOfIntegers(String str) {
		
		char[] ch = str.toCharArray();
		int[] strInt = new int[ch.length];
		String element = "";
		for(int i=0; i<ch.length; i++) {
			element = str.substring(i, i);
			strInt[i] = Integer.parseInt(element);
		}
		return strInt;
		
	}
	public static String toHex(String str) {
		
		String hexCode = " ";
	     String hCode = " ";
		//convert ASCII to HEX
	    char[] ch = str.toCharArray();

	    StringBuilder builder = new StringBuilder();
	    for (char c : ch) {
	       // Step-2 Use %H to format character to Hex
	       hCode = String.format("%H", c);
	       builder.append(hCode);
	    }
	    hexCode = builder.toString();
	    return  hexCode;
	}
	
public static String bintoHex(int[] str) {
		
	     String[] binCode = new String[16];
	     int k= 0;
	    StringBuilder builder = new StringBuilder();
	    for(int i=0; i<16; i++) {
	    	for(int j=0; j<4; j++) {
	    		 builder.append(String.valueOf(str[k]));
	    				k++;
	    	}
	    
	    	binCode[i] = String.valueOf(builder);
	    	builder.delete(0,  builder.length());
	    	
	    }	
	    	 StringBuilder builder2 = new StringBuilder();
	    	 
	    	 String element = "";
	    	 for(int n=0; n<16; n++) {
	    		 element = binToHex(binCode[n]);
	    		 builder2.append(element);
	    	 }
	    	 return String.valueOf(builder2);    
	}
	
	  public static String toBinary(String hex) {
	    //convert HEX to Binary
	    StringBuilder builder1 = new StringBuilder();
	    String binaryCode = " ";
	    char[] b_ch = hex.toCharArray();
	    for(char c : b_ch) {
	    	binaryCode = hexToBin(String.valueOf(c));
	    	builder1.append(" " +binaryCode);
	    }
	    String s = builder1.toString();
	   
	     return s;
	}
		public static String hexToBin(String hex){
	        hex = hex.replaceAll("0", "0000");
	        hex = hex.replaceAll("1", "0001");
	        hex = hex.replaceAll("2", "0010");
	        hex = hex.replaceAll("3", "0011");
	        hex = hex.replaceAll("4", "0100");
	        hex = hex.replaceAll("5", "0101");
	        hex = hex.replaceAll("6", "0110");
	        hex = hex.replaceAll("7", "0111");
	        hex = hex.replaceAll("8", "1000");
	        hex = hex.replaceAll("9", "1001");
	        hex = hex.replaceAll("A", "1010");
	        hex = hex.replaceAll("B", "1011");
	        hex = hex.replaceAll("C", "1100");
	        hex = hex.replaceAll("D", "1101");
	        hex = hex.replaceAll("E", "1110");
	        hex = hex.replaceAll("F", "1111");
	        return hex;
	    }
		
		public static String binToHex(String hex){
	        hex = hex.replaceAll("0000", "0");
	        hex = hex.replaceAll("0001", "1");
	        hex = hex.replaceAll("0010", "2");
	        hex = hex.replaceAll("0011", "3");
	        hex = hex.replaceAll("0100", "4");
	        hex = hex.replaceAll("0101", "5");
	        hex = hex.replaceAll("0110", "6");
	        hex = hex.replaceAll("0111", "7");
	        hex = hex.replaceAll("1000", "8");
	        hex = hex.replaceAll("1001", "9");
	        hex = hex.replaceAll("1010", "A");
	        hex = hex.replaceAll("1011", "B");
	        hex = hex.replaceAll("1100", "C");
	        hex = hex.replaceAll("1101", "D");
	        hex = hex.replaceAll("1110", "E");
	        hex = hex.replaceAll("1111", "F");
	        return hex;
	    }
	}
