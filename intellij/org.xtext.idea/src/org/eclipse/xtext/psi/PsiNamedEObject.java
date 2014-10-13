package org.eclipse.xtext.psi;

import org.eclipse.xtext.naming.QualifiedName;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;

public interface PsiNamedEObject<T extends PsiNamedEObjectStub> extends PsiEObject, PsiNameIdentifierOwner, StubBasedPsiElement<T> {

	QualifiedName getQualifiedName();

	void setQualifiedName(QualifiedName qualifiedName);

}
