/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl;

import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;

@SuppressWarnings("rawtypes")
public class PsiEObjectReference<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> {

	protected PsiEObjectReference(T stub, IStubElementType nodeType) {
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