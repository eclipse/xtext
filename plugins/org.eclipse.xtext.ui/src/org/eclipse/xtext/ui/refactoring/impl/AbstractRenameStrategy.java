/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractRenameStrategy implements IRenameStrategy {

	private String originalName;
	private URI targetElementOriginalURI;
	private URI targetElementNewURI;
	private EAttribute nameAttribute;

	protected AbstractRenameStrategy(EObject targetElement, EAttribute nameAttribute) {
		this.nameAttribute = nameAttribute;
		this.targetElementOriginalURI = EcoreUtil.getURI(targetElement);
		this.originalName = targetElement.eGet(nameAttribute).toString();
		if (Strings.isEmpty(originalName))
			throw new RefactoringStatusException("Target element does not have a name", false);
	}

	public String getOriginalName() {
		return originalName;
	}

	public RefactoringStatus validateNewName(String newName) {
		//TODO: Validate if name is valid in the meaning of the DataTypeRule / Terminal
		RefactoringStatus newRefactoringStatus = new RefactoringStatus();
		if (Strings.equal(newName, originalName))
			newRefactoringStatus.addWarning("Name should be different");
		return newRefactoringStatus;
	}

	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		EObject renamedElement = setName(targetElementOriginalURI, newName, resourceSet);
		targetElementNewURI = EcoreUtil.getURI(renamedElement);
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		if(targetElementNewURI == null)
			return;
		setName(targetElementNewURI, originalName, resourceSet);
	}
	
	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if(targetElement == null) {
			throw new RefactoringStatusException("Target element not loaded.", true);
		}
		targetElement.eSet(getNameAttribute(), newName);
		return targetElement;
	}
	
	protected URI getTargetElementOriginalURI() {
		return targetElementOriginalURI;
	}

	protected URI getTargetElementNewURI() {
		return targetElementNewURI;
	}

	protected EAttribute getNameAttribute() {
		return nameAttribute;
	}

}
