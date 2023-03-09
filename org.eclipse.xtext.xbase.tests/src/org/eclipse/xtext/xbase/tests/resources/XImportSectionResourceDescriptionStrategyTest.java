/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.resources;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.testlanguages.tests.XImportSectionTestLangInjectorProvider;
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

@InjectWith(XImportSectionTestLangInjectorProvider.class)
public class XImportSectionResourceDescriptionStrategyTest extends AbstractXbaseImportedNamesTest {
	@Inject
	private ParseHelper<ImportSectionTestLanguageRoot> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	@Override
	protected XExpression expression(CharSequence string) throws Exception {
		return super.expression("some token import java.lang.Object " + string);
	}

	/**
	 * The bogus expectation documents a shortcoming of the XImportSection scoping logic when combined with nested types.
	 */
	@Test
	public void testImportedNamesFromImportSection() throws Exception {
		ImportSectionTestLanguageRoot model = parseHelper.parse("some token import java.util.Map.Entry import an.unknown.Type.With.Nested.Type");
		Resource resource = model.eResource();
		List<String> expectedImportedNames = Arrays.asList(
//				"an$unknown$type$with$nested$type",
//				"an.unknown$type$with$nested$type",
//				"an.unknown.type$with$nested$type",
//				"an.unknown.type.with$nested$type",
//				"an.unknown.type.with.nested$type",
				"an.unknown.type.with.nested.type",
				"java.lang.object",
				"java.util.map",
				"java.util.map$entry",
				"java.util.map.entry",
				"my.test." + resource.getURI().trimFileExtension().lastSegment().toLowerCase());
		List<String> actualImportedNames = importedNames(resource);
		Assert.assertEquals(expectedImportedNames, actualImportedNames);
	}

	@Override
	protected XExpression expression(CharSequence string, boolean resolve) throws Exception {
		ImportSectionTestLanguageRoot parse = parseHelper.parse(string);
		if (resolve)
			validationHelper.assertNoErrors(parse);
		return parse.getExpression();
	}

	@Override
	protected void addExpectatedImportedNames(Resource resource, List<String> expectation) {
		super.addExpectatedImportedNames(resource, expectation);
		expectation.add("my.test." + resource.getURI().trimFileExtension().lastSegment().toLowerCase());
		expectation.add("my.test.java$util$arraylist");
	}
}
