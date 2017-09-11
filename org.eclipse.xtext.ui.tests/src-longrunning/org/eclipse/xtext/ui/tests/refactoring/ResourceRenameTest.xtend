/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring

import org.eclipse.core.resources.IResource
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider)
@RunWith(XtextRunner)
class ResourceRenameTest extends AbstractResourceRelocationTest {
	
	@Test 
	def void testRenameDir() {
		val x = file('foo/bar/X.fileawaretestlanguage', '''
			package foo.bar
			element X {
				ref X
			}
		''')	
		file('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref bar.X
			}
		''')	
		performRename(x.parent, 'baz')
		assertFalse(x.exists)
		assertFileContents('foo/baz/X.fileawaretestlanguage', '''
			package foo.baz
			element X {
				ref X
			}
		''')
		assertFileContents('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref baz.X
			}
		''')	
	}
	
	@Test 
	def void testRenameDir_2() {
		file('foo/X.fileawaretestlanguage', '''
			package foo
			element X {
				ref X
			}
		''')	
		val y = file('foo/bar/Y.fileawaretestlanguage', '''
			package foo.bar
			element Y {
				ref foo.X
			}
		''')	
		performRename(y.parent, 'baz')
		assertFalse(y.exists)
		assertFileContents('foo/X.fileawaretestlanguage', '''
			package foo
			element X {
				ref X
			}
		''')
		assertFileContents('foo/baz/Y.fileawaretestlanguage', '''
			package foo.baz
			element Y {
				ref foo.X
			}
		''')	
	}
	
	@Test 
	def void testRenameCommonDir() {
		val x = file('foo/X.fileawaretestlanguage', '''
			package foo.bar
			element X {
				ref X
			}
		''')	
		val y = file('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref X
			}
		''')	
		performRename(x.parent, 'baz')
		assertFalse(x.exists)
		assertFalse(y.exists)
		assertFileContents('baz/X.fileawaretestlanguage', '''
			package baz
			element X {
				ref X
			}
		''')
		assertFileContents('baz/Y.fileawaretestlanguage', '''
			package baz
			element Y {
				ref X
			}
		''')
	}
	
	@Test 
	def void testRenameCommonDir_2() {
		val x = file('foo/bar/X.fileawaretestlanguage', '''
			package foo.bar
			element X {
				ref X
			}
		''')	
		val y = file('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref bar.X
			}
		''')	
		performRename(y.parent, 'baz')
		assertFalse(x.exists)
		assertFalse(y.exists)
		assertFileContents('baz/bar/X.fileawaretestlanguage', '''
			package baz.bar
			element X {
				ref X
			}
		''')
		assertFileContents('baz/Y.fileawaretestlanguage', '''
			package baz
			element Y {
				ref bar.X
			}
		''')
	}
	
	protected def performRename(IResource theResource, String theNewName) {
		performRefactoring(new RenameResourceDescriptor() => [
			resourcePath = theResource.fullPath
			newName = theNewName
			project = project.name
		])
	}
}