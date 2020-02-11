/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ResourceURICollectorTest {

	@Test
	public void test_collectAllResources () {
		File testDataDir = new File("test-data/standalone");
		ResourceURICollector collector = new ResourceURICollector();
		List<URI> roots = Lists.newArrayList(
			URI.createFileURI(testDataDir.getAbsolutePath()).appendSegment("src"),
			URI.createFileURI(testDataDir.getAbsolutePath()).appendSegment("src2")
		);
		Set<URI> foundURIs = collector.collectAllResources(roots, Collections.singleton("buildertestlanguage"));
		Set<String> resourceNames = Sets.newHashSet("Foo.buildertestlanguage", "Bar.buildertestlanguage", "JavaClass.java");
		
		for (String resourceName : resourceNames) {
			assertTrue(foundURIs.stream().anyMatch(uri -> uri.lastSegment().equals(resourceName)));
		}
		assertEquals(resourceNames.size(), foundURIs.size());

	}
}
