/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.resource

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.junit.Test
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ui.resource.IStorage2UriMapper
import org.eclipse.emf.ecore.util.EcoreUtil

import static org.junit.Assert.*
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ResourceStorageTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper helper
	
	@Inject IResourceSetProvider resourceSetProvider
	@Inject IStorage2UriMapper uriMapper
	
	@Test def void testLoadFromStorage() {
		val file = 'src/mypack/MyClass.xtend'.createFile('''
			package mypack
			
			class MyClass {
				public def void foo() {
				}
			}
		''')
		val file2 = 'src/mypack/OtherClass.xtend'.createFile('''
			package mypack
			
			class OtherClass extends MyClass {
				override foo() {
				}
			}
		''')
		
		IResourcesSetupUtil.waitForAutoBuild
		
		val uri = uriMapper.getUri(file)
		val uri2 = uriMapper.getUri(file2)
		
		val resourceSet = resourceSetProvider.get(file.project)
		SourceLevelURIsAdapter.setSourceLevelUris(resourceSet, #[])
		
		val resource2 = resourceSet.getResource(uri2, true) as StorageAwareResource
		EcoreUtil.resolveAll(resource2)
		assertTrue(resource2.isIsLoadedFromStorage)
		assertEquals("mypack.OtherClass", resource2.resourceDescription.exportedObjects.map[name.toString].join(','))
		
		val resource = resourceSet.getResource(uri, false) as StorageAwareResource
		assertTrue(resource.isIsLoadedFromStorage)
		assertEquals("mypack.MyClass", resource.resourceDescription.exportedObjects.map[name.toString].join(','))
	}
	
}