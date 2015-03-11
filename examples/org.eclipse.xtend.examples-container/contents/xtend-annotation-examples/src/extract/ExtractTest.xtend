/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package extract

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.junit.Test
import static org.junit.Assert.*

class ExtractTest {
	
	extension XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(Extract)
	
	@Test def void testExtractAnnotation() {
		'''
			@extract.Extract
			class MyClass {
				override doStuff(String myParam) throws IllegalArgumentException {
					return myParam
				}
			}
		'''.compile [
			val extension ctx = transformationContext
			val interf = findInterface('MyClassInterface')
			val clazz = findClass('MyClass')
			
			assertEquals(clazz.implementedInterfaces.head.type, interf)
			
			interf.declaredMethods.head => [
				assertEquals('doStuff', simpleName)
				assertEquals(string, returnType)
				assertEquals(IllegalArgumentException.newTypeReference, exceptions.head)
			]
		]
	}
}