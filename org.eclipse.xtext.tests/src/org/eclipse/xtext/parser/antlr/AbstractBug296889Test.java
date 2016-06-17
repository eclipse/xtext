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
public abstract class AbstractBug296889Test extends AbstractXtextTests {
	
	@Test public void testGetModel_01() throws Exception {
		String model = "Model ID";
		getModel(model);
	}
	
	@Test public void testGetModel_02() throws Exception {
		String model = "Model ID ID";
		getModel(model);
	}

	@Test public void testGetModel_03() throws Exception {
		String model = "Model ID-- ID";
		getModel(model);
	}
	
	@Test public void testGetModel_04() throws Exception {
		String model = "Model ID-- --ID";
		getModel(model);
	}
	
	@Test public void testGetModel_05() throws Exception {
		String model = "Model --ID ID ID--";
		getModel(model);
	}
	
	@Test public void testGetModel_06() throws Exception {
		String model = "Model ID-- --";
		getModelAndExpect(model, 1);
	}
	
	@Test public void testGetDataType_01() throws Exception {
		String model = "DataType ID";
		getModel(model);
	}
	
	@Test public void testGetDataType_02() throws Exception {
		String model = "DataType ID ID";
		getModel(model);
	}

	@Test public void testGetDataType_03() throws Exception {
		String model = "DataType ID-- ID";
		getModel(model);
	}
	
	@Test public void testGetDataType_04() throws Exception {
		String model = "DataType ID-- --ID";
		getModel(model);
	}
	
	@Test public void testGetDataType_05() throws Exception {
		String model = "DataType --ID ID ID--";
		getModel(model);
	}
	
	@Test public void testGetDataType_06() throws Exception {
		String model = "DataType ID-- --";
		getModelAndExpect(model, 1);
	}
}
