/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class UnloadingTest extends AbstractXtendTestCase {
	
	@Test def void testProperUnloading() {
		val String fileB = '''
			class B {
				def void foo() {
					new A(this)
				}
			}
		'''
		val parsedFiles = files(true, '''
			class A {
				new (B b) {
				}
			}
		''', fileB).toList
		
		val resource = parsedFiles.get(1).eResource as DerivedStateAwareResource
		val resourceA = parsedFiles.head.eResource;
		resource.reparse(fileB)
		val file = resourceA.contents.head as XtendFile
		assertNotNull(((file.xtendTypes.head as XtendClass).members.head as XtendConstructor).parameters.head.parameterType.type.eResource)
	}
}