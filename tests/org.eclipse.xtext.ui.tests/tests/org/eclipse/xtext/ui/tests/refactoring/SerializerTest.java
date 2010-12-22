/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author koehnlein - Initial contribution and API
 */
public class SerializerTest extends AbstractXtextTests{

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
	}
	
	public void testSerializeLinkError() throws Exception {
		String model = "A { ref B }";
		XtextResource resource = getResourceAndExpect(new StringInputStream(model),1);
		assertEquals(model, resource.getSerializer().serialize(resource.getContents().get(0)));
	}
}
