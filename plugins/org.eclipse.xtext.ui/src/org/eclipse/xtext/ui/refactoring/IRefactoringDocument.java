/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRefactoringDocumentProvider;

import com.google.inject.ImplementedBy;

/**
 * Abstraction over an open document or a text file that is affected by a refactoring. 
 *  
 * @author koehnlein - Initial contribution and API
 */
public interface IRefactoringDocument {

	Change createChange(String name, TextEdit textEdit);
	
	URI getURI();
	
	@ImplementedBy(DefaultRefactoringDocumentProvider.class)
	static interface Provider {
		IRefactoringDocument get(URI resourceURI, RefactoringStatus status);
	}
}
