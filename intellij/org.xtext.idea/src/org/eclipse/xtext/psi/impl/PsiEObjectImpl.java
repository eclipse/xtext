package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;

public class PsiEObjectImpl<T extends StubElement> extends StubBasedPsiElementBase<T> implements PsiEObject {

	private final IElementType elementType;

	protected PsiEObjectImpl(T stub, IStubElementType nodeType) {
		super(stub, nodeType);
		this.elementType = nodeType;
		getXtextLanguage().injectMembers(this);
	}

	public PsiEObjectImpl(ASTNode node) {
		super(node);
		this.elementType = node.getElementType();
		getXtextLanguage().injectMembers(this);
	}

	public EClass getEClass() {
		INode node = getINode();
		if (node.hasDirectSemanticElement()) {
			return node.getSemanticElement().eClass();
		}
		EReference eReference = getEReference();
		if (eReference != null) {
			return eReference.getEReferenceType();
		}
		return null;
	}

	public EReference getEReference() {
		if (elementType instanceof IGrammarAwareElementType) {
			EObject grammarElement = ((IGrammarAwareElementType) elementType).getGrammarElement();
			if (grammarElement instanceof CrossReference) {
				return GrammarUtil.getReference((CrossReference) grammarElement);
			}
		}
		INode node = getINode();
		if (node == null) {
			return null;
		}
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			return GrammarUtil.getReference((CrossReference) grammarElement);
		}
		if (node.hasDirectSemanticElement()) {
			EObject semanticElement = node.getSemanticElement();
			return semanticElement.eContainmentFeature();
		}
		return null;
	}

	public INode getINode() {
		return getContainingFile().getINode(getNode());
	}

	public boolean isRoot() {
		return getParent() instanceof BaseXtextFile;
	}

	public EObject getEObject() {
		return getINode().getSemanticElement();
	}

	public Resource getResource() {
		return getContainingFile().getResource();
	}

	public IXtextLanguage getXtextLanguage() {
		return (IXtextLanguage) getLanguage();
	}

	@Override
	public BaseXtextFile getContainingFile() {
		return (BaseXtextFile) super.getContainingFile();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getName());
		builder.append("(").append(elementType).append(")");
		return builder.toString();
	}

}