package org.eclipse.xtext.xtend2.tests.smoke

class Case_0 {

	def String foo(String a, String b) {
		if (isUpper(a)) {
			another(a,b+'holla')
		} else {
			var x = a;
			for (y : b.toCharArray) {
				x = x+y
			}
			x
		}
	}
	
	def isUpper(String s) {
		s.toUpperCase == s
	}
		
	def another(String x, String y) { 
		y+x
	}
	

}