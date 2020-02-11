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
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportWithDollarDefaultNormalizerTest extends AbstractImportWithDollarTest {

	@Override
	protected ImportNormalizer createImportNormalizer(QualifiedName imported, boolean wildcard) {
		return new ImportNormalizer(imported, wildcard, false);
	}
	
	@Override
	public void testIgnoreCase() {
		// no exception expected
		new ImportNormalizer(QualifiedName.create("a"), false, true);
	}
	
	@Override
	protected void doTestMap_Map$Entry(QualifiedName resolved) {
		assertNull(resolved);
	}
	
	@Override
	@Test
	public void testMap$Entry_Map$Entry_01() {
		QualifiedName map$entry = createMapEntryImport();
		ImportNormalizer normalizer = createImportNormalizer(map$entry, false);
		QualifiedName relative = QualifiedName.create("Map$Entry");
		assertEquals(map$entry, normalizer.resolve(relative));
	}
	
	@Override
	@Test
	public void testMap$Entry_Entry_01() {
		QualifiedName map$entry = createMapEntryImport();
		ImportNormalizer normalizer = createImportNormalizer(map$entry, false);
		QualifiedName relative = QualifiedName.create("Entry");
		assertNull(normalizer.resolve(relative));
	}
	
//	@Test public void testResolve_ImportNormalizer() throws Exception {
//		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
//		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
//		QualifiedName xytextRelativeName = QualifiedName.create("xtext", "ytext");
//		QualifiedName xytextRelativeNameWithDollar = QualifiedName.create("xtext$ytext");
//
//		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
//		ImportNormalizer importNormalizer = new ImportNormalizer(namespace, false, false);
//		assertEquals(namespace, importNormalizer.resolve(xtextRelativeName));
//		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
//		assertEquals(null, importNormalizer.resolve(xytextRelativeName));
//		assertEquals(null, importNormalizer.resolve(xytextRelativeNameWithDollar));
//		
//		ImportNormalizer wildcardImportNormalizer = new ImportNormalizer(namespace, true, false);
//		assertEquals(namespace.append(xtextRelativeName), wildcardImportNormalizer.resolve(xtextRelativeName));
//		assertEquals(namespace.append(ytextRelativeName), wildcardImportNormalizer.resolve(ytextRelativeName));
//		assertEquals(namespace.append(xytextRelativeName), wildcardImportNormalizer.resolve(xytextRelativeName));
//		assertEquals(namespace.append(xytextRelativeNameWithDollar), wildcardImportNormalizer.resolve(xytextRelativeNameWithDollar));
//
//		ImportNormalizer xtextImportNormalizer = new ImportNormalizer(xtextRelativeName, false, false);
//		assertEquals(xtextRelativeName, xtextImportNormalizer.resolve(xtextRelativeName));
//	}
//	
//	@Test public void testDeresolve_ImportNormalizer() throws Exception {
//		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
//		QualifiedName xtextFQN = namespace.append("Xtext");
//		QualifiedName ytextFQN = namespace.skipLast(1).append("ytext");
//		QualifiedName xytextFQN = namespace.append("ytext");
//
//		ImportNormalizer importNormalizer = new ImportNormalizer(xtextFQN, false, false);
//		assertEquals(QualifiedName.create("Xtext"), importNormalizer.deresolve(xtextFQN));
//		assertEquals(null, importNormalizer.deresolve(ytextFQN));
//		assertEquals(null, importNormalizer.deresolve(xytextFQN));
//		
//		importNormalizer = new ImportNormalizer(xytextFQN, false, false);
//		assertEquals(null, importNormalizer.deresolve(xtextFQN));
//		assertEquals(null, importNormalizer.deresolve(ytextFQN));
//		assertEquals(QualifiedName.create("ytext"), importNormalizer.deresolve(xytextFQN));
//
//		ImportNormalizer wildcardImportNormalizer = new ImportNormalizer(namespace, true, false);
//		assertEquals(QualifiedName.create("Xtext"), wildcardImportNormalizer.deresolve(xtextFQN));
//		assertEquals(null, wildcardImportNormalizer.deresolve(ytextFQN));
//		assertEquals(QualifiedName.create("ytext"), wildcardImportNormalizer.deresolve(xytextFQN));
//	}
}
