/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.server.generator.GeneratorService.GeneratedArtifacts;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

public class GeneratorTest extends AbstractWebServerTest {
	public static class Generator extends AbstractGenerator {
		private int invocationCount = 0;

		public Generator() {
			generatorInstance = this;
		}

		@Override
		public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext ctx) {
			invocationCount++;
			Statemachine statemachine = Iterables.getFirst(Iterables.filter(input.getContents(), Statemachine.class), null);
			if (statemachine != null) {
				StringConcatenation builder = new StringConcatenation();
				builder.append(statemachine.getStates().stream().map(State::getName).collect(Collectors.joining(",")));
				builder.newLineIfNotEmpty();
				fsa.generateFile("/DEFAULT_ARTIFACT", builder);
				fsa.generateFile("/test.txt", "hello, world!");
			}
		}
	}

	private static Generator generatorInstance;

	@Override
	protected com.google.inject.Module getRuntimeModule() {
		return new StatemachineRuntimeModule() {
			@Override
			public Class<? extends IGenerator2> bindIGenerator2() {
				return Generator.class;
			}

			@SuppressWarnings("unused")
			public Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
				return TestLineSeparatorInformation.class;
			}
		};
	}

	@Test
	public void testGenerateText() {
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "generate")
							.put("resource", file.getName())
							.build());
		Assert.assertFalse(generate.isHasSideEffects());
		GeneratorResult result = (GeneratorResult) generate.getService().apply();
		String expectedResult =
				"GeneratorResult [\n" +
				"  name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"\n" +
				"  content = \"foo,bar\\n\"\n" +
				"]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testGenerateAdditionalText() {
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "generate")
						.put("resource", file.getName())
						.put("artifact", "DEFAULT_OUTPUT/test.txt")
						.build());
		Assert.assertFalse(generate.isHasSideEffects());
		GeneratorResult result = (GeneratorResult) generate.getService().apply();
		String expectedResult =
				"GeneratorResult [\n" +
				"  name = \"DEFAULT_OUTPUT/test.txt\"\n" +
				"  contentType = \"text/plain\"\n" +
				"  content = \"hello, world!\"\n" +
				"]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testInvokedOnce() {
		if (generatorInstance != null) {
			generatorInstance.invocationCount = 0;
		}
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "generate")
						.put("resource", file.getName())
						.build());
		generate.getService().apply();
		Assert.assertEquals(1, generatorInstance.invocationCount);
		generate.getService().apply();
		Assert.assertEquals(1, generatorInstance.invocationCount);
	}

	@Test
	public void testGetResultWithoutContent() {
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "generate")
						.put("resource", file.getName())
						.put("artifact", "DEFAULT_OUTPUT/test.txt")
						.put("includeContent", "false")
						.build());
		GeneratorResult result = (GeneratorResult) generate.getService().apply();
		String expectedResult = 
				"GeneratorResult [\n" +
				"  name = \"DEFAULT_OUTPUT/test.txt\"\n" +
				"  contentType = \"text/plain\"\n" +
				"]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testGetAllResults() {
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "generate")
						.put("resource", file.getName())
						.put("allArtifacts", "true")
						.build());
		GeneratedArtifacts result = (GeneratedArtifacts) generate.getService().apply();
		String expectedResult =
				"GeneratedArtifacts [\n  artifacts = ArrayList (\n" +
				"    GeneratorResult [\n" +
				"      name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"\n" +
				"      content = \"foo,bar\\n\"\n" +
				"    ],\n" +
				"    GeneratorResult [\n" +
				"      name = \"DEFAULT_OUTPUT/test.txt\"\n" +
				"      contentType = \"text/plain\"\n" +
				"      content = \"hello, world!\"\n" +
				"    ]\n" +
				"  )\n]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testGetAllResultsWithoutContent() {
		File file = createFile("state foo end state bar end");
		XtextServiceDispatcher.ServiceDescriptor generate = getService(
				ImmutableMap.<String, String>builder().put("serviceType", "generate").put("resource", file.getName())
						.put("allArtifacts", "true").put("includeContent", "false").build());
		GeneratedArtifacts result = (GeneratedArtifacts) generate.getService().apply();
		String expectedResult =
				"GeneratedArtifacts [\n" +
				"  artifacts = ArrayList (\n" +
				"    GeneratorResult [\n" +
				"      name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"\n" +
				"    ],\n" +
				"    GeneratorResult [\n" +
				"      name = \"DEFAULT_OUTPUT/test.txt\"\n" +
				"      contentType = \"text/plain\"\n" +
				"    ]\n" +
				"  )\n]";
		assertEquals(expectedResult, result.toString());
	}
}
