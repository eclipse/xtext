/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.LiveContainerTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.liveContainerTestLanguage.LiveContainerTestLanguagePackage;
import org.eclipse.xtext.resource.liveContainerTestLanguage.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(LiveContainerTestLanguageInjectorProvider.class)
public class LiveShadowedChunkedContainerTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	@Inject
	private Provider<LiveShadowedChunkedResourceDescriptions> provider;

	private WorkspaceConfig workspaceConfig;

	private ProjectConfig fooProject;

	private ProjectConfig barProject;

	private URI fooURI;

	private URI barURI;

	private XtextResourceSet rs1;

	private LiveShadowedChunkedContainer fooContainer;

	private LiveShadowedChunkedContainer barContainer;

	private LiveShadowedChunkedResourceDescriptions liveShadowedChunkedResourceDescriptions;

	@Before
	public void setUp() throws Exception {
		workspaceConfig = new WorkspaceConfig();
		fooProject = new ProjectConfig("foo", workspaceConfig);
		barProject = new ProjectConfig("bar", workspaceConfig);
		XtextResourceSet rs0 = resourceSetProvider.get();
		fooURI = IterableExtensions.head(fooProject.getSourceFolders()).getPath().trimSegments(1)
				.appendSegment("foo.livecontainertestlanguage");
		barURI = IterableExtensions.head(barProject.getSourceFolders()).getPath().trimSegments(1)
				.appendSegment("bar.livecontainertestlanguage");
		Map<String, ResourceDescriptionsData> chunks = Collections.unmodifiableMap(CollectionLiterals.newHashMap(
				Pair.of("foo",
						createResourceDescriptionData(
								Collections.singletonList(parseHelper.parse("foo", fooURI, rs0).eResource()))),
				Pair.of("bar", createResourceDescriptionData(
						Collections.singletonList(parseHelper.parse("bar", barURI, rs0).eResource())))));
		rs1 = resourceSetProvider.get();
		new ChunkedResourceDescriptions(chunks, rs1);
		ProjectConfigAdapter.install(rs1, fooProject);
		liveShadowedChunkedResourceDescriptions = provider.get();
		liveShadowedChunkedResourceDescriptions.setContext(rs1);
		fooContainer = new LiveShadowedChunkedContainer(liveShadowedChunkedResourceDescriptions, "foo");
		barContainer = new LiveShadowedChunkedContainer(liveShadowedChunkedResourceDescriptions, "bar");
	}

	@Test
	public void testRenameElement() throws Exception {
		parseHelper.parse("fooChange", fooURI, rs1);
		Assert.assertEquals("fooChange", IterableExtensions.join(
				IterableExtensions.map(fooContainer.getExportedObjects(), it -> it.getQualifiedName().toString()),
				","));
		Assert.assertEquals("fooChange",
				IterableExtensions
						.join(IterableExtensions.map(
								fooContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL,
										QualifiedName.create("fooChange"), false),
								it -> it.getQualifiedName().toString()), ","));
		Assert.assertEquals("fooChange",
				IterableExtensions.join(IterableExtensions.map(
						fooContainer.getExportedObjectsByType(LiveContainerTestLanguagePackage.Literals.MODEL),
						it -> it.getQualifiedName().toString()), ","));
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertTrue(fooContainer.hasResourceDescription(fooURI));
		Assert.assertFalse(fooContainer.hasResourceDescription(barURI));
		Assert.assertEquals(fooURI, fooContainer.getResourceDescription(fooURI).getURI());
		Assert.assertEquals("bar", IterableExtensions.join(
				IterableExtensions.map(barContainer.getExportedObjects(), it -> it.getQualifiedName().toString()),
				","));
		Assert.assertEquals("bar",
				IterableExtensions.join(IterableExtensions
						.map(barContainer.getExportedObjects(LiveContainerTestLanguagePackage.Literals.MODEL,
								QualifiedName.create("bar"), false), it -> it.getQualifiedName().toString()),
						","));
		Assert.assertEquals("bar",
				exportedObjects(barContainer));
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		Assert.assertTrue(barContainer.hasResourceDescription(barURI));
		Assert.assertFalse(barContainer.hasResourceDescription(fooURI));
		Assert.assertEquals(barURI, barContainer.getResourceDescription(barURI).getURI());
		assertGlobalDescriptionsAreUnaffected();
	}

	@Test
	public void testAddRemoveResource() throws Exception {
		Resource bazResource = parseHelper
				.parse("baz", IterableExtensions.head(fooProject.getSourceFolders()).getPath()
						.trimSegments(1).appendSegment("baz.livecontainertestlanguage"), rs1)
				.eResource();
		Assert.assertEquals(2, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(2, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("baz,foo", exportedObjects(fooContainer));
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		assertGlobalDescriptionsAreUnaffected();
		rs1.getResources().remove(bazResource);
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("foo", exportedObjects(fooContainer));
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		assertGlobalDescriptionsAreUnaffected();
	}

	@Test
	public void testMoveResourceBetweenContainers() throws Exception {
		URI oldURI = IterableExtensions.head(fooProject.getSourceFolders()).getPath().trimSegments(1)
				.appendSegment("baz.livecontainertestlanguage");
		Resource bazResource = parseHelper.parse("baz", oldURI, rs1).eResource();
		Assert.assertEquals(2, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(2, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("baz,foo", exportedObjects(fooContainer));
		Assert.assertEquals(oldURI,
				IterableExtensions
						.head(fooContainer.getExportedObjects(
								LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false))
						.getEObjectURI().trimFragment());
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		assertGlobalDescriptionsAreUnaffected();
		URI newURI = URI.createURI(bazResource.getURI().toString().replace("/foo/", "/bar/"));
		bazResource.setURI(newURI);
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("foo", exportedObjects(fooContainer));
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("bar,baz", IterableExtensions.join(IterableExtensions.sort(
				IterableExtensions.<IEObjectDescription, String>map(barContainer.getExportedObjects(), it -> it.getQualifiedName().toString())),
				","));
		Assert.assertEquals(2, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(2, barContainer.getResourceDescriptionCount());
		Assert.assertEquals(newURI,
				IterableExtensions
						.head(barContainer.getExportedObjects(
								LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false))
						.getEObjectURI().trimFragment());
		assertGlobalDescriptionsAreUnaffected();
	}

	@Test
	public void testAddToNewContainer() throws Exception {
		ProjectConfig bazProject = new ProjectConfig("baz", workspaceConfig);
		URI newURI = IterableExtensions.head(bazProject.getSourceFolders()).getPath().trimSegments(1)
				.appendSegment("baz.livecontainertestlanguage");
		parseHelper.parse("baz", newURI, rs1);
		LiveShadowedChunkedContainer bazContainer = new LiveShadowedChunkedContainer(
				liveShadowedChunkedResourceDescriptions, "baz");
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals("foo", exportedObjects(fooContainer));
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		Assert.assertEquals("bar", exportedObjects(barContainer));
		Assert.assertEquals(1, IterableExtensions.size(bazContainer.getResourceDescriptions()));
		Assert.assertEquals(1, bazContainer.getResourceDescriptionCount());
		Assert.assertEquals("baz", exportedObjects(bazContainer));
		Assert.assertEquals(newURI,
				IterableExtensions
						.head(bazContainer.getExportedObjects(
								LiveContainerTestLanguagePackage.Literals.MODEL, QualifiedName.create("baz"), false))
						.getEObjectURI().trimFragment());
		assertGlobalDescriptionsAreUnaffected();
	}

	@Test
	public void testDeleteElement() throws Exception {
		parseHelper.parse("foo", fooURI, rs1).eResource().getContents().clear();
		Assert.assertEquals("", IterableExtensions.join(
				IterableExtensions.map(fooContainer.getExportedObjects(), it -> it.getQualifiedName().toString()),
				","));
		Assert.assertEquals(1, IterableExtensions.size(fooContainer.getResourceDescriptions()));
		Assert.assertEquals(1, fooContainer.getResourceDescriptionCount());
		Assert.assertEquals(0, IterableExtensions.size(fooContainer.getExportedObjects()));
		Assert.assertEquals(1, IterableExtensions.size(barContainer.getResourceDescriptions()));
		Assert.assertEquals(1, barContainer.getResourceDescriptionCount());
		assertGlobalDescriptionsAreUnaffected();
	}

	private String exportedObjects(LiveShadowedChunkedContainer container) {
		return IterableExtensions.join(IterableExtensions.sort(
				IterableExtensions.<IEObjectDescription, String>map(container.getExportedObjects(), it -> it.getQualifiedName().toString())),
				",");
	}

	private void assertGlobalDescriptionsAreUnaffected() {
		Assert.assertEquals("foo", IterableExtensions.join(
				IterableExtensions.map(
						((ChunkedResourceDescriptions) liveShadowedChunkedResourceDescriptions.getGlobalDescriptions())
								.getContainer("foo").getExportedObjects(),
						it -> it.getQualifiedName().toString()),
				","));
		Assert.assertEquals("bar", IterableExtensions.join(
				IterableExtensions.map(
						((ChunkedResourceDescriptions) liveShadowedChunkedResourceDescriptions.getGlobalDescriptions())
								.getContainer("bar").getExportedObjects(),
						it -> it.getQualifiedName().toString()),
				","));
	}

	private ResourceDescriptionsData createResourceDescriptionData(List<Resource> resources) {
		return new ResourceDescriptionsData(
				ListExtensions.map(resources, it -> resourceDescriptionManager.getResourceDescription(it)));
	}
}
