/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import org.eclipse.xtext.psi.XtextPsiReference

class PsiEObjectReference<PsiE extends PsiElement, T extends StubElement<PsiE>> extends PsiEObjectImpl<PsiE, T> {

	protected new(T stub, IStubElementType<T, PsiE> nodeType) {
		super(stub, nodeType)
	}

	new(ASTNode node) {
		super(node)
	}

	override XtextPsiReference getReference() {
		new XtextPsiReferenceImpl(this)
	}

	override String toString() {
		var StringBuilder builder = new StringBuilder('org.eclipse.xtext.psi.impl.PsiEObjectReference')
		builder.append("(").append(elementType).append(")")
		return builder.toString()
	}

}
