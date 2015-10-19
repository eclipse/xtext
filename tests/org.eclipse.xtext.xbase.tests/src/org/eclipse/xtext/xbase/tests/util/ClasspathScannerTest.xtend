/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.util

import org.eclipse.xtext.xbase.ide.types.ClasspathScanner
import org.junit.Assert
import org.junit.Test

class ClasspathScannerTest {
	val ClasspathScanner scanner = new ClasspathScanner
	
	@Test
	def testBootClasspathScanning() {
		val javaUtil = scanner.getBootClasspathDescriptors(#["java.util"])
		Assert.assertTrue(javaUtil.exists[simpleName == "BitSet"])
	}
	
	@Test
	def testClasspathScanning() {
		val thisPackage = scanner.getDescriptors(class.classLoader, #["org.eclipse.xtext.xbase.tests.util"])
		Assert.assertTrue(thisPackage.exists[simpleName == "ClasspathScannerTest"])
	}
}