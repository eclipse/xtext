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
import java.io.File
import java.net.URLClassLoader

class ClasspathScannerTest {
	val ClasspathScanner scanner = new ClasspathScanner
	
	@Test
	def testBootClasspathScanning() {
		val javaUtil = scanner.getBootClasspathDescriptors(#["java.util"])
		Assert.assertTrue(javaUtil.exists[simpleName == "BitSet"])
	}
	
	@Test
	def testClasspathScanning() {
		val bootstrapJar = new File("../org.eclipse.xtext.bootstrap/lastversion.jar")
		val classloader = new URLClassLoader(#[bootstrapJar.toURI.toURL])
		val utilPackage = scanner.getDescriptors(classloader, #["org.eclipse.xtext.util"])
		Assert.assertTrue(utilPackage.exists[name == "org.eclipse.xtext.util.Arrays"])
	}
}