/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;

public class MockRefactoringDocument implements IRefactoringDocument {

	public static class Provider implements IRefactoringDocument.Provider {

		@Override
		public IRefactoringDocument get(URI resourceURI, StatusWrapper status) {
			return new MockRefactoringDocument(resourceURI, "");
		}
		
	}
	
	private final URI uri;
	private final String content;

	public MockRefactoringDocument(URI uri, String content) {
		this.uri = uri;
		this.content = content;
	}

	public MockRefactoringDocument() {
		this(null, null);
	}

	@Override
	public Change createChange(String name, TextEdit textEdit) {
		return new MockChange(name, textEdit);
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public String getOriginalContents() {
		return content;
	}

	public static class MockChange extends Change {

		private final String name;
		private final TextEdit textEdit;

		public MockChange(String name, TextEdit textEdit) {
			this.name = name;
			this.textEdit = textEdit;
		}

		@Override
		public String getName() {
			return name;
		}

		public TextEdit getTextEdit() {
			return textEdit;
		}

		@Override
		public void initializeValidationData(IProgressMonitor pm) {
		}

		@Override
		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
			return null;
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			return null;
		}

		@Override
		public Object getModifiedElement() {
			return null;
		}

	}

}