/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.importHandling

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration
import org.eclipse.xtext.testlanguages.fileAware.ide.tests.FileAwareTestLanguageIdeInjectorProvider
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FileAwareTestLanguageIdeInjectorProvider)
class FileAwareTestLanguageImportTest {

	@Inject Provider<ChangeSerializer> serializerProvider
	@Inject extension ImportTestHelper

	@Test
	def void testRenameGlobal1() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.fileawaretestlanguage" -> '''
			package pkg1
			
			element Foo {
			}
		'''
		fs += "inmemory:/file2.fileawaretestlanguage" -> '''
			package pkg2
			
			import pkg1.Foo
			
			element Bar {
				ref Foo
			}
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.fileawaretestlanguage", PackageDeclaration)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.name = "newpackage"
		Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		serializer.endRecordChangesToTextDocuments === '''
			---------------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ----------------
			package <8:4|newpackage>
			
			element Foo {
			}
			--------------------------------------------------------------------------------
			8 4 "pkg1" -> "newpackage"
			---------------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ----------------
			package pkg2
			
			import <21:8|newpackage.Foo>
			
			element Bar {
				ref Foo
			}
			--------------------------------------------------------------------------------
			21 8 "pkg1.Foo" -> "newpackage.Foo"
		'''
	}
	
	@Test
	def void testMoveToNewPackage() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.fileawaretestlanguage" -> '''
			package pkg1
			
			element Foo {
			}
		'''
		fs += "inmemory:/file2.fileawaretestlanguage" -> '''
			package pkg1
			
			element Bar {
				ref Foo
			}
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.fileawaretestlanguage", PackageDeclaration)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.name = "newpackage"
		Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		serializer.endRecordChangesToTextDocuments === '''
			---------------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ----------------
			package <8:4|newpackage>
			
			element Foo {
			}
			--------------------------------------------------------------------------------
			8 4 "pkg1" -> "newpackage"
			---------------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ----------------
			<0:39|package pkg1
			
			import newpackage.Foo
			
			element Bar {
				ref Foo
			}
			>
			--------------------------------------------------------------------------------
			0 39 "package pkg1\n\nele..." -> "package pkg1\n\nimp..."
		'''
	}
	
	@Test
	def void testMoveIntoLocalPackage() {
		val fs = new InMemoryURIHandler()
		fs += "inmemory:/file1.fileawaretestlanguage" -> '''
			package other
			
			element Foo {
			}
		'''
		fs += "inmemory:/file2.fileawaretestlanguage" -> '''
			package pkg1
			
			import other.Foo
			
			element Bar {
				ref Foo
			}
		'''

		val rs = fs.createResourceSet
		val model = rs.contents("inmemory:/file1.fileawaretestlanguage", PackageDeclaration)

		val serializer = serializerProvider.get()
		serializer.beginRecordChanges(model.eResource)
		model.name = "pkg1"
		Assert.assertEquals(1, model.eResource.resourceSet.resources.size)
		serializer.endRecordChangesToTextDocuments === '''
			---------------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ----------------
			package <8:5|pkg1>
			
			element Foo {
			}
			--------------------------------------------------------------------------------
			8 5 "other" -> "pkg1"
			---------------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ----------------
			package pkg1<12:20|
			
			>element Bar {
				ref Foo
			}
			--------------------------------------------------------------------------------
			12 20 "\n\nimport other.Foo\n\n" -> "\n\n"
		'''
	}

}
