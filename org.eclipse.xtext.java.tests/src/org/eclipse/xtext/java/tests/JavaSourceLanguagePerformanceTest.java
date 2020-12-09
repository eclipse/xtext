/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.xtext.java.tests;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(JavaInjectorProvider.class)
public class JavaSourceLanguagePerformanceTest {
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceDescription.Manager resourceDesriptionManager;

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	public void doTestPerformance(int max) {
		List<Pair<String, String>> files = new ArrayList<>();
		for (int i = 1; i <= max; i++) {
			files.add(newFile(i, max));
		}
		XtextResourceSet rs = resourceSet(files);
		Stopwatch sw = Stopwatch.createStarted();
		for (Resource r : rs.getResources()) {
			r.getContents();
		}
		System.out.println(max + " file took " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
	}

	public Pair<String, String> newFile(int it, int max) {
		StringConcatenation builder = new StringConcatenation();
		builder.append("package demo; public class Demo" + it + " {\n");
		builder.append("	private String x;\n");
		if (it > 1) {
			builder.append("	private Demo" + (it- 1) + " demo;\n");
		}
		if (it > 2) {
			builder.append("	private Demo" + (it- 2) + " demo2;\n");
		}
		if (it < max) {
			builder.append("	private Demo" + (it+ 1) + " demo3;\n");
		}
		builder.append("}");
		return Pair.of("demo/Demo" + it + ".java", builder.toString());
	}

	@Test(timeout = 30000)
	public void testPerf00100() {
		doTestPerformance(100);
	}

	@Test(timeout = 30000)
	public void testPerf00200() {
		doTestPerformance(200);
	}

	@Test(timeout = 30000)
	public void testPerf00400() {
		doTestPerformance(400);
	}

	@Test(timeout = 30000)
	public void testPerf00800() {
		doTestPerformance(800);
	}

	@Test(timeout = 30000)
	public void testPerf01600() {
		doTestPerformance(1600);
	}

	@Test(timeout = 30000)
	public void testPerf03200() {
		doTestPerformance(3200);
	}

	@Test(timeout = 30000)
	public void testPerf06400() {
		doTestPerformance(6400);
	}

	@Test(timeout = 30000)
	public void testPerf12800() {
		doTestPerformance(12800);
	}

	@Test(timeout = 30000)
	public void testPerf25600() {
		doTestPerformance(25600);
	}

	@Test(timeout = 60000)
	public void testPerf51200() {
		doTestPerformance(51200);
	}

	protected XtextResourceSet resourceSet(List<Pair<String, String>> files) {
		XtextResourceSet result = resourceSetProvider.get();
		typeProviderFactory.createTypeProvider(result);
		result.setClasspathURIContext(getClass().getClassLoader());
		result.getURIConverter().getURIHandlers().clear();
		InMemoryURIHandler uriHandler = new InMemoryURIHandler();
		List<URI> uris = Lists.transform(files, (Pair<String, String> it) -> {
			URI uri = URI.createURI(InMemoryURIHandler.SCHEME + ":/" + it.getKey());
			try (OutputStream out = uriHandler.createOutputStream(uri, CollectionLiterals.<Object, Object>emptyMap())) {
				out.write(it.getValue().getBytes());
				return uri;
			} catch (IOException e) {
				throw Exceptions.sneakyThrow(e);
			}
		});
		result.getURIConverter().getURIHandlers().add(uriHandler);
		ArrayList<IResourceDescription> descriptions = CollectionLiterals.<IResourceDescription>newArrayList();
		for (URI uri : uris) {
			Resource resource = result.getResource(uri, true);
			descriptions.add(resourceDesriptionManager.getResourceDescription(resource));
		}
		ChunkedResourceDescriptions chunkedResourceDescriptions = new ChunkedResourceDescriptions(
				ImmutableMap.<String, ResourceDescriptionsData>builder()
						.put("default", new ResourceDescriptionsData(descriptions)).build());
		chunkedResourceDescriptions.attachToEmfObject(result);
		return result;
	}
}
