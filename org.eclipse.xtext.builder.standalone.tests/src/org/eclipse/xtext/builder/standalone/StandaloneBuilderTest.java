/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
public class StandaloneBuilderTest {

	private static final File PROJECT_DIR = new File("test-data/standalone");
	private static final File TMP_DIR = new File(PROJECT_DIR, "tmp");

	@Inject
	private TestableStandaloneBuilder testBuilder;

	@Before
	public void setUp() {
		testBuilder.resetCallStatistic();
		testBuilder.resetTestSetup();
	}

	@After
	public void cleanup() throws IOException {
		deleteFolder("src-gen");
		deleteFolder("src2-gen");
		if (TMP_DIR.exists()) {
			Files.sweepFolder(TMP_DIR);
			TMP_DIR.delete();
		}
	}

	@Test
	public void testDifferentOutputFolders() {
		initBuilder(new TestLanguageConfiguration(true));
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		generatedFile = getFile("src2-gen/Bar.txt");
		assertTrue(generatedFile.exists());

		File unexpectedFile = getFile("src-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Foo.txt");
		assertFalse(unexpectedFile.exists());
	}

	@Test
	public void testWriteStorageResource() {
		initBuilder(new TestLanguageConfiguration(true));
		testBuilder.setWriteStorageResources(true);
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/.Foo.buildertestlanguagebin");
		assertTrue(generatedFile.exists());
	}

	@Test
	public void testNoWriteStorageResource() {
		initBuilder(new TestLanguageConfiguration(true));
		testBuilder.setWriteStorageResources(false);
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/.Foo.buildertestlanguagebin");
		assertFalse(generatedFile.exists());
	}

	@Test
	public void testSameOutputFolder() {
		initBuilder(new TestLanguageConfiguration(false));
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		generatedFile = getFile("src-gen/Bar.txt");
		assertTrue(generatedFile.exists());

		File unexpectedFile = getFile("src2-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Foo.txt");
		assertFalse(unexpectedFile.exists());
	}

	@Test
	public void testOnlyOneSourceFolder() {
		initBuilder(new TestLanguageConfiguration(false));
		testBuilder.setSourceDirs(ImmutableList.of(new File(PROJECT_DIR, "src").getAbsolutePath()));
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/Foo.txt");
		assertTrue(generatedFile.exists());

		File unexpectedFile = getFile("src-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Foo.txt");
		assertFalse(unexpectedFile.exists());
	}

	@Test
	public void testRelativeSourceFolder() {
		initBuilder(new TestLanguageConfiguration(false));
		testBuilder.setSourceDirs(ImmutableList.of("test-data/standalone/src"));
		assertTrue(testBuilder.launch());

		File generatedFile = getFile("src-gen/Foo.txt");
		assertTrue(generatedFile.exists());

		File unexpectedFile = getFile("src-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Bar.txt");
		assertFalse(unexpectedFile.exists());
		unexpectedFile = getFile("src2-gen/Foo.txt");
		assertFalse(unexpectedFile.exists());
	}

	@Test
	public void testJarToPlatformMapping() {
		initBuilder(new TestLanguageConfiguration(false));
		testBuilder.setSourceDirs(ImmutableList.of("test-data/standalone.with.reference/model"));
		testBuilder.setClassPathEntries(ImmutableList.of("test-data/standalone.with.reference/target/classes/",
				"test-data/model.in.eclipse.project.jar"));

		assertTrue("Builder launch returned false", testBuilder.launch());
		URI uri = EcorePlugin.getPlatformResourceMap().get("model.in.eclipse.project");
		assertNotNull("No platform mapping found for 'model.in.eclipse.project'", uri);
		assertTrue("Platform mapping is archive", uri.toString().startsWith("archive:file:/"));
		assertTrue("Platform mapping points to jared project",
				uri.toString().endsWith("test-data/model.in.eclipse.project.jar!/"));
	}

	@Test
	public void testDuplicateSourceEntries() {
		TestLanguageConfiguration config = new TestLanguageConfiguration(false);
		config.setJavaSupport(true);
		initBuilder(config);
		testBuilder.setJavaSourceDirs(ImmutableList.of(new File(PROJECT_DIR, "src2").getPath()));
		testBuilder.setTempDir(TMP_DIR);
		testBuilder.setDebugLog(true);
		assertTrue("Builder launch returned false", testBuilder.launch());
		File compiledClazz = getFile("tmp/classes/JavaClass.class");
		assertTrue("java compilation failed", compiledClazz.exists());

	}

