/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.javaconverter

import com.google.inject.Inject
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author dhuebner - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class JavaCodeAnalyzerTest {

	@Inject JavaCodeAnalyzer analyzer

	@Test
	def void testSimpleClass() {
		'''
			import java.util.Map;
			public class JavaFoo {
				
			}
		'''.assertJavaTypeIs(ASTParser.K_COMPILATION_UNIT)
	}

	@Test
	def void testSimpleBodyDeclaration_01() {
		'''
			public  void JavaFoo() {}
		'''.assertJavaTypeIs(ASTParser.K_CLASS_BODY_DECLARATIONS)
	}

	@Test
	def void testSimpleBodyDeclaratio_02() {
		'''
			int i;
		'''.assertJavaTypeIs(ASTParser.K_CLASS_BODY_DECLARATIONS)
	}

	@Test
	def void testSimpleSatement_01() {
		'''
			return true;
		'''.assertJavaTypeIs(ASTParser.K_STATEMENTS)
	}

	@Test
	def void testSimpleSatement_02() {
		'''
			int i = 0;
			return i;
		'''.assertJavaTypeIs(ASTParser.K_STATEMENTS).assertNodesCount(2)
	}

	@Test
	def void tesTryCatchSatement_01() {
		'''
			try {
			
			} catch (final Exception e) {
			
			}
		'''.assertJavaTypeIs(ASTParser.K_STATEMENTS).assertNodesCount(1)
	}

	def assertNodesCount(JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> result, int i) {
		assertEquals(i, result.nodes.size)
		return result
	}

	@Test
	def void testSimpleExpression() {
		'''
			true
		'''.assertJavaTypeIs(ASTParser.K_EXPRESSION)
	}

	def JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> assertJavaTypeIs(CharSequence sequence, int type) {
		val javaParseResult = analyzer.determinateJavaType(sequence.toString)
		assertEquals(type, javaParseResult.type)
		return javaParseResult
	}

}