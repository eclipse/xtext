package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
	
	@Accessors String annotationName
	
	override getImage() {
		'newannotation_wiz.gif'
	}
	
}

class XtendAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && annotationName != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('annotation ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getInsertOffset() {
		getNewTypeInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

class JavaAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && annotationName != null  
	}	

	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
			.append('@interface ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}