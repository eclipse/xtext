package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming

class GeneratedFile {
	
	@Inject Grammar
	
	@Inject extension Naming
	
	String getName(Grammar grammar, String prefix, String component) {
		grammar.basePackageRuntime + ".serializer." + prefix + grammar.name.toSimpleName + component
	}
	
	String getQualifiedName() {
		grammar.qualifiedName;		
	}
	
	String getQualifiedName(Grammar grammar) {
		// abstract		
	}
	
	String getPackageName() {
		qualifiedName.toPackageName
	}
	
	String getSimpleName() {
		qualifiedName.toSimpleName
	}
	
	String getSimpleName(Grammar grammar) {
		grammar.qualifiedName.toSimpleName
	}
	
	String getFileName() {
		qualifiedName.asPath + "." + fileExtension;
	}
	
	String getFileExtension() {
		"java";
	}
	
	String getFileContents() {
		"<not implemented>";
	}
}