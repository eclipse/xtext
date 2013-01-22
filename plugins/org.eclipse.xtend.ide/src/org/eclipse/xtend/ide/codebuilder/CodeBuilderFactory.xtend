/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import com.google.inject.Provider
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.jdt.annotation.NonNullByDefault

/** 
 * Creates {@link ICodeBuilder}s to insert Java or Xtend code snippets into an {@link IAppendable}.
 *  
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API 
 */
@NonNullByDefault
class CodeBuilderFactory {
	
	@Inject extension IXtendJvmAssociations
	@Inject extension IJavaElementFinder
	
	@Inject Provider<XtendClassBuilder> xtendClassBuilderProvider
	@Inject Provider<XtendFieldBuilder> xtendFieldBuilderProvider
	@Inject Provider<XtendConstructorBuilder> xtendConstructorBuilderProvider
	@Inject Provider<XtendMethodBuilder> xtendMethodBuilderProvider
	
	@Inject Provider<JavaClassBuilder> javaClassBuilderProvider
	@Inject Provider<JavaFieldBuilder> javaFieldBuilderProvider
	@Inject Provider<JavaConstructorBuilder> javaConstructorBuilderProvider
	@Inject Provider<JavaMethodBuilder> javaMethodBuilderProvider
	
	def createClassBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendClass) 
				xtendClassBuilderProvider.get
			else
				javaClassBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createFieldBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof XtendClass) 
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
			if(ownerSource instanceof XtendClass) 
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
			if(ownerSource instanceof XtendClass) 
				xtendMethodBuilderProvider.get
			else
				javaMethodBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def Object getSource(JvmDeclaredType element) {
		if(element instanceof JvmGenericType) {
			val xtendClass = (element as JvmGenericType).xtendClass
			if(xtendClass != null)
				return xtendClass
		}  
		val jvmElement = findExactElementFor(element)
		if(jvmElement instanceof IType)
			jvmElement
		else 
			null
	}
}

