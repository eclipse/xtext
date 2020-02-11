/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.NestedTypeAwareImportNormalizer;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportWithDotNormalizerWithDollarTest extends AbstractImportWithDotTest {

	@Override
	@Test(expected = IllegalArgumentException.class)
	public void testIgnoreCase() {
		new NestedTypeAwareImportNormalizer(QualifiedName.create("a"), false, true);
	}
	
	@Override
	protected ImportNormalizer createImportNormalizer(QualifiedName imported, boolean wildcard) {
		ImportNormalizer result = new NestedTypeAwareImportNormalizer(imported, wildcard, false);
		return result;
	}
	
	@Override
	protected void doTestMap_Map$Entry(QualifiedName resolved) {
		assertEquals(QualifiedName.create("java", "util", "Map$Entry"), resolved);
	}

}
