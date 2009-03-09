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
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	public void testMergeExportedPackages() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);

		manifest.addExportedPackages(Collections.singleton("org.eclipse.xtext"));
		assertFalse(manifest.isModified());
		
		manifest.addRequiredBundles(Collections.singleton("org.eclipse.xtext.log4j"));
		assertFalse(manifest.isModified());
	}
	
	public void testNoChanges() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		manifest.addExportedPackages(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	public void testMergeIntoCommaSeparatedList() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar", toMerge)));
		assertEquals("bar,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar ,    x", toMerge)));
		assertEquals("baz,bar,foo", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("baz,bar,foo", toMerge)));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("", toMerge)));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(null, toMerge)));
	}

	/**
	 * @param mergeIntoCommaSeparatedList
	 * @return
	 */
	private String removeWS(String s) {
		return s==null?null:s.replaceAll("\\s", "");
	}

	public void testMergeIntoCommaSeparatedListWithParams() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar;version=\"0.7.0\",foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;version=\"0.7.0\"", toMerge)));
		assertEquals("bar;special=foo,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;special=foo ,    x", toMerge)));
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
