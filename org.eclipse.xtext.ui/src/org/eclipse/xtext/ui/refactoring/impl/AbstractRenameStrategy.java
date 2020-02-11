/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;

/**
 * Base class for all {@link IRenameStrategy} implementations. Performs the declaration updates on a semantic EMF model.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractRenameStrategy implements DefaultRenameStrategyProvider.IInitializable {

	private String originalName;
	private URI targetElementOriginalURI;
	private URI targetElementNewURI;
	private EAttribute nameAttribute;
	
	@Override
	public boolean initialize(EObject targetElement, IRenameElementContext context) {
		this.nameAttribute = getNameAttribute(targetElement);
		if(nameAttribute == null)
			return false;
		this.targetElementOriginalURI = EcoreUtil.getURI(targetElement);
		this.originalName = targetElement.eGet(nameAttribute).toString();
		return !Strings.isEmpty(originalName);
	}

	
	@Override
	public String getOriginalName() {
		return originalName;
	}

	@Override
	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus status = new RefactoringStatus();
		return status;
	}

	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		EObject renamedElement = setName(targetElementOriginalURI, newName, resourceSet);
		targetElementNewURI = EcoreUtil.getURI(renamedElement);
	}

	@Override
	public void revertDeclarationChange(ResourceSet resourceSet) {
		if (targetElementNewURI == null)
			return;
		setName(targetElementNewURI, originalName, resourceSet);
	}

	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if (targetElement == null) {
			throw new RefactoringException("Target element not loaded.");
		}
		targetElement.eSet(nameAttribute, newName);
		return targetElement;
	}

	protected URI getTargetElementOriginalURI() {
		return targetElementOriginalURI;
	}

	protected URI getTargetElementNewURI() {
		return targetElementNewURI;
	}

	protected EAttribute getNameAttribute(EObject targetElement) {
		return SimpleAttributeResolver.NAME_RESOLVER.getAttribute(targetElement);
	}
	
	protected EAttribute getNameAttribute() {
		return nameAttribute;
	}

}
