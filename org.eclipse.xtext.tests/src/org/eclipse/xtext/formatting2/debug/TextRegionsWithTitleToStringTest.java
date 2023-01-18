/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import javax.inject.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.inject.Inject;

/**
 * @author dietrich - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class TextRegionsWithTitleToStringTest {
	
	@Inject
	private ParseHelper<Root> parseHelper;
	
	@Inject
	private ValidationTestHelper validationTestHelper;
	
	@Inject
	private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;
	
	private TextRegionsWithTitleToString toString = new TextRegionsWithTitleToString();
	
	@Test
	public void testNewLineAtEnd() throws Exception {
		String model = "1 foo\n";
		Root obj = parseHelper.parse(model);
		validationTestHelper.assertNoErrors(obj);
		ITextRegionAccess access = createFromNodeModel(obj);
		toString.add("Test", access.regionForDocument());
		String expected =
				"{{{}}}: Test at offset=0 length=6\n"
				+ "------------------------------- document snippet -------------------------------\n"
				+ "{{{1 foo\n"
				+ "}}}\n"
				+ "--------------------------------------------------------------------------------";
		assertEquals(expected, toString.toString());
	}


	private ITextRegionAccess createFromNodeModel(EObject obj) {
		return textRegionAccessBuilder.get().forNodeModel((XtextResource) obj.eResource()).create();
	}
	
}
