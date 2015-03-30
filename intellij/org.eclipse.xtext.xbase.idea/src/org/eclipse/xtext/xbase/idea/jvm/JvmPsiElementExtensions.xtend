/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.google.inject.Provider
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.EObject

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiElementExtensions {

	public static val JVM_ELEMENT_KEY = Key.<EObject>create('org.eclipse.xtext.jvm.jvmElement')

	public static val NAVIGATION_ELEMENT_PROVIDER_KEY = Key.<Provider<PsiElement>>create(
		'org.eclipse.xtext.jvm.navigationElementProvider'
	)

	static def getJvmElement(PsiElement it) {
		getUserData(JVM_ELEMENT_KEY)
	}

	static def void setJvmElement(PsiElement it, EObject jvmElement) {
		putUserData(JVM_ELEMENT_KEY, jvmElement)
	}

	static def getNavigationElement(PsiElement it) {
		navigationElementProvider?.get
	}

	static def getNavigationElementProvider(PsiElement it) {
		getUserData(NAVIGATION_ELEMENT_PROVIDER_KEY)
	}

	static def void setNavigationElementProvider(PsiElement it, Provider<PsiElement> navigationElementProvider) {
		putUserData(NAVIGATION_ELEMENT_PROVIDER_KEY, navigationElementProvider)
	}

}