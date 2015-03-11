/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

/**
 * A null reference updater. Does nothing since Java references are handled by JDT. 
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("restriction")
public class NullReferenceUpdater implements IReferenceUpdater {

	public void createReferenceUpdates(
			ElementRenameArguments elementRenameArguments,
			Iterable<IReferenceDescription> referenceDescriptions,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		// nothing to do
	}

}