	@Test
	public void testValidateMultipleResources() {
		TestLanguageConfiguration config = new TestLanguageConfiguration(false);
		initBuilder(config, "src", "src-error");
		testBuilder.setTempDir(TMP_DIR);
		testBuilder.setDebugLog(true);
		testBuilder.setMockGeneration(true);
		
		assertFalse("Build should return false, but returned -success-", testBuilder.launch());
		assertEquals("Build should fail early, but validate all resources", 2, testBuilder.getValidateCalled());
		assertEquals("Build should fail early", 0, testBuilder.getGenerateCalled());

		// revert resource process order - https://bugs.eclipse.org/bugs/show_bug.cgi?id=464663
		initBuilder(config, "src-error", "src");
		
		assertFalse("Build should fail, but returned -success-", testBuilder.launch());
		assertEquals("Build should fail early, but validation was executed", 2, testBuilder.getValidateCalled());
		assertEquals("Build should fail early", 0, testBuilder.getGenerateCalled());

		// allow errors, generator should run in spite validation errors, but launch should return "validation error was found"
		initBuilder(config, "src-error", "src");
		testBuilder.setFailOnValidationError(false);
		assertFalse("Build should fail, but returned -success-", testBuilder.launch());

		assertEquals("Validation was executed", 2, testBuilder.getValidateCalled());
		assertEquals("Generator was executed in spite of validation errors", 1, testBuilder.getGenerateCalled());

	}

	private File getFile(String projectRelativePath) {
		return new File(PROJECT_DIR, projectRelativePath);
	}

	private void deleteFolder(String projectRelativePath) throws FileNotFoundException {
		File folder = getFile(projectRelativePath);
		if (folder.exists()) {
			Files.sweepFolder(folder);
			folder.delete();
		}
	}

	private StandaloneBuilder initBuilder(ILanguageConfiguration config) {
		return initBuilder(config, "src", "src2");
	}

	/**
	 * @param srcDirs
	 *            source dirs from {@value #PROJECT_DIR}
	 */
	private StandaloneBuilder initBuilder(ILanguageConfiguration config, String... srcDirs) {
		List<String> patthes = new ArrayList<String>();
		for (String srcDir : srcDirs) {
			patthes.add(new File(PROJECT_DIR, srcDir).getAbsolutePath());
		}
		testBuilder.setSourceDirs(patthes);
		testBuilder.resetCallStatistic();
		Map<String, LanguageAccess> languages = new LanguageAccessFactory().createLanguageAccess(
				ImmutableList.of(config), getClass().getClassLoader());
		testBuilder.setBaseDir(PROJECT_DIR.getAbsolutePath());
		testBuilder.setLanguages(languages);
		testBuilder.setClassPathEntries(ImmutableList.<String> of());
		return testBuilder;
	}

	public static class TestLanguageConfiguration implements ILanguageConfiguration {

		private boolean useOutputPerSource;
		private boolean javaSupport = false;

		public TestLanguageConfiguration(boolean useOutputPerSource) {
			this.useOutputPerSource = useOutputPerSource;
		}

		/* @NonNull */
		@Override
		public String getSetup() {
			return "org.eclipse.xtext.builder.tests.BuilderTestLanguageStandaloneSetup";
		}

		@Override
		public Set<OutputConfiguration> getOutputConfigurations() {
			OutputConfiguration config = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
			config.setOutputDirectory("src-gen");
			if (useOutputPerSource) {
				SourceMapping sourceMapping = new OutputConfiguration.SourceMapping("src2");
				sourceMapping.setOutputDirectory("src2-gen");
				config.getSourceMappings().add(sourceMapping);
				config.setUseOutputPerSourceFolder(true);
			}
			return ImmutableSet.of(config);
		}

		public void setJavaSupport(boolean javaSupport) {
			this.javaSupport = javaSupport;
		}

		@Override
		public boolean isJavaSupport() {
			return javaSupport;
		}
	}
}
