/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.TextEdit;

import com.google.inject.ImplementedBy;

/**
 * Abstraction over an open document or a text file that is affected by a refactoring. 
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IRefactoringDocument {

	Change createChange(String name, TextEdit textEdit);
	
	URI getURI();
	
	String getOriginalContents();

	@ImplementedBy(DefaultRefactoringDocumentProvider.class)
	static interface Provider {
		IRefactoringDocument get(URI resourceURI, StatusWrapper status);
	}

}
