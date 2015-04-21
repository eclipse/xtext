/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.psi.PsiAnonymousClass
import com.intellij.psi.PsiMirrorElement
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
class JvmPsiAnonymousClass implements PsiAnonymousClass, PsiMirrorElement {

	@Delegate
	val PsiAnonymousClass delegate

	override getNavigationElement() {
		JvmPsiElementExtensions.getNavigationElement(this) ?: delegate.navigationElement
	}

	override getPrototype() {
		this
	}

}