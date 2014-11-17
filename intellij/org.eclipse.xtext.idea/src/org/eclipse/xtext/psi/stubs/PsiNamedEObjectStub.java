package org.eclipse.xtext.psi.stubs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiNamedEObject;

import com.intellij.psi.stubs.NamedStub;

public interface PsiNamedEObjectStub<T extends PsiNamedEObject> extends NamedStub<T> {

	EClass getEClass();

	QualifiedName getQualifiedName();

}
