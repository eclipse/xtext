package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface PsiEObject extends XtextPsiElement {

	EClass getEClass();

	EReference getEReference();

	boolean isRoot();

	EObject getEObject();

}
