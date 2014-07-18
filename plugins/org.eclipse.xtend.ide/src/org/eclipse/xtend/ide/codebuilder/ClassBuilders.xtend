package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractClassBuilder extends AbstractCodeBuilder {
	
	@Accessors String className
	
	override getImage() {
		'newclass_wiz.gif'
	}
	
}

class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && className != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
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
		ownerSource as XtendTypeDeclaration
	}
}

class JavaClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && className != null  
	}	

	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
			.append('class ').append(className).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}