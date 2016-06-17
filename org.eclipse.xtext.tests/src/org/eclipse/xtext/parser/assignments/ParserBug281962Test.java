/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserBug281962Test extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(AssignmentsTestLanguageStandaloneSetup.class);
	}

	@Test public void testSimpleSingle_01() throws Exception {
		Model model = (Model) getModel("simple id something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingle_02() throws Exception {
		Model model = (Model) getModel("simple string 'something'");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingle_03() throws Exception {
		Model model = (Model) getModel("simple alternative something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingle_04() throws Exception {
		Model model = (Model) getModel("simple alternative 'something'");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingle_05() throws Exception {
		Model model = (Model) getModel("simple id ^something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingle_06() throws Exception {
		Model model = (Model) getModel("simple alternative ^something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testSimpleMulti_01() throws Exception {
		Model model = (Model) getModel("simple ids something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMulti_02() throws Exception {
		Model model = (Model) getModel("simple strings 'something'");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMulti_03() throws Exception {
		Model model = (Model) getModel("simple alternatives something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMulti_04() throws Exception {
		Model model = (Model) getModel("simple alternatives 'something'");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMulti_05() throws Exception {
		Model model = (Model) getModel("simple ids ^something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMulti_06() throws Exception {
		Model model = (Model) getModel("simple alternatives ^something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleSingleDatatype_01() throws Exception {
		Model model = (Model) getModel("simple datatypeid something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("IdDatatype: something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingleDatatype_02() throws Exception {
		Model model = (Model) getModel("simple datatypestring 'something'");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("StringDatatype: 'something'", singleValue.getValue());
	}
	
	@Test public void testSimpleSingleDatatype_03() throws Exception {
		Model model = (Model) getModel("simple datatypealternative something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("IdDatatype: something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingleDatatype_04() throws Exception {
		Model model = (Model) getModel("simple datatypealternative 'something'");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("StringDatatype: 'something'", singleValue.getValue());
	}
	
	@Test public void testSimpleSingleDatatype_05() throws Exception {
		Model model = (Model) getModel("simple datatypeid ^something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("IdDatatype: ^something", singleValue.getValue());
	}
	
	@Test public void testSimpleSingleDatatype_06() throws Exception {
		Model model = (Model) getModel("simple datatypealternative ^something");
		SingleValue singleValue = model.getSingle();
		assertNotNull(model);
		assertEquals("IdDatatype: ^something", singleValue.getValue());
	}
	
	@Test public void testSimpleMultiDatatype_01() throws Exception {
		Model model = (Model) getModel("simple datatypeids something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMultiDatatype_02() throws Exception {
		Model model = (Model) getModel("simple datatypestrings 'something'");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("StringDatatype: 'something'", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMultiDatatype_03() throws Exception {
		Model model = (Model) getModel("simple datatypealternatives something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMultiDatatype_04() throws Exception {
		Model model = (Model) getModel("simple datatypealternatives 'something'");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("StringDatatype: 'something'", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMultiDatatype_05() throws Exception {
		Model model = (Model) getModel("simple datatypeids ^something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: ^something", multiValue.getValue().get(0));
	}
	
	@Test public void testSimpleMultiDatatype_06() throws Exception {
		Model model = (Model) getModel("simple datatypealternatives ^something");
		MultiValue multiValue = model.getMulti();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: ^something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexSingle_01() throws Exception {
		Model model = (Model) getModel("complex id something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexSingle_02() throws Exception {
		Model model = (Model) getModel("complex string 'something'");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexSingle_03() throws Exception {
		Model model = (Model) getModel("complex alternative something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexSingle_04() throws Exception {
		Model model = (Model) getModel("complex alternative 'something'");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexSingle_05() throws Exception {
		Model model = (Model) getModel("complex id ^something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexSingle_06() throws Exception {
		Model model = (Model) getModel("complex alternative ^something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("something", singleValue.getValue());
	}
	
	@Test public void testComplexMulti_01() throws Exception {
		Model model = (Model) getModel("complex ids something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMulti_02() throws Exception {
		Model model = (Model) getModel("complex strings 'something'");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMulti_03() throws Exception {
		Model model = (Model) getModel("complex alternatives something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMulti_04() throws Exception {
		Model model = (Model) getModel("complex alternatives 'something'");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMulti_05() throws Exception {
		Model model = (Model) getModel("complex ids ^something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMulti_06() throws Exception {
		Model model = (Model) getModel("complex alternatives ^something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexSingleDatatype_01() throws Exception {
		Model model = (Model) getModel("complex datatypeid something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("IdDatatype: something", singleValue.getValue());
	}
	
	@Test public void testComplexSingleDatatype_02() throws Exception {
		Model model = (Model) getModel("complex datatypestring 'something'");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("StringDatatype: 'something'", singleValue.getValue());
	}
	
	@Test public void testComplexSingleDatatype_03() throws Exception {
		Model model = (Model) getModel("complex datatypealternative something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("IdDatatype: something", singleValue.getValue());
	}
	
	@Test public void testComplexSingleDatatype_04() throws Exception {
		Model model = (Model) getModel("complex datatypealternative 'something'");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("StringDatatype: 'something'", singleValue.getValue());
	}
	
	@Test public void testComplexSingleDatatype_05() throws Exception {
		Model model = (Model) getModel("complex datatypeid ^something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("IdDatatype: ^something", singleValue.getValue());
	}
	
	@Test public void testComplexSingleDatatype_06() throws Exception {
		Model model = (Model) getModel("complex datatypealternative ^something");
		SingleValue singleValue = (SingleValue) model.getObject();
		assertNotNull(model);
		assertEquals("IdDatatype: ^something", singleValue.getValue());
	}
	
	@Test public void testComplexMultiDatatype_01() throws Exception {
		Model model = (Model) getModel("complex datatypeids something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMultiDatatype_02() throws Exception {
		Model model = (Model) getModel("complex datatypestrings 'something'");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("StringDatatype: 'something'", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMultiDatatype_03() throws Exception {
		Model model = (Model) getModel("complex datatypealternatives something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMultiDatatype_04() throws Exception {
		Model model = (Model) getModel("complex datatypealternatives 'something'");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("StringDatatype: 'something'", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMultiDatatype_05() throws Exception {
		Model model = (Model) getModel("complex datatypeids ^something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: ^something", multiValue.getValue().get(0));
	}
	
	@Test public void testComplexMultiDatatype_06() throws Exception {
		Model model = (Model) getModel("complex datatypealternatives ^something");
		MultiValue multiValue = (MultiValue) model.getObject();
		assertNotNull(model);
		assertEquals(1, multiValue.getValue().size());
		assertEquals("IdDatatype: ^something", multiValue.getValue().get(0));
	}
}
