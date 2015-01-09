/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.presentation

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.idea.presentation.DefaultItemPresentationProvider
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedField
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.validation.UIStrings
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection

/**
 * @author kosyakov - Initial contribution and API
 */
class XbaseItemPresentationProvider extends DefaultItemPresentationProvider {

	@Inject UIStrings uiStrings

	@Inject CommonTypeComputationServices services

	@Inject IBatchTypeResolver typeResolver

	def dispatch text(JvmGenericType genericType) {
		genericType.simpleName
	}

	def dispatch text(JvmOperation element) {
		signature(element.simpleName, element)
	}

	def dispatch text(IResolvedOperation element) {
		val returnTypeString = element.resolvedReturnType.simpleName
		var decoratedPart = " : " + returnTypeString
		if (!element.typeParameters.isEmpty) {
			decoratedPart = " <" + uiStrings.toString(element.typeParameters) + "> : " + returnTypeString
		}
		element.declaration.simpleName + "(" + element.resolvedParameterTypes.map[humanReadableName].join(', ') + ")" +
			decoratedPart
	}

	def dispatch text(JvmConstructor constructor) {
		"new" + uiStrings.parameters(constructor)
	}

	def dispatch text(IResolvedConstructor constructor) {
		"new(" + constructor.resolvedParameterTypes.map[humanReadableName].join(', ') + ")"
	}

	def dispatch text(IResolvedField field) {
		field.simpleSignature+" : "+field.resolvedType.humanReadableName
	}

	def dispatch text(JvmField field) {
		field.simpleName + " : " + field.type.simpleName
	}

	def dispatch text(JvmFormalParameter parameter) {
		val parameterType = parameter.parameterType
		if (parameterType == null)
			parameter.name
		else
			parameterType.getSimpleName + " " + parameter.name
	}

	def dispatch text(XImportDeclaration it) 
		'''«importedTypeName»«IF wildcard».*«ELSEIF memberName != null».«memberName»«ENDIF»'''

	def dispatch text(XImportSection element) {
		'import declarations'
	}

	def dispatch text(XVariableDeclaration variableDeclaration) {
		val resolvedTypes = typeResolver.resolveTypes(variableDeclaration)
		val type = resolvedTypes.getActualType(variableDeclaration as JvmIdentifiableElement)
		if (type != null)
			type.humanReadableName + " " + variableDeclaration.name
		else 
			variableDeclaration.name
	}

	protected def signature(String simpleName, JvmIdentifiableElement element) {
		val returnType = if (element instanceof JvmOperation) {
				element.returnType
			} else if (element instanceof JvmField) {
				element.type
			} else {
				null
			}
		val owner = new StandardTypeReferenceOwner(services, element);
		val returnTypeString = if (returnType == null) {
				"void"
			} else {
				owner.toLightweightTypeReference(returnType).humanReadableName
			}
		var decoratedPart = " : " + returnTypeString
		val typeParam = uiStrings.typeParameters(element) ?: ""
		if (typeParam != "") {
			decoratedPart = " " + typeParam + " : " + returnTypeString
		}
		simpleName + uiStrings.parameters(element) + decoratedPart
	}

}