/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.junit4.ide;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.hierarchy.AbstractHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Deprecated(forRemoval = true, since = "2.30")
public abstract class AbstractHierarchyBuilderTest {
	protected static class HierarchyBuilderTestConfiguration {
		private Function1<? super ResourceSet, ? extends IHierarchyBuilder> hierarchyBuilderProvider;

		private Collection<Pair<String, String>> models = new ArrayList<>();

		private int index;

		private String resourceURI;

		private String expectedHierarchy;

		public Function1<? super ResourceSet, ? extends IHierarchyBuilder> getHierarchyBuilderProvider() {
			return hierarchyBuilderProvider;
		}

		public void setHierarchyBuilderProvider(Function1<? super ResourceSet, ? extends IHierarchyBuilder> hierarchyBuilderProvider) {
			this.hierarchyBuilderProvider = hierarchyBuilderProvider;
		}

		public Collection<Pair<String, String>> getModels() {
			return models;
		}

		public void setModels(Collection<Pair<String, String>> models) {
			this.models = models;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getResourceURI() {
			return resourceURI;
		}

		public void setResourceURI(String resourceURI) {
			this.resourceURI = resourceURI;
		}

		public String getExpectedHierarchy() {
			return expectedHierarchy;
		}

		public void setExpectedHierarchy(String expectedHierarchy) {
			this.expectedHierarchy = expectedHierarchy;
		}
	}

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceDescriptionsProvider resourceDescriptionsProvider;

	protected void testBuildHierarchy(Procedure1<? super HierarchyBuilderTestConfiguration> configurator) {
		HierarchyBuilderTestConfiguration configuration = new HierarchyBuilderTestConfiguration();
		configurator.apply(configuration);
		ResourceSet resourceSet = createResourceSet(configuration);
		IHierarchyBuilder hierarchyBuilder = configuration.hierarchyBuilderProvider.apply(resourceSet);
		String resourceURI = null;
		if (configuration.resourceURI == null) {
			resourceURI = Iterables.getLast(configuration.models, null).getKey();
		} else {
			resourceURI = configuration.resourceURI;
		}
		XtextResource resource = (XtextResource) resourceSet.getResource(URI.createURI(resourceURI), false);
		URI rootURI = EcoreUtil2
				.getPlatformResourceOrNormalizedURI(eObjectAtOffsetHelper.resolveElementAt(resource, configuration.index));
		String actualHierarchy = toExpectation(rootURI, hierarchyBuilder);
		Assert.assertEquals(configuration.expectedHierarchy, actualHierarchy);
	}

	protected ResourceSet createResourceSet(HierarchyBuilderTestConfiguration configuration) {
		try {
			XtextResourceSet resourceSet = resourceSetProvider.get();
			for (Pair<String, String> model : configuration.models) {
				Resource resource = resourceSet.createResource(URI.createURI(model.getKey()));
				resource.load(new LazyStringInputStream(model.getValue(), "UTF-8"), null);
				validationTestHelper.assertNoIssues(resource);
			}
			return resourceSet;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected <T extends AbstractHierarchyBuilder> T configureBuilderWith(T hierarchyBuilder, ResourceSet resourceSet) {
		hierarchyBuilder.setResourceAccess(new SimpleLocalResourceAccess(resourceSet));
		hierarchyBuilder.setIndexData(resourceDescriptionsProvider.getResourceDescriptions(resourceSet));
		return hierarchyBuilder;
	}

	protected String toExpectation(URI rootURI, IHierarchyBuilder builder) {
		StringConcatenation richString = new StringConcatenation();
		for (IHierarchyNode root : builder.buildRoots(rootURI, null)) {
			richString.append(toExpectation(root, builder));
			richString.newLineIfNotEmpty();
		}
		return richString.toString();
	}

	protected String toExpectation(IHierarchyNode node, IHierarchyBuilder builder) {
		StringConcatenation richString = new StringConcatenation();
		richString.append(node.getElement());
		richString.append(" {");
		richString.newLineIfNotEmpty();
		richString.append("\t");
		richString.append(internalToExpectation(node, builder), "\t");
		richString.newLineIfNotEmpty();
		richString.append("}");
		richString.newLine();
		return richString.toString();
	}

	protected String internalToExpectation(IHierarchyNode node, IHierarchyBuilder builder) {
		StringConcatenation richString = new StringConcatenation();
		for (IHierarchyNodeReference location : node.getReferences()) {
			richString.append(toExpectation(location));
			richString.newLineIfNotEmpty();
		}
		if (node.mayHaveChildren()) {
			for (IHierarchyNode childNode : builder.buildChildren(node, null)) {
				richString.append(toExpectation(childNode, builder));
				richString.newLineIfNotEmpty();
			}
		}
		return richString.toString();
	}

	protected String toExpectation(IHierarchyNodeReference location) {
		StringConcatenation richString = new StringConcatenation();
		richString.append("\'");
		richString.append(location.getText());
		richString.append("\' [");
		richString.append(location.getOffset());
		richString.append(", ");
		richString.append(location.getLength());
		richString.append("]");
		return richString.toString();
	}
}
