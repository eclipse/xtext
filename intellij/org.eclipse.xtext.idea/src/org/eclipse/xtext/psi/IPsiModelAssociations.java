/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
