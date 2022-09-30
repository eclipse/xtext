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
public class IncrementalStandaloneBuilderTest {

	private static final File ORIGINAL_PROJECT_DIR = new File("test-data/standalone.incremental");
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
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		assertEquals(1, testBuilder.getGenerateCalled());
		assertEquals(2, testBuilder.getGenerateResources());

		File out = getFile("src-gen/FirstObject.txt");
		assertTrue(out.exists());
		out = getFile("src-gen/SecondObjectA.txt");
		assertTrue(out.exists());
		out = getFile("src-gen/SecondObjectB.txt");
		assertTrue(out.exists());
	}
	
	@Test
	public void testRelaunchWithoutChanges() {
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
	}

	@Test
	public void testRelaunchAfterDeleteOutputFile() {
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		File out = getFile("src-gen/SecondObjectA.txt");
		assertTrue(out.exists());
		out.delete();

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(out.exists());
	}
	
	@Test
	public void testRelaunchAfterTinkeringWithOutputFile() throws IOException {
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		File out = getFile("src-gen/SecondObjectB.txt");
		assertTrue(out.exists());
		byte[] bytes = java.nio.file.Files.readAllBytes(out.toPath());
		java.nio.file.Files.write(out.toPath(), Arrays.asList(""), ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(out.exists());
		Assert.assertArrayEquals(bytes, java.nio.file.Files.readAllBytes(out.toPath()));
	}
	
	@Test
	public void testRelaunchAfterDeleteModelFile() throws IOException {
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		File modelFile = getFile("src/Second.buildertestlanguage");
		assertTrue(modelFile.delete());

		assertTrue(testBuilder.launch());
		assertEquals(0, testBuilder.getGenerateResources());
		
		File out = getFile("src-gen/SecondObjectA.txt");
		assertFalse(out.exists());
		out = getFile("src-gen/SecondObjectB.txt");
		assertFalse(out.exists());
	}
	
	@Test
	public void testRelaunchAfterMoveModelElement() throws IOException {
		initBuilder(new TestLanguageConfiguration());
		assertTrue(testBuilder.launch());
		
		File firstModel = getFile("src/First.buildertestlanguage");
		File secondModel = getFile("src/Second.buildertestlanguage");
		
		File firstOut = getFile("src-gen/FirstObject.txt");
		List<String> outputContent = com.google.common.io.Files.readLines(firstOut, ISO_8859_1);
		
		java.nio.file.Files.write(firstModel.toPath(), Arrays.asList("object NewObject"), ISO_8859_1,  TRUNCATE_EXISTING);

		List<String> secondContent = com.google.common.io.Files.readLines(secondModel, ISO_8859_1);
		secondContent.replaceAll(s->{
			if (s.contains("object SecondObjectB references Namespace.SecondObjectA")) {
				return s.replace("SecondObjectB", "FirstObject");
			}
			return s;
		});
		java.nio.file.Files.write(secondModel.toPath(), secondContent, ISO_8859_1,  TRUNCATE_EXISTING);
		
		assertTrue(testBuilder.launch());
		assertEquals(2, testBuilder.getGenerateResources());
		
		assertTrue(firstOut.exists());
		List<String> newOutputContent = com.google.common.io.Files.readLines(firstOut, ISO_8859_1);
		assertFalse(outputContent.equals(newOutputContent));
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

	public static class TestLanguageConfiguration implements ILanguageConfiguration {

		/* @NonNull */
		@Override
		public String getSetup() {
			return "org.eclipse.xtext.builder.tests.BuilderTestLanguageStandaloneSetup";
		}

		@Override
		public Set<OutputConfiguration> getOutputConfigurations() {
			OutputConfiguration config = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
			config.setOutputDirectory("src-gen");
			return ImmutableSet.of(config);
		}

		@Override
		public boolean isJavaSupport() {
			return false;
		}
	}
}
