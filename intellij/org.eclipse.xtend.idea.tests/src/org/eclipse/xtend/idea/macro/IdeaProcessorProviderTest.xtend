/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.macro

import com.google.common.collect.Iterables
import com.google.inject.Inject
import org.eclipse.xtend.core.idea.macro.IdeaProcessorProvider
import org.eclipse.xtend.core.macro.XAnnotationExtensions
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtend.lib.macro.TransformationContext
import org.junit.Test

class IdeaProcessorProviderTest extends LightXtendTest {

	@Inject
	extension XAnnotationExtensions

	@Inject
	IdeaProcessorProvider provider

	def void testData() {
		configureByText('''
			import org.eclipse.xtend.lib.annotations.Data
			
			@Data class Foo {}
		''')
		val file = xtextFile.resource.contents.head as XtendFile
		val processorType = file.xtendTypes.head.annotations.head.processorType
		val processor = provider.getProcessorInstance(processorType)
		assertEquals("DataProcessor", processor.class.simpleName)
	}
	
	@Test
	def void testLoadClass() {
		configureByText('''
			import org.eclipse.xtend.lib.annotations.Data
			
			@Data class Foo {}
		''')
		val file = xtextFile.resource.contents.head as XtendFile
		val processorType = file.xtendTypes.head.annotations.head.processorType
		val classLoader = provider.getClassLoader(file)
		
		assertNull(classLoader.loadClass(String.name).classLoader)
		
		assertEquals(TransformationContext.classLoader, classLoader.loadClass(TransformationContext.name).classLoader)
		assertEquals(TransformationContext.classLoader, classLoader.loadClass(Procedures.name).classLoader)
		assertEquals(TransformationContext.classLoader, classLoader.loadClass(Iterables.name).classLoader)
		
		assertEquals(classLoader, classLoader.loadClass(processorType.identifier).classLoader)
	}	

}
