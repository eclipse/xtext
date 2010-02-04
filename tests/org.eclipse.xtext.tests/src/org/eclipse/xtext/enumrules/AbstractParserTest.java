/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model;
import org.eclipse.xtext.enumrules.enums.EnumsPackage;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;
import org.eclipse.xtext.parser.ParserTestHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserTest extends AbstractEnumRulesTest {

	private ParserTestHelper helper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EnumRulesTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}

	@Override
	protected void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}

	public void testParseSameName() throws Exception {
		String modelAsString = "existing SameName";
		Model model = (Model) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.SAME_NAME, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	public void testParseSameName2() throws Exception {
		String modelAsString = "generated SameName";
		Model model = (Model) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals(GeneratedEnum.SAME_NAME, model.getGenerated());
		assertEquals(EnumsPackage.Literals.EXISTING_ENUM.getDefaultValue(), model.getExisting());
	}
	
	public void testParseOverridden() throws Exception {
		String modelAsString = "existing overridden";
		Model model = (Model) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.OVERRIDDEN_LITERAL, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	public void testParseDifferentName() throws Exception {
		String modelAsString = "existing DifferentLiteral";
		Model model = (Model) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals(ExistingEnum.DIFFERENT_NAME, model.getExisting());
		assertEquals(EnumRulesTestLanguagePackage.Literals.GENERATED_ENUM.getDefaultValue(), model.getGenerated());
	}
	
	public void testParseDifferentName2() throws Exception {
		String modelAsString = "generated DifferentLiteral";
		Model model = (Model) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals(GeneratedEnum.DIFFERENT_NAME, model.getGenerated());
		assertEquals(EnumsPackage.Literals.EXISTING_ENUM.getDefaultValue(), model.getExisting());
	}
}
