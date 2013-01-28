package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer

abstract class AbstractClassBuilder extends AbstractCodeBuilder {
	
	@Property String className
	
	override getImage() {
		'newclass_wiz.gif'
	}
	
}

class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtypeTypeReferenceSerializer typeRefSerializer

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
		getNewTypeInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendType() {
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