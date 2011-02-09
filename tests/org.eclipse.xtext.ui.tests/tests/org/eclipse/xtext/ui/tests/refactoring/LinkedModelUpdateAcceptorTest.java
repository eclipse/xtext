/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import junit.framework.TestCase;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.LinkedModelCalculator.LinkedModelUpdateAcceptor;
import org.eclipse.xtext.ui.tests.refactoring.MockRefactoringDocument.MockChange;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class LinkedModelUpdateAcceptorTest extends TestCase {
	LinkedModelUpdateAcceptor linkedModelUpdateAcceptor = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		linkedModelUpdateAcceptor = new LinkedModelUpdateAcceptor();
	}
	
	public void testAcceptTextEdits() throws Exception {
		TextEdit textEdit = new ReplaceEdit(0,0,"");
		linkedModelUpdateAcceptor.accept(null, textEdit);
	}
	
	public void testNotAcceptChange() throws Exception {
		Change change = new MockChange("Mock", null);
		try {
		linkedModelUpdateAcceptor.accept(null, change);
		} catch (UnsupportedOperationException e){
			// Everything is fine
			return;
		}
		fail("LinkedModelUpdateAcceptor should not accept a Change-Object.");
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		linkedModelUpdateAcceptor = null;
	}
	
}
