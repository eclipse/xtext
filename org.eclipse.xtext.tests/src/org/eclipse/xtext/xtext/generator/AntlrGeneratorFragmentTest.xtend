/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugGrammarGenerator
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions
import org.junit.Test

class AntlrGeneratorFragmentTest extends AbstractXtextTests {
	
	override void setUp() throws Exception {
		super.setUp()
		with(XtextStandaloneSetup)
	}
	
	@Test def void testDebugGrammar_01() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			MyRule :
				->(('a'|'b'|'c') 'd') 
			;
		'''.asserTranslatesToDebugGrammar('''
			grammar DebugInternalbar;
			
			// Rule MyRule
			ruleMyRule:
				(
					('a' | 'b' | 'c')=>
					(
						'a'
						    |
						'b'
						    |
						'c'
					)
					'd'
				)
			;
		''')
	}
	
	@Test def void testDebugGrammar_Bug482677() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			MyRule :
				->(x=('a'|'b'|'c') y='d') 
			;
		'''.asserTranslatesToDebugGrammar('''
			grammar DebugInternalbar;
			
			// Rule MyRule
			ruleMyRule:
				(
					('a' | 'b' | 'c')=>
					(
						'a'
						    |
						'b'
						    |
						'c'
					)
					'd'
				)
			;
		''')
	}
	
	@Test def void testDebugGrammar_Bug482677_02() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			MyRule :
				'foo' ->('bar' prop=('a'|'b'|'c') more='more')?
			;
		'''.asserTranslatesToDebugGrammar('''
			grammar DebugInternalbar;
			
			// Rule MyRule
			ruleMyRule:
				'foo'
				(
					('bar')=>
					'bar'
					(
						'a'
						    |
						'b'
						    |
						'c'
					)
					'more'
				)?
			;
		''')
	}
	
	protected def void asserTranslatesToDebugGrammar(CharSequence xtextGrammar, String expectedDebugGrammar) {
		val grammar = super.getModel(xtextGrammar.toString) as Grammar
		val injector = Guice.createInjector(new DefaultGeneratorModule)
		val inMem = new InMemFSA
		val options = new AntlrOptions
		injector.getInstance(AntlrDebugGrammarGenerator).generate(grammar, options, inMem)
		assertEquals(expectedDebugGrammar, inMem.allFiles.values.head.toString)
	}
	
	static class InMemFSA extends InMemoryFileSystemAccess implements IXtextGeneratorFileSystemAccess {
		
		override getPath() {
			"./"
		}
		
		override isOverwrite() {
			true
		}
		
		override initialize(Injector injector) {
			injector.injectMembers(this)
		}
		
	}
	
}