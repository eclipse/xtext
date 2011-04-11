/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.ImplementedBy;

/**
 * Customizable strategy for the text based rename refactoring of a given {@link EObject}. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IRenameStrategy {

	String getOriginalName();
	
	RefactoringStatus validateNewName(String newName);

	/**
	 * Applies the declaration change to the semantic model in the given resource set.
	 */
	void applyDeclarationChange(String newName, ResourceSet resourceSet);
	
	/**
	 * Reverts the declaration change to the semantic model in the given resource set.
	 */
	void revertDeclarationChange(ResourceSet resourceSet);
	
	/**
	 * Creates the document updates and reports them to the updateAcceptor
	 * @since 2.0
	 */
	void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor);

	@ImplementedBy(DefaultRenameStrategy.Provider.class)
	interface Provider {
		IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext);
	}
}
