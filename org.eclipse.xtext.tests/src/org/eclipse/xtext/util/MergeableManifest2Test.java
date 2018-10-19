/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import static com.google.common.base.Strings.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
public class MergeableManifest2Test {

	private static final String NL = System.lineSeparator();

	@Test
	public void make512Safe_empty() throws Exception {
		assertEquals("", make512Safe(""));
	}

	@Test
	public void make512Safe_512Lines() throws Exception {
		assertEquals(repeat("\n", 512), make512Safe(repeat("\n", 512)));
	}

	@Test
	public void make512Safe_2Lines_512chars() throws Exception {
		assertEquals(repeat("a", 255) + "\n" + repeat("b", 255) + "\n",
				make512Safe(repeat("a", 255) + "\n" + repeat("b", 255) + "\n"));
	}

	@Test
	public void make512Safe_2Lines_513chars() throws Exception {
		assertEquals(repeat("a", 256) + "\n" + repeat("b", 255) + "\n",
				make512Safe(repeat("a", 256) + "\n" + repeat("b", 255) + "\n"));
	}

	@Test
	public void make512Safe_oneLine512Chars() throws Exception {
		assertEquals(repeat("a", 512) + "\n", make512Safe(repeat("a", 512)));
	}

	@Test
	public void make512Safe_oneLine513Chars() throws Exception {
		assertEquals(repeat("a", 510) + "\n aaa\n", make512Safe(repeat("a", 513)));
	}

	@Test
	public void make512Safe_oneLine1025Chars() throws Exception {
		assertEquals(repeat("a", 510) + "\n " + repeat("a", 510) + "\n aaaaa\n", make512Safe(repeat("a", 1025)));
	}

	@Test
	public void make512Safe_2Lines_One513chars() throws Exception {
		assertEquals(repeat("a", 255) + "\n" + repeat("b", 510) + "\n bbb\n",
				make512Safe(repeat("a", 255) + "\n" + repeat("b", 513) + "\n"));
	}

	@Test
	public void manifest_empty() throws Exception {
		MergeableManifest2 manifest = newManifest("");

		assertTrue(manifest.getEntries().isEmpty());
		assertTrue(manifest.getMainAttributes().isEmpty());
		assertFalse(manifest.isModified());
	}

	@Test
	public void manifest_emptyLine() throws Exception {
		MergeableManifest2 manifest = newManifest("\n");

		assertTrue(manifest.getEntries().isEmpty());
		assertTrue(manifest.getMainAttributes().isEmpty());
		assertFalse(manifest.isModified());
	}

	@Test
	public void manifest_emptyLine_windowsStyle() throws Exception {
		MergeableManifest2 manifest = newManifest("\r\n");

		assertTrue(manifest.getEntries().isEmpty());
		assertTrue(manifest.getMainAttributes().isEmpty());
		assertFalse(manifest.isModified());
	}

	@Test(expected = IOException.class)
	public void manifest_LineWith513Chars() throws Exception {
		newManifest(repeat("a", 513));
	}

	@Test(expected = IOException.class)
	public void manifest_toLingALine() throws Exception {
		newManifest("test: " + repeat("a", 512) + NL);
	}

	@Test
	public void manifest_oneMainEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("test: ttt\n");

