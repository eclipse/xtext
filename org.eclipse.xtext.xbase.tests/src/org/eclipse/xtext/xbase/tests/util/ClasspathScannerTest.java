/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.xtext.common.types.descriptions.ClasspathScanner;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ClasspathScannerTest {
	private ClasspathScanner scanner = new ClasspathScanner();

	@Test
	public void testBootClasspathScanning() throws Exception {
		Iterable<ITypeDescriptor> javaUtil = scanner.getBootClasspathDescriptors(Lists.newArrayList("java.util"));
		Assert.assertTrue(IterableExtensions.join(javaUtil, ", "),
				IterableExtensions.exists(javaUtil, it -> "BitSet".equals(it.getSimpleName())));
		Assert.assertFalse(IterableExtensions.join(javaUtil, ", "),
				IterableExtensions.exists(javaUtil, it -> "String".equals(it.getSimpleName())));
	}

	@Test
	public void testArrayDeque() throws Exception {
		Iterable<ITypeDescriptor> javaUtil = scanner.getBootClasspathDescriptors(Lists.newArrayList("java"));
		Assert.assertTrue(IterableExtensions.join(javaUtil, ", "),
				IterableExtensions.exists(javaUtil, it -> "ArrayDeque".equals(it.getSimpleName())));
		Assert.assertEquals(IterableExtensions.join(javaUtil, ", "), 1,
				IterableExtensions.size(IterableExtensions.filter(javaUtil, it -> "ArrayDeque".equals(it.getSimpleName()))));
	}

	@Test
	public void testClasspathScanning() throws Exception {
		File bootstrapJar = new File("./somelib/sample.jar");
		URLClassLoader classloader = new URLClassLoader(new URL[] { bootstrapJar.toURI().toURL() });
		Iterable<ITypeDescriptor> utilPackage = scanner.getDescriptors(classloader, Lists.newArrayList("sample"));
		Assert.assertTrue(IterableExtensions.exists(utilPackage, it -> "sample.Sample".equals(it.getName())));
	}

	@Test
	public void testNoSystemClassesInUserClassLoader() throws Exception {
		File bootstrapJar = new File("./somelib/sample.jar");
		URLClassLoader classloader = new URLClassLoader(new URL[] { bootstrapJar.toURI().toURL() });
		Iterable<ITypeDescriptor> fromJar = scanner.getDescriptors(classloader, Lists.newArrayList());
		Assert.assertFalse(IterableExtensions.join(fromJar, ", "),
				IterableExtensions.exists(fromJar, it -> "ArrayList".equals(it.getSimpleName())));
	}

	@Test
	public void testFoundInParent() throws Exception {
		File bootstrapJar = new File("./somelib/sample.jar");
		URLClassLoader parentLoader = new URLClassLoader(new URL[] { bootstrapJar.toURI().toURL() });
		URLClassLoader classloader = new URLClassLoader(new URL[] {}, parentLoader);
		Iterable<ITypeDescriptor> fromJar = scanner.getDescriptors(classloader, Lists.newArrayList());
		Assert.assertTrue(IterableExtensions.exists(fromJar, it -> "sample.Sample".equals(it.getName())));
	}
}
