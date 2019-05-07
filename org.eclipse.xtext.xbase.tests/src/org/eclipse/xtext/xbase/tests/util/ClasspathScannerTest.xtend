/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.util

import java.io.File
import java.net.URLClassLoader
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner
import org.junit.Assume

class ClasspathScannerTest {
	val ClasspathScanner scanner = new ClasspathScanner
	
	@Test
	def testBootClasspathScanning() {
		val javaUtil = scanner.getBootClasspathDescriptors(#["java.util"])
		Assume.assumeFalse("Should be possible to find descriptors", javaUtil.isEmpty)
		Assert.assertTrue(javaUtil.join(", "), javaUtil.exists[simpleName == "BitSet"])
	}
	
	@Test
	def testClasspathScanning() {
		val bootstrapJar = new File("./somelib/sample.jar")
		val classloader = new URLClassLoader(#[bootstrapJar.toURI.toURL])
		val utilPackage = scanner.getDescriptors(classloader, #["sample"])
		Assert.assertTrue(utilPackage.exists[name == "sample.Sample"])
	}
}
