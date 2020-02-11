/*******************************************************************************
 * Copyright (c) 2008, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

import org.eclipse.xtext.util.MergeableManifest;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Wrapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ManifestMergerTest extends Assert {
	private static final String NL = Strings.newLine();

	@Test public void testMergeRequiredBundles() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = ((String) attrs.get(MergeableManifest.REQUIRE_BUNDLE)).replaceAll("\\s","");
		manifest.addRequiredBundles(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.REQUIRE_BUNDLE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	@Test public void testMergeExportedPackages() throws Exception {
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

	@Test public void testNoLongLine() throws Exception {
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
		String lineDelimiter = Strings.newLine();
		for (int i=0; i< lineDelimiter.length(); i++) {
			assertEquals(result, lineDelimiter.charAt(i), result.charAt(idx+i));
		}
		assertEquals(result, ' ', result.charAt(idx + lineDelimiter.length()));
	}

	@Test public void testSplit512Length() throws Exception {
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

	@Test public void testNoChanges() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest manifest = new MergeableManifest(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = ((String) attrs.get(MergeableManifest.EXPORT_PACKAGE)).replaceAll("\\s","");
		manifest.addExportedPackages(Collections.singleton("foo.bar.baz"));
		String after = (String) attrs.get(MergeableManifest.EXPORT_PACKAGE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s",""));
	}

	@Test public void testMergeIntoCommaSeparatedList() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar", toMerge, Wrapper.wrap(false), NL)));
		assertEquals("bar,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("bar ,    x", toMerge, Wrapper.wrap(false), NL)));
		assertEquals("baz,bar,foo", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("baz,bar,foo", toMerge, Wrapper.wrap(false), NL)));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList("", toMerge, Wrapper.wrap(false), NL)));
		assertEquals("foo,bar,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(null, toMerge, Wrapper.wrap(false), NL)));
	}

	/**
	 * @param mergeIntoCommaSeparatedList
	 * @return
	 */
	private String removeWS(String s) {
		return s==null?null:s.replaceAll("\\s", "");
	}

	@Test public void testMergeIntoCommaSeparatedListWithParams() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");

		assertEquals("bar;version=\"0.7.0\",foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;version=\"0.7.0\"", toMerge, Wrapper.wrap(false), NL)));
		assertEquals("bar;special=foo,x,foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;special=foo ,    x", toMerge, Wrapper.wrap(false), NL)));
	}
	
	@Test public void testMergeIntoCommaSeparatedListWithCommaSeparatedParams() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo");
		toMerge.add("bar");
		toMerge.add("baz");
		
		assertEquals("bar;x-friends=\"xxx,foo,bar,zzz\",foo,baz", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar;x-friends=\"xxx,foo,bar,zzz\"", toMerge, Wrapper.wrap(false), NL)));
	}

	@Test public void testMergeIntoCommaSeparatedListValidParam() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo;foo=version");
		assertEquals("bar,foo;foo=version", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"bar", toMerge, Wrapper.wrap(false), NL)));
	}

	@Test public void testMergeIntoCommaSeparatedListSkipWhenParamExists() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo;foo=other");
		assertEquals("foo;version=\"0.7.0\"", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"foo;version=\"0.7.0\"", toMerge, Wrapper.wrap(false), NL)));
	}

	@Test public void testMergeIntoCommaSeparatedListAddParam() throws Exception {
		LinkedHashSet<String> toMerge = new LinkedHashSet<String>();
		toMerge.add("foo;version=\"0.7.0\"");
		assertEquals("foo;version=\"0.7.0\"", removeWS(MergeableManifest.mergeIntoCommaSeparatedList(
				"foo", toMerge, Wrapper.wrap(false), NL)));
	}

}
