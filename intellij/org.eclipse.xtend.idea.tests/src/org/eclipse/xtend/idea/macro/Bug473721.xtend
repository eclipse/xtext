/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.macro

import org.eclipse.xtend.idea.LightXtendTest

/**
 * @author efftinge - Initial contribution and API
 */
class Bug473721 extends LightXtendTest {
	
	def void testBug473721() {
		myFixture.addFileToProject('somePackage/Foo.java', '''
			package somePackage;
			public class Foo {
			}
		''')
		val file = myFixture.addFileToProject('otherPackage/Bar.xtend', '''
			package otherPackage
			
			import somePackage.Foo
			import org.eclipse.xtend.lib.annotations.Data
			
			@Data class Bar {
				Foo myFoo
			}
		''')
		assertTrue(myFixture.findFileInTempDir('xtend-gen/otherPackage/Bar.java').exists)
		myFixture.testHighlighting(true, true, true, file.virtualFile)
	}
}