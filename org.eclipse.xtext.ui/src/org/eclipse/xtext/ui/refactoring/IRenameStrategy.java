/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider;
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
	 */
	void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor);

	@ImplementedBy(DefaultRenameStrategyProvider.class)
	interface Provider {
		/**
		 * @return an {@link IRenameStrategy} to rename the given target object 
		 * 	or null if the element should be skipped (e.g. XtendConstructor)
		 * @throws NoSuchStrategyException with a reason when refactoring is forbidden. 
		 */
		IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) throws NoSuchStrategyException;
		
		/**
		 * @since 2.4
		 */
		class NoSuchStrategyException extends Exception {
			private static final long serialVersionUID = 5167954119728880001L;

			public NoSuchStrategyException(String message) {
				super(message);
			}
		}
	}
	
}
