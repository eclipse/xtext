package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import static extension org.eclipse.xtext.util.Strings 

class GeneratedJavaClass {
	
	@Inject Grammar
	
	@Inject extension Naming
	
	String getName(String prefix, String component) {
		return grammar.basePackageRuntime + ".serializer." + prefix + grammar.name.toSimpleName + component;
	}
	
	String getQualifiedName() {
		// abstract		
	}
	
	String getPackageName() {
		qualifiedName.toPackageName
	}
	
	String getSimpleName() {
		qualifiedName.toSimpleName
	}
	
	String getFileName() {
		qualifiedName.asPath + ".java";
	}
	
	String getFileContents() {
		"<not implemented>";
	}
}