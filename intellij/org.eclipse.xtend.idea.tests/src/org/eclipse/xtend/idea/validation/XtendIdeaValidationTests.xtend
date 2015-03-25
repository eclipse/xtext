/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.validation

import org.eclipse.xtend.idea.LightXtendTest

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendIdeaValidationTests extends LightXtendTest {
	
	def void testWrongPackage() {
		configureByText('''
			package <error descr="The declared package 'my.foo.pack' does not match the expected package ''">my.foo.pack</error>
			class Foo {
			}
		''')
		myFixture.checkHighlighting
	}

}