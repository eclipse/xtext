/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;

public interface IPsiModelAssociations {
	EObject getEObject(PsiElement element);

	PsiElement getPsiElement(EObject object);

	PsiElement getPsiElement(IEObjectDescription objectDescription, Resource context);
	
	PsiFile getPsiFile(URI uri, ResourceSet context);
	
	PsiFile getPsiFile(URI uri, Project project);
}
