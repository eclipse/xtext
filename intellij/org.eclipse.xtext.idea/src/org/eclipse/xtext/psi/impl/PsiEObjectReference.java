/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;

public class PsiEObjectReference<PsiE extends PsiElement, T extends StubElement<PsiE>> extends PsiEObjectImpl<PsiE, T> {

	protected PsiEObjectReference(T stub, IStubElementType<T, PsiE> nodeType) {
		super(stub, nodeType);
	}

	public PsiEObjectReference(ASTNode node) {
		super(node);
	}

	@Override
	public PsiReference getReference() {
		return new XtextPsiReferenceImpl(this);
	}

}