/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.junit4.build;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationAdapter;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.junit4.util.InMemoryURIHandler;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;

import com.google.common.annotations.Beta;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * Abstract base class for testing languages in the incremental builder.
 * 
 * @since 2.9
 * 
 * @noreference
 * @noimplement
 * 
 * @deprecated Use org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest instead.
 */
@Beta
@Deprecated(forRemoval = true)
public abstract class AbstractIncrementalBuilderTest {
	@Inject
	protected IncrementalBuilder incrementalBuilder;

	@Inject
	protected IndexState indexState;

	@Inject
	protected Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private OutputConfigurationProvider configurationProvider;

	protected Multimap<URI, URI> generated;

	protected List<URI> deleted;

	protected List<Issue> issues;

	protected InMemoryURIHandler inMemoryURIHandler;

	@Before
	public void setUp() {
		clean();
		inMemoryURIHandler = new InMemoryURIHandler();
	}

	protected List<Issue> clean() {
		List<Issue> result = null;
		generated = ArrayListMultimap.create();
		deleted = new ArrayList<>();
		result = issues = new ArrayList<>();
		return result;
	}

	protected IndexState build(BuildRequest buildRequest) {
		clean();
		indexState = incrementalBuilder.build(buildRequest, (URI it) -> getLanguages().getResourceServiceProvider(it)).getIndexState();
		return indexState;
	}

	protected void withOutputConfig(BuildRequest it, Procedure1<? super OutputConfiguration> init) {
		OutputConfiguration config = Iterables.getFirst(configurationProvider.getOutputConfigurations(), null);
		init.apply(config);
		OutputConfigurationAdapter adapter = new OutputConfigurationAdapter(Collections.singletonMap(languageName, Collections.singleton(config)));
		it.getResourceSet().eAdapters().add(adapter);
	}

	protected abstract IResourceServiceProvider.Registry getLanguages();

	protected BuildRequest newBuildRequest(Procedure1<? super BuildRequest> init) {
		BuildRequest result = new BuildRequest();
		ResourceDescriptionsData newIndex = indexState.getResourceDescriptions().copy();
		result.setBaseDir(uri(""));
		XtextResourceSet rs = resourceSetProvider.get();
		rs.getURIConverter().getURIHandlers().clear();
		rs.getURIConverter().getURIHandlers().add(inMemoryURIHandler);
		rs.setClasspathURIContext(AbstractIncrementalBuilderTest.class.getClassLoader());
		ProjectDescription projectDescription = new ProjectDescription();
		projectDescription.setName("test-project");
		projectDescription.attachToEmfObject(rs);
		ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(Collections.emptyMap(), rs);
		index.setContainer(projectDescription.getName(), newIndex);
		result.setResourceSet(rs);
		result.setDirtyFiles(Collections.emptyList());
		result.setDeletedFiles(Collections.emptyList());
		result.setAfterValidate((uri, issues) -> {
			Iterables.addAll(this.issues, issues);
			return IterableExtensions.isEmpty(issues);
		});
		result.setAfterDeleteFile(uri -> deleted.add(uri));
		result.setAfterGenerateFile((source, target) -> generated.put(source, target));
		result.setState(new IndexState(newIndex, indexState.getFileMappings().copy()));
		init.apply(result);
		return result;
	}

	protected URI delete(URI uri) {
		try {
			inMemoryURIHandler.delete(uri, Collections.emptyMap());
			return uri;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected URI uri(String path) {
		return URI.createURI(InMemoryURIHandler.SCHEME + ":/" + path);
	}

	protected URI operator_minus(String path, String content) {
		try {
			URI uri = uri(path);
			OutputStream outputStream = inMemoryURIHandler.createOutputStream(uri, Collections.emptyMap());
			try {
				outputStream.write(content.getBytes());
				outputStream.close();
			} catch (IOException e) {
				throw Exceptions.sneakyThrow(e);
			}
			return uri;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected boolean containsSuffix(Iterable<? extends URI> uris, String... suffixes) {
		@SuppressWarnings("unchecked")
		Iterable<String> iterable = (Iterable<String>) Conversions.doWrapArray(suffixes);
		return IterableExtensions.forall(iterable,
				(String suffix) -> IterableExtensions.exists(uris, (URI uri) -> uri.toString().endsWith(suffix)));
	}
}
