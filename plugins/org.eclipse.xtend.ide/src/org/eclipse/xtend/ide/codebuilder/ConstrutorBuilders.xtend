package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import java.util.List
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

abstract class AbstractConstructorBuilder extends AbstractCodeBuilder {
	
	@Property List<JvmTypeReference> parameterTypes = emptyList

	def protected appendDefaultBody(IAppendable appendable, String statementSeparator) {
		appendable.append('throw new UnsupportedOperationException("TODO: auto-generated method stub")')
			.append(statementSeparator)
	}
}

class XtendConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtendTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable
			.appendVisibility(visibility, JvmVisibility::PUBLIC)
			.append('new')
			.appendParameters(parameterTypes)
			.append(' {').increaseIndentation.newLine
			.appendDefaultBody('')
			.decreaseIndentation.newLine
			.append('}')
	}

	override getInsertOffset() {
		getNewConstructorInsertOffset(context, xtendClass)
	}
	
	override getXtendClass() {
		ownerSource as XtendClass
	}
}

class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable
			.appendVisibility(visibility, JvmVisibility::PRIVATE)
			.append(owner.simpleName)
			.appendParameters(parameterTypes)
			.append(' {').increaseIndentation.newLine
			.appendDefaultBody(';')
			.decreaseIndentation.newLine
			.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}