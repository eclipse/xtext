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
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractImportNormalizerTest extends Assert {

	protected abstract ImportNormalizer createImportNormalizer(QualifiedName imported, boolean wildcard);
	
	protected abstract QualifiedName createMapEntryImport();
	
	public abstract void testIgnoreCase();
	
	@Test
	public void testMap_Map$Entry() {
		QualifiedName map = QualifiedName.create("java", "util", "Map");
		ImportNormalizer normalizer = createImportNormalizer(map, false);
		QualifiedName map$entry = QualifiedName.create("Map$Entry");
		doTestMap_Map$Entry(normalizer.resolve(map$entry));
	}
	protected void doTestMap_Map$Entry(QualifiedName resolved) {
		assertEquals(createMapEntryImport(), resolved);
	}
	
	@Test
	public void testMap$Entry_Map$Entry_01() {
		QualifiedName map$entry = createMapEntryImport();
		ImportNormalizer normalizer = createImportNormalizer(map$entry, false);
		QualifiedName relative = QualifiedName.create("Map$Entry");
		doTestMap$Entry_Map$Entry(normalizer.resolve(relative));
	}

	@Test
	public void testMap$Entry_Map$Entry_02() {
		QualifiedName map$entry = createMapEntryImport();
		ImportNormalizer normalizer = createImportNormalizer(map$entry, false);
		QualifiedName relative = QualifiedName.create("Map", "Entry");
		doTestMap$Entry_Map$Entry(normalizer.resolve(relative));
	}
	
	protected void doTestMap$Entry_Map$Entry(QualifiedName resolved) {
		assertEquals(null, resolved);
	}
	
	@Test
	public void testMap$Entry_Entry_01() {
		QualifiedName map$entry = createMapEntryImport();
		ImportNormalizer normalizer = createImportNormalizer(map$entry, false);
		QualifiedName relative = QualifiedName.create("Entry");
		doTestMap$Entry_Entry(normalizer.resolve(relative));
	}
	
	protected void doTestMap$Entry_Entry(QualifiedName resolved) {
		assertEquals(createMapEntryImport(), resolved);
	}
	
//	public abstract void testWildcard_Util_Map$Entry();
//	public abstract void testWildcard_Util_Map();
	
}
