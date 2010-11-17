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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringDocumentProvider;
import org.eclipse.xtext.util.concurrent.IReadAccess;

import com.google.inject.ImplementedBy;

/**
 * Abstraction on files and opened documents affected by a refactoring.
 * 
 * @author koehnlein - Initial contribution and API
 */
public interface IRefactoringDocument extends IReadAccess<XtextResource>{

	TextEdit apply(TextEdit edit);
	
	Change createChange(String name, TextEdit textEdit);

	@ImplementedBy(RefactoringDocumentProvider.class)
	interface Provider {
		IRefactoringDocument get(final URI uri, final RefactoringStatus status);
	}
}
