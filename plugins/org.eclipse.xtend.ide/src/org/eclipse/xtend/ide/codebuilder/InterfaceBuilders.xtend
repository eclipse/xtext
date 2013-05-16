package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer

abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
	
	@Property String interfaceName
	
	override getImage() {
		'newint_wiz.gif'
	}
	
}

class XtendInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtypeTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && interfaceName != null && visibility == JvmVisibility::PUBLIC  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.append('interface ').append(interfaceName).append(' {')
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

class JavaInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override isValid() {
		super.valid && interfaceName != null  
	}	

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.appendVisibility(visibility, JvmVisibility::DEFAULT)
			.append('interface ').append(interfaceName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}