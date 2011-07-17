/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xtend2.scoping.NestedTypeAwareImportNormalizer;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeAwareImportNormalizerTest extends TestCase {

	public void testIgnoreCase() {
		try {
			new NestedTypeAwareImportNormalizer(QualifiedName.create("a"), false, true);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e) {
		}
	}
	
	public void testResolve_ImportNormalizer() throws Exception {
		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
		QualifiedName xytextRelativeName = QualifiedName.create("xtext","ytext");

		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		ImportNormalizer importNormalizer = new NestedTypeAwareImportNormalizer(namespace, false, false);
		assertEquals(namespace, importNormalizer.resolve(xtextRelativeName));
		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
		assertEquals(null, importNormalizer.resolve(xytextRelativeName));
		
		ImportNormalizer wildCardImportNormalizer = new NestedTypeAwareImportNormalizer(namespace, true, false);
		assertEquals(namespace.append(xtextRelativeName), wildCardImportNormalizer.resolve(xtextRelativeName));
		assertEquals(namespace.append(ytextRelativeName), wildCardImportNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.append(xytextRelativeName), wildCardImportNormalizer.resolve(xytextRelativeName));

		ImportNormalizer xtextImportNormalizer = new NestedTypeAwareImportNormalizer(xtextRelativeName, false, false);
		assertEquals(xtextRelativeName, xtextImportNormalizer.resolve(xtextRelativeName));
	}
	
	public void testResolve_NestedTypes() throws Exception {
		QualifiedName mapEntry = QualifiedName.create("Map$Entry");
		QualifiedName maps = QualifiedName.create("Maps");
		QualifiedName mapsInternal = QualifiedName.create("Maps$Internal");
		QualifiedName imported = QualifiedName.create("java", "util", "Map");
		QualifiedName expected = QualifiedName.create("java", "util", "Map$Entry");
		ImportNormalizer importNormalizer = new NestedTypeAwareImportNormalizer(imported, false, false);
		assertEquals(expected, importNormalizer.resolve(mapEntry));
		assertEquals(null, importNormalizer.resolve(maps));
		assertEquals(null, importNormalizer.resolve(mapsInternal));
		
		importNormalizer = new NestedTypeAwareImportNormalizer(expected, false, false);
		assertEquals(QualifiedName.create("java", "util", "Map$Entry$Internal"), importNormalizer.resolve(QualifiedName.create("Entry$Internal")));
		assertEquals(null, importNormalizer.resolve(QualifiedName.create("Entry2$Internal")));
		
		ImportNormalizer wildCardImportNormalizer = new NestedTypeAwareImportNormalizer(imported, true, false);
		assertEquals(imported.append(mapEntry), wildCardImportNormalizer.resolve(mapEntry));
		assertEquals(imported.append(maps), wildCardImportNormalizer.resolve(maps));
		assertEquals(imported.append(mapsInternal), wildCardImportNormalizer.resolve(mapsInternal));
	}
	
	public void testDeresolve_ImportNormalizer() throws Exception {
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

	public void testDeesolve_NestedTypes() throws Exception {
		QualifiedName mapEntry = QualifiedName.create("Map$Entry");
		QualifiedName imported = QualifiedName.create("java", "util", "Map");
		QualifiedName fqnMapEntry = QualifiedName.create("java", "util", "Map$Entry");
		QualifiedName fqnMaps = QualifiedName.create("java", "util", "Maps");
		QualifiedName fqnMapsInternal = QualifiedName.create("java", "util", "Maps$Internal");

		ImportNormalizer importNormalizer = new NestedTypeAwareImportNormalizer(imported, false, false);
		assertEquals(mapEntry, importNormalizer.deresolve(fqnMapEntry));
		assertEquals(null, importNormalizer.deresolve(fqnMaps));
		assertEquals(null, importNormalizer.deresolve(fqnMapsInternal));
		
		importNormalizer = new NestedTypeAwareImportNormalizer(fqnMapEntry, false, false);
		assertEquals(QualifiedName.create("Entry"), importNormalizer.deresolve(fqnMapEntry));
		assertEquals(QualifiedName.create("Entry$Nested"), importNormalizer.deresolve(QualifiedName.create("java", "util", "Map$Entry$Nested")));

		ImportNormalizer wildCardImportNormalizer = new NestedTypeAwareImportNormalizer(QualifiedName.create("java", "util"), true, false);
		assertEquals(QualifiedName.create("Map$Entry"), wildCardImportNormalizer.deresolve(fqnMapEntry));
	}
}
