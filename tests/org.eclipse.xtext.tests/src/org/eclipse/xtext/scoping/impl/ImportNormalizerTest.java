/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import junit.framework.TestCase;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportNormalizerTest extends TestCase {

	public void testNull() throws Exception {
		try {
			new ImportNormalizer(null, true);
			fail("Expected exception");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	public void testResolve() throws Exception {
		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
		QualifiedName xytextRelativeName = QualifiedName.create("xtext","ytext");

		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		ImportNormalizer importNormalizer = new ImportNormalizer(namespace, false);
		assertEquals(namespace, importNormalizer.resolve(xtextRelativeName));
		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), importNormalizer.resolve(xytextRelativeName));
		
		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace, true);
		assertEquals(namespace.append(xtextRelativeName), wildCardImportNormalizer.resolve(xtextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), wildCardImportNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), importNormalizer.resolve(xytextRelativeName));

		ImportNormalizer xtextImportNormalizer = new ImportNormalizer(xtextRelativeName, false);
		assertEquals(xtextRelativeName, xtextImportNormalizer.resolve(xtextRelativeName));
	}
	
	public void testDeresolve() throws Exception {
		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		QualifiedName xtextFQN = namespace.append("Xtext");
		QualifiedName ytextFQN = namespace.skipLast(1).append("ytext");
		QualifiedName xytextFQN = namespace.append("ytext");

		ImportNormalizer importNormalizer = new ImportNormalizer(xtextFQN, false);
		assertEquals(QualifiedName.create("Xtext"), importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(null, importNormalizer.deresolve(xytextFQN));
		
		importNormalizer = new ImportNormalizer(xytextFQN, false);
		assertEquals(null, importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), importNormalizer.deresolve(xytextFQN));

		ImportNormalizer wildCardImportNormalizer = new ImportNormalizer(namespace, true);
		assertEquals(QualifiedName.create("Xtext"), wildCardImportNormalizer.deresolve(xtextFQN));
		assertEquals(null, wildCardImportNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), wildCardImportNormalizer.deresolve(xytextFQN));
	}
}
