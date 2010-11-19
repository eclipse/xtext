/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author koehnlein - Initial contribution and API
 */
public class MockRefactoringDocument implements IRefactoringDocument {

	private XtextResource resource;

	public MockRefactoringDocument(XtextResource resource) {
		this.resource = resource;
	}
	
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		try {
			return work.exec(resource);
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	public TextEdit apply(TextEdit edit) {
		return null;
	}

	public Change createChange(String name, TextEdit textEdit) {
		return null;
	}

}
