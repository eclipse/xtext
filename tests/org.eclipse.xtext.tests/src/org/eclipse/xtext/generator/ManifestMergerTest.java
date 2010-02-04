/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import junit.framework.TestCase;

import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Wrapper;

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
		String before = ((String) attrs.get(MergeableManifest.REQUIRE_BUNDLE)).replaceAll("\\s","");
		manifest.addRequiredBundles(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.REQUIRE_BUNDLE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	public void testMergeExportedPackages() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		assertFalse(manifest.isModified());

		manifest.addExportedPackages(Collections.singleton("org.eclipse.xtext"));
		assertFalse(manifest.isModified());

		manifest.addRequiredBundles(Collections.singleton("org.eclipse.xtend"));
		assertFalse(manifest.isModified());
		
		manifest.addImportedPackages(Collections.singleton("org.apache.log4j"));
		assertFalse(manifest.isModified());
	}

	public void testNoLongLine() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		manifest.addExportedPackages(Collections.singleton("foobar"));
		assertTrue(manifest.isModified());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		manifest.write(out);
		String result = out.toString();
		String lookup = "Require-Bundle: org.eclipse.xtext,";
		int idx = result.indexOf(lookup);
		assertTrue(idx != -1);
		idx += lookup.length();
		assertEquals(result, '\r', result.charAt(idx));
		assertEquals(result, '\n', result.charAt(idx + 1));
		assertEquals(result, ' ', result.charAt(idx + 2));
	}

	public void testSplit512Length() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		char[] buff = new char[712];
		Arrays.fill(buff, 'c');
		manifest.addExportedPackages(Collections.singleton(new String(buff)));
		assertTrue(manifest.isModified());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		manifest.write(out);
		String result = out.toString();
		try {
			new Manifest(new StringInputStream(result));
		} catch(Exception e) {
			fail("long line has not been splitted into chunks");
		}
	}

	public void testNoChanges() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = ((String) attrs.get(MergeableManifest.EXPORT_PACKAGE)).replaceAll("\\s","");
		manifest.addExportedPackages(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	public void testMergeIntoCommaSeparatedList() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar", toMerge, Wrapper.wrap(false))));
		assertEquals("bar,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar ,    x", toMerge, Wrapper.wrap(false))));
		assertEquals("baz,bar,foo", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("baz,bar,foo", toMerge, Wrapper.wrap(false))));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("", toMerge, Wrapper.wrap(false))));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(null, toMerge, Wrapper.wrap(false))));
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
				"bar;version=\"0.7.0\"", toMerge, Wrapper.wrap(false))));
		assertEquals("bar;special=foo,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;special=foo ,    x", toMerge, Wrapper.wrap(false))));
	}

	public void testMergeIntoCommaSeparatedListInvalidParam() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo;foo=version");
		toMerge.add("bar");
		toMerge.add("baz");
		try {
			assertEquals("bar;version=\"0.7.0\",foo,baz", MergeableManifest.mergeIntoCommaSeparatedList(
					"bar;version=\"0.7.0\"", toMerge, Wrapper.wrap(false)));
			fail("Exception expected");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

}
