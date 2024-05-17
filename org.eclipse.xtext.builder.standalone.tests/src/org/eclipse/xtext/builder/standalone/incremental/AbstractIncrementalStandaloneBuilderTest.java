/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider;
import org.eclipse.xtext.builder.standalone.TestableStandaloneBuilder;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Files;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
public abstract class AbstractIncrementalStandaloneBuilderTest {

	protected static final File PROJECT_DIR = new File("projectUnderTest").getAbsoluteFile();

	@Inject
	protected TestableStandaloneBuilder testBuilder;

	protected static void copy(Path from, Path to) {
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

	protected File getFile(String projectRelativePath) {
		return new File(PROJECT_DIR, projectRelativePath);
	}

	protected StandaloneBuilder initBuilder(ILanguageConfiguration... configs) {
		return initBuilder(configs, "src");
	}

	protected StandaloneBuilder initBuilder(ILanguageConfiguration[] configs, String... srcDirs) {
		List<String> paths = new ArrayList<String>();
		for (String srcDir : srcDirs) {
			paths.add(new File(PROJECT_DIR, srcDir).getAbsolutePath());
		}
		testBuilder.setSourceDirs(paths);
		testBuilder.resetCallStatistic();
		Map<String, LanguageAccess> languages = new LanguageAccessFactory()
				.createLanguageAccess(List.of(configs), getClass().getClassLoader());
		testBuilder.setBaseDir(PROJECT_DIR.getAbsolutePath());
		testBuilder.setLanguages(languages);
		testBuilder.setClassPathEntries(Collections.emptyList());
		return testBuilder;
	}

	@After
	public void cleanup() throws IOException {
		deleteFolder(PROJECT_DIR);
	}

	@BeforeClass
	public static void removeOldProjectDir() throws FileNotFoundException {
		deleteFolder(PROJECT_DIR);
	}

	protected static void deleteFolder(File folder) throws FileNotFoundException {
		if (folder.exists()) {
			Files.sweepFolder(folder);
			folder.delete();
		}
	}

}
