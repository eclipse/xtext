/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBug289524Test extends AbstractXtextTests {
	
	@Test public void testGetModel_01() throws Exception {
		String model = "Model containment C reference C";
		getModel(model);
	}
	
	@Test public void testGetModel_02() throws Exception {
		String model = "Model containment C reference C$C";
		getModel(model);
	}

	@Test public void testGetModel_03() throws Exception {
		String model = "Model reference C";
		getModelAndExpect(model, 1);
	}
	
	@Test public void testGetModel_04() throws Exception {
		String model = "Model containment C reference C reference C";
		getModel(model);
	}
	
	@Test public void testGetModel_05() throws Exception {
		String model = "Model containment C containment C reference C";
		getModelAndExpect(model, 0);
	}
	
	@Test public void testGetModel_06() throws Exception {
		String model = "Model reference C$C";
		getModelAndExpect(model, 2);
	}
}
