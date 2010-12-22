/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultRenameStrategy implements IRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {

		@Inject
		private ILocationInFileProvider locationInFileProvider;
		
		public IRenameStrategy get(final EObject targetElement) {
			return new DefaultRenameStrategy(targetElement, locationInFileProvider);
		}

	}

	protected String currentName;
	protected URI targetElementURI;
	protected ITextRegion currentNameRegion;

	protected DefaultRenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider) {
		this.targetElementURI = EcoreUtil.getURI(targetElement);
		EAttribute nameAttribute = getNameAttribute(targetElement);
		this.currentName = targetElement.eGet(nameAttribute).toString();
		if (Strings.isEmpty(currentName))
			throw new RefactoringStatusException("Target element does not have a name", false);
		currentNameRegion = locationInFileProvider.getFullTextRegion(targetElement, nameAttribute, 0);
	}

	public String getCurrentName() {
		return currentName;
	}

	public void applyChange(String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if(targetElement == null) {
			throw new RefactoringStatusException("Target element not loaded.", true);
		}
		EAttribute nameAttribute = getNameAttribute(targetElement);
		targetElement.eSet(nameAttribute, newName);
	}
	
	public ReplaceRegion getReplaceRegion(String newName) {
		return new ReplaceRegion(currentNameRegion.getOffset(), currentNameRegion.getLength(), newName);
	}
	
	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus newRefactoringStatus = new RefactoringStatus();
		if (Strings.equal(newName, currentName))
			newRefactoringStatus.addWarning("Name should be different");
		return newRefactoringStatus;
	}

	protected EAttribute getNameAttribute(EObject eObject) {
		return SimpleAttributeResolver.NAME_RESOLVER.getAttribute(eObject);
	}

}
