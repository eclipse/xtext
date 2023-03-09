/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model;
import org.eclipse.xtext.enumrules.enums.EnumsPackage;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractEnumRulesTest {

	private ParserTestHelper helper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EnumRulesTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}

	@Override
	public void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}

	@Test public void testParseSameName() throws Exception {
		String modelAsString = "existing SameName";
		Model model = (Model) parse(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.SAME_NAME, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	@Test public void testParseSameName2() throws Exception {
		String modelAsString = "generated SameName";
		Model model = (Model) parse(modelAsString);
		assertNotNull(model);
		assertEquals(GeneratedEnum.SAME_NAME, model.getGenerated());
		assertEquals(EnumsPackage.Literals.EXISTING_ENUM.getDefaultValue(), model.getExisting());
	}
	
	@Test public void testParseOverridden() throws Exception {
		String modelAsString = "existing overridden";
		Model model = (Model) parse(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.OVERRIDDEN_LITERAL, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	@Test public void testParseDifferentName() throws Exception {
		String modelAsString = "existing DifferentLiteral";
		Model model = (Model) parse(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.DIFFERENT_NAME, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	@Test public void testParseDifferentName2() throws Exception {
		String modelAsString = "generated DifferentLiteral";
		Model model = (Model) parse(modelAsString);
		assertNotNull(model);
		assertEquals(GeneratedEnum.DIFFERENT_NAME, model.getGenerated());
		assertEquals(EnumsPackage.Literals.EXISTING_ENUM.getDefaultValue(), model.getExisting());
	}

	protected EObject parse(String modelAsString) throws IOException {
		return helper.getModel(modelAsString);
	}
}
