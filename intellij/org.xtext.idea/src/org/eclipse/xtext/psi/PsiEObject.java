package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;

import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;

public interface PsiEObject extends PsiElement {
	
	Key<INode> XTEXT_NODE_KEY = new Key<INode>("XTEXT_NODE_KEY");

	Key<EReference> XTEXT_EREFERENCE_KEY = new Key<EReference>("XTEXT_EREFERENCE_KEY");
	
	INode getINode();
	
	EClass getEClass();
	
	EReference getEReference();

	boolean isRoot();

	EObject getEObject();

	Resource getResource();
	
	IXtextLanguage getXtextLanguage();

}
