package org.eclipse.xtext.xtend2.tests.smoke

class Case_2 {

	aOrB(String a, String b) {
		if (a.isNullOrEmpty()) 
			b
		else
			a 
	}
	
	returnInIf() {
		if ('x'!='x') return 'xx' else return 'yy'
	}

}