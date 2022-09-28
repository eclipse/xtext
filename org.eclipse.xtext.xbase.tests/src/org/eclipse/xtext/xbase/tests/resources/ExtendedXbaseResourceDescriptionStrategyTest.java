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
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot;
import org.eclipse.xtext.xbase.testlanguages.tests.ContentAssistFragmentTestLangInjectorProvider;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

@InjectWith(ContentAssistFragmentTestLangInjectorProvider.class)
public class ExtendedXbaseResourceDescriptionStrategyTest extends AbstractXbaseImportedNamesTest {
	@Inject
	private ParseHelper<ContentAssistFragmentTestLanguageRoot> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;
	
	@Test
	public void testImportedNamesFromModelReferences() throws Exception {
		ContentAssistFragmentTestLanguageRoot model = parseHelper.parse("{} entity x extends an.Entity");
		Resource resource = model.eResource();
		List<String> expectedImportedNames = Arrays.asList(
				"an.entity",
				"java.lang.an$entity",
				"java.lang.object",
				"my.test." + resource.getURI().trimFileExtension().lastSegment().toLowerCase(),
				"my.test.an$entity",
				"org.eclipse.xtext.xbase.lib.an$entity");
		List<String> actualImportedNames = importedNames(resource);
		Assert.assertEquals(expectedImportedNames, actualImportedNames);
	}
	
	@Override
	protected XExpression expression(CharSequence string, boolean resolve) throws Exception {
		ContentAssistFragmentTestLanguageRoot parse = parseHelper.parse(string);
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
