/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.tests.refactoring.MockRefactoringDocument.MockChange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class UpdateAcceptorTest extends Assert {

	private static final String CHANGE_NAME = "My change";
	private RefactoringUpdateAcceptor updateAcceptor;
	private URI resourceURI0;
	private URI resourceURI1;

	@Before
	public void setUp() throws Exception {
		updateAcceptor = new RefactoringUpdateAcceptor(new MockRefactoringDocument.Provider());
		resourceURI0 = URI.createURI("resource0");
		resourceURI1 = URI.createURI("resource1");
	}

	@Test public void testAddTextEdit() throws Exception {

		updateAcceptor.accept(resourceURI0, new ReplaceEdit(0, 1, "foo"));
		updateAcceptor.accept(resourceURI1, new ReplaceEdit(1, 2, "bar"));
		updateAcceptor.accept(resourceURI0, new ReplaceEdit(3, 4, "baz"));

		Change change = updateAcceptor.createCompositeChange(CHANGE_NAME, new NullProgressMonitor());
		assertTrue(change instanceof CompositeChange);
		Change[] children = ((CompositeChange) change).getChildren();
		assertEquals(2, children.length);
		assertTrue(children[0] instanceof MockChange);
		MockChange change0 = (MockChange) children[0];
		assertEquals(CHANGE_NAME, change0.getName());
		assertTrue(children[1] instanceof MockChange);
		MockChange change1 = (MockChange) children[1];
		assertEquals(CHANGE_NAME, change1.getName());
		assertTrue(change0.getTextEdit() instanceof MultiTextEdit);
		assertTrue(change1.getTextEdit() instanceof MultiTextEdit);
		assertEquals(
				3,
				((MultiTextEdit) change0.getTextEdit()).getChildrenSize()
						+ ((MultiTextEdit) change1.getTextEdit()).getChildrenSize());
	}
}
