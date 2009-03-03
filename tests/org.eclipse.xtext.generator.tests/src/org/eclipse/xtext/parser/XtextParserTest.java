/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class XtextParserTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void test_resolveReturnType() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo generate foo 'bar' as x Model returns x::Foo : 'holla' name=ID;");
		assertWithXtend("'x'", "metamodelDeclarations.first().alias", model);
	}

	public void testParseCrossRef() throws Exception {
		Grammar model = (Grammar) getModel("grammar foo generate foo 'bar' as boo Model : 'a' stuff+=Stuff*; Stuff : 'stuff' name=ID refersTo=[Stuff];");
		assertWithXtend("'boo'", "eAllContents.typeSelect(xtext::CrossReference).first().type.metamodel.alias", model);
		assertWithXtend("'Stuff'", "eAllContents.typeSelect(xtext::CrossReference).first().type.classifier.name", model);
	}
}
