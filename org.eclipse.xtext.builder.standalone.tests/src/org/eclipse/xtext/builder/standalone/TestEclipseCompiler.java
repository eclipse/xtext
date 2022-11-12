/*******************************************************************************
 * Copyright (c) 2016, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.util.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestEclipseCompiler {
	private final class ClassFileFilter implements Predicate<URI> {
		@Override
		public boolean apply(URI input) {
			return input != null && "class".equals(input.fileExtension());
		}
	}

	static final String SRC_TEST_RESOURCES = "test-data/ec-test";
	static final String DOES_NOT_EXISTS = "src/test/resources/test";
	IJavaCompiler compiler;
	File outputClassDirectory;
	static Injector injector;

	@BeforeClass
	public static void setUpOnce() {
		injector = Guice.createInjector(new StandaloneBuilderModule());
	}

	@Before
	public void setUp() throws IOException {
		compiler = newCompiler();
		outputClassDirectory = new File("target/temp");
	}
	
	protected IJavaCompiler newCompiler() {
		IJavaCompiler result = injector.getInstance(IJavaCompiler.class);
		result.getConfiguration().setVerbose(true);
		result.getConfiguration().setSourceLevel("8");
		result.getConfiguration().setTargetLevel("8");
		return result;
	}

	@After
	public void tearDown() throws IOException {
		tearDown(outputClassDirectory);
	}

	void tearDown(File directory) throws IOException {
		if (directory != null && directory.exists()) {
			assertTrue("Unable to delete test directory: " + directory.getAbsolutePath(), Files.sweepFolder(directory));
		}
	}
	
	@Test
	public void testEmptySrcDirs() {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(DOES_NOT_EXISTS);
		assertEquals(CompilationResult.SKIPPED, compiler.compile(sourceRoots, outputClassDirectory));
	}

	@Test
	public void testNonEmptySrcDirs() {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class");
		sourceRoots.add(DOES_NOT_EXISTS);
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, new File("target/temp")));
		Collection<URI> resolvePathes = collectOutputFiles();
		assertEquals("Should have found 4 class files, but was: " + resolvePathes, 4, resolvePathes.size());
	}

	@Test
	public void testNoJavaSrcDirs() {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-nojava");
		assertEquals(CompilationResult.SKIPPED, compiler.compile(sourceRoots, new File("target/temp")));
	}

	@Test
	public void testMultiSrcDirs() {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class");
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class2");
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, new File("target/temp")));
		Collection<URI> resolvePathes = collectOutputFiles();
		assertEquals("Should have found 5 class files, but was: " + resolvePathes, 5, resolvePathes.size());
	}

	Collection<URI> collectOutputFiles() {
		return collectOutputFiles(outputClassDirectory);
	}

	protected Collection<URI> collectOutputFiles(File dir) {
		return new PathTraverser().resolvePathes(Lists.newArrayList(dir.getAbsolutePath()),
				new ClassFileFilter()).values();
	}

}
