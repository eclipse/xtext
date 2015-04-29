/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi.impl

import com.google.inject.Inject
import com.intellij.psi.PsiInvalidElementAccessException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.impl.XtextFileAwareEObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses

/**
 * @author kosyakov - Initial contribution and API
 */
class StubBasedJvmPsiClass implements JvmPsiClass {

	@Inject
	JvmPsiClasses jvmPsiClasses

	@Inject
	extension IPsiModelAssociations

	JvmPsiClass delegate

	@Accessors
	IEObjectDescription objectDescription

	@Delegate
	synchronized def JvmPsiClass getDelegate() {
		if (delegate == null) {
			delegate = objectDescription.getPsiElement(xtextFile.resource) as JvmPsiClass
		}
		delegate
	}

	override getType() {
		objectDescription.EClass
	}

	override getQualifiedName() {
		objectDescription.qualifiedName.toString.replace('$', '.')
	}

	override getName() {
		jvmPsiClasses.getShortName(objectDescription.qualifiedName)
	}

	override getContainingFile() throws PsiInvalidElementAccessException {
		xtextFile
	}

	override getProject() throws PsiInvalidElementAccessException {
		xtextFile.project
	}

	override getManager() {
		xtextFile.manager
	}

	def getXtextFile() {
		if(objectDescription instanceof XtextFileAwareEObjectDescription) objectDescription.xtextFile
	}

	override toString() {
		StubBasedJvmPsiClass.simpleName + ':' + qualifiedName
	}

}