/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AntlrGeneratorFragmentTest extends AbstractXtextTests {
	public static class InMemFSA extends InMemoryFileSystemAccess implements IXtextGeneratorFileSystemAccess {
		@Override
		public String getPath() {
			return "./";
		}

		@Override
		public boolean isOverwrite() {
			return true;
		}

		@Override
		public void initialize(Injector injector) {
			injector.injectMembers(this);
		}
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void testDebugGrammar_01() throws Exception {
		String xtextGrammar =
				"grammar com.foo.bar \n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate myPack 'http://mypack'\n" +
				"\n" +
				"MyRule :\n" +
				"	->(('a'|'b'|'c') 'd') \n" +
				";\n";
		String expectedDebugGrammar =
				"grammar DebugInternalbar;\n" +
				"\n" +
				"// Rule MyRule\n" +
				"ruleMyRule:\n" +
				"	(\n" +
				"		('a' | 'b' | 'c')=>\n" +
				"		(\n" +
				"			'a'\n" +
				"			    |\n" +
				"			'b'\n" +
				"			    |\n" +
				"			'c'\n" +
				"		)\n" +
				"		'd'\n" +
				"	)\n" +
				";\n";
		asserTranslatesToDebugGrammar(xtextGrammar, expectedDebugGrammar);
	}

	@Test
	public void testDebugGrammar_Bug482677() throws Exception {
		String xtextGrammar =
				"grammar com.foo.bar \n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate myPack 'http://mypack'\n" +
				"\n" +
				"MyRule :\n" +
				"	->(x=('a'|'b'|'c') y='d') \n" +
				";\n";
		String expectedDebugGrammar =
				"grammar DebugInternalbar;\n" +
				"\n" +
				"// Rule MyRule\n" +
				"ruleMyRule:\n" +
				"	(\n" +
				"		('a' | 'b' | 'c')=>\n" +
				"		(\n" +
				"			'a'\n" +
				"			    |\n" +
				"			'b'\n" +
				"			    |\n" +
				"			'c'\n" +
				"		)\n" +
				"		'd'\n" +
				"	)\n" +
				";\n";
		asserTranslatesToDebugGrammar(xtextGrammar, expectedDebugGrammar);
	}

	@Test
	public void testDebugGrammar_Bug482677_02() throws Exception {
		String xtextGrammar =
				"grammar com.foo.bar \n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate myPack 'http://mypack'\n" +
				"\n" +
				"MyRule :\n" +
				"	'foo' ->('bar' prop=('a'|'b'|'c') more='more')?\n" +
				";\n";
		String expectedDebugGrammar =
				"grammar DebugInternalbar;\n" +
				"\n" +
				"// Rule MyRule\n" +
				"ruleMyRule:\n" +
				"	'foo'\n" +
				"	(\n" +
				"		('bar')=>\n" +
				"		'bar'\n" +
				"		(\n" +
				"			'a'\n" +
				"			    |\n" +
				"			'b'\n" +
				"			    |\n" +
				"			'c'\n" +
				"		)\n" +
				"		'more'\n" +
				"	)?\n" +
				";\n";
		asserTranslatesToDebugGrammar(xtextGrammar, expectedDebugGrammar);
	}

	protected void asserTranslatesToDebugGrammar(CharSequence xtextGrammar, String expectedDebugGrammar)
			throws Exception {
		Grammar grammar = ((Grammar) super.getModel(xtextGrammar.toString()));
		Injector injector = Guice.createInjector(new DefaultGeneratorModule());
		InMemFSA inMem = new InMemFSA();
		AntlrOptions options = new AntlrOptions();
		injector.getInstance(AntlrDebugGrammarGenerator.class).generate(grammar, options, inMem);
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectedDebugGrammar),
				Iterables.getFirst(inMem.getAllFiles().values(), null).toString());
	}
}
