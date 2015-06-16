/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.intellij.psi.PsiArrayType
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiNameHelper
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypeParameter
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.access.impl.Primitives
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants

class StubURIHelper implements URIHelperConstants {

	def getFullURI(String name) {
		createURIBuilder.appendClassResourceURI(name).append('#').appendTypeFragment(name).createURI
	}

	def createResourceURI(String name) {
		createURIBuilder.appendClassResourceURI(name).createURI
	}

	def getFragment(String name) {
		createFragmentBuilder.appendTypeFragment(name).toString
	}

	protected def appendClassResourceURI(StringBuilder builder, String name) {
		val topLevelTypeName = name.trimInnerType.trimBrackets
		if (Primitives.forName(topLevelTypeName) !== null) {
			builder.append(PRIMITIVES)
		} else {
			builder.append(OBJECTS).append(topLevelTypeName)
		}
		return builder
	}

	protected def trimInnerType(String name) {
		val innerTypeIndex = name.indexOf('$')
		if (innerTypeIndex == -1) {
			return name
		}
		val simpleNameIndex = name.lastIndexOf('.')
		if (simpleNameIndex + 1 == innerTypeIndex) {
			return name
		}
		return name.substring(0, innerTypeIndex)
	}

	protected def trimBrackets(String name) {
		if (name.endsWith("]")) {
			val endIndex = name.indexOf('[')
			return name.substring(0, endIndex)	
		} else {
			return name
		}
	}

	protected def appendTypeFragment(StringBuilder builder, String name) {
		builder.append(name)
	}

	def getFullURI(PsiClass psiClass) {
		createURIBuilder.appendFullURI(psiClass).createURI
	}

	def getFullURI(PsiMethod method) {
		if (method.parameterList.parametersCount != 0) {
			throw new IllegalArgumentException(method.toString)
		}
		createURIBuilder.appendFullURI(method.containingClass).append('.').append(method.name).append("()").createURI
	}

	def getFullURI(PsiField field) {
		createURIBuilder.appendFullURI(field.containingClass).append('.').append(field.name).createURI
	}

	def getFullURI(PsiType type) throws UnresolvedPsiClassType {
		createURIBuilder.appendFullURI(type).createURI
	}

	protected def appendFullURI(StringBuilder it, PsiType type) throws UnresolvedPsiClassType {
		appendTypeResourceURI(type).append('#').appendTypeFragment(type)
	}
	
	protected def appendFullURI(StringBuilder it, PsiClass psiClass) {
		appendClassResourceURI(psiClass).append('#').appendClassFragment(psiClass)
	}

	protected def StringBuilder appendTypeResourceURI(StringBuilder builder, PsiType type) throws UnresolvedPsiClassType {
		switch type {
			PsiArrayType:
				builder.appendTypeResourceURI(type.componentType)
			PsiPrimitiveType:
				builder.append(PRIMITIVES)
			PsiClassType: {
				val resolveResult = type.resolveGenerics
				if (!resolveResult.validResult) {
					throw new UnresolvedPsiClassType(type, resolveResult)
				}
				builder.appendClassResourceURI(resolveResult.element)
			}
			default:
				throw new IllegalStateException("Unknown type: " + type)
		}
	}

	protected def StringBuilder appendClassResourceURI(StringBuilder builder, PsiClass psiClass) {
		if (psiClass instanceof PsiTypeParameter) {
			return builder.appendTypeParameterResourceURI(psiClass)
		}
		val containingClass = psiClass.containingClass
		if (containingClass != null) {
			builder.appendClassResourceURI(containingClass)
		} else {
			builder.append(OBJECTS).append(psiClass.qualifiedName)
		}
	}

	protected def appendTypeParameterResourceURI(StringBuilder builder, PsiTypeParameter typeParameter) {
		switch owner : typeParameter.owner {
			PsiClass: builder.appendClassResourceURI(owner)
			PsiMethod: builder.appendClassResourceURI(owner.containingClass)
		}
	}

	protected def StringBuilder appendTypeFragment(StringBuilder builder, PsiType type) throws UnresolvedPsiClassType {
		switch type {
			PsiPrimitiveType:
				builder.append(type.getCanonicalText(false))
			PsiClassType: {
				val resolveResult = type.resolveGenerics
				if (!resolveResult.validResult) {
					throw new UnresolvedPsiClassType(type, resolveResult)
				}
				builder.appendClassFragment(resolveResult.element)
			}
			PsiArrayType:
				builder.appendTypeFragment(type.componentType).append('[]')
			default:
				throw new IllegalStateException("Unknown type: " + type)
		}
	}

	protected def StringBuilder appendClassFragment(StringBuilder builder, PsiClass psiClass) {
		if (psiClass instanceof PsiTypeParameter) {
			return builder.appendTypeParameterFragment(psiClass);	
		}
		val containingClass = psiClass.containingClass
		if (containingClass == null) {
			return builder.append(psiClass.qualifiedName)
		} else {
			return builder.appendClassFragment(containingClass).append('$').append(psiClass.name)
		}
	}

	protected def appendTypeParameterFragment(StringBuilder builder, PsiTypeParameter typeParameter) {
		// TODO type parameters of method should be resolved in the produced type
		switch owner : typeParameter.owner {
			PsiClass: builder.appendClassFragment(owner)
			PsiMethod: builder.appendMethodFragment(owner)
		}
		return builder.append('/').append(typeParameter.name)
	}

	protected def appendMethodFragment(StringBuilder builder, PsiMethod method) {
		builder.appendClassFragment(method.containingClass)
		builder.append('.').append(method.name).append('(')
		val parameterList = method.parameterList
		val parameterCount = parameterList.parametersCount
		if (parameterCount > 0) {
			val parameters = parameterList.parameters			
			for (var i = 0; i < parameterCount; i++) {
				if (i != 0) {
					builder.append(',')
				}
				builder.appendTypeName(parameters.get(i).type)
			}
		}
		return builder.append(')')
	}

	def StringBuilder appendTypeName(StringBuilder builder, PsiType type) {
		switch type {
			PsiPrimitiveType:
				builder.append(type.canonicalText)
			PsiClassType: {
				val resolved = type.resolve
				switch resolved {
					PsiTypeParameter: builder.append(resolved.name)
					case resolved != null: builder.appendTypeName(resolved)
					default: builder.append(PsiNameHelper.getQualifiedClassName(type.canonicalText, false))
				}
			}
			PsiArrayType:
				builder.appendTypeName(type.componentType).append('[]')
			default:
				throw new IllegalStateException("Unknown type: " + type?.canonicalText)
		}
	}
	
	private def StringBuilder appendTypeName(StringBuilder builder, PsiClass clazz) {
		val container = clazz.containingClass
		if (container !== null) {
			builder.appendTypeName(container).append('$').append(clazz.name)
		} else {
			builder.append(clazz.qualifiedName)
		}
	}

	protected def createURIBuilder() {
		new StringBuilder(48).append(URIHelperConstants.PROTOCOL).append(':')
	}

	protected def createFragmentBuilder() {
		new StringBuilder(32)
	}

	protected def createURI(StringBuilder uriBuilder) {
		URI.createURI(uriBuilder.toString())
	}

}