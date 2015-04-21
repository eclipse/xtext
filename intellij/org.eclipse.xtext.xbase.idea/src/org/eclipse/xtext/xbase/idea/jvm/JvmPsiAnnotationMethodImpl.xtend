/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.PsiAnnotationMethodImpl
import com.intellij.psi.PsiMirrorElement

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiAnnotationMethodImpl extends PsiAnnotationMethodImpl implements PsiMirrorElement {
	
	new(ASTNode node) {
		super(node)
	}

	override getNavigationElement() {
		JvmPsiElementExtensions.getNavigationElement(this) ?: super.navigationElement
	}
	
	override getPrototype() {
		this
	}
	
}