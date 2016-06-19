/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.parser.assignments.bug288432Test.Body;
import org.eclipse.xtext.parser.assignments.bug288432Test.MyElement;
import org.eclipse.xtext.parser.assignments.bug288432Test.MyInt;
import org.eclipse.xtext.parser.assignments.bug288432Test.ParameterObject;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug288432Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug288432TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testBug288432_01() throws Exception {
		String modelAsText = "body\n" + 
				"	content\n" + 
				"		element 1\n" + 
				"	end content\n" + 
				"	'foo'\n" +
				"end body";
		Body body = (Body) getModel(modelAsText);
		ParameterObject paramObject = body.getContent();
		assertNotNull("content", paramObject);
		assertTrue("paramObject instanceof MyElement", paramObject instanceof MyElement);
		MyElement myElement = (MyElement) paramObject;
		ParameterObject bar = myElement.getBar();
		assertNotNull("bar", bar);
		assertTrue("bar instanceof MyInt", bar instanceof MyInt);
		MyInt myInt = (MyInt) bar;
		assertEquals(1, myInt.getInt());
	}
	
}
