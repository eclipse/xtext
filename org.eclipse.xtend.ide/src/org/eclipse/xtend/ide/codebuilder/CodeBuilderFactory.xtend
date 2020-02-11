/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder

/** 
 * Creates {@link ICodeBuilder}s to insert Java or Xtend code snippets into an {@link IAppendable}.
 *  
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API 
 */
class CodeBuilderFactory {
	
	@Inject extension IXtendJvmAssociations
	@Inject extension IJavaElementFinder
	
	@Inject Provider<XtendClassBuilder> xtendClassBuilderProvider
	@Inject Provider<XtendInterfaceBuilder> xtendInterfaceBuilderProvider
	@Inject Provider<XtendAnnotationBuilder> xtendAnnotationBuilderProvider
	@Inject Provider<XtendFieldBuilder> xtendFieldBuilderProvider
	@Inject Provider<XtendConstructorBuilder> xtendConstructorBuilderProvider
	@Inject Provider<XtendMethodBuilder> xtendMethodBuilderProvider
	@Inject Provider<XtendParameterBuilder> xtendParameterBuilderProvider
	
	@Inject Provider<JavaClassBuilder> javaClassBuilderProvider
	@Inject Provider<JavaInterfaceBuilder> javaInterfaceBuilderProvider
	@Inject Provider<JavaAnnotationBuilder> javaAnnotationBuilderProvider
	@Inject Provider<JavaFieldBuilder> javaFieldBuilderProvider
	@Inject Provider<JavaConstructorBuilder> javaConstructorBuilderProvider
	@Inject Provider<JavaMethodBuilder> javaMethodBuilderProvider
	@Inject Provider<JavaParameterBuilder> javaParameterBuilderProvider
	
	def createClassBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendClassBuilderProvider.get
			else
				javaClassBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createInterfaceBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendInterfaceBuilderProvider.get
			else
				javaInterfaceBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createAnnotationBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendAnnotationBuilderProvider.get
			else
				javaAnnotationBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createFieldBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendFieldBuilderProvider.get
			else
				javaFieldBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createConstructorBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendConstructorBuilderProvider.get
			else
				javaConstructorBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createMethodBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendMethodBuilderProvider.get
			else
				javaMethodBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createParameterBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendTypeDeclaration) 
				xtendParameterBuilderProvider.get
			else
				javaParameterBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def Object getSource(JvmDeclaredType element) {
		val xtendType = element.primarySourceElement
		if(xtendType instanceof XtendTypeDeclaration)
			return xtendType
		val jvmElement = findExactElementFor(element)
		if(jvmElement instanceof IType)
			jvmElement
		else 
			null
	}
}