		assertTrue(manifest.getEntries().isEmpty());
		assertEquals(1, manifest.getMainAttributes().size());
		assertEquals("ttt", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_windowsStyle() throws Exception {
		MergeableManifest2 manifest = newManifest("test: ttt\r\n");

		assertEquals("ttt", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_valueEndingWithBlank() throws Exception {
		MergeableManifest2 manifest = newManifest("test: ttt \n");

		assertEquals("ttt ", getMainAttributeValue(manifest, "test"));
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_blankAfterName() throws Exception {
		newManifest("test : ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameOnly() throws Exception {
		newManifest("test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameAndColon() throws Exception {
		newManifest("test:\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameBlankAndColon() throws Exception {
		newManifest("test :\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_noName() throws Exception {
		newManifest(": ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_noNameButBlank() throws Exception {
		newManifest(" : ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameLongerThen70Chars() throws Exception {
		newManifest(repeat("a", 71) + ": ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameWithInvalidCharacter() throws Exception {
		newManifest("#: ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameWithInvalidCharacter2() throws Exception {
		newManifest(";: ttt\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneMainEntry_nameWithInvalidCharacter3() throws Exception {
		newManifest("~: ttt\n");
	}

	@Test
	public void manifest_oneMainEntry_withAllValidCharacterClasses() throws Exception {
		MergeableManifest2 manifest = newManifest("abcxyz_ABCXYZ-123: 123\n");

		assertEquals("123", getMainAttributeValue(manifest, "abcxyz_ABCXYZ-123"));
	}

	@Test
	public void manifest_oneMainEntry_continuesOnSecondLine() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 123\n 456\n");

		assertEquals("123456", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_continuesOnSecondLine_windowsStyle() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 123\r\n 456\r\n");

		assertEquals("123456", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_continuesOnSecondAndThirdLine() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 123\n 456\n 789\n");

		assertEquals("123456789", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_duplicateMainEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 1\ntest: 2\n");

		assertEquals("2", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_duplicateMainEntry_onTwoLines() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 1\n 2\ntest: 2\n 3\n");

		assertEquals("23", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneEntry_name() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\n");

		assertNull(getMainAttributeValue(manifest, "test"));
		assertNotNull(manifest.getAttributes("test"));
		assertEquals(0, manifest.getAttributes("test").size());
	}

	@Test
	public void manifest_oneEntry_name_beforeMultipleNewlines() throws Exception {
		MergeableManifest2 manifest = newManifest("\n\nName: test\n");

		assertNull(getMainAttributeValue(manifest, "test"));
		assertNotNull(manifest.getAttributes("test"));
		assertEquals(0, manifest.getAttributes("test").size());
	}

	@Test
	public void manifest_oneEntry_name_windowsStyle() throws Exception {
		MergeableManifest2 manifest = newManifest("\r\nName: test\r\n");

		assertNull(getMainAttributeValue(manifest, "test"));
		assertNotNull(manifest.getAttributes("test"));
		assertEquals(0, manifest.getAttributes("test").size());
	}

	@Test
	public void manifest_oneEntry_nameAsLowerCase() throws Exception {
		MergeableManifest2 manifest = newManifest("\nname: test\n");

		assertNull(getMainAttributeValue(manifest, "test"));
		assertNotNull(manifest.getAttributes("test"));
		assertEquals(0, manifest.getAttributes("test").size());
	}

	@Test
	public void manifest_oneEntry_name_onTwoLines() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\n 123\n");

		assertEquals(0, manifest.getAttributes("test123").size());
	}

	@Test
	public void manifest_oneEntry_name_onThreeLines() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\n 123\n asdf\n");

		assertEquals(0, manifest.getAttributes("test123asdf").size());
	}

	@Test
	public void manifest_oneEntry_withOneAttribute() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\na1: v1\n");

		assertNull(getMainAttributeValue(manifest, "test"));
		assertNull(getMainAttributeValue(manifest, "a1"));
		assertEquals(1, manifest.getAttributes("test").size());
		assertEquals("v1", getAttributeValue(manifest, "test", "a1"));
	}

	@Test
	public void manifest_oneEntry_withTwoAttributes() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\na1: v1\na2: v2\n");

		assertEquals(2, manifest.getAttributes("test").size());
		assertEquals("v1", getAttributeValue(manifest, "test", "a1"));
		assertEquals("v2", getAttributeValue(manifest, "test", "a2"));
	}

	@Test
	public void manifest_oneEntry_withOneAttributeOnMultipleLines() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test\na1: v1\n 2\n 3\n");

		assertEquals(1, manifest.getAttributes("test").size());
		assertEquals("v123", getAttributeValue(manifest, "test", "a1"));
	}

	@Test
	public void manifest_twoEntries() throws Exception {
		MergeableManifest2 manifest = newManifest("\nName: test1\n\nName: test2\n");

		assertNull(getMainAttributeValue(manifest, "test1"));
		assertNull(getMainAttributeValue(manifest, "test2"));
		assertNotNull(manifest.getAttributes("test1"));
		assertNotNull(manifest.getAttributes("test2"));
		assertEquals(0, manifest.getAttributes("test1").size());
		assertEquals(0, manifest.getAttributes("test2").size());
	}

	@Test
	public void manifest_twoEntries_withValues() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"\nName: test1\ntest1_a1: v1a1\ntest1_a2: v1a2\n\nName: test2\ntest2_a1: v2a1\ntest2_a2: v2a2\n");

		assertEquals(2, manifest.getAttributes("test1").size());
		assertEquals("v1a1", getAttributeValue(manifest, "test1", "test1_a1"));
		assertEquals("v1a2", getAttributeValue(manifest, "test1", "test1_a2"));
		assertEquals(2, manifest.getAttributes("test2").size());
		assertEquals("v2a1", getAttributeValue(manifest, "test2", "test2_a1"));
		assertEquals("v2a2", getAttributeValue(manifest, "test2", "test2_a2"));
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat() throws Exception {
		newManifest("\nName : test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat2() throws Exception {
		newManifest("\nN:1\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat3() throws Exception {
		newManifest("\nZame: test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat4() throws Exception {
		newManifest("\nNZme: test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat5() throws Exception {
		newManifest("\nNaZe: test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat6() throws Exception {
		newManifest("\nNamZ: test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat7() throws Exception {
		newManifest("\nNameZ test\n");
	}

	@Test(expected = IOException.class)
	public void manifest_oneEntry_name_invalidFormat8() throws Exception {
		newManifest("\nName:Ztest\n");
	}

	@Test
	public void write_empty() throws Exception {
		assertEquals("", write(""));
	}

	@Test
	public void write_versionOnly() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL, write("Manifest-Version: 1.0" + NL));
	}

	@Test
	public void write_signatureVersionOnly() throws Exception {
		assertEquals("Signature-Version: 1.0" + NL, write("Signature-Version: 1.0" + NL));
	}

	@Test
	public void write_oneMainEntry_missingVersion() throws Exception {
		assertEquals("", write("test: 0\n"));
	}

	@Test
	public void write_oneMainEntry_afterVersion() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + "test: 0" + NL,
				write("Manifest-Version: 1.0" + NL + "test: 0" + NL));
	}

	@Test
	public void write_oneMainEntry_beforeVersion() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + "test: 0" + NL,
				write("test: 0" + NL + "Manifest-Version: 1.0" + NL));
	}

	@Test
	public void write_twoMainEntries_afterVersion() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + "test0: 0" + NL + "test1: 1" + NL,
				write("Manifest-Version: 1.0" + NL + "test0: 0" + NL + "test1: 1" + NL));
	}

	@Test
	public void write_mainEntry_lineWith512chars() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + "test: " + repeat("a", 504) + NL,
				write("Manifest-Version: 1.0" + NL + "test: " + repeat("a", 504) + NL));
	}

	@Test
	public void write_mainEntry_lineWithMoreThen512chars() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.getMainAttributes().put("test", repeat("a", 512));

		assertEquals("Manifest-Version: 1.0" + NL + "test: " + repeat("a", 504) + NL + " aaaaaaaa" + NL,
				write(manifest));
	}

	@Test
	public void write_oneEntry_onlyName() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL,
				write("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL));
	}

	@Test
	public void write_oneName_oneEntry() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: 0" + NL,
				write("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: 0" + NL));
	}

	@Test
	public void write_oneName_oneEntry_emptyValue() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL,
				write("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: " + NL));
	}

	@Test
	public void write_oneName_twoEntries() throws Exception {
		assertEquals("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: 0" + NL + "t1: 1" + NL,
				write("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: 0" + NL + "t1: 1" + NL));
	}

	@Test
	public void write_twoNames_twoEntries() throws Exception {
		assertEquals(
				"Manifest-Version: 1.0" + NL + NL + "Name: test0" + NL + "t0: 0" + NL + "t1: 1" + NL + NL
						+ "Name: test1" + NL + "t2: 2" + NL + "t3: 3" + NL,
				write("Manifest-Version: 1.0" + NL + NL + "Name: test0" + NL + "t0: 0" + NL + "t1: 1" + NL + NL
						+ "Name: test1" + NL + "t2: 2" + NL + "t3: 3" + NL));
	}

	@Test
	public void write_oneName_oneEntry_lineWithMoreThen512chars() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL);
		manifest.getEntries().get("test").put("t0", repeat("a", 512));

		assertEquals(
				"Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: " + repeat("a", 506) + NL + " aaaaaa" + NL,
				write(manifest));
	}

