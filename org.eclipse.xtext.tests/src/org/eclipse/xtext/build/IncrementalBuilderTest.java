/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.build;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndexTestLanguageInjectorProvider.class)
public class IncrementalBuilderTest extends AbstractIncrementalBuilderTest {
	private static class CancelOnFirstModel implements BuildRequest.IPostValidationCallback, CancelIndicator {
		private boolean canceled;

		@Override
		public boolean afterValidate(URI validated, Iterable<Issue> issues) {
			if (canceled) {
				Assert.fail("Builder didn't cancel");
			}
			return canceled = true;
		}

		@Override
		public boolean isCanceled() {
			return canceled;
		}
	}

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderFactory;

	@Override
	public IResourceServiceProvider.Registry getLanguages() {
		return resourceServiceProviderFactory;
	}

	@Test
	public void testNoCleanupBuild() {
		BuildRequest buildRequest = newBuildRequest((BuildRequest it) -> {
			withOutputConfig(it, (OutputConfiguration cfg) -> cfg.setCleanUpDerivedResources(false));
			String model = 
					"foo {\n" +
					"	entity B {}\n" +
					"	entity A { foo.B myReference }\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", model)));
		});
		build(buildRequest);
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
		newBuildRequest((BuildRequest it) -> {
			withOutputConfig(it, (OutputConfiguration cfg) -> cfg.setCleanUpDerivedResources(false));
			it.setDeletedFiles(Lists.newArrayList(delete(uri("src/A.indextestlanguage"))));
		});
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
	}

	@Test
	public void testGeneratedOnceBuild() {
		BuildRequest buildRequest = newBuildRequest((BuildRequest it) -> {
			withOutputConfig(it, (OutputConfiguration cfg) -> cfg.setOverrideExistingResources(false));
			String model = 
					"foo {\n" +
					"	entity B {}\n" +
					"	entity A { foo.B myReference }\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", model)));
		});
		build(buildRequest);
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
		newBuildRequest((BuildRequest it) -> {
			withOutputConfig(it, (OutputConfiguration cfg) -> cfg.setOverrideExistingResources(false));
			String model = "foo {\n\tentity B {}\n\tentity A { foo.B someReference }\n}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", model)));
			it.setAfterGenerateFile((URI $0, URI $1) -> {
				Assert.fail();
			});
		});
	}

	@Test
	public void testSimpleFullBuild() {
		BuildRequest buildRequest = newBuildRequest((BuildRequest it) -> {
			String model = 
					"foo {\n" +
					"\tentity B {}\n" +
					"\tentity A { foo.B myReference }\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", model)));
		});
		build(buildRequest);
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
	}

	@Test(expected = OperationCanceledException.class)
	public void testCancellation() {
		IncrementalBuilderTest.CancelOnFirstModel cancelOnFirstModel = new IncrementalBuilderTest.CancelOnFirstModel();
		BuildRequest buildRequest = newBuildRequest((BuildRequest it) -> {
			String modelA = 
					"foo {\n" +
					"	entity A { foo.B myReference }\n" +
					"}\n";
			String modelB = 
					"foo {\n" +
					"	entity B {}\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", modelA),
					newFile("src/MyFile2.indextestlanguage", modelB)));
			it.setCancelIndicator(cancelOnFirstModel);
			it.setAfterValidate(cancelOnFirstModel);
		});
		build(buildRequest);
	}

	@Test
	public void testIndexOnly() {
		BuildRequest buildRequest = newBuildRequest((BuildRequest it) -> {
			it.setIndexOnly(true);
			String model = 
					"foo {\n" +
					"	entity A {}\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/MyFile.indextestlanguage", model)));
			it.setAfterValidate((URI $0, Iterable<Issue> $1) -> {
				throw new IllegalStateException();
			});
			it.setAfterGenerateFile((URI $0, URI $1) -> {
				throw new IllegalStateException();
			});
		});
		IndexState result = build(buildRequest);
		Assert.assertEquals(1, Iterables.size(result.getResourceDescriptions().getAllResourceDescriptions()));
	}

	@Test
	public void testDelete_01() {
		build(newBuildRequest((BuildRequest it) -> {
			String modelA = 
					"foo {\n" +
					"	entity A {foo.B references}\n" +
					"}\n";
			String modelB = 
					"foo {\n" +
					"	entity B\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", modelA),
					newFile("src/B.indextestlanguage", modelB)));
		}));
		AtomicBoolean validateCalled = new AtomicBoolean(false);
		build(newBuildRequest((BuildRequest it) -> {
			it.setDeletedFiles(Lists.newArrayList(uri("src/B.indextestlanguage")));
			it.setAfterValidate((URI uri, Iterable<Issue> issues) -> {
				if (Objects.equals(uri("src/A.indextestlanguage"), uri)) {
					Assert.assertTrue(issues.toString(), Iterables.<Issue>getFirst(issues, null).getMessage()
							.contains("Couldn't resolve reference to Type 'foo.B'"));
					validateCalled.set(true);
					return false;
				} else {
					if (Objects.equals(uri("src/B.indextestlanguage"), uri)) {
						Assert.assertEquals("zero issues expected", 0, Iterables.size(issues));
						return true;
					} else {
						throw new IllegalStateException(("unexpected issues for " + uri));
					}
				}
			});
		}));
		Assert.assertTrue(validateCalled.get());
	}

	@Test
	public void testDeleteClearsReusedResourceSet() {
		BuildRequest req = newBuildRequest((BuildRequest it) -> {
			String modelA = 
					"foo {\n" +
					"    entity A {foo.B references}\n" +
					"}\n";
			String modelB = 
					"foo {\n" +
					"    entity B\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", modelA),
					newFile("src/B.indextestlanguage", modelB)));
		});
		XtextResourceSet resourceSet = req.getResourceSet();
		build(req);
		AtomicBoolean validateCalled = new AtomicBoolean(false);
		build(newBuildRequest((BuildRequest it) -> {
			it.setDeletedFiles(Lists.newArrayList(uri("src/B.indextestlanguage")));
			it.setAfterValidate((URI uri, Iterable<Issue> issues) -> {
				if (Objects.equals(uri("src/A.indextestlanguage"), uri)) {
					Assert.assertTrue(issues.toString(),
							!Iterables.isEmpty(issues) && Iterables.<Issue>getFirst(issues, null).getMessage()
									.contains("Couldn't resolve reference to Type 'foo.B'"));
					validateCalled.set(true);
					return false;
				} else {
					if (Objects.equals(uri("src/B.indextestlanguage"), uri)) {
						Assert.assertEquals("zero issues expected", 0, Iterables.size(issues));
						return true;
					} else {
						throw new IllegalStateException(("unexpected issues for " + uri));
					}
				}
			});
			it.setResourceSet(resourceSet);
			ChunkedResourceDescriptions desc = ChunkedResourceDescriptions.findInEmfObject(it.getResourceSet());
			desc.setContainer("test-project", it.getState().getResourceDescriptions());
		}));
		Assert.assertTrue(validateCalled.get());
		Assert.assertNull(resourceSet.getResource(uri("src/B.indextestlanguage"), false));
	}

	@Test
	public void testIncrementalBuild() {
		build(newBuildRequest((BuildRequest it) -> {
			String modelA = 
					"foo {\n" +
					"	entity A {foo.B reference}\n" +
					"}\n";
			String modelB = 
					"foo {\n" +
					"	entity B {foo.A reference}\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", modelA),
					newFile("src/B.indextestlanguage", modelB)));
		}));
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
		build(newBuildRequest((BuildRequest it) -> {
			String model = 
					"foo {\n" +
					"	entity A {foo.B reference}\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", model)));
		}));
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(1, generated.size());
		Assert.assertFalse(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
		build(newBuildRequest((BuildRequest it) -> {
			String model = 
					"foo {\n" +
					"	entity X { foo.B reference }\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", model)));
		}));
		Assert.assertEquals(issues.toString(), 1, issues.size());
		Assert.assertEquals(1, generated.size());
		Assert.assertFalse(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/X.txt"));
		Assert.assertEquals(1, indexState.getFileMappings().getGenerated(uri("src/A.indextestlanguage")).size());
		Assert.assertEquals(1, deleted.size());
		Assert.assertTrue(containsSuffix(deleted, "src-gen/A.txt"));
		build(newBuildRequest((BuildRequest it) -> {
			String model = 
					"foo {\n" +
					"	entity A { foo.B reference }\n" +
					"}\n";
			it.setDirtyFiles(Lists.newArrayList(newFile("src/A.indextestlanguage", model)));
		}));
		Assert.assertTrue(issues.toString(), issues.isEmpty());
		Assert.assertEquals(2, generated.size());
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/B.txt"));
		Assert.assertTrue(containsSuffix(generated.values(), "src-gen/A.txt"));
		Assert.assertTrue(containsSuffix(deleted, "src-gen/X.txt"));
		build(newBuildRequest((BuildRequest it) -> {
			it.setDeletedFiles(Lists.newArrayList(delete(uri("src/A.indextestlanguage"))));
		}));
		Assert.assertEquals(issues.toString(), 1, issues.size());
		Assert.assertEquals(0, generated.size());
		Assert.assertEquals(1, deleted.size());
		Assert.assertTrue(containsSuffix(deleted, "src-gen/A.txt"));
	}
}
