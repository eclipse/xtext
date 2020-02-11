/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaKeywordTest extends AbstractXbaseTestCase {

	@Inject
	private JavaKeywords javaKeywords;
	
	private final static List<String> JAVA_KEYWORDS = Arrays.asList(
		"abstract",
		"assert", // added in 1.4
		"boolean",
		"break",
		"byte",
		"case",
		"catch",
		"char",
		"class",
		"const", // not used
		"continue",
		"default",
		"do",
		"double",
		"else",
		"enum", // added in 5.0
		"extends",
		"false",
		"final",
		"finally",
		"float",
		"for",
		"goto", // not used
		"if",
		"implements",
		"import",
		"instanceof",
		"int",
		"interface",
		"long",
		"native",
		"new",
		"null",
		"package",
		"private",
		"protected",
		"public",
		"return",
		"short",
		"static",
		"strictfp", // added in 1.2
		"super",
		"switch",
		"synchronized",
		"this",
		"throw",
		"throws",
		"transient",
		"true",
		"try",
		"void",
		"volatile",
		"while");

	@Test public void testJavaKeyword() {
		for(String javaKeyword : JAVA_KEYWORDS) {
			assertTrue(javaKeywords.isJavaKeyword(javaKeyword));
		}
	}
}
