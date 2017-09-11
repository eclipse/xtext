/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring

import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IResource
import org.eclipse.ltk.core.refactoring.resource.MoveResourcesDescriptor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider)
@RunWith(XtextRunner)
class ResourceMoveTest extends AbstractResourceRelocationTest {
	
	@Test 
	def void testMoveFile() {
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
		performMove(folder('foo/baz'), x)
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
	def void testMoveFile_2() {
 		file('foo/bar/X.fileawaretestlanguage', '''
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
		performMove(folder('foo/baz'), y)
		assertFalse(y.exists)
		assertFileContents('foo/bar/X.fileawaretestlanguage', '''
			package foo.bar
			element X {
				ref X
			}
		''')
		assertFileContents('foo/baz/Y.fileawaretestlanguage', '''
			package foo.baz
			element Y {
				ref foo.bar.X
			}
		''')	
	}
	
	@Test 
	def void testMoveFiles() {
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
		performMove(folder('foo/baz'), x, y)
		assertFalse(y.exists)
		assertFileContents('foo/baz/X.fileawaretestlanguage', '''
			package foo.baz
			element X {
				ref X
			}
		''')
		assertFileContents('foo/baz/Y.fileawaretestlanguage', '''
			package foo.baz
			element Y {
				ref X
			}
		''')	
	}
	
	@Test 
	def void testMoveDirectory() {
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
		performMove(folder('foo/baz'), x.parent)
		assertFalse(x.exists)
		assertFileContents('foo/baz/bar/X.fileawaretestlanguage', '''
			package foo.baz.bar
			element X {
				ref X
			}
		''')
		assertFileContents('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref baz.bar.X
			}
		''')	
	}
	
	@Test@Ignore
	def void testMoveDirectoryToRoot() {
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
		performMove(project, x.parent)
		assertFalse(x.exists)
		assertFileContents('bar/X.fileawaretestlanguage', '''
			package bar
			element X {
				ref X
			}
		''')
		assertFileContents('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref bar.X
			}
		''')	
	}
	
	protected def performMove(IContainer theDestination, IResource... theResources) {
		performRefactoring(new MoveResourcesDescriptor() => [
			resourcePathsToMove = theResources.map[fullPath]
			destinationPath = theDestination.fullPath 
		])
	}
	
}