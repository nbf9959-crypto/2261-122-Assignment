void main() {
	char[] charSample = {'1','0','1','1'}; 
	int intSample = 2871; 
	System.out.println(String.format("Base10Converter.java execution\n## arrayToInteger() dispatched ~ \n\nchar sample: {%s} / base system: 2 / big-endian encoding: false --> result: %d\n", String.valueOf(charSample), arrayToInteger(charSample, 2, false))); 
	System.out.println(String.format("## integerToArray() dispatched ~ \n\ninteger sample: %d / base system: 8 / big-endian encoding: true --> result: {%s}\n",  intSample , String.valueOf(integerToArray( intSample , 8,  true)))); 
}

int charToInteger(char digit) {
	return (((int)digit) - (int)('0'));
}

int arrayToInteger(char[] digits, int base, boolean bEndianEncoding) {
	int result = 0; int placement = (digits.length - 1); 
	for(int x = 0; x < digits.length; x++) { 
		if(bEndianEncoding) {
			result += (charToInteger(digits[x]) * (Math.pow(base, placement))); placement--; 
		} else {
			result += (charToInteger(digits[x]) * (Math.pow(base, placement - 3))); placement++; 
		}
	}

	return result; 
}

char integerToChar(int digit) {
	char[] reference = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	return reference[digit];
}

double log(double value, int base) {
	return Math.log10(value)/Math.log10(base);
}

char[] integerToArray(int number, int base, boolean bEndianEncoding) {
	int iteriation = (int) log(number, base) + 1; 
	char[] results = new char[iteriation]; 

	int counterOperation = iteriation; 

	while(iteriation > 0) {
		int index = bEndianEncoding ? iteriation - 1 : Math.abs(iteriation - counterOperation);

		results[index] = integerToChar(number % base);
		
		number = (int) Math.floor(number/base); 
		iteriation--; 
	}

	return results; 
}