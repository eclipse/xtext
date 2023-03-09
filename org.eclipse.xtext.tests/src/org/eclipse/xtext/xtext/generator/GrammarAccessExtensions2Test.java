/**
 * Copyright (c) 2020, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(GrammarAccessExtensions2Test.XtextInjectorProvider.class)
public class GrammarAccessExtensions2Test {
	public static class XtextInjectorProvider implements IInjectorProvider {
		@Override
		public Injector getInjector() {
			TerminalsStandaloneSetup.doSetup();
			return Guice.createInjector(new XtextRuntimeModule(), new com.google.inject.Module() {
				@Override
				public void configure(Binder binder) {
					binder.bind(IXtextProjectConfig.class).toInstance(new StandardProjectConfig());
				}
			});
		}
	}

	@Inject
	private ParseHelper<Grammar> parseHelper;

	@Inject
	private GrammarAccessExtensions grammarAccessExtensions;

	@Test
	public void testGrammarFragmentToString() throws Exception {
		String NL = System.lineSeparator();
		String grammar = "grammar org.xtext.example.mydsl.MyDsl\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
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
				"//OpOther:" + NL +
				"//      '->'" + NL +
				"//    | '..<'" + NL +
				"//    | '>' '..'" + NL +
				"//    | '..'" + NL +
				"//    | '=>'" + NL +
				"//    | '>' (=>('>' '>') | '>')" + NL +
				"//    | '<' (=>('<' '<') | '<' | '=>')" + NL +
				"//    | '<>'" + NL +
				"//    | '?:';";
		firstRuleIsConvertedTo(grammar, expected);
	}
	
	@Test
	public void testGrammarFragmentToString2() throws Exception {
		String grammar =
				"grammar org.xtext.example.mydsl.MyDsl hidden (ML_COMMENT)\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"Model: name=ID;\n" +
				"terminal ML_COMMENT: '/*'(!'*')->'*/';\n" +
				"terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;";
		String expected = 
				"//terminal ML_COMMENT: '/*'(!'*')->'*/';";
		secondRuleIsConvertedTo(grammar, expected);
	}

	private void firstRuleIsConvertedTo(CharSequence text, CharSequence expected) throws Exception {
		String actual = grammarAccessExtensions
				.grammarFragmentToString(Iterables.getFirst(parseHelper.parse(text).getRules(), null), "//");
		Assert.assertEquals(expected.toString().trim(), actual);
	}
	
	private void secondRuleIsConvertedTo(CharSequence text, CharSequence expected) throws Exception {
		String actual = grammarAccessExtensions
				.grammarFragmentToString(Iterables.get(parseHelper.parse(text).getRules(), 1), "//");
		Assert.assertEquals(expected.toString().trim(), actual);
	}
}
