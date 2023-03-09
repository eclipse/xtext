/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.imports;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration;
import org.eclipse.xtext.xbase.testlanguages.tests.XImportSectionTestLangInjectorProvider;
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XImportSectionTestLangInjectorProvider.class)
public class DefaultImportsConfigurationTest {
	@Inject
	private ParseHelper<ImportSectionTestLanguageRoot> parseHelper;

	@Inject
	private DefaultImportsConfiguration importsConfiguration;

	@Test
	public void testParseWithComments() throws Exception {
		// @formatter:off
		String model =
			"// hello\n" +
			"some token\n" +
			"import java.util.Set\n";
		// @formatter:on
		ImportSectionTestLanguageRoot root = parseHelper.parse(model);
		Assert.assertEquals(19, importsConfiguration.getImportSectionOffset((XtextResource) root.eResource()));
	}
}
