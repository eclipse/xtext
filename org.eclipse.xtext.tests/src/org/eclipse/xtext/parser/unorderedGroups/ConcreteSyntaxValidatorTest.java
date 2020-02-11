/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguageFactory;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;
import org.eclipse.xtext.validation.AbstractConcreteSyntaxValidationTest;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxValidator;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcreteSyntaxValidatorTest extends AbstractConcreteSyntaxValidationTest {

	private Model model;
	private UnorderedSerialization toBeValidated;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(UnorderedGroupsTestLanguageStandaloneSetup.class);
		validator = get(ConcreteSyntaxValidator.class);
		model = UnorderedGroupsTestLanguageFactory.eINSTANCE.createModel();
		toBeValidated = UnorderedGroupsTestLanguageFactory.eINSTANCE.createUnorderedSerialization();
		model.setSerialized(toBeValidated);
	}

	private IConcreteSyntaxValidator validator;

	@Override
	protected IConcreteSyntaxValidator getValidator() {
		return validator;
	}

	@Test public void testNoValueAssigned() {
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A() {
		toBeValidated.setFirst(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_B() {
		toBeValidated.setSecond(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_C() {
		toBeValidated.setThird(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_D() {
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_B() {
		toBeValidated.setFirst(true);
		toBeValidated.setSecond(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_C() {
		toBeValidated.setFirst(true);
		toBeValidated.setThird(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_D() {
		toBeValidated.setFirst(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_B_C() {
		toBeValidated.setFirst(true);
		toBeValidated.setSecond(true);
		toBeValidated.setThird(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_B_D() {
		toBeValidated.setFirst(true);
		toBeValidated.setSecond(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_A_B_C_D() {
		toBeValidated.setFirst(true);
		toBeValidated.setSecond(true);
		toBeValidated.setThird(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_B_C_D() {
		toBeValidated.setSecond(true);
		toBeValidated.setThird(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_B_C() {
		toBeValidated.setSecond(true);
		toBeValidated.setThird(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_B_D() {
		toBeValidated.setSecond(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_1_C_D() {
		toBeValidated.setThird(true);
		toBeValidated.setForth(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_2_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getSecondAsList().add("b");
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_2_A_B_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getSecondAsList().add("b");
		toBeValidated.getSecondAsList().add("b");
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_2_A_B_A_B_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getSecondAsList().add("b");
		toBeValidated.getSecondAsList().add("b");
		toBeValidated.getSecondAsList().add("b");
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_3_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.setSecond(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_3_A_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.setSecond(true);
		validate(toBeValidated).assertOK();
	}

	@Test public void testValidate_3_A_A_A_B() {
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.getFirstAsList().add("a");
		toBeValidated.setSecond(true);
		validate(toBeValidated).assertOK();
	}
}
