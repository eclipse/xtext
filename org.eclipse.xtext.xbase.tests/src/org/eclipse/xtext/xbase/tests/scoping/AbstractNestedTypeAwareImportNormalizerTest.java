/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.AbstractNestedTypeAwareImportNormalizer;
import org.eclipse.xtext.xbase.scoping.NestedTypeAwareImportNormalizer;
import org.eclipse.xtext.xbase.scoping.NestedTypeAwareImportNormalizerWithDotSeparator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractNestedTypeAwareImportNormalizerTest extends Assert {

	@Test
	public void testCreateWithDollar() {
		QualifiedName importedName = QualifiedName.create("java", "util", "Map$Entry");
		ImportNormalizer result = AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(importedName, false, false);
		assertTrue(result instanceof NestedTypeAwareImportNormalizer);
	}
	
	@Test
	public void testCreateWithDot() {
		QualifiedName importedName = QualifiedName.create("java", "util", "Map", "Entry");
		ImportNormalizer result = AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(importedName, false, false);
		assertTrue(result instanceof NestedTypeAwareImportNormalizerWithDotSeparator);
	}
	
}
