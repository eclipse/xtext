package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;

import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;

public class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> implements PsiNamedEObject<T> {

	private QualifiedName qualifiedName;

	private final IElementType nameType;

	public PsiNamedEObjectImpl(
			T stub,
			IStubElementType<?, ?> nodeType,
			IElementType nameType) {
		super(stub, nodeType);
		this.nameType = nameType;
	}

	public PsiNamedEObjectImpl(ASTNode node, IElementType nameType) {
		super(node);
		this.nameType = nameType;
	}

	public QualifiedName getQualifiedName() {
		PsiNamedEObjectStub<?> stub = getStub();
		if (stub != null) {
			return stub.getQualifiedName();
		}
		return qualifiedName;
	}

	public void setQualifiedName(QualifiedName qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	@Override
	public EClass getEClass() {
		PsiNamedEObjectStub<?> stub = getStub();
		if (stub != null) {
			return stub.getEClass();
		}
		return super.getEClass();
	}

	protected ASTNode getNameLeafElement() {
		ASTNode referenceNode = getNode().findChildByType(nameType);
		while (referenceNode instanceof CompositeElement) {
			referenceNode = referenceNode.getLastChildNode();
		}
		return referenceNode;
	}

	public PsiElement getNameIdentifier() {
		ASTNode nameLeafElement = getNameLeafElement();
		if (nameLeafElement == null) {
			return null;
		}
		return nameLeafElement.getPsi();
	}

	@Override
	public String getName() {
		PsiNamedEObjectStub<?> stub = getStub();
		if (stub != null) {
			return stub.getName();
		}
		PsiElement nameIdentifier = getNameIdentifier();
		if (nameIdentifier == null) {
			return null;
		}
		return nameIdentifier.getText();
	}

	public PsiElement setName(String name) throws IncorrectOperationException {
		ASTNode oldNode = getNameLeafElement();
		if (oldNode != null) {
			LeafElement newNode = ASTFactory.leaf(oldNode.getElementType(), name);
			CodeEditUtil.setNodeGenerated(newNode, true);
			oldNode.getTreeParent().replaceChild(oldNode, newNode);
		}
		return this;
	}

	@Override
	public int getTextOffset() {
		PsiElement nameIdentifier = getNameIdentifier();
		if (nameIdentifier == null) {
			return super.getTextOffset();
		}
		return nameIdentifier.getTextOffset();
	}

}