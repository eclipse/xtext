/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;

import com.google.inject.ImplementedBy;

/**
 * A component to update references to elements renamed in a refactoring.
 * 
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultReferenceUpdater.class)
public interface IReferenceUpdater {

	RefactoringStatus createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			IRenameStrategy renameStrategy, Iterable<IReferenceDescription> referenceDescriptions,
			UpdateAcceptor updateAcceptor, IProgressMonitor monitor);

}
