/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
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

		public IRenameStrategy get(final EObject targetElement, final IRefactoringDocument targetDocument) {
			return new DefaultRenameStrategy(targetElement, locationInFileProvider);
		}

	}

	protected ITextRegion currentNameTextRegion;
	protected String currentName;

	protected DefaultRenameStrategy(EObject targetElement,
			ILocationInFileProvider locationInFileProvider) {
		EAttribute nameAttribute = getNameAttribute(targetElement);
		currentNameTextRegion = locationInFileProvider.getFullTextRegion(targetElement, nameAttribute, 0);
		currentName = targetElement.eGet(getNameAttribute(targetElement)).toString();
		if (Strings.isEmpty(currentName))
			throw new RefactoringStatusException("Target element does not have a name", false);
	}

	public String getCurrentName() {
		return currentName;
	}

	public ReplaceRegion getReplaceRegion(String newName) {
		if (Strings.isEmpty(newName))
			throw new RefactoringStatusException("New name is not set", false);
		return new ReplaceRegion(currentNameTextRegion.getOffset(), currentNameTextRegion.getLength(), newName);
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
