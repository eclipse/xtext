/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class BatchLinkingServiceTest extends AbstractXtendTestCase {
	
	@Test def void testBug464762() {
		val file = file('''
			class Foo {
				def void bar() {
					__UNRESOLVABLE_SuperDuper_()
				}
			}
		''', false)
		
		assertNull(file.eResource.getEObject("|0"))
	}
}