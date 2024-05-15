/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.Document;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.TextEditBasedChange;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DisplayChangeWrapperTest extends AbstractXtextTests {

	@Test 
	public void testDocumentChange() throws CoreException {
		Change change = new DocumentChange("my change", new Document());
		Change wrapped = DisplayChangeWrapper.wrap(change);
		assertTrue(wrapped instanceof TextEditBasedChange);
		assertTrue(wrapped instanceof DisplayChangeWrapper.Wrapper);
		assertEquals(change, ((DisplayChangeWrapper.Wrapper) wrapped).getDelegate());
		Change undo = wrapped.perform(new NullProgressMonitor());
		assertTrue(undo instanceof DisplayChangeWrapper.Wrapper);
	}
	
	@Test 
	public void testNullChange() throws CoreException {
		Change change = new NullChange("my change");
		Change wrapped = DisplayChangeWrapper.wrap(change);
		assertFalse(wrapped instanceof TextEditBasedChange);
		assertTrue(wrapped instanceof DisplayChangeWrapper.Wrapper);
		assertEquals(change, ((DisplayChangeWrapper.Wrapper) wrapped).getDelegate());
		Change undo = wrapped.perform(new NullProgressMonitor());
		assertTrue(undo instanceof DisplayChangeWrapper.Wrapper);
	}
	
	@Test 
	public void testNoUndoChange() throws CoreException {
		Change change = new NullChange("my no undo change") {
			@Override
			public Change perform(IProgressMonitor pm) throws CoreException {
				return null;
			}
		};
		Change wrapped = DisplayChangeWrapper.wrap(change);
		assertFalse(wrapped instanceof TextEditBasedChange);
		assertTrue(wrapped instanceof DisplayChangeWrapper.Wrapper);
		assertEquals(change, ((DisplayChangeWrapper.Wrapper) wrapped).getDelegate());
		Change undo = wrapped.perform(new NullProgressMonitor());
		assertNull(undo);
	}
}
