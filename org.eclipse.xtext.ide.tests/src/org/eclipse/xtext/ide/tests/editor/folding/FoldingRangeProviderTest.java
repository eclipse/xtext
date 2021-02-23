/*******************************************************************************
 * Copyright (c) 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.folding;

import org.eclipse.xtext.ide.editor.folding.FoldingRange;
import org.eclipse.xtext.ide.editor.folding.FoldingRangeKind;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Mark Sujew - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class FoldingRangeProviderTest extends AbstractFoldingRangeProviderTest<Model> {

	@Test
	public void foldingRangesProvider() {
		String actual = "package testLanguage {"
				+ "\n"
				+ "\n";
		int commentIndex = actual.length();
		
		actual += "/*\n"
				+ " * This s a multiline comment"
				+ " */";
		int commentLength = actual.length() - commentIndex;
		
		actual += "\n";
		int typeIndex = actual.length();
		
		actual += "type myType {"
				+ "\n" 
				+ "}";
		int typeLength = actual.length() - typeIndex;
		actual += "\n}";
		
		assertFoldingRanges(actual, new FoldingRange(0, actual.length()), new FoldingRange(commentIndex, commentLength, FoldingRangeKind.COMMENT), new FoldingRange(typeIndex, typeLength));
	}
	
}
