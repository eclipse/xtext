/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
public interface IRenameStrategy {

	String getCurrentName();
	
	ReplaceRegion getReplaceRegion(String newName);
	
	RefactoringStatus validateNewName(String newName);
	
	@ImplementedBy(DefaultRenameStrategy.Provider.class)
	interface Provider {
		IRenameStrategy get(EObject targetEObject, IRefactoringDocument targetDocument);
	}
}
