/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.naming.QualifiedName;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportNormalizerTest extends Assert {

	@Test public void testNull() throws Exception {
		try {
			new ImportNormalizer(null, true, false);
			fail("Expected exception");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test public void testResolve() throws Exception {
		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
		QualifiedName xytextRelativeName = QualifiedName.create("xtext","ytext");

		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		ImportNormalizer importNormalizer = new ImportNormalizer(namespace, false, false);
		assertEquals(namespace, importNormalizer.resolve(xtextRelativeName));
		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
		assertEquals(null, importNormalizer.resolve(xytextRelativeName));
		
		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace, true, false);
		assertEquals(namespace.append(xtextRelativeName), wildCardImportNormalizer.resolve(xtextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), wildCardImportNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.append(xytextRelativeName), wildCardImportNormalizer.resolve(xytextRelativeName));

		ImportNormalizer xtextImportNormalizer = new ImportNormalizer(xtextRelativeName, false, false);
		assertEquals(xtextRelativeName, xtextImportNormalizer.resolve(xtextRelativeName));
	}
	
	@Test public void testResolveIgnoreCase() throws Exception {
		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
		QualifiedName xytextRelativeName = QualifiedName.create("xtext","ytext");

		QualifiedName namespace = QualifiedName.create("ORG", "ECLIPSE", "XTEXT");
		ImportNormalizer importNormalizer = new ImportNormalizer(namespace, false, true);
		assertEquals("ORG.ECLIPSE.xtext", importNormalizer.resolve(xtextRelativeName).toString());
		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
		assertEquals(null, importNormalizer.resolve(xytextRelativeName));
		
		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace, true, true);
		assertEquals(namespace.append(xtextRelativeName), wildCardImportNormalizer.resolve(xtextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), wildCardImportNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.append(xytextRelativeName), wildCardImportNormalizer.resolve(xytextRelativeName));

		ImportNormalizer xtextImportNormalizer = new ImportNormalizer(QualifiedName.create("XTEXT"), false, true);
		assertEquals(xtextRelativeName, xtextImportNormalizer.resolve(xtextRelativeName));
	}
	
	@Test public void testDeresolve() throws Exception {
		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		QualifiedName xtextFQN = namespace.append("Xtext");
		QualifiedName ytextFQN = namespace.skipLast(1).append("ytext");
		QualifiedName xytextFQN = namespace.append("ytext");

		ImportNormalizer importNormalizer = new ImportNormalizer(xtextFQN, false, false);
		assertEquals(QualifiedName.create("Xtext"), importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(null, importNormalizer.deresolve(xytextFQN));
		
		importNormalizer = new ImportNormalizer(xytextFQN, false, false);
		assertEquals(null, importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), importNormalizer.deresolve(xytextFQN));

		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace, true, false);
		assertEquals(QualifiedName.create("Xtext"), wildCardImportNormalizer.deresolve(xtextFQN));
		assertEquals(null, wildCardImportNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), wildCardImportNormalizer.deresolve(xytextFQN));
	}
	
	@Test public void testDeresolveIgnoreCase() throws Exception {
		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		QualifiedName xtextFQN = namespace.append("Xtext");
		QualifiedName ytextFQN = namespace.skipLast(1).append("ytext");
		QualifiedName xytextFQN = namespace.append("ytext");

		ImportNormalizer importNormalizer = new ImportNormalizer(xtextFQN.toUpperCase(), false, true);
		assertEquals(QualifiedName.create("Xtext"), importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(null, importNormalizer.deresolve(xytextFQN));
		
		importNormalizer = new ImportNormalizer(xytextFQN.toUpperCase(), false, true);
		assertEquals(null, importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), importNormalizer.deresolve(xytextFQN));

		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace.toUpperCase(), true, true);
		assertEquals(QualifiedName.create("Xtext"), wildCardImportNormalizer.deresolve(xtextFQN));
		assertEquals(null, wildCardImportNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), wildCardImportNormalizer.deresolve(xytextFQN));
	}
}
