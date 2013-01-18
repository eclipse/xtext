package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import java.util.List
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

abstract class AbstractMethodBuilder extends AbstractCodeBuilder {
	
	@Property String methodName
	@Property JvmTypeReference returnType
	@Property List<JvmTypeReference> parameterTypes = emptyList

	def protected appendDefaultBody(IAppendable appendable, String statementSeparator) {
		appendable.append('throw new UnsupportedOperationException("TODO: auto-generated method stub")')
			.append(statementSeparator)
	}
}

class XtendMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtendTypeReferenceSerializer typeRefSerializer

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.append('def ')
			.appendVisibility(visibility, JvmVisibility::PUBLIC)
			.append(methodName)
			.appendParameters(parameterTypes)
			.append(' {').increaseIndentation.newLine
			.appendDefaultBody('')
			.decreaseIndentation.newLine
			.append('}')
	}

	override getInsertOffset() {
		val member = EcoreUtil2::getContainerOfType(context, typeof(XtendMember))
		if(member == null) 
			throw new RuntimeException("Cannot insert field without a reference member");
		val memberNode = NodeModelUtils::findActualNodeFor(member)
		memberNode.offset + memberNode.length
	}
	
	override getXtendClass() {
		ownerSource as XtendClass
	}
}

class JavaMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable
			.appendVisibility(visibility, JvmVisibility::PRIVATE)
			.appendType(returnType, "void").append(' ')
			.append(methodName)
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