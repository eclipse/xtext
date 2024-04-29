/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
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
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.util.JavaVersion;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
public class IncrementalStandaloneBuilderWithJava21Test {

	private static final File ORIGINAL_PROJECT_DIR = new File("test-data/standalone.incremental.java21");
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
		testBuilder.getCompiler().getConfiguration().setSourceLevel(JavaVersion.JAVA21.getQualifier());
		testBuilder.getCompiler().getConfiguration().setTargetLevel(JavaVersion.JAVA21.getQualifier());
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
	public void testCleanBuildAccessingJava21Record() {
		Assume.assumeTrue("Active only on Java 21 and later", JavaRuntimeVersion.isJava21OrLater());
		initBuilder(new ContentAssistFragmentTestLangConfiguration());
		assertTrue(testBuilder.launch());
		
		assertEquals(1, testBuilder.getGenerateCalled());
		assertEquals(2, testBuilder.getGenerateResources());

		File javaFile = getFile("src-gen/my/test/First.java");
		assertTrue(javaFile.exists());
		javaFile = getFile("src-gen/my/test/Second.java");
		assertTrue(javaFile.exists());
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
		List<String> pathes = new ArrayList<String>();
		for (String srcDir : srcDirs) {
			pathes.add(new File(PROJECT_DIR, srcDir).getAbsolutePath());
		}
		testBuilder.setSourceDirs(pathes);
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
