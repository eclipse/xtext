/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.serializer

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(PartialSerializationTestLanguageInjectorProvider)
class PartialSerializerTest {

	extension PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE
	@Inject Provider<ChangeSerializer> serializerProvider
	@Inject extension ChangeSerializerTestHelper

	@Test
	def void testMandatoryValueChange() {
		recordDiff(MandatoryValue, "#2 foo") [
			name = "bar"
		] === '''
			0 0   H
			      B MandatoryValue'bar'  Model
			0 2    S "#2"                 Model:'#2'
			2 1    H " "                  Whitespace:TerminalRule'WS'
			3 3 1  S "bar"                MandatoryValue:name=ID
			      E MandatoryValue'bar'  Model
			6 0   H
			------------ diff 1 ------------
			3 3 S "foo"                MandatoryValue:name=ID
		'''
	}

	@Test
	def void testOptionalValueInsert() {
		recordDiff(OptionalValue, "#3") [
			name = "foo"
		] === '''
			0 0 1 H
			      B OptionalValue'foo'   Model
			0 2 1  S "#3"                 Model:'#3'
			2 0 1  H
			2 3 1  S "foo"                OptionalValue:name=ID
			      E OptionalValue'foo'   Model
			5 0 1 H
			------------ diff 1 ------------
			0 0 H
			0 2 S "#3"                 Model:'#3'
			2 0 H
		'''
	}

	@Test
	def void testOptionalValueChange() {
		recordDiff(OptionalValue, "#3 foo") [
			name = "baz"
		] === '''
			0 0   H
			      B OptionalValue'baz'   Model
			0 2    S "#3"                 Model:'#3'
			2 1    H " "                  Whitespace:TerminalRule'WS'
			3 3 1  S "baz"                OptionalValue:name=ID
			      E OptionalValue'baz'   Model
			6 0   H
			------------ diff 1 ------------
			3 3 S "foo"                OptionalValue:name=ID
		'''
	}

	@Test
	def void testOptionalValueRemove() {
		recordDiff(OptionalValue, "#3 foo") [
			name = null
		] === '''
			0 0   H
			      B OptionalValue        Model
			0 2    S "#3"                 Model:'#3'
			      E OptionalValue        Model
			2 1 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 1 ------------
			2 1  H " "                  Whitespace:TerminalRule'WS'
			3 3  S "foo"                OptionalValue:name=ID
			6 0  H
		'''
	}

	@Test
	def void testMandatoryChildChange() {
		recordDiff(MandatoryChild, "#4 foo") [
			child = createMandatoryValue => [name = "baz"]
		] === '''
			0 0   H
			      B MandatoryChild       Model
			0 2    S "#4"                 Model:'#4'
			2 1 1  H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'baz'  MandatoryValue path:MandatoryChild/child
			3 3 1   S "baz"                MandatoryValue:name=ID
			       E MandatoryValue'baz'  MandatoryValue path:MandatoryChild/child
			      E MandatoryChild       Model
			6 0 1 H
			------------ diff 1 ------------
			2 1  H " "                  Whitespace:TerminalRule'WS'
			3 3  S "foo"                MandatoryValue:name=ID
			6 0  H
		'''
	}

	@Test
	def void testOptionalChildInsert() {
		recordDiff(OptionalChild, "#5") [
			child = createMandatoryValue => [name = "baz"]
		] === '''
			0 0 1 H
			      B OptionalChild        Model
			0 2 1  S "#5"                 Model:'#5'
			2 0 1  H
			       B MandatoryValue'baz'  OptionalChild:child=MandatoryValue path:OptionalChild/child
			2 3 1   S "baz"                MandatoryValue:name=ID
			       E MandatoryValue'baz'  OptionalChild:child=MandatoryValue path:OptionalChild/child
			      E OptionalChild        Model
			5 0 1 H
			------------ diff 1 ------------
			0 0 H
			0 2 S "#5"                 Model:'#5'
			2 0 H
		'''
	}

	@Test
	def void testOptionalChildChange() {
		recordDiff(OptionalChild, "#5 foo") [
			child = createMandatoryValue => [name = "baz"]
		] === '''
			0 0   H
			      B OptionalChild        Model
			0 2    S "#5"                 Model:'#5'
			2 1 1  H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'baz'  MandatoryValue path:OptionalChild/child
			3 3 1   S "baz"                MandatoryValue:name=ID
			       E MandatoryValue'baz'  MandatoryValue path:OptionalChild/child
			      E OptionalChild        Model
			6 0 1 H
			------------ diff 1 ------------
			2 1  H " "                  Whitespace:TerminalRule'WS'
			3 3  S "foo"                MandatoryValue:name=ID
			6 0  H
		'''
	}

	@Test
	def void testOptionalChildRemove() {
		recordDiff(OptionalChild, "#5 foo") [
			child = null
		] === '''
			0 0   H
			      B OptionalChild        Model
			0 2    S "#5"                 Model:'#5'
			      E OptionalChild        Model
			2 1 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 1 ------------
			2 1  H " "                  Whitespace:TerminalRule'WS'
			3 3  S "foo"                MandatoryValue:name=ID
			6 0  H
		'''
	}

	@Test
	def void testMoveInList1() {
		recordDiff(Node, "#1 root { Foo; Bar; }") [
			children.move(0, 1)
		] === '''
			0 0   H
			       B Node'root'           Model
			 0 2    S "#1"                 Model:'#1'
			 2 1    H " "                  Whitespace:TerminalRule'WS'
			 3 4    S "root"               Node:name=ID
			 7 1    H " "                  Whitespace:TerminalRule'WS'
			 8 1    S "{"                  Node:'{'
			 9 1 1  H " "                  Whitespace:TerminalRule'WS'
			        B Node'Bar'            Node:children+=Node path:Node'root'/children[0]
			10 3 1   S "Bar"                Node:name=ID
			13 0 1   H
			13 1 1   S ";"                  Node:';'
			        E Node'Bar'            Node:children+=Node path:Node'root'/children[0]
			14 1 1  H " "                  Whitespace:TerminalRule'WS'
			        B Node'Foo'            Node:children+=Node path:Node'root'/children[1]
			15 3     S "Foo"                Node:name=ID
			18 0     H
			18 1     S ";"                  Node:';'
			        E Node'Foo'            Node:children+=Node path:Node'root'/children[1]
			19   2  H " "                  Whitespace:TerminalRule'WS'
			   2    " "                  Whitespace:TerminalRule'WS'
			21 1    S "}"                  Node:'}'
			       E Node'root'           Model
			22 0   H
			------------ diff 1 ------------
			 9 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 2 ------------
			14 1  H " "                  Whitespace:TerminalRule'WS'
			15 3  S "Bar"                Node:name=ID
			18 0  H
			18 1  S ";"                  Node:';'
			19 1  H " "                  Whitespace:TerminalRule'WS'
		'''
	}

	def private <T extends EObject> ITextRegionAccess recordDiff(Class<T> modelType, CharSequence modelText,
		(T)=>void modification) {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> modelText.toString

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", modelType)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		modification.apply(model)
		return serializer.endRecordChangesToTextRegions
	}

}
