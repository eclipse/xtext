package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
	
	@Accessors String interfaceName
	
	override getImage() {
		'newint_wiz.gif'
	}
	
}

class XtendInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && interfaceName != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
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

class JavaInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && interfaceName != null  
	}	

	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
			.append('interface ').append(interfaceName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}