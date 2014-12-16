package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.intellij.psi.PsiElement;

public interface IPsiModelAssociations {
	EObject getEObject(PsiElement element);

	PsiElement getPsiElement(EObject object);

	PsiElement getPsiElement(IEObjectDescription objectDescription, Resource context);
}