	@Test
	public void clear_removesAllEntries() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL);
		manifest.clear();

		assertEquals("", write(manifest));
	}

	@Test
	public void putValue_addOneMainEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.getMainAttributes().put("test", "1");

		assertTrue(manifest.isModified());
		assertEquals("1", manifest.getMainAttributes().get("test"));
	}

	@Test
	public void putValue_addOneMainEntry_twice() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.getMainAttributes().put("test", "1");
		manifest.getMainAttributes().put("test", "2");

		assertTrue(manifest.isModified());
		assertEquals("2", manifest.getMainAttributes().get("test"));
	}

	@Test
	public void putValue_addOneMainEntry_alreadyThere() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "test: 1" + NL);
		manifest.getMainAttributes().put("test", "1");

		assertFalse(manifest.isModified());
		assertEquals("1", manifest.getMainAttributes().get("test"));
	}

	@Test
	public void cloneMethod() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + NL + "Name: test" + NL);
		manifest.getEntries().get("test").put("t0", repeat("a", 512));
		MergeableManifest2 copy = manifest.clone();

		assertEquals(
				"Manifest-Version: 1.0" + NL + NL + "Name: test" + NL + "t0: " + repeat("a", 506) + NL + " aaaaaa" + NL,
				write(copy));
	}

	@Test
	public void addRequiredBundles_missingAttribute_emptyValues() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.emptySet());

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_oneValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("a"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_oneEmptyValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton(""));

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_twoValues() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(new HashSet<>(java.util.Arrays.asList("a", "b")));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingOneValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles(Collections.singleton("b"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles(Collections.singleton("a"));

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_oneValue_withVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("a;1.0"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValue_withVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles(Collections.singleton("a;1.0"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withoutVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("a"));

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withSameVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("a;1.0"));

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withDifferentVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("a;1.1"));

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_threeValuesBefore_addingMoreVersions() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0," + NL + " b," + NL + " c" + NL);
		manifest.addRequiredBundles(new HashSet<>(java.util.Arrays.asList("b", "d;2.1", "e")));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0," + NL + " b," + NL + " c," + NL + " d;2.1,"
				+ NL + " e" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("\"a,b\""));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_quotedEntryAlreadyPresent() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b;1.0\"" + NL);
		manifest.addRequiredBundles(Collections.singleton("c"));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b;1.0\"," + NL + " c" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_unclosed() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("\"a,b"));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles(Collections.singleton("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\""));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\""
				+ NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version_toExisting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"" + NL);
		manifest.addRequiredBundles(Collections.singleton("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\""));

		assertEquals("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"," + NL
				+ " org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version_toExistingWithPreivous() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: org.eclipse.xtext.util," + NL
						+ " org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"" + NL);
		manifest.addRequiredBundles(Collections.singleton("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\""));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: org.eclipse.xtext.util," + NL
				+ " org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"," + NL
				+ " org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNamePresent() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL);
		manifest.addRequiredBundles(Collections.singleton("a"));

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL + "Require-Bundle: a" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNamePresent_addSelf() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL);
		manifest.addRequiredBundles(Collections.singleton("self"));

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNameWithVersionPresent_addSelf() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self;1.1" + NL);
		manifest.addRequiredBundles(Collections.singleton("self"));

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self;1.1" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_projectNamePresent_addSelf() throws Exception {
		MergeableManifest2 manifest = new MergeableManifest2(new StringInputStream("Manifest-Version: 1.0" + NL),
				"self");
		manifest.addRequiredBundles(Collections.singleton("self"));

		assertEquals("Manifest-Version: 1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_projectNamePresent_addOther() throws Exception {
		MergeableManifest2 manifest = new MergeableManifest2(new StringInputStream("Manifest-Version: 1.0" + NL),
				"self");
		manifest.addRequiredBundles(Collections.singleton("other"));

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: other" + NL, write(manifest));
	}

	@Test
	public void addExportedPackages_oneEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addExportedPackages("a");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL, write(manifest));
	}

	@Test
	public void addExportedPackages_oneEntry_alreadyExisting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL);
		manifest.addExportedPackages("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL, write(manifest));
	}

	@Test
	public void addExportedPackages_oneEntry_usingSet() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addExportedPackages(Collections.singleton("a"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL, write(manifest));
	}

	@Test
	public void addExportedPackages_twoEntries() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addExportedPackages("a", "b");

		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addExportedPackages_threeValuesBefore_addingMoreVersions() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Export-Package: a;1.0," + NL + " b," + NL + " c" + NL);
		manifest.addExportedPackages("b", "d;2.1", "e");

		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a;1.0," + NL + " b," + NL + " c," + NL + " d;2.1,"
				+ NL + " e" + NL, write(manifest));
	}

	@Test
	public void addImportedPackages_oneEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addImportedPackages("a");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL, write(manifest));
	}

	@Test
	public void addImportedPackages_oneEntry_alreadyExisting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL);
		manifest.addImportedPackages("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL, write(manifest));
	}

	@Test
	public void addImportedPackages_oneEntry_usingSet() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addImportedPackages(Collections.singleton("a"));

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL, write(manifest));
	}

	@Test
	public void addImportedPackages_twoEntries() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addImportedPackages("a", "b");

		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addImportedPackages_threeValuesBefore_addingMoreVersions() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Import-Package: a;1.0," + NL + " b," + NL + " c" + NL);
		manifest.addImportedPackages("b", "d;2.1", "e");

		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a;1.0," + NL + " b," + NL + " c," + NL + " d;2.1,"
				+ NL + " e" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfMainAttributes_1() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL
				+ "Export-Package: b" + NL + "Import-Package: c" + NL);

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL + "Export-Package: b" + NL
				+ "Import-Package: c" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfMainAttributes_2() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Import-Package: c" + NL
				+ "Require-Bundle: a" + NL + "Export-Package: b" + NL);

		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: c" + NL + "Require-Bundle: a" + NL
				+ "Export-Package: b" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfAttributes_1() throws Exception {
		MergeableManifest2 manifest = newManifest(NL + "Name: a" + NL + "a0: 0" + NL + "a1: 1" + NL + "a2: 2" + NL);

		assertEquals(NL + "Name: a" + NL + "a0: 0" + NL + "a1: 1" + NL + "a2: 2" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfAttributes_2() throws Exception {
		MergeableManifest2 manifest = newManifest(NL + "Name: a" + NL + "a2: 2" + NL + "a1: 1" + NL + "a0: 0" + NL);

		assertEquals(NL + "Name: a" + NL + "a2: 2" + NL + "a1: 1" + NL + "a0: 0" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfAttributeNames_1() throws Exception {
		MergeableManifest2 manifest = newManifest(NL + "Name: a" + NL + "a0: 0" + NL + NL + "Name: b" + NL + "b0: 0"
				+ NL + NL + "Name: c" + NL + "c0: 0" + NL);

		assertEquals(NL + "Name: a" + NL + "a0: 0" + NL + NL + "Name: b" + NL + "b0: 0" + NL + NL + "Name: c" + NL
				+ "c0: 0" + NL, write(manifest));
	}

	@Test
	public void stableOrderOfAttributeNames_2() throws Exception {
		MergeableManifest2 manifest = newManifest(NL + "Name: c" + NL + "c0: 0" + NL + NL + "Name: b" + NL + "b0: 0"
				+ NL + NL + "Name: a" + NL + "a0: 0" + NL);

		assertEquals(NL + "Name: c" + NL + "c0: 0" + NL + NL + "Name: b" + NL + "b0: 0" + NL + NL + "Name: a" + NL
				+ "a0: 0" + NL, write(manifest));
	}

	@Test
	public void setBree() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.setBREE("test");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-RequiredExecutionEnvironment: test" + NL, write(manifest));
		assertEquals("test", manifest.getBREE());
	}

	@Test
	public void setBree_replaceOld() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Bundle-RequiredExecutionEnvironment: test" + NL);
		manifest.setBREE("new");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-RequiredExecutionEnvironment: new" + NL, write(manifest));
		assertEquals("new", manifest.getBREE());
	}

	@Test
	public void setBree_existingValue() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Bundle-RequiredExecutionEnvironment: test" + NL);
		manifest.setBREE("test");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-RequiredExecutionEnvironment: test" + NL, write(manifest));
		assertEquals("test", manifest.getBREE());
	}

	@Test
	public void setBundleActivator() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.setBundleActivator("test");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL, write(manifest));
		assertEquals("test", manifest.getBundleActivator());
	}

	@Test
	public void setBundleActivator_replaceOld() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		manifest.setBundleActivator("new");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-Activator: new" + NL, write(manifest));
		assertEquals("new", manifest.getBundleActivator());
	}

	@Test
	public void setBundleActivator_existingValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		manifest.setBundleActivator("test");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL, write(manifest));
		assertEquals("test", manifest.getBundleActivator());
	}

	@Test
	public void setLineDelimiter() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		manifest.setLineDelimiter("###");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0###Bundle-Activator: test###", write(manifest));
	}

	@Test
	public void equals_true() throws Exception {
		MergeableManifest2 manifest0 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		MergeableManifest2 manifest1 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);

		assertTrue(manifest0.equals(manifest1));
	}

	@Test
	public void equals_false_becauseOfMainEntry() throws Exception {
		MergeableManifest2 manifest0 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		MergeableManifest2 manifest1 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: other" + NL);

		assertFalse(manifest0.equals(manifest1));
	}

	@Test
	public void equals_false_becauseOfEntry() throws Exception {
		MergeableManifest2 manifest0 = newManifest(NL + "Name: a" + NL + "a0: 0" + NL);
		MergeableManifest2 manifest1 = newManifest(NL + "Name: a" + NL + "a0: other" + NL);

		assertFalse(manifest0.equals(manifest1));
	}

	@Test
	public void hashCode_same() throws Exception {
		MergeableManifest2 manifest0 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		MergeableManifest2 manifest1 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);

		assertEquals(manifest0.hashCode(), manifest1.hashCode());
	}

	@Test
	public void hachCode_differ_becauseOfMainEntry() throws Exception {
		MergeableManifest2 manifest0 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: test" + NL);
		MergeableManifest2 manifest1 = newManifest("Manifest-Version: 1.0" + NL + "Bundle-Activator: other" + NL);

		assertNotEquals(manifest0.hashCode(), manifest1.hashCode());
	}

	@Test
	public void hachCode_differ_becauseOfEntry() throws Exception {
		MergeableManifest2 manifest0 = newManifest(NL + "Name: a" + NL + "a0: 0" + NL);
		MergeableManifest2 manifest1 = newManifest(NL + "Name: a" + NL + "a0: other" + NL);

		assertNotEquals(manifest0.hashCode(), manifest1.hashCode());
	}

	private String make512Safe(String input) {
		return make512Safe(input, "\n");
	}

	private String make512Safe(String input, String newline) {
		return MergeableManifest2.make512Safe(new StringBuffer(input), newline);
	}

	private String write(String input) throws IOException {
		return write(newManifest(input));
	}

	private String write(MergeableManifest2 manifest) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		manifest.write(stream);
		return stream.toString();
	}

	private MergeableManifest2 newManifest(String content) throws IOException {
		return new MergeableManifest2(new StringInputStream(content));
	}

	private Object getMainAttributeValue(MergeableManifest2 manifest, String attributeName) {
		return manifest.getMainAttributes().get(attributeName);
	}

	private Object getAttributeValue(MergeableManifest2 manifest, String attributeName, String entryName) {
		return manifest.getAttributes(attributeName).get(entryName);
	}

}
