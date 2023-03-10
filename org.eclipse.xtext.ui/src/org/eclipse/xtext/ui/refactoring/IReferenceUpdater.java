/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * A component to create updates for cross-references to elements that are renamed in a refactoring. Clients should
 * rather inherit from {@link org.eclipse.xtext.ui.refactoring.impl.AbstractReferenceUpdater} than implementing this
 * interface directly.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IReferenceUpdater {

	void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Iterable<IReferenceDescription> referenceDescriptions, IRefactoringUpdateAcceptor updateAcceptor,
			IProgressMonitor monitor);

}
