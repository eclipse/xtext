package org.eclipse.xtext.purexbase.jvmmodel

class MyDispatchTest implements CharSequenceExtension {
	
	def dispatch operator_plus(CharSequence a, CharSequence b) {
		
	}
	
	def dispatch operator_plus(String a, CharSequence b) {
		
	}
	
	def dispatch operator_plus(StringBuilder a, CharSequence b) {
		
	}


}