/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
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
import java.util.jar.Manifest;

import org.eclipse.xtext.util.MergeableManifest2;
import org.eclipse.xtext.util.MergeableManifest2.Attributes;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Test;

/**
 * Adaption of olf {@link ManifestMergerTest} for new
 * {@link MergeableManifest2}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class ManifestMerger2Test extends Assert {

	@Test
	public void testMergeRequiredBundles() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest2 manifest = new MergeableManifest2(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = attrs.get(MergeableManifest2.REQUIRE_BUNDLE).replaceAll("\\s", "");
		manifest.addRequiredBundles(Collections.singleton("foo.bar.baz"));
		String after = attrs.get(MergeableManifest2.REQUIRE_BUNDLE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s", ""));
	}

	@Test
	public void testMergeExportedPackages() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest2 manifest = new MergeableManifest2(resourceAsStream);
		assertFalse(manifest.isModified());

		manifest.addExportedPackages(Collections.singleton("org.eclipse.xtext"));
		assertFalse(manifest.isModified());

		manifest.addRequiredBundles(Collections.singleton("org.eclipse.xtend"));
		assertFalse(manifest.isModified());

		manifest.addImportedPackages(Collections.singleton("org.apache.log4j"));
		assertFalse(manifest.isModified());
	}

	@Test
	public void testNoLongLine() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest2 manifest = new MergeableManifest2(resourceAsStream);
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
		for (int i = 0; i < lineDelimiter.length(); i++) {
			assertEquals(result, lineDelimiter.charAt(i), result.charAt(idx + i));
		}
		assertEquals(result, ' ', result.charAt(idx + lineDelimiter.length()));
	}

	@Test
	public void testSplit512Length() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest2 manifest = new MergeableManifest2(resourceAsStream);
		char[] buff = new char[712];
		Arrays.fill(buff, 'c');
		manifest.addExportedPackages(Collections.singleton(new String(buff)));
		assertTrue(manifest.isModified());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		manifest.write(out);
		String result = out.toString();
		try {
			new Manifest(new StringInputStream(result));
		} catch (Exception e) {
			fail("long line has not been splitted into chunks");
		}
	}

	@Test
	public void testNoChanges() throws Exception {
		String packageName = getClass().getPackage().getName().replace('.', '/');
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + packageName + "/Test_Manifest.MF");
		MergeableManifest2 manifest = new MergeableManifest2(resourceAsStream);
		Attributes attrs = manifest.getMainAttributes();
		String before = attrs.get(MergeableManifest2.EXPORT_PACKAGE).replaceAll("\\s", "");
		manifest.addExportedPackages(Collections.singleton("foo.bar.baz"));
		String after = attrs.get(MergeableManifest2.EXPORT_PACKAGE);
		assertEquals(before + ",foo.bar.baz", after.replaceAll("\\s", ""));
	}

}
