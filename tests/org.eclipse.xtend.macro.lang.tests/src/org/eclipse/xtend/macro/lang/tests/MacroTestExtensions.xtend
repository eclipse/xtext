package org.eclipse.xtend.macro.lang.tests

import org.eclipse.xtext.xbase.lib.Pair

class MacroTestExtensions {
	
	def Pair<String,CharSequence> xtend(CharSequence code) {
		'MyXtendFile.xtend' -> code
	}
	
	def Pair<String,CharSequence> macro(CharSequence code) {
		'MyMacroFile.macro' -> code
	}
}