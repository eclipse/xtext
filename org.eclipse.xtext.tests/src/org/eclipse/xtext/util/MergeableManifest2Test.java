/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import static com.google.common.base.Strings.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

import com.google.common.io.CharStreams;

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

	@Test
	public void manifest_LineWith513Chars_separatedOnTwoLinesStaySeperated() throws Exception {
		MergeableManifest2 manifest = newManifest("test: " + repeat("a", 506) + NL + " " + repeat("a", 7) + NL);

		assertEquals(repeat("a", 506) + NL + " " + repeat("a", 7), getMainAttributeValue(manifest, "test"));
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

		assertEquals("123" + NL + " 456", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_continuesOnSecondLine_windowsStyle() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 123\r\n 456\r\n");

		assertEquals("123" + NL + " 456", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_oneMainEntry_continuesOnSecondAndThirdLine() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 123\n 456\n 789\n");

		assertEquals("123" + NL + " 456" + NL + " 789", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_duplicateMainEntry() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 1\ntest: 2\n");

		assertEquals("2", getMainAttributeValue(manifest, "test"));
	}

	@Test
	public void manifest_duplicateMainEntry_onTwoLines() throws Exception {
		MergeableManifest2 manifest = newManifest("test: 1\n 2\ntest: 2\n 3\n");

		assertEquals("2" + NL + " 3", getMainAttributeValue(manifest, "test"));
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
		manifest.addRequiredBundles("");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_twoValues() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles("a", "b");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingOneValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles("b");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a," + NL + " b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValue() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_missingAttribute_oneValue_withVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles("a;1.0");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValue_withVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles("a;bundle-version=\"1.0\"");

		assertTrue(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withoutVersion() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"" + NL);
		manifest.addRequiredBundles("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withSameVersion() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL);
		manifest.addRequiredBundles("a;1.0");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersion_withDifferentVersion() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"" + NL);
		manifest.addRequiredBundles("a;bundle-version=\"1.1\"");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_threeValuesBefore_addingMoreVersions() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: a;bundle-version=\"1.0\"," + NL + " b," + NL + " c" + NL);
		manifest.addRequiredBundles("b", "d;bundle-version=\"2.1\"", "e");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"1.0\"," + NL + " b," + NL
				+ " c," + NL + " d;bundle-version=\"2.1\"," + NL + " e" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles("\"a,b\"");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_quotedEntryAlreadyPresent() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b;1.0\"" + NL);
		manifest.addRequiredBundles("c");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b;1.0\"," + NL + " c" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_unclosed() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles("\"a,b");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: \"a,b" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL);
		manifest.addRequiredBundles("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\""
				+ NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version_toExisting() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"" + NL);
		manifest.addRequiredBundles("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"");

		assertEquals("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"," + NL
				+ " org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_version_toExistingWithPreivous() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: org.eclipse.xtext.util," + NL
						+ " org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"" + NL);
		manifest.addRequiredBundles("org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: org.eclipse.xtext.util," + NL
				+ " org.eclipse.xtext.xbase.lib;bundle-version=\"[2.13.0,2.14.0)\"," + NL
				+ " org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_overMultipleLines() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.util.formallang;x-friends:=\"org.eclipse.xtext.ide," + NL
				+ " org.eclipse.xtext.xtext.generator," + NL + " org.eclipse.xtext," + NL + " org.eclipse.xtext.tests\""
				+ NL);
		manifest.addRequiredBundles("org.eclipse.xtext.util.formallang;bundle-version=\"[3.2.0,3.2.1)\"");

		assertEquals("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: org.eclipse.xtext.util.formallang;bundle-version=\"[3.2.0,3.2.1)\";x-friends:=\"org.eclipse.xtext.ide,"
				+ NL + " org.eclipse.xtext.xtext.generator," + NL + " org.eclipse.xtext," + NL
				+ " org.eclipse.xtext.tests\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_quoting_quotedSemicolonInName() throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: \"org.eclipse.xtext.xbase.lib;\"" + NL);
		manifest.addRequiredBundles("\"org.eclipse.xtext.xbase.lib;\";bundle-version=\"1\"");

		assertEquals("Manifest-Version: 1.0" + NL
				+ "Require-Bundle: \"org.eclipse.xtext.xbase.lib;\";bundle-version=\"1\"" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNamePresent() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL);
		manifest.addRequiredBundles("a");

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL + "Require-Bundle: a" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNamePresent_addSelf() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL);
		manifest.addRequiredBundles("self");

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_bundleSymbolicNameWithVersionPresent_addSelf() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self;1.1" + NL);
		manifest.addRequiredBundles("self");

		assertEquals("Manifest-Version: 1.0" + NL + "Bundle-SymbolicName: self;1.1" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_projectNamePresent_addSelf() throws Exception {
		MergeableManifest2 manifest = new MergeableManifest2(new StringInputStream("Manifest-Version: 1.0" + NL),
				"self");
		manifest.addRequiredBundles("self");

		assertEquals("Manifest-Version: 1.0" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_projectNamePresent_addOther() throws Exception {
		MergeableManifest2 manifest = new MergeableManifest2(new StringInputStream("Manifest-Version: 1.0" + NL),
				"self");
		manifest.addRequiredBundles("other");

		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: other" + NL, write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersionAndOthers_withoutVersion()
			throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"2.14.0\";visibility:=reexport" + NL);
		manifest.addRequiredBundles("a");

		assertFalse(manifest.isModified());
		assertEquals(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"2.14.0\";visibility:=reexport" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueWithoutVersionButOthers_withVersion()
			throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;visibility:=reexport" + NL);
		manifest.addRequiredBundles("a;bundle-version=\"2.14.0\"");

		assertTrue(manifest.isModified());
		assertEquals(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"2.14.0\";visibility:=reexport" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersionAndOthers_withoutVersion_noQuoting()
			throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=2.14.0;visibility:=reexport" + NL);
		manifest.addRequiredBundles("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=2.14.0;visibility:=reexport" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueWithoutVersionButOthers_withVersion_noQuoting()
			throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;visibility:=reexport" + NL);
		manifest.addRequiredBundles("a;bundle-version=2.14.0");

		assertTrue(manifest.isModified());
		assertEquals(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;bundle-version=\"2.14.0\";visibility:=reexport" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_oneValueBefore_addingExistingValueVersionAndOthersReversedOrder_withVersion_noQuoting()
			throws Exception {
		MergeableManifest2 manifest = newManifest(
				"Manifest-Version: 1.0" + NL + "Require-Bundle: a;visibility:=reexport;bundle-version=2.14.0" + NL);
		manifest.addRequiredBundles("a");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a;visibility:=reexport;bundle-version=2.14.0" + NL,
				write(manifest));
	}

	@Test
	public void addRequiredBundles_emptyBundlesAreIgnored() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL);
		manifest.addRequiredBundles("");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Require-Bundle: a" + NL, write(manifest));
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
	public void addExportedPackage_emptyBundlesAreIgnored() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL);
		manifest.addExportedPackages("");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Export-Package: a" + NL, write(manifest));
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
	public void addImportedPackage_emptyBundlesAreIgnored() throws Exception {
		MergeableManifest2 manifest = newManifest("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL);
		manifest.addImportedPackages("");

		assertFalse(manifest.isModified());
		assertEquals("Manifest-Version: 1.0" + NL + "Import-Package: a" + NL, write(manifest));
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

	@Test
	public void readWrite_realisticManifest() throws Exception {
		// @formatter:off
		String content =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
			"Bundle-Vendor: Eclipse Xtext" + NL + 
			"Bundle-Version: 2.16.0.qualifier" + NL + 
			"Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
			"Bundle-ActivationPolicy: lazy" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.equinox.common;bundle-version=\"3.5.0\"," + NL + 
			" org.eclipse.emf.ecore," + NL + 
			" org.objectweb.asm;bundle-version=\"[6.2.1,6.3.0)\";resolution:=optional," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtend.lib;bundle-version=\"2.14.0\"," + NL + 
			" org.eclipse.emf.common," + NL + 
			" org.eclipse.xtext.common.types," + NL + 
			" org.eclipse.xtext.xbase.lib;bundle-version=\"2.14.0\"" + NL + 
			"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
			"Export-Package: org.eclipse.xtext.example.homeautomation.ruleEngine.util," + NL + 
			" org.eclipse.xtext.example.homeautomation.ruleEngine," + NL + 
			" org.eclipse.xtext.example.homeautomation.ruleEngine.impl," + NL + 
			" org.eclipse.xtext.example.homeautomation," + NL + 
			" org.eclipse.xtext.example.homeautomation.parser.antlr.lexer," + NL + 
			" org.eclipse.xtext.example.homeautomation.parser.antlr.internal," + NL + 
			" org.eclipse.xtext.example.homeautomation.validation," + NL + 
			" org.eclipse.xtext.example.homeautomation.jvmmodel," + NL + 
			" org.eclipse.xtext.example.homeautomation.scoping," + NL + 
			" org.eclipse.xtext.example.homeautomation.serializer," + NL + 
			" org.eclipse.xtext.example.homeautomation.parser.antlr," + NL + 
			" org.eclipse.xtext.example.homeautomation.services," + NL + 
			" org.eclipse.xtext.example.homeautomation.formatting2" + NL + 
			"Import-Package: org.apache.log4j" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		assertEquals(content, write(manifest));
	}

	@Test
	public void readWrite_addRequiredBundles_realisticManifest_regression() throws Exception {
		// @formatter:off
        String content =
            "Manifest-Version: 1.0" + NL + 
            "Bundle-ManifestVersion: 2" + NL + 
            "Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
            "Bundle-Vendor: Eclipse Xtext" + NL + 
            "Bundle-Version: 2.16.0.qualifier" + NL + 
            "Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
            "Bundle-ActivationPolicy: lazy" + NL + 
            "Require-Bundle: org.eclipse.xtext," + NL + 
            " org.eclipse.xtext.xbase," + NL + 
            " org.eclipse.equinox.common;bundle-version=\"3.5.0\"," + NL + 
            " org.eclipse.emf.ecore," + NL + 
            " org.objectweb.asm;bundle-version=\"[6.2.1,6.3.0)\";resolution:=optional," + NL + 
            " org.eclipse.xtext.util," + NL + 
            " org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
            " org.eclipse.xtend.lib;bundle-version=\"2.14.0\"," + NL + 
            " org.eclipse.emf.common," + NL + 
            " org.eclipse.xtext.common.types;bundle-version=\"2.14.0\";visibility:=reexport," + NL + 
            " org.eclipse.xtext.xbase.lib;bundle-version=\"2.14.0\"" + NL + 
            "Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
            "Export-Package: org.eclipse.xtext.example.homeautomation.ruleEngine.util," + NL + 
            " org.eclipse.xtext.example.homeautomation.ruleEngine," + NL + 
            " org.eclipse.xtext.example.homeautomation.ruleEngine.impl," + NL + 
            " org.eclipse.xtext.example.homeautomation," + NL + 
            " org.eclipse.xtext.example.homeautomation.parser.antlr.lexer," + NL + 
            " org.eclipse.xtext.example.homeautomation.parser.antlr.internal," + NL + 
            " org.eclipse.xtext.example.homeautomation.validation," + NL + 
            " org.eclipse.xtext.example.homeautomation.jvmmodel," + NL + 
            " org.eclipse.xtext.example.homeautomation.scoping," + NL + 
            " org.eclipse.xtext.example.homeautomation.serializer," + NL + 
            " org.eclipse.xtext.example.homeautomation.parser.antlr," + NL + 
            " org.eclipse.xtext.example.homeautomation.services," + NL + 
            " org.eclipse.xtext.example.homeautomation.formatting2" + NL + 
            "Import-Package: org.apache.log4j" + NL + 
            "Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
        // @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addRequiredBundles("org.eclipse.xtext.common.types");
		assertEquals(content, write(manifest));
	}

	@Test
	public void readWrite_addRequiredBundles_realisticManifest_regression_multipleBundlesOnOneLine() throws Exception {
		// @formatter:off
        String content =
            "Manifest-Version: 1.0" + NL + 
            "Bundle-ManifestVersion: 2" + NL + 
            "Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
            "Bundle-Vendor: Eclipse Xtext" + NL + 
            "Bundle-Version: 2.16.0.qualifier" + NL + 
            "Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
            "Bundle-ActivationPolicy: lazy" + NL + 
            "Require-Bundle: org.eclipse.xtext,org.eclipse.xtext.xbase,org.eclipse.equinox.common;bundle-version=\"3.5.0\"" + NL + 
            "Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
            "Export-Package: org.eclipse.xtext.example.homeautomation.ruleEngine.util,org.eclipse.xtext.example.homeautomation.formatting2" + NL + 
            "Import-Package: org.apache.log4j" + NL + 
            "Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
        String expectedContent =
    		"Manifest-Version: 1.0" + NL + 
    		"Bundle-ManifestVersion: 2" + NL + 
    		"Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
    		"Bundle-Vendor: Eclipse Xtext" + NL + 
    		"Bundle-Version: 2.16.0.qualifier" + NL + 
    		"Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
    		"Bundle-ActivationPolicy: lazy" + NL + 
    		"Require-Bundle: org.eclipse.xtext,org.eclipse.xtext.xbase,org.eclipse.equinox.common;bundle-version=\"3.5.0\"," + NL + 
    		" org.eclipse.xtext.common.types" + NL +
    		"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
    		"Export-Package: org.eclipse.xtext.example.homeautomation.ruleEngine.util,org.eclipse.xtext.example.homeautomation.formatting2" + NL + 
    		"Import-Package: org.apache.log4j" + NL + 
    		"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
        // @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addRequiredBundles("org.eclipse.xtext.common.types");
		assertEquals(expectedContent, write(manifest));
	}

	@Test
	public void readWrite_realisticManifest_regression_xtend() throws Exception {
		// @formatter:off
		String content =
				"Manifest-Version: 1.0" + NL + 
				"Bundle-ManifestVersion: 2" + NL + 
				"Bundle-Name: %pluginName" + NL + 
				"Bundle-SymbolicName: org.eclipse.xtend.core;singleton:=true" + NL + 
				"Bundle-Version: 2.17.0.qualifier" + NL + 
				"Bundle-ClassPath: ." + NL + 
				"Bundle-Vendor: %providerName" + NL + 
				"Bundle-Localization: plugin" + NL + 
				"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
				"Export-Package: org.eclipse.xtend.core;x-friends:=\"org.eclipse.xtend.ide.common," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler;x-friends:=\"org.eclipse.xtend.m2e," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler.batch," + NL + 
				" org.eclipse.xtend.core.conversion;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.common\"," + NL + 
				" org.eclipse.xtend.core.documentation;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.findReferences;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.formatting2;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.imports;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.javaconverter;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.jvmmodel;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.tests," + NL + 
				"   org.eclipse.xtend.ide.common\"" + NL + 
				"Require-Bundle: org.eclipse.core.runtime;bundle-version=\"3.13.0\"," + NL + 
				" org.eclipse.emf.ecore;bundle-version=\"2.10.2\";visibility:=reexport" + NL + 
				"Bundle-ActivationPolicy: lazy" + NL + 
				"Import-Package: org.apache.log4j;version=\"1.2.15\"" + NL;
		// @formatter:on
		assertEquals(content, write(newManifest(content)));
	}

	@Test
	public void readWrite_addExportedPackage_realisticManifest_regression_xtend() throws Exception {
		// @formatter:off
		String content =
				"Manifest-Version: 1.0" + NL + 
				"Bundle-ManifestVersion: 2" + NL + 
				"Bundle-Name: %pluginName" + NL + 
				"Export-Package: org.eclipse.xtend.core;x-friends:=\"org.eclipse.xtend.ide.common," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler;x-friends:=\"org.eclipse.xtend.m2e," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler.batch," + NL + 
				" org.eclipse.xtend.core.conversion;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.common\"," + NL + 
				" org.eclipse.xtend.core.documentation;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.findReferences;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.formatting2;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.imports;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.javaconverter;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.jvmmodel;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.tests," + NL + 
				"   org.eclipse.xtend.ide.common\"" + NL + 
				"Require-Bundle: org.eclipse.core.runtime;bundle-version=\"3.13.0\"," + NL + 
				" org.eclipse.emf.ecore;bundle-version=\"2.10.2\";visibility:=reexport" + NL + 
				"Bundle-ActivationPolicy: lazy" + NL + 
				"Import-Package: org.apache.log4j;version=\"1.2.15\"" + NL;
		String expectedNewContent =
				"Manifest-Version: 1.0" + NL + 
				"Bundle-ManifestVersion: 2" + NL + 
				"Bundle-Name: %pluginName" + NL + 
				"Export-Package: org.eclipse.xtend.core;x-friends:=\"org.eclipse.xtend.ide.common," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler;x-friends:=\"org.eclipse.xtend.m2e," + NL + 
				"   org.eclipse.xtend.ide.tests\"," + NL + 
				" org.eclipse.xtend.core.compiler.batch," + NL + 
				" org.eclipse.xtend.core.conversion;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.common\"," + NL + 
				" org.eclipse.xtend.core.documentation;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.findReferences;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.formatting2;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.imports;x-internal:=true," + NL + 
				" org.eclipse.xtend.core.javaconverter;x-friends:=\"org.eclipse.xtend.ide,\"" + NL + 
				" org.eclipse.xtend.ide.common," + NL + 
				" org.eclipse.xtend.core.jvmmodel;x-friends:=\"org.eclipse.xtend.ide," + NL + 
				"   org.eclipse.xtend.ide.tests," + NL + 
				"   org.eclipse.xtend.ide.common\"," + NL + 
				" test" + NL + 
				"Require-Bundle: org.eclipse.core.runtime;bundle-version=\"3.13.0\"," + NL + 
				" org.eclipse.emf.ecore;bundle-version=\"2.10.2\";visibility:=reexport" + NL + 
				"Bundle-ActivationPolicy: lazy" + NL + 
				"Import-Package: org.apache.log4j;version=\"1.2.15\"" + NL;
		// @formatter:on
		MergeableManifest2 newManifest = newManifest(content);
		newManifest.addExportedPackages("test");
		assertEquals(expectedNewContent, write(newManifest));
	}

	@Test
	public void readWrite_emptyBundleEntriesAreFiltered() throws Exception {
		// @formatter:off
		String content =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
			"Bundle-Vendor: Eclipse Xtext" + NL + 
			"Bundle-Version: 2.16.0.qualifier" + NL + 
			"Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
			"Bundle-ActivationPolicy: lazy" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			"    ," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types," + NL + 
			" " + NL + 
			"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
			"Export-Package: ," + NL + 
			" org.eclipse.xtext.example.homeautomation.ruleEngine," + NL + 
			" \t," + NL + 
			" org.eclipse.xtext.example.homeautomation.ruleEngine.impl," + NL + 
			" " + NL + 
			"Import-Package: org.apache.log4j" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		String expected =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Bundle-Name: Xtext Homeautomation Example - Runtime" + NL + 
			"Bundle-Vendor: Eclipse Xtext" + NL + 
			"Bundle-Version: 2.16.0.qualifier" + NL + 
			"Bundle-SymbolicName: org.eclipse.xtext.example.homeautomation; singleton:=true" + NL + 
			"Bundle-ActivationPolicy: lazy" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types" + NL + 
			"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL + 
			"Export-Package: org.eclipse.xtext.example.homeautomation.ruleEngine," + NL + 
			" org.eclipse.xtext.example.homeautomation.ruleEngine.impl" + NL + 
			"Import-Package: org.apache.log4j" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		assertEquals(expected, write(manifest));
	}

	@Test
	public void readWrite_addRequiredBundle_emptyInOriginal_filteredEvenWhenAddingEmpty() throws Exception {
		// @formatter:off
		String content =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			"    ," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types," + NL + 
			" " + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		String expected =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addRequiredBundles("");

		assertEquals(expected, write(manifest));
	}

	@Test
	public void readWrite_addRequiredBundle_newVersion() throws Exception {
		// @formatter:off
		String content =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types," + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		String expected =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util;bundle-version=\"1.0\"," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addRequiredBundles("org.eclipse.xtext.util;bundle-version=\"1.0\"");

		assertEquals(expected, write(manifest));
	}

	@Test
	public void readWrite_addRequiredBundle_newVersion_firstEntry() throws Exception {
		// @formatter:off
		String content =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types," + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		String expected =
			"Manifest-Version: 1.0" + NL + 
			"Bundle-ManifestVersion: 2" + NL + 
			"Require-Bundle: org.eclipse.xtext;bundle-version=\"1.0\"," + NL + 
			" org.eclipse.xtext.xbase," + NL + 
			" org.eclipse.xtext.util," + NL + 
			" org.antlr.runtime;bundle-version=\"[3.2.0,3.2.1)\"," + NL + 
			" org.eclipse.xtext.common.types" + NL + 
			"Automatic-Module-Name: org.eclipse.xtext.example.homeautomation" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addRequiredBundles("org.eclipse.xtext;bundle-version=\"1.0\"");

		assertEquals(expected, write(manifest));
	}

	@Test
	public void readWrite_BundleManifestVersion() throws Exception {
		// @formatter:off
		String content =
			"Bundle-ManifestVersion: 2" + NL + 
			"Bundle-Name: org.mealy.ui" + NL + 
			"Bundle-Vendor: My Company" + NL + 
			"Bundle-Version: 1.0.0.qualifier" + NL + 
			"Bundle-SymbolicName: org.mealy.ui; singleton:=true" + NL + 
			"Bundle-ActivationPolicy: lazy" + NL + 
			"Require-Bundle: org.mealy,org.mealy.ide,org.eclipse.xtext.ui,org.eclipse" + NL + 
			" .xtext.ui.shared,org.eclipse.xtext.ui.codetemplates.ui,org.eclipse.ui.e" + NL + 
			" ditors;bundle-version=\"3.5.0\",org.eclipse.ui.ide;bundle-version=\"3.5.0\"" + NL + 
			" ,org.eclipse.ui,org.eclipse.compare,org.eclipse.xtext.builder,org.eclip" + NL + 
			" se.xtext.xbase.lib;bundle-version=\"2.14.0\",org.eclipse.xtend.lib;bundle" + NL + 
			" -version=\"2.14.0\";resolution:=optional,org.eclipse.ui.console;bundle-ve" + NL + 
			" rsion=\"3.8.100\"" + NL + 
			"Import-Package: org.apache.log4j" + NL + 
			"Bundle-RequiredExecutionEnvironment: JavaSE-11" + NL + 
			"Automatic-Module-Name: org.mealy.ui" + NL + 
			"Export-Package: org.mealy.ui.internal,org.mealy.ui.quickfix,org.mealy.ui" + NL + 
			" .contentassist" + NL + 
			"Bundle-Activator: org.mealy.ui.internal.MealyActivator" + NL + 
			"Bundle-ClassPath: lib/mealyMachine-1.0-SNAPSHOT.jar," + NL + 
			" ." + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);

		assertEquals(content, write(manifest));
	}

	@Test
	public void replicate_issue_1120_linebreaks_inside_bundle_version_or_name() throws Exception {
		// @formatter:off
		String content =
				"Manifest-Version: 1.0" + NL +
				"Automatic-Module-Name: org.hello.ui" + NL +
				"Bundle-ManifestVersion: 2" + NL +
				"Bundle-Name: org.hello.ui" + NL +
				"Bundle-Vendor: My Company" + NL +
				"Bundle-Version: 1.0.0.qualifier" + NL +
				"Bundle-SymbolicName: org.hello.ui; singleton:=true" + NL +
				"Bundle-ActivationPolicy: lazy" + NL +
				"Require-Bundle: org.hello,org.hello.ide,org.eclipse.xtext.ui,org.eclipse" + NL +
				" .xtext.ui.shared,org.eclipse.xtext.ui.codetemplates.ui,org.eclipse.ui.e" + NL +
				" ditors;bundle-version=\"3.5.0\",org.eclipse.ui.ide;bundle-version=\"3.5.0\"" + NL +
				" ,org.eclipse.ui,org.eclipse.compare,org.eclipse.xtext.builder,org.eclip" + NL +
				" se.xtext.xbase.lib;bundle-version=\"2.14.0\",org.eclipse.xtend.lib;bundle" + NL +
				" -version=\"2.14.0\";resolution:=optional,org.eclipse.ui.console;bundle-ve" + NL +
				" rsion=\"3.8.100\"" + NL +
				"Import-Package: org.apache.log4j" + NL +
				"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL +
				"Export-Package: org.hello.ui.internal,org.hello.ui.contentassist,org.hel" + NL +
				" lo.ui.quickfix" + NL +
				"Bundle-Activator: org.hello.ui.internal.HelloActivator"+ NL;
		String expected =
				"Manifest-Version: 1.0" + NL +
				"Automatic-Module-Name: org.hello.ui" + NL +
				"Bundle-ManifestVersion: 2" + NL +
				"Bundle-Name: org.hello.ui" + NL +
				"Bundle-Vendor: My Company" + NL +
				"Bundle-Version: 1.0.0.qualifier" + NL +
				"Bundle-SymbolicName: org.hello.ui; singleton:=true" + NL +
				"Bundle-ActivationPolicy: lazy" + NL +
				"Require-Bundle: org.hello,org.hello.ide,org.eclipse.xtext.ui,org.eclipse" + NL +
				" .xtext.ui.shared,org.eclipse.xtext.ui.codetemplates.ui,org.eclipse.ui.e" + NL +
				" ditors;bundle-version=\"3.5.0\",org.eclipse.ui.ide;bundle-version=\"3.5.0\"" + NL +
				" ,org.eclipse.ui,org.eclipse.compare,org.eclipse.xtext.builder,org.eclip" + NL +
				" se.xtext.xbase.lib;bundle-version=\"2.14.0\",org.eclipse.xtend.lib;bundle" + NL +
				" -version=\"2.14.0\";resolution:=optional,org.eclipse.ui.console;bundle-ve" + NL +
				" rsion=\"3.8.100\"" + NL +
				"Import-Package: org.apache.log4j" + NL +
				"Bundle-RequiredExecutionEnvironment: JavaSE-1.8" + NL +
				"Export-Package: org.hello.ui.internal,org.hello.ui.contentassist,org.hel" + NL +
				" lo.ui.quickfix" + NL +
				"Bundle-Activator: org.hello.ui.internal.HelloActivator" + NL;
		// @formatter:on
		MergeableManifest2 manifest = newManifest(content);
		manifest.addExportedPackages(manifest.getMainAttributes().get(MergeableManifest2.EXPORT_PACKAGE).replaceAll("\r\n ", "").split(","));
		manifest.addImportedPackages(manifest.getMainAttributes().get(MergeableManifest2.IMPORT_PACKAGE).replaceAll("\r\n ", "").split(","));
		manifest.addRequiredBundles(manifest.getMainAttributes().get(MergeableManifest2.REQUIRE_BUNDLE).replaceAll("\r\n ", "").split(","));
		manifest.addRequiredBundles("org.eclipse.ui.editors", "org.eclipse.xtext.xbase.lib;bundle-version=\"2.14.0\"",
				"org.eclipse.xtext.ui.shared");

		assertEquals(expected, write(manifest));
	}

	/**
	 * In this final test we read all "META-INF/MANIFEST.MF" files from
	 * classpath. We the:
	 * <ol>
	 * <li>Read each file once as "manifest0"</li>
	 * <li>Write it as string once and read the result again as "manifest1"</li>
	 * <li>Compare "manifest0" and "manifest1"</li>
	 * <li>Execute some sanity checks to ensure we do not compare empty files or
	 * similar</li>
	 * </ol>
	 * This way we ensure we can read and write all manifest files.
	 */
	@Test
	public void readWrite_allManifestsFromClasspath() throws Exception {
		for (String content : readAllManifestsFromClasspath()) {
			MergeableManifest2 manifest0 = newManifest(content);
			MergeableManifest2 manifest1 = newManifest(write(manifest0));
			assertEquals(manifest0, manifest1);
			// start of sanity checks
			assertTrue(content.length() > 0);
			assertNotNull(manifest0.getMainAttributes().get(MergeableManifest2.MANIFEST_VERSION));
		}
	}

	private List<String> readAllManifestsFromClasspath() throws IOException {
		List<String> result = new ArrayList<>();
		Enumeration<URL> resources = MergeableManifest2Test.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
		while (resources.hasMoreElements()) {
			try (InputStreamReader reader = new InputStreamReader(resources.nextElement().openStream(), "UTF-8")) {
				String content = CharStreams.toString(reader);
				result.add(content);
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
		assertTrue("Expect to find at least one MANIFEST", result.size() > 0);
		return result;
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
