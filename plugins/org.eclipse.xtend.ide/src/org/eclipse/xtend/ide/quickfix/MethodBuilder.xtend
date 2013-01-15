/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Collections
import java.util.Set
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions$CompletionDataAcceptor
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.typing.ITypeProvider

import static org.eclipse.xtext.common.types.util.Primitives$Primitive.*
import static org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions$VariableType.*
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

/**
 * @author Sebastian Benz - Initial contribution and API
 */
class MethodBuilderProvider {

	@Inject Provider<XtendMethodBuilder> xtendMethodBuilderProvider
	@Inject Provider<JavaMethodBuilder> javaMethodBuilderProvider

	def newXtendMethodBuilder(String methodName, XAbstractFeatureCall call) {
		xtendMethodBuilderProvider.invoke(methodName, call)
	}

	def newJavaMethodBuilder(String methodName, XAbstractFeatureCall call) {
		javaMethodBuilderProvider.invoke(methodName, call)
	}

	def protected invoke(Provider<? extends XtendMethodBuilder> provider, String methodName, XAbstractFeatureCall call) {
		val builder = provider.get
		builder.methodName = methodName
		builder.featureCall = call
		builder
	}
}

class XtendMethodBuilder {

	@Inject extension ITypeProvider
	@Inject extension JdtVariableCompletions
	@Inject extension Primitives
	@Inject extension ExpectedTypeResolver
	@Inject extension TypeReferenceSerializer

	@Property String methodName
	@Property boolean isInterface
	@Property XAbstractFeatureCall featureCall

	def build(IAppendable appendable) {
		appendable => [
			addPrefix
			addName
			addArguments
			addBody
		]
	}

	def protected addName(IAppendable appendable) {
		appendable.append(methodName)
	}

	def protected addPrefix(IAppendable appendable) {
		appendable.append("def ")
	}

	def protected addBody(IAppendable appendable) {
		if(isInterface) return appendable.append(";");
		appendable.append(
			'''
				{
					«returnStatement»
				}
			''')
	}

	def protected returnStatement() {
		if (featureCall == null || featureCall.isVoid) {
			return ""
		} else {
			return defaultReturnStatement
		}
	}

	def protected defaultReturnStatement() {
		val expectedType = returnType
		val result = new StringBuilder("return ")
		if (isPrimitive(expectedType)) {
			val primitiveKind = primitiveKind(expectedType.type as JvmPrimitiveType)
			switch (primitiveKind) {
				case Boolean:
					result.append("false")
				default:
					result.append("0")
			}
		} else {
			return result.append("null")
		}
		return result
	}

	def protected isVoid(XAbstractFeatureCall featureCall) {
		val returnType = returnType()
		return returnType == null || returnType.simpleName == "void"
	}

	def protected returnType() {
		featureCall.expectedType
	}

	def protected addArguments(IAppendable appendable) {
		if (featureCall == null) {
			return appendable.append("()")
		}
		var iterator = if (featureCall instanceof XMemberFeatureCall) {
				(featureCall as XMemberFeatureCall).memberCallArguments.iterator
			} else {
				featureCall.explicitArguments.iterator
			}
		val notallowed = <String>newHashSet()
		appendable.append("(")

		while (iterator.hasNext()) {
			val expression = iterator.next()
			val typeRef = expression.type
			if (typeRef != null) {
				appendable.append(typeRef)
				appendable.append(" ")
				val acceptor = new VariableNameAcceptor(notallowed)
				getVariableProposals(typeRef.getIdentifier(), featureCall, PARAMETER, notallowed, acceptor)
				appendable.append(acceptor.getVariableName())
			}
			if (iterator.hasNext())
				appendable.append(", ")
		}
		appendable.append(")")
	}

	def protected append(IAppendable appendable, JvmTypeReference typeRef) {
		if (typeRef == null) {
			appendable.append("void")
		} else {
			val resolvedExpectedType = featureCall.resolveExpectedType(typeRef)
			resolvedExpectedType.serialize(featureCall, appendable)
		}
		appendable
	}

}

class JavaMethodBuilder extends XtendMethodBuilder {

	override protected defaultReturnStatement() {
		super.defaultReturnStatement().append(";")
	}

	override protected addPrefix(IAppendable appendable) {
		appendable.append("public ").append(returnType).append(" ")
	}

}

class VariableNameAcceptor implements JdtVariableCompletions$CompletionDataAcceptor {

	val Set<String> notallowed
	val Set<String> variableNames = newHashSet()

	new(Set<String> notallowed) {
		this.notallowed = notallowed;
	}

	override accept(String replaceText, StyledString label, Image img) {
		variableNames.add(replaceText);
		notallowed.add(replaceText);
	}

	def getVariableName() {
		val candidates = Lists::newArrayList(variableNames);
		Collections::sort(candidates,
			[ left, right |
				if (left.length() < right.length()) {
					return -1;
				} else if (left.length() > right.length()) {
					return 1;
				} else {
					return 0;
				}
			])
		if (candidates.size > 0)
			return candidates.get(0)
		return ""
	}
}
