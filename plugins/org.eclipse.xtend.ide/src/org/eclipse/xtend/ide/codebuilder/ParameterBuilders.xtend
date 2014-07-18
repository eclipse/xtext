package org.eclipse.xtend.ide.codebuilder

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

abstract class AbstractParameterBuilder extends AbstractCodeBuilder {
	@Accessors String name
	@Accessors LightweightTypeReference type
	@Accessors boolean varArgsFlag
	@Accessors boolean extensionFlag
	@Accessors boolean finalFlag
	
	override build(ISourceAppender appendable) {
		appendable.appendModifiers
		if(varArgsFlag) 
			appendable.appendType((type as ArrayTypeReference).componentType, "Object").append('...')	
		else 
			appendable.appendType(type, "Object")
		appendable.append(" ").append(name)
	}
	
	protected def ISourceAppender appendModifiers(ISourceAppender appendable)

	override isValid() {
		type != null 
		&& (!varArgsFlag || type instanceof ArrayTypeReference)
		&& super.isValid()
	}
	
	override getImage() {
		'parameter.gif'
	}
}

class XtendParameterBuilder extends AbstractParameterBuilder {
	
	protected override appendModifiers(ISourceAppender appendable) {
		if(extensionFlag) 
			appendable.append("extension ")
		appendable
	}
}

class JavaParameterBuilder extends AbstractParameterBuilder {
	
	protected override appendModifiers(ISourceAppender appendable) {
		if(finalFlag) 
			appendable.append("final ")
		appendable
	}
	
	override isValid() {
		!extensionFlag && super.isValid()
	}
	
}
