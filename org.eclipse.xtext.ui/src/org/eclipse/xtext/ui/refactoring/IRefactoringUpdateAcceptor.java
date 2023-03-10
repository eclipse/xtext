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
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;

import com.google.inject.ImplementedBy;

/**
 * Aggregates document updates as {@link Change Changes} or {@link TextEdit}s. Clients can report issues to the
 * refactoring status.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(RefactoringUpdateAcceptor.class)
public interface IRefactoringUpdateAcceptor {

	void accept(URI resourceURI, TextEdit textEdit);

	void accept(URI resourceURI, Change change);

	StatusWrapper getRefactoringStatus();
	
	/**
	 * Returns the document related to the refactoring.
	 * 
	 * @return The refactoring document or null if it can not be found or is not editable
	 */
	IRefactoringDocument getDocument(URI resourceURI);
	
	/**
	 * Returns a composite change of all accepted updates.
	 */
	Change createCompositeChange(String name, IProgressMonitor monitor);

}