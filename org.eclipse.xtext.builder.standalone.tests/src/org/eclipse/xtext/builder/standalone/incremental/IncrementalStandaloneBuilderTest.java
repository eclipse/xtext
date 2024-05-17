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
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Files.write;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class IncrementalStandaloneBuilderTest extends AbstractIncrementalStandaloneBuilderTest {

	private static final File ORIGINAL_PROJECT_DIR = new File("test-data/standalone.incremental");

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
		byte[] bytes = readAllBytes(out.toPath());
		write(out.toPath(), Arrays.asList(""), ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(1, testBuilder.getGenerateResources());
		assertTrue(out.exists());
		Assert.assertArrayEquals(bytes, readAllBytes(out.toPath()));
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
		List<String> outputContent = readLines(firstOut, ISO_8859_1);

		java.nio.file.Files.write(firstModel.toPath(), Arrays.asList("object NewObject"), ISO_8859_1,
				TRUNCATE_EXISTING);

		List<String> secondContent = readLines(secondModel, ISO_8859_1);
		secondContent.replaceAll(s -> {
			if (s.contains("object SecondObjectB references Namespace.SecondObjectA")) {
				return s.replace("SecondObjectB", "FirstObject");
			}
			return s;
		});
		write(secondModel.toPath(), secondContent, ISO_8859_1, TRUNCATE_EXISTING);

		assertTrue(testBuilder.launch());
		assertEquals(2, testBuilder.getGenerateResources());

		assertTrue(firstOut.exists());
		List<String> newOutputContent = readLines(firstOut, ISO_8859_1);
		assertFalse(outputContent.equals(newOutputContent));
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
