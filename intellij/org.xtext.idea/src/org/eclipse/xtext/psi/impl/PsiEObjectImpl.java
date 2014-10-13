package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.resource.ResourceInitializationService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.PsiEObject;

import com.google.inject.Inject;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;

public class PsiEObjectImpl<T extends StubElement> extends StubBasedPsiElementBase<T> implements PsiEObject {
	
	@Inject
	private ResourceInitializationService resourceInitializationService;
	
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
		return getNode().getUserData(XTEXT_EREFERENCE_KEY);
	}

	public INode getINode() {
		INode node = getNode().getUserData(XTEXT_NODE_KEY);
		EObject semanticElement = node.getSemanticElement();
		if (semanticElement != null) {
			Boolean ensureInitialized = getUserData(ResourceInitializationService.ENSURE_INITIALIZED);
			if (!Boolean.FALSE.equals(ensureInitialized)) {
				resourceInitializationService.ensureFullyInitialized(semanticElement.eResource());
			}
		}
		return node;
	}

	public boolean isRoot() {
		return getParent() instanceof BaseXtextFile;
	}

	public EObject getEObject() {
		return getINode().getSemanticElement();
	}

	public Resource getResource() {
		return getEObject().eResource();
	}

	public IXtextLanguage getXtextLanguage() {
		return (IXtextLanguage) getLanguage();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("PsiEObject");
		builder.append("(").append(elementType).append(")");
		EReference reference = getEReference();
		if (reference != null) {
			builder.append("(").append(reference.getName()).append(")");
		}
		EClass type = getEClass();
		if (type != null) {
			builder.append("(").append(type.getName()).append(")");
		}
		return builder.toString();
	}
}
