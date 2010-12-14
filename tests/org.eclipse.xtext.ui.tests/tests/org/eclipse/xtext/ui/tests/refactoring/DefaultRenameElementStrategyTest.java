/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultRenameElementStrategyTest extends AbstractXtextTests {

	@Inject
	private IRenameStrategy.Provider strategyProvider;
	
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
		final XtextResource resource = getResourceFromString("A { B { C } }");
		EObject targetElement = resource.getContents().get(0).eContents().get(0);
		assertNotNull(targetElement);
		assertTrue(targetElement instanceof Element);
		assertEquals("A", ((Element) targetElement).getName());
		IRefactoringDocument mockDocument = new IRefactoringDocument() {
			public Change createChange(String name, TextEdit textEdit) {
				return null;
			}
			public URI getURI() {
				return resource.getURI();
			}
		};
		IRenameStrategy renameElementStrategy = strategyProvider.get(targetElement, mockDocument);
		assertNotNull(renameElementStrategy);
		assertEquals("A", renameElementStrategy.getCurrentName());
		RefactoringStatus validateNewNameStatus = renameElementStrategy.validateNewName("A");
		assertTrue(validateNewNameStatus.hasWarning());
		assertFalse(validateNewNameStatus.hasError());
		validateNewNameStatus = renameElementStrategy.validateNewName("D");
		assertTrue(validateNewNameStatus.isOK());
		ReplaceRegion renameEdit = renameElementStrategy.getReplaceRegion("D");
		assertEquals(0, renameEdit.getOffset());
		assertEquals(1, renameEdit.getLength());
		assertEquals("D", renameEdit.getText());
	}
}
