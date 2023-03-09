/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ClasspathScannerTest {
	private ClasspathScanner scanner = new ClasspathScanner();

	@Test
	public void testArrayDeque() throws Exception {
		Iterable<ITypeDescriptor> javaUtil = scanner.getBootClasspathDescriptors(Lists.newArrayList("java"));
		Assert.assertTrue(IterableExtensions.join(javaUtil, ", "),
				IterableExtensions.exists(javaUtil, it -> "ArrayDeque".equals(it.getSimpleName())));
		Assert.assertEquals(IterableExtensions.join(javaUtil, ", "), 1,
				IterableExtensions.size(IterableExtensions.filter(javaUtil, it -> "ArrayDeque".equals(it.getSimpleName()))));
	}

}
