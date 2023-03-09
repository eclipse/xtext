/**
 * Copyright (c) 2020, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * Test cases for the {@link XtextFormatter} class.
 * 
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class XtextFormatterTest {
	@Inject
	private ParseHelper<Grammar> parseHelper;

	@Inject
	private INodeModelFormatter nodeModelFormatter;

	@Test
	public void formatting_with_windows_line_endings01() throws Exception {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	  '->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=>('>' '>') | '>')\n" +
				"	| '<' (=>('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		String expected =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	'->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=> ('>' '>') | '>')\n" +
				"	| '<' (=> ('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		assertFormattedAs(Strings.toPlatformLineSeparator(model), expected);
	}

	@Test
	public void formatting_with_windows_line_endings02() throws Exception {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	  '->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=>('>' '>') | '>')\n" +
				"	| '<' (=>('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';\n" +
				"		";
		String expected =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	'->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=> ('>' '>') | '>')\n" +
				"	| '<' (=> ('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		assertFormattedAs(Strings.toPlatformLineSeparator(model), expected);
	}

	@Test
	public void formatting_with_unix_line_endings01() throws Exception {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	  '->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=>('>' '>') | '>')\n" +
				"	| '<' (=>('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		String expected =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	'->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=> ('>' '>') | '>')\n" +
				"	| '<' (=> ('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		assertFormattedAs(Strings.toUnixLineSeparator(model), expected);
	}

	@Test
	public void formatting_with_unix_line_endings02() throws Exception {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	  '->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=>('>' '>') | '>')\n" +
				"	| '<' (=>('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';\n";
		String expected =
				"grammar org.xtext.example.mydsl.MyDsl\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"OpOther:\n" +
				"	'->'\n" +
				"	| '..<'\n" +
				"	| '>' '..'\n" +
				"	| '..'\n" +
				"	| '=>'\n" +
				"	| '>' (=> ('>' '>') | '>')\n" +
				"	| '<' (=> ('<' '<') | '<' | '=>')\n" +
				"	| '<>'\n" +
				"	| '?:';";
		assertFormattedAs(Strings.toUnixLineSeparator(model), expected);
	}

	private void assertFormattedAs(CharSequence input, CharSequence expected) throws Exception {
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected).toString(), formattedText(input));
	}

	private String formattedText(CharSequence unformattedText) throws Exception {
		ICompositeNode rootNode = ((XtextResource) parseHelper.parse(unformattedText).eResource()).getParseResult()
				.getRootNode();
		return nodeModelFormatter.format(rootNode, 0, unformattedText.length()).getFormattedText();
	}
}
