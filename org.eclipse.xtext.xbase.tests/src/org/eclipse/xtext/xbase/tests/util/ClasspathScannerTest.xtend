/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.util

import java.io.File
import java.net.URLClassLoader
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.common.types.descriptions.ClasspathScanner

class ClasspathScannerTest {
	val ClasspathScanner scanner = new ClasspathScanner

	@Test
	def testBootClasspathScanning() {
		val javaUtil = scanner.getBootClasspathDescriptors(#["java.util"])
		Assert.assertTrue(javaUtil.join(", "), javaUtil.exists[simpleName == "BitSet"])
		Assert.assertFalse(javaUtil.join(", "), javaUtil.exists[simpleName == "String"])
	}
	
	@Test
	def testArrayDeque() {
		val javaUtil = scanner.getBootClasspathDescriptors(#["java"])
		Assert.assertTrue(javaUtil.join(", "), javaUtil.exists[simpleName == "ArrayDeque"])
		Assert.assertEquals(javaUtil.join(", "), 1, javaUtil.filter[simpleName == "ArrayDeque"].size)
	}

	@Test
	def testClasspathScanning() {
		val bootstrapJar = new File("./somelib/sample.jar")
		val classloader = new URLClassLoader(#[bootstrapJar.toURI.toURL])
		val utilPackage = scanner.getDescriptors(classloader, #["sample"])
		Assert.assertTrue(utilPackage.exists[name == "sample.Sample"])
	}
	
	@Test
	def testNoSystemClassesInUserClassLoader() {
		val bootstrapJar = new File("./somelib/sample.jar")
		val classloader = new URLClassLoader(#[bootstrapJar.toURI.toURL])
		val fromJar = scanner.getDescriptors(classloader, #[])
		Assert.assertFalse(fromJar.join(", "), fromJar.exists[simpleName == "ArrayList"])
	}
	
	@Test
	def testFoundInParent() {
		val bootstrapJar = new File("./somelib/sample.jar")
		val parentLoader = new URLClassLoader(#[bootstrapJar.toURI.toURL])
		val classloader = new URLClassLoader(#[], parentLoader)
		val fromJar = scanner.getDescriptors(classloader, #[])
		Assert.assertTrue(fromJar.exists[name == "sample.Sample"])
	}
	
}
