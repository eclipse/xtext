/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.impl.UpdateAcceptor;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * Updates references to renamed elements.
 * 
 * @author koehnlein - Initial contribution and API
 */
public interface IReferenceUpdater {

	RefactoringStatus createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			ReplaceRegion declarationEdit, ResourceSet resourceSet, UpdateAcceptor updateAcceptor);

}
