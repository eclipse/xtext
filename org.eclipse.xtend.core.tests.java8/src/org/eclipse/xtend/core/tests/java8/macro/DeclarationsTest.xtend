/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.macro

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtext.testing.InjectWith
import org.junit.Test

@InjectWith(Java8RuntimeInjectorProvider)
class DeclarationsTest extends org.eclipse.xtend.core.tests.macro.declaration.DeclarationsTest {
	
	@Test def testXtendInterfaceWithDefaultMethod() {
		validFile('''
			package p
			
			interface MyIntf {
				
				def String dflt() { "" }
				def String abstrct()
				def static String statc() { "" }
				
			}
		''').asCompilationUnit [
			assertEquals('p', packageName)
			val intf = sourceTypeDeclarations.head as InterfaceDeclaration
			
			assertEquals('p.MyIntf', intf.qualifiedName)
			assertTrue(intf.extendedInterfaces.empty)
			assertEquals(3, intf.declaredMembers.size)
			
			val dflt = intf.declaredMethods.head
			assertTrue(dflt.isDefault)
			assertFalse(dflt.isAbstract)
			
			val abstract = intf.declaredMethods.get(1)
			assertFalse(abstract.isDefault)
			assertTrue(abstract.isAbstract)
			
			val static = intf.declaredMethods.get(2)
			assertFalse(static.isDefault)
			assertFalse(static.isAbstract)
			assertTrue(static.isStatic)
		]
	}
}
