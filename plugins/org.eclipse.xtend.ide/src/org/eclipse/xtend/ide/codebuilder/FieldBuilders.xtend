package org.eclipse.xtend.ide.codebuilder

import javax.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
	
	@Property String fieldName
	@Property JvmTypeReference fieldType
} 

class XtendFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtendTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets
	
	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.appendVisibility(visibility, JvmVisibility::PRIVATE)
			.appendType(fieldType, "Object").append(' ').append(fieldName)
	}

	override getInsertOffset() {
		getNewFieldInsertOffset(context, xtendClass)
	}
	
	override getXtendClass() {
		ownerSource as XtendClass
	}
}

class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.appendVisibility(visibility, JvmVisibility::DEFAULT)
			.appendType(fieldType, "Object").append(' ').append(fieldName).append(';')
	}

	override getIType() {
		ownerSource as IType
	}
}