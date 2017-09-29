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
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(PartialSerializationTestLanguageInjectorProvider)
class ChangeSerializerWithImports {

	@Inject Provider<ChangeSerializer> serializerProvider
	@Inject extension ChangeSerializerTestHelper


	@Test
	def void testRenameGlobal1() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.pstl" -> '''#1 root1 { child1; }'''
		fs += "inmemory:/file2.pstl" -> '''#1 import root1.child1 refs child1;'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.pstl", Node)

		val serializer = serializerProvider.get()
		serializer.addModification(model.eResource) [
			model.children.get(0).name = "newchild"
			Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		]
		serializer.endRecordChangesToTextDocuments === '''
			----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------
			#1 root1 { <11:6|newchild>; }
			--------------------------------------------------------------------------------
			11 6 "child1" -> "newchild"
			----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------
			#1 import <10:12|root1.newchild> refs <28:6|newchild>;
			--------------------------------------------------------------------------------
			10 12 "root1.child1" -> "root1.newchild"
			28  6 "child1" -> "newchild"
		'''
	}

}
