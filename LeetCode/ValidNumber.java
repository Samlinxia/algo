class ValidNumber {
	/* 
	consideration:
		1. 'e', '.' can appear only once; -> a boolean type denote whether appear already
		   '+/-' can appear twice
		2. '.': 1) if no digit prefix or postfix, view as a '0' auto-fill. so "3." & ".3" is both valid, equals 3.0 & 0.3
				2) Can't apear after 'e'
		3. 'e': 1)must digit prefix
		4. '+/-': 1)can appear twice.  once is leading;  another must follows a digit
		
	case:
		1. 3. -> valid
	*/
	public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        boolean hasSign = false;
        boolean hasDot = false;
        boolean hasExp = false;
        boolean preDigit = false;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                if (!preDigit || hasExp) {
                    return false;
                }
                preDigit = false;
                hasExp = true;
            } else if (c == '.') {
                if (hasDot || hasExp) {
                    return false;
                }
                hasDot = true;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (Character.isDigit(c)) {
                preDigit = true;
            } else { //alpha-betic or invalid char
                return false;
            }
            i++;
        }
        return preDigit;
    }
}