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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteSource;
import com.google.common.io.FileWriteMode;

public class TestIncrementalEclipseCompiler extends TestEclipseCompiler implements IResourceDescription.Event.Listener {

	private File outputStateDirectory;
	private File additionalSourceDirectory;
	private Event event;

	@Before
	@Override
	public void setUp() throws IOException {
		super.setUp();
		outputStateDirectory = new File("target/state");
		additionalSourceDirectory = new File("target/temp-src-gen");
		Files.createDirectories(additionalSourceDirectory.toPath());
		compiler.getConfiguration().enableIncrementalCompilation(outputStateDirectory, this);
	}

	@After
	@Override
	public void tearDown() throws IOException {
		super.tearDown();
		tearDown(outputStateDirectory);
		tearDown(additionalSourceDirectory);
		event = null;
		compiler.getConfiguration().disableIncrementalCompilation();
	}
	
	@Override
	public void descriptionsChanged(Event event) {
		this.event = event;
	}
	
	void assertEvent(Consumer<Event> asserter) {
		assertNotNull(event);
		asserter.accept(event);
		event = null;
	}

	@Test
	public void testIncrementalCompilationBinariesTouched() throws IOException {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class");
		sourceRoots.add(DOES_NOT_EXISTS);
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		
		assertEvent(e->{
			assertEquals(3, event.getDeltas().size());
		});

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertTrue(event.getDeltas().isEmpty());
		});
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));

		new File(outputClassDirectory, "TestClass.class").delete();

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertTrue(event.getDeltas().isEmpty());
		});

		new File(outputClassDirectory, "com/acme/BugsBunny$Carrot.class").delete();

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));

		ByteSource.wrap(new byte[] { 1, 1 }).copyTo(com.google.common.io.Files
				.asByteSink(new File(outputClassDirectory, "com/acme/BugsBunny.class"), FileWriteMode.APPEND));
		assertEvent(e->{
			assertTrue(event.getDeltas().isEmpty());
		});

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertTrue(event.getDeltas().isEmpty());
		});
	}
	
	@Test
	public void testIncrementalCompilationSourcesTouched() throws IOException {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class");
		sourceRoots.add(additionalSourceDirectory.getAbsolutePath());
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(3, event.getDeltas().size());
			assertEquals(ImmutableSet.of("TestClass", "com.acme.BugsBunny", "com.acme.LoonyToon"), topLevelTypeNames(event));
		});
		Collection<URI> resolvePathes = collectOutputFiles();
		assertEquals("Should have found 4 class files, but was: " + resolvePathes, 4, resolvePathes.size());
		
		File tweetyFile = new File(additionalSourceDirectory, "com/acme/Tweety.java");
		Files.createDirectories(tweetyFile.getParentFile().toPath());
		Files.write(tweetyFile.toPath(), Arrays.asList(
				"package com.acme;",
				"public class Tweety extends LoonyToon {}"));

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(1, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Tweety"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 5 class files, but was: " + resolvePathes, 5, resolvePathes.size());
		assertTrue(tweetyFile.delete());
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(1, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Tweety"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 4 class files, but was: " + resolvePathes, 4, resolvePathes.size());
		Files.write(tweetyFile.toPath(), Arrays.asList(
				"package com.acme;",
				"class Sylvester extends LoonyToon { class CatFood {} }"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(1, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Sylvester"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 6 class files, but was: " + resolvePathes, 6, resolvePathes.size());
		Files.write(tweetyFile.toPath(), Arrays.asList(
				"package com.acme;",
				"public class Tweety extends LoonyToon {}"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(2, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Sylvester", "com.acme.Tweety"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 5 class files, but was: " + resolvePathes, 5, resolvePathes.size());
		Files.write(tweetyFile.toPath(), Arrays.asList(
				"package com.acme;",
				"class Sylvester {}",
				"class YosemiteSam {}",
				"class ElmerFudd {}"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(4, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Sylvester", "com.acme.YosemiteSam", "com.acme.ElmerFudd", "com.acme.Tweety"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 7 class files, but was: " + resolvePathes, 7, resolvePathes.size());
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertTrue(event.getDeltas().isEmpty());
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 7 class files, but was: " + resolvePathes, 7, resolvePathes.size());
		Files.write(tweetyFile.toPath(), Arrays.asList(
				"package com.acme;",
				"class Sylvester {}",
				"class YosemiteSam {}"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(1, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.ElmerFudd"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 6 class files, but was: " + resolvePathes, 6, resolvePathes.size());
	}
	
	@Test
	public void testIncrementalCompilationAffectedSources() throws IOException {
		List<String> sourceRoots = new ArrayList<String>();
		sourceRoots.add(SRC_TEST_RESOURCES + "/test-class");
		sourceRoots.add(additionalSourceDirectory.getAbsolutePath());
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(3, event.getDeltas().size());
			assertEquals(ImmutableSet.of("TestClass", "com.acme.BugsBunny", "com.acme.LoonyToon"), topLevelTypeNames(event));
		});
		Collection<URI> resolvePathes = collectOutputFiles();
		assertEquals("Should have found 4 class files, but was: " + resolvePathes, 4, resolvePathes.size());
		
		File tweety = new File(additionalSourceDirectory, "com/acme/Tweety.java");
		File birdseed = new File(additionalSourceDirectory, "com/acme/BirdSeed.java");
		File names = new File(additionalSourceDirectory, "com/acme/Names.java");
		Files.createDirectories(tweety.getParentFile().toPath());
		Files.write(tweety.toPath(), Arrays.asList(
				"package com.acme;",
				"public class Tweety extends LoonyToon {",
				"  public static final String name = Names.TWEETY;",
				"  void eat(BirdSeed food) { food.toString(); }",
				"}"));
		Files.write(birdseed.toPath(), Arrays.asList(
				"package com.acme;",
				"public class BirdSeed {",
				"}"));
		Files.write(names.toPath(), Arrays.asList(
				"package com.acme;",
				"public class Names {",
				"  static final String TWEETY = \"Tweety\";",
				"}"));

		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(3, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Tweety", "com.acme.BirdSeed", "com.acme.Names"), topLevelTypeNames(event));
		});
		resolvePathes = collectOutputFiles();
		assertEquals("Should have found 7 class files, but was: " + resolvePathes, 7, resolvePathes.size());
		Files.write(birdseed.toPath(), Arrays.asList(
				"package com.acme;",
				"public class BirdSeed {",
				"  @Override public String toString() { return super.toString(); }",
				"}"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(2, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Tweety", "com.acme.BirdSeed"), topLevelTypeNames(event));
		});
		Files.write(names.toPath(), Arrays.asList(
				"package com.acme;",
				"public class Names {",
				"  static final String TWEETY = \"TWEETY\";",
				"}"));
		assertEquals(CompilationResult.SUCCEEDED, compiler.compile(sourceRoots, outputClassDirectory));
		assertEvent(e->{
			assertEquals(2, event.getDeltas().size());
			assertEquals(ImmutableSet.of("com.acme.Tweety", "com.acme.Names"), topLevelTypeNames(event));
		});
	}
	
	private Set<String> topLevelTypeNames(IResourceDescription.Event event) {
		Set<String> result = new HashSet<String>();
		for(Delta delta: event.getDeltas()) {
			result.add(delta.getUri().segment(1));
		}
		return result;
	}

}
