/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */

class ResourceStorageTest extends AbstractXtendTestCase {
	
	@Inject IResourceStorageFacade resourceStorageFacade
	
	@Test def void testParsing() {
		val file = file('''
		package foo
		
		class Bar {
			def dispatch myMethod(String s) {}
			def dispatch myMethod(CharSequence cs) {}
		}
		''')
		
		val bout = new ByteArrayOutputStream
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(file.eResource as StorageAwareResource)
		
		val in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		val resource = file.eResource.resourceSet.createResource(URI.createURI("synthetic:/test/MyClass.xtend"))
		file.eResource.resourceSet.resources += resource;
		(resource as StorageAwareResource).load(in)
		
		val jvmClass = resource.contents.get(1) as JvmGenericType
		assertEquals('java.lang.CharSequence', jvmClass.declaredOperations.get(2).parameters.head.parameterType.qualifiedName)
		assertEquals('java.lang.Object', jvmClass.declaredOperations.get(2).returnType.qualifiedName)
	}
}