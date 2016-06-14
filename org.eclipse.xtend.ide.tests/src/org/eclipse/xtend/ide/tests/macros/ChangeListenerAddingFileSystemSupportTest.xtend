/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import org.junit.Before
import org.eclipse.xtend.ide.builder.UIResourceChangeRegistry
import org.eclipse.xtend.core.macro.declaration.ChangeListenerAddingFileSystemSupport
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import java.io.InputStream
import org.junit.Test
import org.junit.After

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ChangeListenerAddingFileSystemSupportTest {
	
	UIResourceChangeRegistry registry
	
	URI uri
	
	extension ChangeListenerAddingFileSystemSupport fsa
	
	Path path
	
	@Before
	def void setup() {
		registry = new UIResourceChangeRegistry()
		uri = URI.createPlatformResourceURI('myProject/src/com/acme/C.xtend', true)
		fsa = new ChangeListenerAddingFileSystemSupport(uri, new NoopFileSystemSupport, registry)
		path = new Path('a')
	}
	@After
	def void tearDown() {
		registry = null
		uri = null
		fsa = null
		path = null
	}
	
	@Test
	def void readFile() {
		path.getContents
		assertTrue(registry.contentsListeners.containsEntry(path.toString, uri))
	}
	
	@Test
	def void readWriteAndReadFile() {
		path.contents = ''
		path.getContents
		assertTrue(registry.contentsListeners.empty)
	}
	
	@Test
	def void readReadAndWriteFile() {
		path.getContents
		path.setContents('')
		assertTrue(registry.contentsListeners.empty)
	}
	
	@Test
	def void listChildren() {
		fsa.getChildren(path)
		assertTrue(registry.childrenListeners.containsEntry(path.toString, uri))
	}
	
	@Test
	def void exists() {
		fsa.exists(path)
		assertTrue(registry.existsListeners.containsEntry(path.toString, uri))
	}
	
	@Test
	def void isFile() {
		fsa.isFile(path)
		assertTrue(registry.existsListeners.containsEntry(path.toString, uri))
	}
	
	@Test
	def void isFolder() {
		fsa.isFolder(path)
		assertTrue(registry.existsListeners.containsEntry(path.toString, uri))
	}
	
	@Test
	def void mkDir() {
		fsa.mkdir(path)
		assertTrue(registry.childrenListeners.empty)
	}
	
	@Test
	def void isFolderAndMkDir() {
		fsa.isFolder(path)
		fsa.mkdir(path)
		assertTrue(registry.childrenListeners.empty)
	}
	
	@Test
	def void discardCreateAndModifyInformation() {
		fsa.mkdir(path)
		fsa.mkdir(new Path('b'))
		assertTrue(registry.changesNotRelevantListeners.containsEntry(path.toString, uri))
		assertTrue(registry.changesNotRelevantListeners.containsEntry('b', uri))
		registry.discardCreateOrModifyInformation(uri)
		assertTrue(registry.changesNotRelevantListeners.empty)
	}
	
	static class NoopFileSystemSupport implements MutableFileSystemSupport {
		
		override delete(Path path) {
		}
		
		override mkdir(Path path) {
		}
		
		override setContents(Path path, CharSequence contents) {
		}
		
		override setContentsAsStream(Path path, InputStream source) {
		}
		
		override exists(Path path) {
			return false
		}
		
		override getCharset(Path path) {
		}
		
		override getChildren(Path path) {
		}
		
		override getContents(Path path) {
		}
		
		override getContentsAsStream(Path path) {
		}
		
		override getLastModification(Path path) {
			return 0L
		}
		
		override isFile(Path path) {
			return true
		}
		
		override isFolder(Path path) {
			return true
		}
		
		override toURI(Path path) {
		}
		
	} 
	
}