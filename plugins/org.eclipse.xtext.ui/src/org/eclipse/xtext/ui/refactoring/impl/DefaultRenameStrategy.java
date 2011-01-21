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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRenameStrategy implements IRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {

		@Inject
		private ILocationInFileProvider locationInFileProvider;
		
		public IRenameStrategy get(final EObject targetElement, IRenameElementContext renameElementContext) {
			return new DefaultRenameStrategy(targetElement, locationInFileProvider);
		}

	}

	protected String originalName;
	protected URI targetElementOriginalURI;
	protected ITextRegion originalNameRegion;
	private URI targetElementNewURI;

	protected DefaultRenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider) {
		this.targetElementOriginalURI = EcoreUtil.getURI(targetElement);
		EAttribute nameAttribute = getNameAttribute(targetElement);
		this.originalName = targetElement.eGet(nameAttribute).toString();
		if (Strings.isEmpty(originalName))
			throw new RefactoringStatusException("Target element does not have a name", false);
		originalNameRegion = locationInFileProvider.getFullTextRegion(targetElement, nameAttribute, 0);
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
		EObject renamedElement = setName(targetElementOriginalURI, newName, resourceSet);
		targetElementNewURI = EcoreUtil.getURI(renamedElement);
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		if(targetElementNewURI == null)
			return;
		setName(targetElementNewURI, originalName, resourceSet);
	}
	
	public void createDeclarationUpdates(String newName, IRefactoringUpdateAcceptor updateAcceptor) {
		updateAcceptor.accept(targetElementOriginalURI.trimFragment(), getDeclarationTextEdit(newName));
	}

	protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
		EObject targetElement = resourceSet.getEObject(targetElementURI, false);
		if(targetElement == null) {
			throw new RefactoringStatusException("Target element not loaded.", true);
		}
		EAttribute nameAttribute = getNameAttribute(targetElement);
		targetElement.eSet(nameAttribute, newName);
		return targetElement;
	}
	
	protected EAttribute getNameAttribute(EObject eObject) {
		return SimpleAttributeResolver.NAME_RESOLVER.getAttribute(eObject);
	}

	protected TextEdit getDeclarationTextEdit(String newName) {
		return new ReplaceEdit(originalNameRegion.getOffset(), originalNameRegion.getLength(), newName);
	}
	

}
