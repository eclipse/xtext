package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer

abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
	
	@Property String annotationName
	
	override getImage() {
		'newannotation_wiz.gif'
	}
	
}

class XtendAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtypeTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && annotationName != null && visibility == JvmVisibility::PUBLIC  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.append('annotation ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getInsertOffset() {
		getNewTypeInsertOffset(context, xtendClass)
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendClass() {
		ownerSource as XtendClass
	}
}

class JavaAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override isValid() {
		super.valid && annotationName != null  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.appendVisibility(visibility, JvmVisibility::DEFAULT)
			.append('@interface ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}