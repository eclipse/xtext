package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;

import com.intellij.psi.stubs.NamedStub;

public interface PsiNamedEObjectStub<T extends PsiNamedEObject> extends NamedStub<T> {

	EClass getEClass();

	QualifiedName getQualifiedName();

}
