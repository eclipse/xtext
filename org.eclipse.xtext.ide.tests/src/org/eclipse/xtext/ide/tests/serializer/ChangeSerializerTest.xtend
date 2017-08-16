/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.serializer

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert
import org.eclipse.emf.common.util.URI

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(PartialSerializationTestLanguageInjectorProvider)
class ChangeSerializerTest {

	extension PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE

	@Inject Provider<ChangeSerializer> serializerProvider
	@Inject extension ChangeSerializerTestHelper

	@Test
	def void testSimple() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#2 foo'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", MandatoryValue)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.name = "bar"
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#2 <3:3|bar>
			--------------------------------------------------------------------------------
			3 3 "foo" -> "bar"
		'''
	}

	@Test
	def void testTwoChildren() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root { foo1; foo2; }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.children.get(0).name = "bazz4"
		model.children.get(1).name = "bazz5"
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root { <10:4|bazz4>; <16:4|bazz5>; }
			--------------------------------------------------------------------------------
			10 4 "foo1" -> "bazz4"
			16 4 "foo2" -> "bazz5"
		'''
	}

	@Test
	def void testInsertOneChild() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root { child1 { foo1; } }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.children.get(0).children += createNode => [name = "bazz"]
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root { child1 { foo1;<24:1| bazz; >} }
			--------------------------------------------------------------------------------
			24 1 " " -> " bazz; "
		'''
	}

	@Test
	def void testInsertTwoChild() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root { child1 { foo1; } }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.children.get(0).children += createNode => [name = "bazz1"]
		model.children.get(0).children += createNode => [name = "bazz2"]
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root { child1 { foo1;<24:1| bazz1; bazz2; >} }
			--------------------------------------------------------------------------------
			24 1 " " -> " bazz1; bazz2; "
		'''
	}

	@Test
	def void testDeleteChild() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root { child1 { foo1; } }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		EcoreUtil.remove(model.children.get(0).children.get(0))
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root { child1 {<18:7|  >} }
			--------------------------------------------------------------------------------
			18 7 " foo1; " -> "  "
		'''
	}

	@Test
	def void testRenameLocal() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root { foo1; foo2 { ref foo1 } }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.children.get(0).name = "bazz4"
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root { <10:4|bazz4>; foo2 { ref <27:4|bazz4> } }
			--------------------------------------------------------------------------------
			10 4 "foo1" -> "bazz4"
			27 4 "foo1" -> "bazz4"
		'''
	}

	@Test
	def void testRenameGlobal1() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root1;'''
		fs += "inmemory:/file2.pstl" -> '''#1 root2 { ref root1 }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.name = "newroot"
		Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 <3:5|newroot>;
			--------------------------------------------------------------------------------
			3 5 "root1" -> "newroot"
			----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------
			#1 root2 { ref <15:5|newroot> }
			--------------------------------------------------------------------------------
			15 5 "root1" -> "newroot"
		'''
	}
	
	@Test
	def void testResourceURIChange() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/f.pstl" -> '''#1 root { }'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/f.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.eResource.URI = URI.createURI("inmemory:/x.pstl")
		serializer.endRecordChangesToTextDocuments === '''
			----- renamed inmemory:/f.pstl to inmemory:/x.pstl (syntax: <offset|text>) -----
			(no changes)
			--------------------------------------------------------------------------------
		'''
	}

}
