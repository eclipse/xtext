package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.compiler.XtendTypeReferenceSerializer
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

abstract class AbstractClassBuilder extends AbstractCodeBuilder {
	
	@Property String className
	
	override getImage() {
		'newclass_wiz.gif'
	}
	
}

class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtendTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && className != null && visibility == JvmVisibility::PUBLIC  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.append('class ').append(className).append(' {')
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

class JavaClassBuilder extends AbstractClassBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override isValid() {
		super.valid && className != null  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.appendVisibility(visibility, JvmVisibility::DEFAULT)
			.append('class ').append(className).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}