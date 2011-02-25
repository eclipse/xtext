package org.eclipse.xtext.xtend2.tests.smoke

class Case_4 {
	richStrings_01() {
		'''foobar'''
	}
	richStrings_02() {
		'''«'start'»
		  first line
		  second line
	    		'''
	}
	richStrings_03() {
		'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''
	}
	richStrings_04() {
		'''  «FOR a:'1'.toCharArray»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''
	}
	richStrings_05() {
		'''
			«FOR a:'1'.toCharArray»
			  «FOR a:'12'.toCharArray»foobar«ENDFOR»
			«ENDFOR»
		'''
	}
}