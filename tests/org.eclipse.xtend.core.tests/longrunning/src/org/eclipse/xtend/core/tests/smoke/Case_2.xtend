package org.eclipse.xtend.core.tests.smoke

class Case_2 {

	def aOrB(String a, String b) {
		if (a.isNullOrEmpty()) 
			b
		else
			a 
	}
	
	def returnInIf() {
		if ('x'!='x') return 'xx' else return 'yy'
	}

}