package org.eclipse.xtend.core.tests.smoke

class Case_4 {
	def richStrings_01() {
		'''foobar'''
	}
	def richStrings_02()
		'''«'start'»
		  first line
		  second line
	    		'''
	def richStrings_03() {
		'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''
	}
	def richStrings_04() {
		'''  «FOR a:'1'.toCharArray»«FOR a2:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''
	}
	def richStrings_05() {
		'''
			«FOR a:'1'.toCharArray»
			  «FOR a2:'12'.toCharArray»foobar«ENDFOR»
			«ENDFOR»
		'''
	}
}