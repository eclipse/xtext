/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValidationTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testMarkerForCrossReferences() throws Exception {
		XtextResource resource = getResourceFromString(
				"grammar org.foo.Bar with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'myURI'\n" +
				"Model: name=ID ref=[Model|(ID|STRING)];");
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
		assertTrue(resource.getWarnings().toString(), resource.getWarnings().isEmpty());

		Grammar grammar = (Grammar) resource.getContents().get(0);
		ParserRule modelRule = (ParserRule) grammar.getRules().get(0);
		Assignment assignment = (Assignment) ((Group) modelRule.getAlternatives()).getTokens().get(1);
		CrossReference reference = (CrossReference) assignment.getTerminal();

		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals(diag.getChildren().toString(), 1, diag.getChildren().size());
		assertEquals("diag.isWarning", diag.getSeverity(), Diagnostic.WARNING);
		assertEquals(diag.getData().toString(), grammar, diag.getData().get(0));
		assertEquals(diag.getData().toString(), 1, diag.getData().size());

		Diagnostic child = diag.getChildren().get(0);
		assertNotNull("child", child);
		assertEquals("child.isWarning", child.getSeverity(), Diagnostic.WARNING);
		assertNull("child.children", child.getChildren());
		assertEquals("child.data[0]", reference, child.getData().get(0));
		assertEquals("child.data[1]", XtextPackage.CROSS_REFERENCE__TERMINAL, child.getData().get(1));
		assertEquals(child.getData().toString(), 2, child.getData().size());
	}

}
