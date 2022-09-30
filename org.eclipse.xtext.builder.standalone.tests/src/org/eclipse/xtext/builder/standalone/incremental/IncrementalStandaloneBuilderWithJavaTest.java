/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider;
import org.eclipse.xtext.builder.standalone.TestableStandaloneBuilder;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Files;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
public class IncrementalStandaloneBuilderWithJavaTest {

	private static final File ORIGINAL_PROJECT_DIR = new File("test-data/standalone.incremental.java");
	private static final File PROJECT_DIR = new File("projectUnderTest").getAbsoluteFile();

	@Inject
	private TestableStandaloneBuilder testBuilder;

	@BeforeClass
	public static void removeOldProjectDir() throws FileNotFoundException {
		deleteFolder(PROJECT_DIR);
	}
	
	@Before
	public void setUp() {
		copy(ORIGINAL_PROJECT_DIR.toPath(), PROJECT_DIR.toPath());
		testBuilder.resetCallStatistic();
		testBuilder.resetTestSetup();
		testBuilder.setFailOnValidationError(false);
		testBuilder.setIncrementalBuild(true);
		testBuilder.setTempDir(new File(PROJECT_DIR, "tmp"));
	}

	private static void copy(Path from, Path to) {
		try {
			java.nio.file.Files.walk(from).forEach(src -> {
				try {
					java.nio.file.Files.copy(src, to.resolve(from.relativize(src)));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@After
	public void cleanup() throws IOException {
		deleteFolder(PROJECT_DIR);
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
		byte[] bytes = java.nio.file.Files.readAllBytes(javaFile.toPath());
		java.nio.file.Files.write(javaFile.toPath(), Arrays.asList(""), ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(javaFile.exists());
		Assert.assertArrayEquals(bytes, java.nio.file.Files.readAllBytes(javaFile.toPath()));
	}
	
	@Test
	public void testRelaunchAfterTinkeringWithTraceFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());
		
		File traceFile = getFile("src-gen/my/test/.First.java._trace");
		assertTrue(traceFile.exists());
		byte[] bytes = java.nio.file.Files.readAllBytes(traceFile.toPath());
		java.nio.file.Files.write(traceFile.toPath(), new byte[0], TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(traceFile.exists());
		Assert.assertArrayEquals(bytes, java.nio.file.Files.readAllBytes(traceFile.toPath()));
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
		List<String> content = com.google.common.io.Files.readLines(javaFile, ISO_8859_1);
		content.removeIf(s->s.contains("class Carrot {}"));
		java.nio.file.Files.write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
	}
	
	@Test
	public void testRelaunchAfterChangeToIndirectlyReferencedJavaFile() throws IOException {
		File modelFile = getFile("src/com/acme/First.contentassistfragmenttestlang");
		java.nio.file.Files.write(modelFile.toPath(), Arrays.asList(
				"{",
				"  new com.acme.BugsBunny().singSomeSong()",
				"  return null",
				"}"), ISO_8859_1, TRUNCATE_EXISTING);
		
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());
		
		File javaFile = getFile("src/com/acme/LoonyToon.java");
		List<String> content = com.google.common.io.Files.readLines(javaFile, ISO_8859_1);
		content.replaceAll(s->{
			if (s.contains("singSomeSong")) {
				return s.replace("singSomeSong", "_singSomeSong");
			}
			return s;
		});
		java.nio.file.Files.write(javaFile.toPath(), content,ISO_8859_1,  TRUNCATE_EXISTING);

		assertFalse(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		
		content.replaceAll(s->{
			if (s.contains("_singSomeSong")) {
				return s.replace("_singSomeSong", "singSomeSong");
			}
			return s;
		});
		java.nio.file.Files.write(javaFile.toPath(), content,ISO_8859_1,  TRUNCATE_EXISTING);
		
		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
	}
	
	@Test
	public void testRelaunchAfterChangeToIndependentJavaFile() throws IOException {
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());
		
		File javaFile = getFile("src/com/acme/Tweety.java");
		List<String> content = com.google.common.io.Files.readLines(javaFile, ISO_8859_1);
		content.removeIf(s->s.contains("chirp"));
		java.nio.file.Files.write(javaFile.toPath(), content, ISO_8859_1, TRUNCATE_EXISTING);

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
		List<String> genContent = com.google.common.io.Files.readLines(genJavaFile, ISO_8859_1);
		assertFalse(genContent.stream().filter(s->s.contains("new Object()")).findFirst().isPresent());
		
		assertFalse(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		
		genContent = com.google.common.io.Files.readLines(genJavaFile, ISO_8859_1);
		assertTrue(genContent.stream().filter(s->s.contains("new Object()")).findFirst().isPresent());
		
		java.nio.file.Files.write(modelFile.toPath(), Arrays.asList("{}"),ISO_8859_1,  CREATE_NEW);
		assertTrue(testBuilder.launch());
		assertEquals(2, testBuilder.getGenerateResources());
		
		genContent = com.google.common.io.Files.readLines(genJavaFile, ISO_8859_1);
		assertFalse(genContent.stream().filter(s->s.contains("new Object()")).findFirst().isPresent());
	}

	private File getFile(String projectRelativePath) {
		return new File(PROJECT_DIR, projectRelativePath);
	}

	private static void deleteFolder(File folder) throws FileNotFoundException {
		if (folder.exists()) {
			Files.sweepFolder(folder);
			folder.delete();
		}
	}

	private StandaloneBuilder initBuilder(ILanguageConfiguration... configs) {
		return initBuilder(configs, "src");
	}

	private StandaloneBuilder initBuilder(ILanguageConfiguration[] configs, String... srcDirs) {
		List<String> patthes = new ArrayList<String>();
		for (String srcDir : srcDirs) {
			patthes.add(new File(PROJECT_DIR, srcDir).getAbsolutePath());
		}
		testBuilder.setSourceDirs(patthes);
		testBuilder.resetCallStatistic();
		Map<String, LanguageAccess> languages = new LanguageAccessFactory()
				.createLanguageAccess(ImmutableList.copyOf(configs), getClass().getClassLoader());
		testBuilder.setBaseDir(PROJECT_DIR.getAbsolutePath());
		testBuilder.setLanguages(languages);
		testBuilder.setClassPathEntries(ImmutableList.<String>of());
		return testBuilder;
	}

	public static class ContentAssistFragmentTestLangConfiguration implements ILanguageConfiguration {

		public ContentAssistFragmentTestLangConfiguration() {
		}

		@Override
		public String getSetup() {
			return "org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangStandaloneSetup";
		}

		@Override
		public Set<OutputConfiguration> getOutputConfigurations() {
			OutputConfiguration config = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
			config.setOutputDirectory("src-gen");
			return ImmutableSet.of(config);
		}

		@Override
		public boolean isJavaSupport() {
			return true;
		}
	}
}
