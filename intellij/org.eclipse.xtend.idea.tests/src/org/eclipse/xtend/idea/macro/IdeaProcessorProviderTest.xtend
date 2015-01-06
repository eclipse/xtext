/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.core.macro.XAnnotationExtensions
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.idea.completion.LightXtendTest

class IdeaProcessorProviderTest extends LightXtendTest {
	
	@Inject
	ProcessorInstanceForJvmTypeProvider provider
	@Inject
	extension XAnnotationExtensions 
	
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
	
}