/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import org.junit.Test

class RenameResourceTest extends AbstractXtendRenameRefactoringTest {
	
	@Test 
	def void testRenameClassWithSameName() {
		try {			
			createFile('Foo', 'class Foo {}')
				.renameTo('Bar.xtend')
				.assertFileContains('class Bar {}')
		} finally {
			getFile('Bar.xtend').delete(true, null)
		}
	}
	
	@Test 
	def void testDontRenameClassWithDifferenName() {
		try {			
			createFile('Foo', 'class FooBar {}')
				.renameTo('Bar.xtend')
				.assertFileContains('class FooBar {}')
		} finally {
			getFile('Bar.xtend').delete(true, null)
		}
	}
	
	@Test 
	def void testGuardMissingFileExtension() {
		try {			
			createFile('Foo', 'class Foo {}')
				.renameTo('Bar')
				.assertFileContains('class Foo {}')
		} finally {
			getFile('Bar').delete(true, null)
		}
	}
}