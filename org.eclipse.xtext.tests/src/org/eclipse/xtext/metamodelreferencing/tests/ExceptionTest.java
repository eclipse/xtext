/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExceptionTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test public void testExceptionOnRegenerate() throws Exception {
		String model = "grammar org.eclipse.xtext.ExceptionTest with org.eclipse.xtext.common.Terminals\n" +
			"generate existing 'http://www.eclipse.org/xtext/tests/grammarinheritance'\n" +
			"import 'classpath:/org/eclipse/xtext/grammarinheritance/ametamodel.ecore' as existing\n" +
			"AType : name=ID;";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}

}
