/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class DefaultRenameStrategy extends AbstractRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {

		@Inject
		private ILocationInFileProvider locationInFileProvider;
		
		public IRenameStrategy get(final EObject targetElement, IRenameElementContext renameElementContext) {
			return new DefaultRenameStrategy(targetElement, locationInFileProvider);
		}

		protected ILocationInFileProvider getLocationInFileProvider() {
			return locationInFileProvider;
		}
	}

	protected ITextRegion originalNameRegion;

	protected DefaultRenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider) {
		super(targetElement);
		originalNameRegion = locationInFileProvider.getFullTextRegion(targetElement, getNameAttribute(targetElement), 0);
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor) {
		updateAcceptor.accept(targetElementOriginalURI.trimFragment(), getDeclarationTextEdit(newName));
	}

	protected TextEdit getDeclarationTextEdit(String newName) {
		return new ReplaceEdit(originalNameRegion.getOffset(), originalNameRegion.getLength(), newName);
	}
	

}
