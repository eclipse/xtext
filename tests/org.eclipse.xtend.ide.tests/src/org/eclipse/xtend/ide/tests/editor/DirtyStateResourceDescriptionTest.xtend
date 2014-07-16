/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.DirtyStateResourceDescription
import org.eclipse.xtext.util.StringInputStream
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class DirtyStateResourceDescriptionTest extends AbstractXtendUITestCase {
	
	@Inject IResourceDescription.Manager plainManager
	
	@Inject DirtyStateResourceDescription.Manager dirtyManager
	
	@Inject Provider<XtextResourceSet> resourceSetProvider

	@Test
	def void testTextHash() {
		val d = '''
			class Foo {
			}
		'''.dirtyResourceDescription
		assertEquals(1, d.exportedObjects.size)
		val textHash = d.exportedObjects.head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH)
		assertNotNull(textHash)
		assertFalse('' == textHash)
	}
	
	@Test
	def void testEmptyContents() {
		val d = '''
			class Foo {
			}
		'''.dirtyResourceDescription
		assertTrue(d.importedNames.empty)
		assertTrue(d.referenceDescriptions.empty)
	}
	
	@Test
	def void testTextChange() {
		val d = '''
			class Foo {
			}
		'''.dirtyResourceDescription
		val textHash = d.exportedObjects.head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH)
		val d1 = '''
			class Foo {
				// added comment
			}
		'''.dirtyResourceDescription
		val textHash1 = d1.exportedObjects.head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH)
		assertFalse(textHash == textHash1)
		
		val delta = dirtyManager.createDelta(d, d1)
		assertTrue(delta.haveEObjectDescriptionsChanged)
	} 
	
	@Test
	def void testNoTextChange() {
		val d = '''
			class Foo {
			}
		'''.dirtyResourceDescription
		val textHash = d.exportedObjects.head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH)
		val d1 = '''
			class Foo {
			}
		'''.dirtyResourceDescription
		val textHash1 = d1.exportedObjects.head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH)
		assertEquals(textHash, textHash1)
		
		val delta = dirtyManager.createDelta(d, d1)
		assertFalse(delta.haveEObjectDescriptionsChanged)
	}
	
	@Test
	def void testAffected() {
		val foo = plainManager.getResourceDescription('Foo'.parse('''
			interface Foo {
			}
		'''))
		val bar = plainManager.getResourceDescription('Bar'.parse('''
			class Bar implements Foo {
			}
		'''))
		val dirtyFoo = dirtyManager.getResourceDescription('Foo'.parse('''
			interface Foo {
				// added comment
			}
		'''))
		val delta = plainManager.createDelta(foo, dirtyFoo)
		assertTrue(plainManager.isAffected(delta, bar))
	}
	
	@Test
	def void testAffected1() {
		val foo = plainManager.getResourceDescription('Foo'.parse('''
			interface Foo {
			}
		'''))
		val bar = plainManager.getResourceDescription('Bar'.parse('''
			class Bar implements Foo {
			}
		'''))
		val dirtyFoo = dirtyManager.getResourceDescription('Foo'.parse('''
			interface Foo {
				def void foo()
			}
		'''))
		val delta = plainManager.createDelta(foo, dirtyFoo)
		assertTrue(plainManager.isAffected(delta, bar))
	}
	
	@Test
	def void testNotAffected() {
		val foo = plainManager.getResourceDescription('Foo'.parse('''
			interface Foo {
			}
		'''))
		val bar = plainManager.getResourceDescription('Bar'.parse('''
			class Bar {
			}
		'''))
		val dirtyFoo = dirtyManager.getResourceDescription('Foo'.parse('''
			interface Foo {
				def void foo()
			}
		'''))
		val delta = plainManager.createDelta(foo, dirtyFoo)
		assertFalse(plainManager.isAffected(delta, bar))
	}
	
	def getDirtyResourceDescription(CharSequence model) {
		dirtyManager.getResourceDescription('Foo'.parse(model))
	}
	
	def parse(String fileName, CharSequence model) {
		val rs = resourceSetProvider.get	
		val r = rs.createResource(URI.createURI(fileName + ".xtend")) as XtextResource
		r.load(new StringInputStream(model.toString), #{})
		r
	}
}