package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.lazy.CrossReferenceDescription.CrossReferenceDescriptionProvider;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;
import org.eclipse.xtext.psi.PsiEObjectReference;
import org.eclipse.xtext.psi.PsiReferenceEObject;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;

@SuppressWarnings("rawtypes")
public class PsiReferenceEObjectImpl<T extends StubElement> extends PsiEObjectImpl<T> implements PsiReferenceEObject {
	
	@Inject
	private CrossReferenceDescriptionProvider crossReferenceDescriptionProvider;

	protected PsiReferenceEObjectImpl(T stub, IStubElementType nodeType) {
		super(stub, nodeType);
	}

	public PsiReferenceEObjectImpl(ASTNode node) {
		super(node);
	}

    @Override
    public PsiReference getReference() {
    	ASTNode node = getNode();
		TextRange textRange = node.getTextRange();
    	TextRange childRange = node.getLastChildNode().getTextRange();
    	int startOffset = childRange.getStartOffset() - textRange.getStartOffset();
		int endOffset = startOffset + childRange.getLength();
		return new PsiEObjectReference(this, new TextRange(startOffset, endOffset));
    }

	public Integer getIndex() {
		return getNode().getUserData(XTEXT_INDEX_KEY);
	}

	public EObject getEContext() {
		return getNode().getUserData(XTEXT_ECONTEXT_KEY);
	}

	public ICrossReferenceDescription getCrossReferenceDescription() {
		Integer index = getIndex();
		EObject context = getEContext();
		EReference reference = getEReference();
		return crossReferenceDescriptionProvider.get(context, reference, index);
	}

}
