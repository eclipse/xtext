package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.PsiNamedEObjectStub;

import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;

public class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub> extends PsiEObjectImpl<T> implements PsiNamedEObject<T> {

	private QualifiedName qualifiedName;

	private final IElementType nameType;

	public PsiNamedEObjectImpl(
			T stub,
			IStubElementType<? extends PsiNamedEObjectStub, ? extends PsiNamedEObject> nodeType,
			IElementType nameType) {
		super(stub, nodeType);
		this.nameType = nameType;
	}

	public PsiNamedEObjectImpl(ASTNode node, IElementType nameType) {
		super(node);
		this.nameType = nameType;
	}

	@Override
	public String getName() {
		PsiNamedEObjectStub stub = getStub();
		if (stub != null) {
			return stub.getName();
		}
		PsiElement nameIdentifier = getNameIdentifier();
		if (nameIdentifier == null) {
			return null;
		}
		return nameIdentifier.getText();
	}

	public QualifiedName getQualifiedName() {
		PsiNamedEObjectStub stub = getStub();
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
		PsiNamedEObjectStub stub = getStub();
		if (stub != null) {
			return stub.getEClass();
		}
		return super.getEClass();
	}

	public PsiElement setName(String name) throws IncorrectOperationException {
		PsiElement nameIdentifier = getNameIdentifier();
		if (nameIdentifier != null) {
			ASTNode nameNode = nameIdentifier.getNode();
			ASTNode oldNode = nameNode.getFirstChildNode();
			LeafElement newChild = ASTFactory.leaf(oldNode.getElementType(), name);
			CodeEditUtil.setNodeGenerated(newChild, true);
			nameNode.replaceChild(oldNode, newChild);
		}
		return this;
	}

	public PsiElement getNameIdentifier() {
		return findChildByType(nameType);
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
