package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming

class GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension Naming naming
	
	def String getName(Grammar grammar, String prefix, String component) {
		grammar.basePackageRuntime + ".serializer." + prefix + grammar.name.toSimpleName + component
	}
	
	def String getQualifiedName() {
		grammar.qualifiedName;		
	}
	
	def String getQualifiedName(Grammar grammar) {
		// abstract		
	}
	
	def String getPackageName() {
		qualifiedName.toPackageName
	}
	
	def String getSimpleName() {
		qualifiedName.toSimpleName
	}
	
	def String getSimpleName(Grammar grammar) {
		grammar.qualifiedName.toSimpleName
	}
	
	def String getFileName() {
		qualifiedName.asPath + "." + fileExtension;
	}
	
	def String getFileExtension() {
		"java";
	}
	
	def CharSequence getFileContents() '''
		<not implemented>
	'''
}