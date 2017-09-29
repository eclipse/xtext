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
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ide.serializer.IChangeSerializer

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
	
	@Test
	def void testOptionalChildListInsertIntoEmpty() {
		recordDiff(OptionalChildList, "#13") [
			children += createMandatoryValue => [name = "foo"]
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 0 1  H
			       B MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]
			3 3 1   S "foo"                MandatoryValue:name=ID
			       E MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]
			      E OptionalChildList    Model
			6 0 1 H
			------------ diff 1 ------------
			3 0  H
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoEmpty2() {
		recordDiff(OptionalChildList, "#13") [
			children += createMandatoryValue => [name = "foo"]
			children += createMandatoryValue => [name = "bar"]
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 0 1  H
			       B MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]
			3 3 1   S "foo"                MandatoryValue:name=ID
			       E MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]
			6 0 1  H
			       B MandatoryValue'bar'  MandatoryValue path:OptionalChildList/children[1]
			6 3 1   S "bar"                MandatoryValue:name=ID
			       E MandatoryValue'bar'  MandatoryValue path:OptionalChildList/children[1]
			      E OptionalChildList    Model
			9 0 1 H
			------------ diff 1 ------------
			3 0  H
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoFirst() {
		recordDiff(OptionalChildList, "#13 x2") [
			children.add(0, createMandatoryValue => [name = "x1"]) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1 1  H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'x1'   MandatoryValue path:OptionalChildList/children[0]
			4 2 1   S "x1"                 MandatoryValue:name=ID
			       E MandatoryValue'x1'   MandatoryValue path:OptionalChildList/children[0]
			6 0 1  H
			       B MandatoryValue'x2'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]
			6 2     S "x2"                 MandatoryValue:name=ID
			       E MandatoryValue'x2'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]
			      E OptionalChildList    Model
			8 0   H
			------------ diff 1 ------------
			3 1 H " "                  Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoMiddle() {
		recordDiff(OptionalChildList, "#13 x1 x3") [
			children.add(1, createMandatoryValue => [name = "x2"]) 
		] === '''
			0 0   H
			       B OptionalChildList    Model
			 0 3    S "#13"                Model:'#13'
			 3 1    H " "                  Whitespace:TerminalRule'WS'
			        B MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			 4 2     S "x1"                 MandatoryValue:name=ID
			        E MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			 6 1 1  H " "                  Whitespace:TerminalRule'WS'
			        B MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]
			 7 2 1   S "x2"                 MandatoryValue:name=ID
			        E MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]
			 9 0 1  H
			        B MandatoryValue'x3'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]
			 9 2     S "x3"                 MandatoryValue:name=ID
			        E MandatoryValue'x3'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]
			       E OptionalChildList    Model
			11 0   H
			------------ diff 1 ------------
			 6 1  H " "                  Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoEndOne() {
		recordDiff(OptionalChildList, "#13 x1") [
			children += createMandatoryValue => [name = "x2"] 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1    H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			4 2     S "x1"                 MandatoryValue:name=ID
			       E MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			6 0 1  H
			       B MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]
			6 2 1   S "x2"                 MandatoryValue:name=ID
			       E MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]
			      E OptionalChildList    Model
			8 0 1 H
			------------ diff 1 ------------
			6 0   H
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoEndTwo() {
		recordDiff(OptionalChildList, "#13 a") [
			children += createMandatoryValue => [name = "b"] 
			children += createMandatoryValue => [name = "c"] 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1    H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			4 1     S "a"                  MandatoryValue:name=ID
			       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			5 0 1  H
			       B MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]
			5 1 1   S "b"                  MandatoryValue:name=ID
			       E MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]
			6 0 1  H
			       B MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]
			6 1 1   S "c"                  MandatoryValue:name=ID
			       E MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]
			      E OptionalChildList    Model
			7 0 1 H
			------------ diff 1 ------------
			5 0   H
		'''
	}
	
	@Test
	def void testOptionalChildListInsertIntoEndThree() {
		recordDiff(OptionalChildList, "#13 a") [
			children += createMandatoryValue => [name = "b"] 
			children += createMandatoryValue => [name = "c"] 
			children += createMandatoryValue => [name = "d"] 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1    H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			4 1     S "a"                  MandatoryValue:name=ID
			       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			5 0 1  H
			       B MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]
			5 1 1   S "b"                  MandatoryValue:name=ID
			       E MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]
			6 0 1  H
			       B MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]
			6 1 1   S "c"                  MandatoryValue:name=ID
			       E MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]
			7 0 1  H
			       B MandatoryValue'd'    MandatoryValue path:OptionalChildList/children[3]
			7 1 1   S "d"                  MandatoryValue:name=ID
			       E MandatoryValue'd'    MandatoryValue path:OptionalChildList/children[3]
			      E OptionalChildList    Model
			8 0 1 H
			------------ diff 1 ------------
			5 0   H
		'''
	}
	
	@Test
	def void testOptionalChildRemoveListAllOne() {
		recordDiff(OptionalChildList, "#13 x1") [
			EcoreUtil.remove(children.get(0)) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			      E OptionalChildList    Model
			3 1 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 1 ------------
			3 1  H " "                  Whitespace:TerminalRule'WS'
			4 2  S "x1"                 MandatoryValue:name=ID
			6 0  H
		'''
	}
	
	@Test
	def void testOptionalChildRemoveListAllTwo() {
		recordDiff(OptionalChildList, "#13 a b") [
			EcoreUtil.remove(children.get(1)) 
			EcoreUtil.remove(children.get(0)) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			      E OptionalChildList    Model
			3 1 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 1 ------------
			3 1  H " "                  Whitespace:TerminalRule'WS'
			4 1  S "a"                  MandatoryValue:name=ID
			5 1  H " "                  Whitespace:TerminalRule'WS'
			6 1  S "b"                  MandatoryValue:name=ID
			7 0  H
		'''
	}
	
	@Test
	def void testOptionalChildRemoveListFirstTwo() {
		recordDiff(OptionalChildList, "#13 a b c") [
			EcoreUtil.remove(children.get(1)) 
			EcoreUtil.remove(children.get(0)) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3   1  H " "                  Whitespace:TerminalRule'WS'
			  2    " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'c'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			5 1     S "c"                  MandatoryValue:name=ID
			       E MandatoryValue'c'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			      E OptionalChildList    Model
			6 0   H
			------------ diff 1 ------------
			3 1 H " "                  Whitespace:TerminalRule'WS'
			4 1 S "a"                  MandatoryValue:name=ID
			5 1 H " "                  Whitespace:TerminalRule'WS'
			6 1 S "b"                  MandatoryValue:name=ID
			7 1 H " "                  Whitespace:TerminalRule'WS'
		'''
	}
	
	@Test
	def void testOptionalChildRemoveListLastTwo() {
		recordDiff(OptionalChildList, "#13 a b c") [
			EcoreUtil.remove(children.get(2)) 
			EcoreUtil.remove(children.get(1)) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1    H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			4 1     S "a"                  MandatoryValue:name=ID
			       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			      E OptionalChildList    Model
			5 1 1 H " "                  Whitespace:TerminalRule'WS'
			------------ diff 1 ------------
			5 1   H " "                  Whitespace:TerminalRule'WS'
			6 1   S "b"                  MandatoryValue:name=ID
			7 1   H " "                  Whitespace:TerminalRule'WS'
			8 1   S "c"                  MandatoryValue:name=ID
			9 0   H
		'''
	}
	
	@Test
	def void testOptionalChildRemoveListMiddleTwo() {
		recordDiff(OptionalChildList, "#13 a b c d") [
			EcoreUtil.remove(children.get(2)) 
			EcoreUtil.remove(children.get(1)) 
		] === '''
			0 0   H
			      B OptionalChildList    Model
			0 3    S "#13"                Model:'#13'
			3 1    H " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			4 1     S "a"                  MandatoryValue:name=ID
			       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]
			5   1  H " "                  Whitespace:TerminalRule'WS'
			  2    " "                  Whitespace:TerminalRule'WS'
			       B MandatoryValue'd'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]
			7 1     S "d"                  MandatoryValue:name=ID
			       E MandatoryValue'd'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]
			      E OptionalChildList    Model
			8 0   H
			------------ diff 1 ------------
			5 1  H " "                  Whitespace:TerminalRule'WS'
			6 1  S "b"                  MandatoryValue:name=ID
			7 1  H " "                  Whitespace:TerminalRule'WS'
			8 1  S "c"                  MandatoryValue:name=ID
			9 1  H " "                  Whitespace:TerminalRule'WS'
		'''
	}
	
	def private <T extends EObject> ITextRegionAccess recordDiff(Class<T> modelType, CharSequence modelText,
		IChangeSerializer.IModification<T> modification) {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> modelText.toString

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", modelType)

		val serializer = serializerProvider.get()
		serializer.addModification(model, modification)
		return serializer.endRecordChangesToTextRegions
	}

}
