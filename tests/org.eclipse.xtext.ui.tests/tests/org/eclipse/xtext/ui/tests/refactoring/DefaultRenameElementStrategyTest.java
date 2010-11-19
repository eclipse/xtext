/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameElementStrategy;
import org.eclipse.xtext.ui.tests.Activator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultRenameElementStrategyTest extends AbstractXtextTests {

	@Inject
	private IRenameElementStrategy.Provider strategyProvider;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getInjector().injectMembers(this);
	}
	
	@Override
	protected Injector getInjector() {
		return Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage");
	}

	public void testRenameElementStrategy() throws Exception {
		XtextResource resource = getResourceFromString("A { B { C } }");
		URI targetElementURI = resource.getURI().appendFragment("//@elements.0");
		MockRefactoringDocument mockDocument = new MockRefactoringDocument(resource);
		IRenameElementStrategy renameElementStrategy = strategyProvider.get(targetElementURI, mockDocument);
		assertNotNull(renameElementStrategy);
		assertEquals("A", renameElementStrategy.getCurrentName());
		RefactoringStatus validateNewNameStatus = renameElementStrategy.validateNewName("A");
		assertTrue(validateNewNameStatus.hasWarning());
		assertFalse(validateNewNameStatus.hasError());
		validateNewNameStatus = renameElementStrategy.validateNewName("D");
		assertTrue(validateNewNameStatus.isOK());
		ReplaceEdit renameEdit = renameElementStrategy.getRenameEdit("D");
		assertEquals(0, renameEdit.getOffset());
		assertEquals(1, renameEdit.getLength());
		assertEquals("D", renameEdit.getText());
	}
}
