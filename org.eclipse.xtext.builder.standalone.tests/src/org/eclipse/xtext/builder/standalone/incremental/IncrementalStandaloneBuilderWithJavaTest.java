/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import static com.google.common.io.Files.readLines;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.file.Files.createDirectories;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Files.write;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IncrementalStandaloneBuilderWithJavaTest extends AbstractIncrementalStandaloneBuilderTest {

	private static final File ORIGINAL_PROJECT_DIR = new File("test-data/standalone.incremental.java");

	@Before
	public void setUp() {
		copy(ORIGINAL_PROJECT_DIR.toPath(), PROJECT_DIR.toPath());
		testBuilder.resetCallStatistic();
		testBuilder.resetTestSetup();
		testBuilder.setFailOnValidationError(false);
		testBuilder.setIncrementalBuild(true);
		testBuilder.setTempDir(new File(PROJECT_DIR, "tmp"));
	}

	@Test
	public void testSingleLanguageCleanBuild() {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		assertEquals(1, testBuilder.getGenerateCalled());
		assertEquals(2, testBuilder.getGenerateResources());

		File javaFile = getFile("src-gen/my/test/First.java");
		assertTrue(javaFile.exists());
		javaFile = getFile("src-gen/my/test/Second.java");
		assertTrue(javaFile.exists());
	}

	@Test
	public void testRelaunchWithoutChanges() {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
	}

	@Test
	public void testRelaunchAfterDeleteOutputFile() {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File javaFile = getFile("src-gen/my/test/First.java");
		assertTrue(javaFile.exists());
		javaFile.delete();

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(javaFile.exists());
	}

	@Test
	public void testRelaunchAfterDeleteTraceFile() {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File traceFile = getFile("src-gen/my/test/.First.java._trace");
		assertTrue(traceFile.exists());
		traceFile.delete();

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(traceFile.exists());
	}

	@Test
	public void testRelaunchAfterTinkeringWithOutputFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File javaFile = getFile("src-gen/my/test/First.java");
		assertTrue(javaFile.exists());
		byte[] bytes = readAllBytes(javaFile.toPath());
		write(javaFile.toPath(), Arrays.asList(""), ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(javaFile.exists());
		Assert.assertArrayEquals(bytes, readAllBytes(javaFile.toPath()));
	}

	@Test
	public void testRelaunchAfterTinkeringWithTraceFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File traceFile = getFile("src-gen/my/test/.First.java._trace");
		assertTrue(traceFile.exists());
		byte[] bytes = readAllBytes(traceFile.toPath());
		write(traceFile.toPath(), new byte[0], TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(traceFile.exists());
		Assert.assertArrayEquals(bytes, readAllBytes(traceFile.toPath()));
	}

	@Test
	public void testRelaunchAfterDeleteStubFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File stubJavafile = getFile("tmp/stubs/my/test/Second.java");
		assertTrue(stubJavafile.exists());
		stubJavafile.delete();

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(stubJavafile.exists());
	}

	@Test
	public void testRelaunchAfterDeleteStubClassFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File stubClassFile = getFile("tmp/stub-classes/my/test/Second.class");
		assertTrue(stubClassFile.exists());
		stubClassFile.delete();

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
		assertTrue(stubClassFile.exists());

		stubClassFile = getFile("tmp/stub-classes/com/acme/BugsBunny.class");
		assertTrue(stubClassFile.exists());
		stubClassFile.delete();

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
		assertTrue(stubClassFile.exists());
	}

	@Test
	public void testRelaunchAfterChangeToReferencedJavaFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File javaFile = getFile("src/com/acme/BugsBunny.java");
		List<String> content = readLines(javaFile, ISO_8859_1);
		content.removeIf(s -> s.contains("class Carrot {}"));
		write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
	}

	@Test
	public void testRelaunchAfterChangeToIndirectlyReferencedJavaFile() throws IOException {
		File modelFile = getFile("src/com/acme/First.contentassistfragmenttestlang");
		write(modelFile.toPath(), Arrays.asList(
				"{",
				"  new com.acme.BugsBunny().singSomeSong()",
				"  return null",
				"}"),
				ISO_8859_1, TRUNCATE_EXISTING);

		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File javaFile = getFile("src/com/acme/LoonyToon.java");
		List<String> content = readLines(javaFile, ISO_8859_1);
		content.replaceAll(s -> {
			if (s.contains("singSomeSong")) {
				return s.replace("singSomeSong", "_singSomeSong");
			}
			return s;
		});
		write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

		assertFalse(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());

		content.replaceAll(s -> {
			if (s.contains("_singSomeSong")) {
				return s.replace("_singSomeSong", "singSomeSong");
			}
			return s;
		});
		write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
	}

	@Test
	public void testRelaunchAfterChangeToIndependentJavaFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File javaFile = getFile("src/com/acme/Tweety.java");
		List<String> content = readLines(javaFile, ISO_8859_1);
		content.removeIf(s -> s.contains("chirp"));
		write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
	}

	@Test
	public void testRelaunchAfterDeleteModelFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File modelFile = getFile("src/com/acme/Second.contentassistfragmenttestlang");
		assertTrue(modelFile.delete());

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());

		File stubClassFile = getFile("tmp/stub-classes/my/test/Second.class");
		assertFalse(stubClassFile.exists());
		File genJavaFile = getFile("src-gen/my/test/Second.java");
		assertFalse(genJavaFile.exists());
	}

	@Test
	public void testRelaunchAfterDeleteReferencedModelFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());

		File modelFile = getFile("src/com/acme/First.contentassistfragmenttestlang");
		assertTrue(modelFile.delete());

		File genJavaFile = getFile("src-gen/my/test/Second.java");
		List<String> genContent = readLines(genJavaFile, ISO_8859_1);
		assertFalse(genContent.stream().filter(s -> s.contains("new Object()")).findFirst().isPresent());

		assertFalse(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());

		genContent = readLines(genJavaFile, ISO_8859_1);
		assertTrue(genContent.stream().filter(s -> s.contains("new Object()")).findFirst().isPresent());

		write(modelFile.toPath(), Arrays.asList("{}"), ISO_8859_1, CREATE_NEW);
		assertTrue(testBuilder.launch());
		assertEquals(2, testBuilder.getGenerateResources());

		genContent = readLines(genJavaFile, ISO_8859_1);
		assertFalse(genContent.stream().filter(s -> s.contains("new Object()")).findFirst().isPresent());
	}

	@Test
	public void testPathInTraceFile() throws IOException {
		initBuilder(new ILanguageConfiguration[] { new ContentAssistFragmentTestLangConfiguration() },
				"src", "src2");

		File modelFile = getFile("src2/foo/bar/Another.contentassistfragmenttestlang");
		createDirectories(modelFile.getParentFile().toPath());
		write(modelFile.toPath(), Arrays.asList(
				"{",
				"  new com.acme.BugsBunny().singSomeSong()",
				"  return null",
				"}"), ISO_8859_1, CREATE_NEW);

		assertTrue(testBuilder.launch());

		assertEquals("com/acme/First.contentassistfragmenttestlang",
				loadTraceSourcePath(PROJECT_DIR + "/src-gen/my/test/.First.java._trace"));
		assertEquals("foo/bar/Another.contentassistfragmenttestlang",
				loadTraceSourcePath(PROJECT_DIR + "/src-gen/my/test/.Another.java._trace"));
	}

	private String loadTraceSourcePath(String file) throws IOException {
		try (FileInputStream in = new FileInputStream(file)) {
			AbstractTraceRegion region = new TraceRegionSerializer().readTraceRegionFrom(in);
			return region.getAssociatedSrcRelativePath().toString();
		}
	}

}
