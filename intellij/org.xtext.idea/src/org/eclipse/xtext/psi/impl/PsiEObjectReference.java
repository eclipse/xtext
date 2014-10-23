package org.eclipse.xtext.psi.impl;

import org.eclipse.xtext.psi.XtextPsiReference;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;

@SuppressWarnings("rawtypes")
public class PsiEObjectReference<T extends StubElement> extends PsiEObjectImpl<T> {

	protected PsiEObjectReference(T stub, IStubElementType nodeType) {
		super(stub, nodeType);
	}

	public PsiEObjectReference(ASTNode node) {
		super(node);
	}

	@Override
	public PsiReference getReference() {
		return new XtextPsiReference(this);
	}

}