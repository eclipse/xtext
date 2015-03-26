/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.ExceptionThrowingAcceptor
import org.eclipse.xtext.serializer.sequencer.IContextFinder
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider)
@RunWith(XtextRunner)
class RegionAccessTest {
	@Inject ParseHelper<Root> parseHelper
	@Inject SerializerHelper serializerHelper

	@Test def void testSimple() {
		'''
			test 1 foo
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Simple'foo'
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "1" Simple:'1'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			 7 3 Semantic "foo" Simple:name=ID
			     End      Simple'foo'
			10 0 Hidden
		'''
	}

	@Test def void testAssignedDelegate() {
		'''
			test 2 foo
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Delegation
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "2" Delegation:'2'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    delegate=Delegate'foo'
			 7 3 Semantic "foo" Delegate:name=ID
			     End      Delegation, delegate=Delegate'foo'
			10 0 Hidden
		'''
	}

	@Test def void testUnassignedDelegate() {
		'''
			test 3 foo
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Delegate'foo'
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "3" Unassigned:'3'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			 7 3 Semantic "foo" Delegate:name=ID
			     End      Delegate'foo'
			10 0 Hidden
		'''
	}

	@Test def void testUnassignedPrefixedDelegate() {
		'''
			test 4 prefix foo
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    PrefixedUnassigned
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "4" PrefixedUnassigned:'4'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    delegate=Delegate'foo'
			 7 6 Semantic "prefix" PrefixedDelegate:'prefix'
			13 1 Hidden   " " Whitespace:TerminalRule'WS'
			14 3 Semantic "foo" Delegate:name=ID
			     End      PrefixedUnassigned, delegate=Delegate'foo'
			17 0 Hidden
		'''
	}
	
	@Test def void testExpression1() {
		'''
			test 5 a + b
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Add
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "5" Root:'5'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    left=Named'a'
			 7 1 Semantic "a" Primary:name=ID
			     End      left=Named'a'
			 8 1 Hidden   " " Whitespace:TerminalRule'WS'
			 9 1 Semantic "+" Expression:'+'
			10 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    right=Named'b'
			11 1 Semantic "b" Primary:name=ID
			     End      Add, right=Named'b'
			12 0 Hidden
		'''
	}
	
	@Test def void testExpression2() {
		'''
			test 5 (a + b) + c
		'''.toString.trim === '''
			 0 0 Hidden
			     Start    Add
			 0 4 Semantic "test" Root:'test'
			 4 1 Hidden   " " Whitespace:TerminalRule'WS'
			 5 1 Semantic "5" Root:'5'
			 6 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    left=Add
			 7 1 Semantic "(" Parenthesized:'('
			 8 0 Hidden
			     Start    left=Named'a'
			 8 1 Semantic "a" Primary:name=ID
			     End      left=Named'a'
			 9 1 Hidden   " " Whitespace:TerminalRule'WS'
			10 1 Semantic "+" Expression:'+'
			11 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    right=Named'b'
			12 1 Semantic "b" Primary:name=ID
			     End      right=Named'b'
			13 0 Hidden
			13 1 Semantic ")" Parenthesized:')'
			     End      left=Add
			14 1 Hidden   " " Whitespace:TerminalRule'WS'
			15 1 Semantic "+" Expression:'+'
			16 1 Hidden   " " Whitespace:TerminalRule'WS'
			     Start    right=Named'c'
			17 1 Semantic "c" Primary:name=ID
			     End      Add, right=Named'c'
			18 0 Hidden
		'''
	}

	private def ===(CharSequence file, CharSequence expectation) {
		val exp = expectation.toString
		val obj = parseHelper.parse(file)
		val access1 = obj.createFromNodeModel
		val access2 = obj.createFromSerializer
		Assert.assertEquals(exp, new TextRegionAccessToString().withOrigin(access1).hideColumnExplanation() + "\n")
		Assert.assertEquals(exp, new TextRegionAccessToString().withOrigin(access2).hideColumnExplanation() + "\n")
	}

	private def createFromNodeModel(EObject obj) {
		new NodeModelBasedRegionAccess.Builder().withResource(obj.eResource as XtextResource).create
	}

	private def createFromSerializer(EObject obj) {
		val builder = new SerializerBasedRegionAccess.Builder().withRoot(obj)
		serializerHelper.serialize(obj, builder)
		builder.regionAccess
	}
}

class SerializerHelper {
	@Inject Provider<ISemanticSequencer> semanticSequencerProvider;
	@Inject Provider<ISyntacticSequencer> syntacticSequencerProvider;
	@Inject Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;
	@Inject IContextFinder contextFinder;

	def void serialize(EObject semanticObject, ISequenceAcceptor tokens) {
		val errors = new ExceptionThrowingAcceptor
		val context = contextFinder.findContextsByContentsAndContainer(semanticObject, null).iterator.next
		val semantic = semanticSequencerProvider.get();
		val syntactic = syntacticSequencerProvider.get();
		val hidden = hiddenTokenSequencerProvider.get();
		semantic.init(syntactic as ISemanticSequenceAcceptor, errors);
		syntactic.init(context, semanticObject, hidden as ISyntacticSequenceAcceptor, errors);
		hidden.init(context, semanticObject, tokens, errors);
		semantic.createSequence(context, semanticObject);
	}
}
