package org.eclipse.xtext.builder.standalone;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
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
		public boolean apply(URI input) {
			return "class".equals(input.fileExtension());
		}
	}

	private static final String SRC_TEST_RESOURCES = "test-data/ec-test";
	private static final String DOES_NOT_EXISTS = "src/test/resources/test";
	private IJavaCompiler compiler;
	private File outputClassDirectory;
	private static Injector injector;

	@BeforeClass
	public static void setUpOnce() {
		injector = Guice.createInjector(new StandaloneBuilderModule());
	}

	@Before
	public void setUp() {
		compiler = injector.getInstance(IJavaCompiler.class);
		compiler.getConfiguration().setVerbose(true);
		outputClassDirectory = new File("target/temp");
	}

	@After
	public void tearDown() throws FileNotFoundException {
		if (outputClassDirectory != null && outputClassDirectory.exists()) {
			assertTrue("Unable to delete test directory: " + outputClassDirectory.getAbsolutePath(),
					Files.sweepFolder(outputClassDirectory));
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
		assertEquals("Should found 2 class files, but was: " + resolvePathes, 2, resolvePathes.size());
	}

	private Collection<URI> collectOutputFiles() {
		return new PathTraverser().resolvePathes(Lists.newArrayList(outputClassDirectory.getAbsolutePath()),
				new ClassFileFilter()).values();
	}

}
