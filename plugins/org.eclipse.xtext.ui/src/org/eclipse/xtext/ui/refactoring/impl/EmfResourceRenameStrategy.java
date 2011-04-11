/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.0
 */
public class EmfResourceRenameStrategy implements IRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {
		
		@Inject
		private EmfResourceChangeUtil changeUtil;

		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if(targetEObject instanceof ENamedElement)
				return new EmfResourceRenameStrategy((ENamedElement) targetEObject, changeUtil);
			else 
				return null;
		}
	}

	private URI targetEObjectURI;
	private String originalName;
	private EmfResourceChangeUtil changeUtil;

	protected EmfResourceRenameStrategy(ENamedElement targetEObject, EmfResourceChangeUtil changeUtil) {
		this.changeUtil = changeUtil;
		this.targetEObjectURI = EcoreUtil.getURI(targetEObject);
		this.originalName = targetEObject.getName();
	}

	public String getOriginalName() {
		return originalName;
	}

	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus newRefactoringStatus = new RefactoringStatus();
		if (Strings.equal(newName, originalName))
			newRefactoringStatus.addWarning("Name should be different");
		return newRefactoringStatus;
	}

	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		EObject target = resourceSet.getEObject(targetEObjectURI, true);
		if(!(target instanceof ENamedElement))
			throw new RefactoringStatusException("Target element cannot be resolved", true);
		((ENamedElement)target).setName(newName);
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		EObject target = resourceSet.getEObject(targetEObjectURI, true);
		if(!(target instanceof ENamedElement))
			throw new RefactoringStatusException("Target element cannot be resolved", true);
		((ENamedElement)target).setName(originalName);
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor) {
		applyDeclarationChange(newName, resourceSet);
		Resource targetResource = resourceSet.getResource(targetEObjectURI.trimFragment(), false);
		try {
			changeUtil.addSaveAsUpdate(targetResource, updateAcceptor);
		} catch(IOException exc) {
			throw new RefactoringStatusException(exc, true);
		}
	}

	
}
