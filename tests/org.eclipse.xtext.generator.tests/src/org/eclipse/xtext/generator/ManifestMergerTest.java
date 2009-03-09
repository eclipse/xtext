/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.jar.Attributes;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ManifestMergerTest extends TestCase {

	public void testMergeRequiredBundles() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = (String) attrs.get(MergeableManifest.REQUIRE_BUNDLE);
		manifest.addRequiredBundles(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.REQUIRE_BUNDLE);
		assertEquals(before + ",foo.bar.baz", after);
	}

	public void testMergeExportedPackages() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		manifest.addExportedPackages(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		assertEquals(before + ",foo.bar.baz", after);
	}

	public void testMergeIntoCommaSeparatedList() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar,foo,baz", MergeableManifest.mergeIntoCommaSeparatedList("bar", toMerge));
		assertEquals("bar,x,foo,baz", MergeableManifest.mergeIntoCommaSeparatedList("bar ,    x", toMerge));
		assertEquals("baz,bar,foo", MergeableManifest.mergeIntoCommaSeparatedList("baz,bar,foo", toMerge));
		assertEquals("foo,bar,baz", MergeableManifest.mergeIntoCommaSeparatedList("", toMerge));
		assertEquals("foo,bar,baz", MergeableManifest.mergeIntoCommaSeparatedList(null, toMerge));
	}

	public void testMergeIntoCommaSeparatedListWithParams() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar;version=\"0.7.0\",foo,baz", MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;version=\"0.7.0\"", toMerge));
		assertEquals("bar;special=foo,x,foo,baz", MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;special=foo ,    x", toMerge));
	}

	public void testMergeIntoCommaSeparatedListInvalidParam() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo;foo=version");
		toMerge.add("bar");
		toMerge.add("baz");
		try {
			assertEquals("bar;version=\"0.7.0\",foo,baz", MergeableManifest.mergeIntoCommaSeparatedList(
					"bar;version=\"0.7.0\"", toMerge));
			fail("Exception expected");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

}
