/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.eclipse.xtext.xbase.resource.BatchLinkableResource
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade
import java.io.ByteArrayOutputStream
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import java.io.ByteArrayInputStream
import org.eclipse.xtext.util.EmfFormatter
import org.junit.Assert
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class BatchLinkableResourceStateStreamsTest {
	
	@Inject ParseHelper<XtendFile> parser
	@Inject BatchLinkableResourceStorageFacade resourceStorageFacade
	
	@Inject Provider<BatchLinkableResource> resourceProvider
	
	@Test def void testSerialization() {
		
		val file = parser.parse('''
			package foo
			
			@Data class SomeClass {
				
				String field
				
				def someMethod() {
					return getField()
				}
			}
		''')
		
		val out = new ByteArrayOutputStream()
		val out2 = resourceStorageFacade.createResourceStorageOutputStream(out)
		out2.writeResource(file.eResource as StorageAwareResource)
		
		val bytes = out.toByteArray
		
		val in = new ByteArrayInputStream(bytes)
		val in2 = resourceStorageFacade.createResourceStorageInputStream(in)
		val copied = resourceProvider.get
		copied.URI = URI.createURI("synthetic:/foouupll.xtend")
		file.eResource.resourceSet.resources += copied
		copied.load(in2)
		
		Assert.assertEquals(EmfFormatter.listToStr(file.eResource.contents), EmfFormatter.listToStr(copied.contents))
	}
}