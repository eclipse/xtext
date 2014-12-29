/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.ValidationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug456264Test extends AbstractActiveAnnotationTest {
	
	@Test def void testAddError() {
		try {
			'''
				@org.eclipse.xtend.core.tests.macro.Bug456264 class C {}
			'''.compile[
				fail("nothing to assert")
			]
		} catch(IllegalStateException e) {
			assertTrue(e.message.contains("My error message"))
		}
	}
	
}


@Active(typeof(Bug456264Processor))
annotation Bug456264 {}
class Bug456264Processor extends AbstractClassProcessor {
	
	override doValidate(ClassDeclaration annotatedClass, extension ValidationContext context) {
		annotatedClass.addError("My error message")
	}
	
}