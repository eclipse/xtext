/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package i18n

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.junit.Test

import static org.junit.Assert.assertEquals

class ExternalizedTest {
	
	extension XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(class.classLoader)
	
	@Test def void testExtractAnnotation() {
		'''
			package i18n
			
			@Externalized
			class MyMessages {
				val GREETING = "Hello {0}"
				val DATE_MESSAGE = "Today, is ${0,date}."
			}
		'''.compile [
			val extension ctx = transformationContext
			val clazz = findClass('i18n.MyMessages')
			
			assertEquals(2, clazz.declaredMethods.size)
			
			val path = compilationUnit.filePath
			val properties = path.targetFolder.append(clazz.qualifiedName.replace('.','/')+'.properties')
			assertEquals('''
				GREETING = Hello {0}
				DATE_MESSAGE = Today, is ${0,date}.
			'''.toString, properties.contents.toString)
		]
	}
}