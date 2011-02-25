package org.eclipse.xtext.xtend2.tests.smoke

class Case_0 {

	String foo(String a, String b) {
		if (isUpper(a)) {
			another(a,b+'holla')
		} else {
			val x = a;
			for (y : b.toCharArray) {
				x = x+y
			}
			x
		}
	}
	
	private isUpper(String s) {
		s.toUpperCase == s
	}
		
	private another(String x, String y) { 
		y+x
	}
	

}