/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.UpdateAcceptor;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author koehnlein - Initial contribution and API
 */
public class UpdateAcceptorTest extends TestCase {

	private static final String CHANGE_NAME = "My change";

	public void testAddTextEdit() throws Exception {
		UpdateAcceptor updateAcceptor = new UpdateAcceptor();
		IRefactoringDocument mockDocument0 = new MockDocument();
		IRefactoringDocument mockDocument1 = new MockDocument();
		
		updateAcceptor.accept(mockDocument0, new ReplaceRegion(0,1,"foo"));
		updateAcceptor.accept(mockDocument1, new ReplaceRegion(1,2,"bar"));
		updateAcceptor.accept(mockDocument0, new ReplaceRegion(3,4,"baz"));

		Change change = updateAcceptor.createChange(CHANGE_NAME);
		assertTrue(change instanceof CompositeChange);
		Change[] children = ((CompositeChange)change).getChildren();
		assertEquals(2, children.length);
		assertTrue(children[0] instanceof MockChange);
		MockChange change0 = (MockChange)children[0];
		assertEquals(CHANGE_NAME, change0.getName());
		assertTrue(children[1] instanceof MockChange);
		MockChange change1 = (MockChange)children[1];
		assertEquals(CHANGE_NAME, change1.getName());
		assertTrue(change0.getTextEdit() instanceof MultiTextEdit);
		assertTrue(change1.getTextEdit() instanceof MultiTextEdit);
		assertEquals(3, ((MultiTextEdit)change0.getTextEdit()).getChildrenSize() + ((MultiTextEdit)change1.getTextEdit()).getChildrenSize());
	}
	
	
	public static class MockDocument implements IRefactoringDocument {

		public Change createChange(String name, TextEdit textEdit) {
			return new MockChange(name, textEdit);
		}

		public URI getURI() {
			return null;
		}
		
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
