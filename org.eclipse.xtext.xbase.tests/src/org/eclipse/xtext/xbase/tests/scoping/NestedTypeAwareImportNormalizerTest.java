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
public class NestedTypeAwareImportNormalizerTest extends AbstractNestedTypeAwareImportNormalizerTestBase {

	@Override
	@Test(expected = IllegalArgumentException.class)
	public void testIgnoreCase() {
		new NestedTypeAwareImportNormalizer(QualifiedName.create("a"), false, true);
	}

	@Test public void testResolve_ImportNormalizer() throws Exception {
		QualifiedName xtextRelativeName = QualifiedName.create("xtext");
		QualifiedName ytextRelativeName = QualifiedName.create("ytext");
		QualifiedName xytextRelativeName = QualifiedName.create("xtext", "ytext");
		QualifiedName xytextRelativeNameWithDollar = QualifiedName.create("xtext$ytext");

		QualifiedName namespace = QualifiedName.create("org", "eclipse$xtext");
		ImportNormalizer importNormalizer = createImportNormalizer(namespace, false);
		assertEquals(namespace, importNormalizer.resolve(xtextRelativeName));
		assertEquals(null, importNormalizer.resolve(ytextRelativeName));
		assertEquals(namespace.skipLast(1).append("eclipse$xtext$ytext"), importNormalizer.resolve(xytextRelativeName));
		assertEquals(namespace.skipLast(1).append("eclipse$xtext$ytext"), importNormalizer.resolve(xytextRelativeNameWithDollar));
		
		ImportNormalizer wildcardImportNormalizer = createImportNormalizer(namespace, true);
		assertEquals(null, wildcardImportNormalizer.resolve(xtextRelativeName));
		assertEquals(null, wildcardImportNormalizer.resolve(ytextRelativeName));
		assertEquals(null, wildcardImportNormalizer.resolve(xytextRelativeName));
		assertEquals(null, wildcardImportNormalizer.resolve(xytextRelativeNameWithDollar));

		ImportNormalizer xytextRelativeNameWithDollarNormalizer = createImportNormalizer(xytextRelativeNameWithDollar, false);
		assertEquals(xytextRelativeNameWithDollar, xytextRelativeNameWithDollarNormalizer.resolve(xytextRelativeNameWithDollar));
	}
	
	@Test public void testResolve_NestedTypes() throws Exception {
		QualifiedName mapEntry = QualifiedName.create("Map$Entry");
		QualifiedName mapEntryWithDot = QualifiedName.create("Map", "Entry");
		QualifiedName maps = QualifiedName.create("Maps");
		QualifiedName mapsInternal = QualifiedName.create("Maps$Internal");
		QualifiedName mapsInternalWithDot = QualifiedName.create("Maps", "Internal");
		QualifiedName imported = QualifiedName.create("java", "util", "Map$Entry");
		QualifiedName expected = QualifiedName.create("java", "util", "Map$Entry");
		ImportNormalizer importNormalizer = createImportNormalizer(imported, false);
		assertEquals(imported, importNormalizer.resolve(mapEntry));
		assertEquals(null, importNormalizer.resolve(mapEntryWithDot));
		assertEquals(null, importNormalizer.resolve(maps));
		assertEquals(null, importNormalizer.resolve(mapsInternal));
		assertEquals(null, importNormalizer.resolve(mapsInternalWithDot));
		
		importNormalizer = createImportNormalizer(expected, false);
		assertEquals(QualifiedName.create("java", "util", "Map$Entry$Internal"), importNormalizer.resolve(QualifiedName.create("Entry$Internal")));
		assertEquals(QualifiedName.create("java", "util", "Map$Entry$Internal"), importNormalizer.resolve(QualifiedName.create("Entry", "Internal")));
		assertEquals(null, importNormalizer.resolve(QualifiedName.create("Entry2$Internal")));
		assertEquals(null, importNormalizer.resolve(QualifiedName.create("Entry2", "Internal")));
		
		ImportNormalizer wildcardImportNormalizer = createImportNormalizer(imported, true);
		assertEquals(null, wildcardImportNormalizer.resolve(mapEntry));
		assertEquals(null, wildcardImportNormalizer.resolve(mapEntryWithDot));
		assertEquals(null, wildcardImportNormalizer.resolve(maps));
		assertEquals(null, wildcardImportNormalizer.resolve(mapsInternal));
		assertEquals(null, wildcardImportNormalizer.resolve(mapsInternalWithDot));
	}

	@Override
	protected ImportNormalizer createImportNormalizer(QualifiedName imported, boolean wildcard) {
		ImportNormalizer result = super.createImportNormalizer(imported, wildcard);
		assertTrue(result instanceof NestedTypeAwareImportNormalizer);
		return result;
	}

	@Test public void testDeresolve_ImportNormalizer() throws Exception {
		QualifiedName namespace = QualifiedName.create("org", "eclipse", "xtext");
		QualifiedName xtextFQN = namespace.append("Xtext$Xtext");
		QualifiedName ytextFQN = namespace.skipLast(1).append("ytext");
		QualifiedName xytextFQN = namespace.append("ytext$ytext");

		ImportNormalizer importNormalizer = createImportNormalizer(xtextFQN, false);
		assertEquals(QualifiedName.create("Xtext"), importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(null, importNormalizer.deresolve(xytextFQN));
		
		importNormalizer = createImportNormalizer(xytextFQN, false);
		assertEquals(null, importNormalizer.deresolve(xtextFQN));
		assertEquals(null, importNormalizer.deresolve(ytextFQN));
		assertEquals(QualifiedName.create("ytext"), importNormalizer.deresolve(xytextFQN));

		ImportNormalizer wildcardImportNormalizer = createImportNormalizer(xtextFQN, true);
		assertEquals(null, wildcardImportNormalizer.deresolve(xtextFQN));
		assertEquals(null, wildcardImportNormalizer.deresolve(ytextFQN));
		assertEquals(null, wildcardImportNormalizer.deresolve(xytextFQN));
	}

	@Test public void testDeesolve_NestedTypes() throws Exception {
		QualifiedName imported = QualifiedName.create("java", "util", "Map$Entry");
		QualifiedName fqnMapEntry = QualifiedName.create("java", "util", "Map$Entry");
		QualifiedName fqnMaps = QualifiedName.create("java", "util", "Maps");
		QualifiedName fqnMapsInternal = QualifiedName.create("java", "util", "Maps$Internal");

		ImportNormalizer importNormalizer = createImportNormalizer(imported, false);
		assertEquals(QualifiedName.create("Entry"), importNormalizer.deresolve(fqnMapEntry));
		assertEquals(null, importNormalizer.deresolve(fqnMaps));
		assertEquals(null, importNormalizer.deresolve(fqnMapsInternal));
		
		importNormalizer = createImportNormalizer(fqnMapEntry, false);
		assertEquals(QualifiedName.create("Entry"), importNormalizer.deresolve(fqnMapEntry));
		assertEquals(QualifiedName.create("Entry$Nested"), importNormalizer.deresolve(QualifiedName.create("java", "util", "Map$Entry$Nested")));
	}
}
